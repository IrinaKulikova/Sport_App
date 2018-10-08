package application.repository;

import application.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface ScheduleRepository extends JpaRepository<Schedule,Integer> {
  /*  @Modifying
    @Query("insert into schedule (dayid,starttime,event_schedule) values(:dayid,:strtime,:schid)")
    public void midifyingQuryInsertSchadule(@Param("dayid")int dayid,@Param("strtime") String description,@Param("schid") int filepath);*/
}
