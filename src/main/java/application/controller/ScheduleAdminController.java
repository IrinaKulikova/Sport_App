package application.controller;

import application.entity.Day;
import application.entity.Schedule;
import application.entity.ScheduleEvent;
import application.helper.ScheduleSender;
import application.service.implementations.DayServise;
import application.service.implementations.ScheduleService;
import application.service.implementations.SchedulesEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Controller
@RequestMapping("/schedules")
public class ScheduleAdminController {
    private static final int startTime = 8;
    private static final int endTime = 20;
    @Autowired
    ScheduleService scheduleServise;
    @Autowired
    SchedulesEventService schedulesEventService;
    @Autowired
    DayServise dayServise;

    @GetMapping()
    public String getSchedules(Model model) {
        List<Day> dayList = null;
        try {
            dayList = dayServise.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Schedule> scheduleList = null;
        try {
            scheduleList = scheduleServise.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<List<ScheduleSender>> scheduleListTable = makeTable(dayList, scheduleList);
        model.addAttribute("daylist", dayList);
        model.addAttribute("schedulelist", scheduleListTable);
        //    List<Schedule> scheduleList=scheduleServise.getAll();
        return "schedule/schedule";
    }
    @GetMapping("/schedule_edit")
    public String getEditSchedules(Model model){
        List<ScheduleSender> listSender=new ArrayList<>();
        ScheduleSender sender=null;
        List<Schedule> scheduleList=null;
        List<ScheduleEvent> scheduleEventsList=null;
        List<Day> dayList=null;
        try {
            scheduleList = scheduleServise.getAll();
       //     scheduleEventsList = schedulesEventService.getAll();
       //     dayList = dayServise.getAll();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        for(Schedule sch:scheduleList){
            String time =sch.getStarttime().toString();
            time.substring(0,5);
            sender=new ScheduleSender(sch.getId(),sch.getScheduleEvent().getName(),time,sch.getDay().getNameDay());//sch.getStarttime().toString(),sch.getDay().getNameDay()
            listSender.add(sender);
        }
        model.addAttribute("shedule",listSender);

        return "/schedule/schedule_edit";
    }

 /*   @GetMapping("/save_schedule_event")
    public String getSaveScheduleEvent() {
        return "shedule_event/events";
    } */

    @PostMapping("/save_schedule_event")
    public String postSaveScheduleEvent(ScheduleEvent event) {
        try {
            schedulesEventService.save(event);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @GetMapping("/save_shedule")
    public String getSaveSchedule(Model model) {
        List<Day> dayList = null;
        List<ScheduleEvent> eventList = null;
        try {
            eventList = schedulesEventService.getAll();
            dayList = dayServise.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("eventshedule", eventList);
        model.addAttribute("weekday", dayList);
        return "schedule/save_schedule";
    }

    @PostMapping("/save_shedule")
    public String postSaveSchedule(@RequestParam String starttime, @RequestParam int sheduleEvent, @RequestParam int day) {
        Day newDay = null;
        ScheduleEvent scheduleEvent = new ScheduleEvent();
        try {
            newDay = dayServise.getById(day);
            scheduleEvent = schedulesEventService.getById(sheduleEvent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm");
        localDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+2"));
        Date date = null;
        try {
            date = localDateFormat.parse(starttime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Time sd = new java.sql.Time(date.getTime());
        Schedule schedule = new Schedule(newDay, sd, scheduleEvent);
        //    scheduleRepository.midifyingQuryInsertSchadule(Integer.parseInt(day),timestring,Integer.parseInt(event));
        try {
            scheduleServise.save(schedule);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @GetMapping("/dbclickcreate")
    public String getDoubleClickCreate(@RequestParam String time, @RequestParam String id, Model model) {
        List<Day> dayList = null;
        List<ScheduleEvent> eventList = null;
        try {
            eventList = schedulesEventService.getAll();
            dayList = dayServise.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("time", time);
        model.addAttribute("idday", id);
        model.addAttribute("eventshedule", eventList);
        model.addAttribute("weekday", dayList);
        return "schedule/dbclickcreate";
    }

    @GetMapping("/dbclickedit/{id}")
    public String getDoubleClickEdit(Model model, @PathVariable int id) {
        Schedule schedule = null;
        List<Day> dayList = null;
        List<ScheduleEvent> eventList = null;
        try {
            schedule = scheduleServise.getById(id);
            eventList = schedulesEventService.getAll();
            dayList = dayServise.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String time = schedule.getStarttime().toString();
        time = time.substring(0, 5);
        if (time.startsWith("0")) time = time.substring(1, 5);
        model.addAttribute("time", time);
        model.addAttribute("eventshedule", eventList);
        model.addAttribute("weekday", dayList);
        model.addAttribute("schedule", schedule);
        return "schedule/dbclickedit";
    }

 /*   @PutMapping("/dbclickedit")
    public String putDoubleClickEdit(@RequestParam String starttime, @RequestParam int sheduleevent, @RequestParam int day, @PathVariable("id") int id) {
        System.out.println(starttime);
        System.out.println(sheduleevent);
        System.out.println(day);
        return "redirect:/";
    }*/


    private List<List<ScheduleSender>> makeTable(List<Day> dayList, List<Schedule> scheduleList) {
        ScheduleSender sender = null;
        List<List<ScheduleSender>> scheduleListSenders = new ArrayList<>();
        for (int i = startTime; i <= endTime; i++) {
            List<ScheduleSender> scheduleSenders = new ArrayList<>();
            sender = new ScheduleSender(i + ":00");
            scheduleSenders.add(sender);
            for (Day d : dayList) {
                String attributeTime = i + ":00";
                Integer idday = d.getId();
                sender = new ScheduleSender("", attributeTime, idday.toString());
                sender.setScheduleList(isHaveSchedules(d.getId(), attributeTime, scheduleList));
                scheduleSenders.add(sender);
            }
            scheduleListSenders.add(scheduleSenders);
        }
        return scheduleListSenders;
    }

    private List<Schedule> isHaveSchedules(int dayId, String time, List<Schedule> readScheduleList) {
        SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm");
        Date date = null;
        try {
            date = localDateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        List<Schedule> scheduleList = new ArrayList<>();
        for (Schedule schedule : readScheduleList) {
            long timeStart = schedule.getStarttime().getTime();
            long timeTable = date.getTime();
            //   java.util.Date dt=new java.util.Date(schedule.getStarttime().getTime());
            if ((schedule.getDay().getId() == dayId) && (date.getTime() == schedule.getStarttime().getTime())) {
                scheduleList.add(schedule);
            }
        }


        return scheduleList;
    }
}
