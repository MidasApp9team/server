package com.example.purplepeople.mapper;

import com.example.purplepeople.domain.Schedule;
import com.example.purplepeople.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Mapper
@Repository
public interface ScheduleMapper {
    /**
     * 일정을 등록한다.
     *
     * @param schedule schedule
     * @return 등록한 스케쥴의 번호
     */
    public int register(Schedule schedule);
    /**
     * 일정을 삭제한다.
     *
     * @param schedule schedule
     * @return 등록한 스케쥴의 번호
     */
    public int delete(Schedule schedule);
    /**
     * 일정을 조회한다.
     *
     * @param schedule schedule
     * @return 등록한 스케쥴의 번호
     */
    public Schedule getByDate(LocalDate date);
}
