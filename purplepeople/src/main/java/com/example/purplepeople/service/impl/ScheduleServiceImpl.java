package com.example.purplepeople.service.impl;

import com.example.purplepeople.domain.Schedule;
import com.example.purplepeople.mapper.ScheduleMapper;
import com.example.purplepeople.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleMapper scheduleMapper;

    @Override
    public int register(Schedule schedule) {
        return scheduleMapper.register(schedule);
    }

    @Override
    public Schedule getByDate(LocalDate date) {
        return scheduleMapper.getByDate(date);
    }

}
