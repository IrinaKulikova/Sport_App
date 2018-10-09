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
    private static final int startTime=8;
    private static final int endTime=20;
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
        List<List<ScheduleSender>> scheduleListTable=makeTable(dayList,scheduleList);
        model.addAttribute("daylist", dayList);
        model.addAttribute("schedulelist", scheduleListTable);
        //    List<Schedule> scheduleList=scheduleServise.getAll();
        return "schedule/schedule";
    }

    @GetMapping("/save_schedule_event")
    public String getSaveScheduleEvent() {
        return "shedule_event/events";
    }

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
        System.out.println(starttime);
        System.out.println(sheduleEvent);
        System.out.println(day);
        Day newDay = null;
        try {
            newDay = dayServise.getById(day);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ScheduleEvent scheduleEvent = schedulesEventService.getById(sheduleEvent);
//        String event=request.getParameter("event_schedule");
//        String day=request.getParameter("day");
//        String hour=request.getParameter("hour");
//        String min=request.getParameter("min");
        SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm");
        localDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+2"));
//        String timestring = hour+":"+min;//"Mar 19 2018 - 14:39";
        Date date = null;
        try {
            date = localDateFormat.parse(starttime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //    if(date==null)  return "redirect:/";
        //    Day day1=new Day(Integer.parseInt(day));
        java.sql.Time sd = new java.sql.Time(date.getTime());
        //      ScheduleEvent event1=new ScheduleEvent(Integer.parseInt(event));
        Schedule schedule = new Schedule(newDay, sd, scheduleEvent);
        //    scheduleRepository.midifyingQuryInsertSchadule(Integer.parseInt(day),timestring,Integer.parseInt(event));
        try {
            scheduleServise.save(schedule);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }
    private List<List<ScheduleSender>> makeTable(List<Day> dayList,  List<Schedule> scheduleList){
        ScheduleSender sender=null;
      List<List<ScheduleSender>> scheduleListSenders=new ArrayList<>();
        for (int i=startTime;i<=endTime;i++){
          List<ScheduleSender> scheduleSenders=new ArrayList<>();
          sender= new ScheduleSender(i+":00");
          scheduleSenders.add(sender);
            for (Day d:dayList) {
                String attributeTime=i + ":00";
     /*           if(i<10) {
                    attributeTime ="0"+ i + ":00";
                }else {
                    attributeTime = i + ":00";
                }*/
                Integer idday=d.getId();
                sender=new ScheduleSender("",attributeTime,idday.toString());
                sender.setScheduleList(isHaveSchedules(d.getId(),attributeTime,scheduleList));
                scheduleSenders.add(sender);
            }
            scheduleListSenders.add(scheduleSenders);
        }
        return scheduleListSenders;
    }
    private List<Schedule> isHaveSchedules(int dayId,String time,List<Schedule> readScheduleList){
        SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm");
        Date date = null;
        try {
            date = localDateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        List<Schedule> scheduleList=new ArrayList<>();
        for (Schedule schedule:readScheduleList) {
            long timeStart=schedule.getStarttime().getTime();
            long timeTable=date.getTime();
         //   java.util.Date dt=new java.util.Date(schedule.getStarttime().getTime());
           if((schedule.getDay().getId()==dayId)&&(date.getTime()==schedule.getStarttime().getTime())){
                 scheduleList.add(schedule);
           }
        }



        return scheduleList;
    }
}
