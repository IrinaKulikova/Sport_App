package application.helper;

public class ScheduleSender {
    String name="";
    String attributeTime="";
    String attributeDay="";
    public ScheduleSender(String name) {
        this.name = name;
    }
    public ScheduleSender(String name, String attributeTime, String attributeDay) {
        this.name = name;
        this.attributeTime = attributeTime;
        this.attributeDay = attributeDay;
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
}
