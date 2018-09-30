package application.entity;

public enum DayOfWeek {
    Monday("Понедельник",1),
    Tuesday("Вторник",2),
    Wednesday("Среда",3),
    Thursday("Четверг",4),
    Friday("Пятница",5),
    Saturday("Суббота",6),
    Sunday("Воскресенье",7);


    private String name;
    private int numderDay;
    DayOfWeek(String nameDay,int numder){
      name=nameDay;
      numderDay=numder;
    }

    public String getDay(int idx){
      for(DayOfWeek c:DayOfWeek.values()){
          if(idx==c.numderDay){
              return c.name;
          }
      }
        return "no info for Day";
    }

}
