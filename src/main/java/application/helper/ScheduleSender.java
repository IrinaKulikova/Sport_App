package application.helper;

import application.entity.Schedule;

import java.util.List;

public class ScheduleSender {
  //  int number=0;//номер по порядку
    int id=0;
    String name="";
    String attributeTime="";
    String attributeDay="";
    List<Schedule> scheduleList=null;
    public ScheduleSender(String name) {
        this.name = name;
    }
    public ScheduleSender(String name, String attributeTime, String attributeDay) {
        this.name = name;
        this.attributeTime = attributeTime;
        this.attributeDay = attributeDay;
    }

    public ScheduleSender(int id, String name, String attributeTime, String attributeDay) {
        this.id = id;
        this.name = name;
        this.attributeTime = attributeTime;
        this.attributeDay = attributeDay;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAttributeTime() {
        return attributeTime;
    }

    public String getAttributeDay() {
        return attributeDay;
    }

    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }
}
