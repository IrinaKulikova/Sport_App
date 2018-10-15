package application.dto;

import application.entity.Schedule;

import java.util.List;

public class ScheduleSenderDTO {
    int numbersort=0;//номер по порядку
    int id=0;
    String name="";
    String attributeTime="";
    String attributeDay="";
    List<Schedule> scheduleList=null;
    public ScheduleSenderDTO(String name) {
        this.name = name;
    }
    public ScheduleSenderDTO(String name, String attributeTime, String attributeDay) {
        this.name = name;
        this.attributeTime = attributeTime;
        this.attributeDay = attributeDay;
    }

    public ScheduleSenderDTO(int numbersort, int id, String name, String attributeTime, String attributeDay) {
        this.numbersort=numbersort;
        this.id = id;
        this.name = name;
        this.attributeTime = attributeTime;
        this.attributeDay = attributeDay;
    }

    public int getId() {
        return id;
    }

    public int getNumbersort() {
        return numbersort;
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

    public void setNumbersort(int numbersort) {
        this.numbersort = numbersort;
    }
}
