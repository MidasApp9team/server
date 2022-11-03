package com.example.purplepeople.mapper;

import com.example.purplepeople.domain.Schedule;
import com.example.purplepeople.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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

}
