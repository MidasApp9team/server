package com.example.purplepeople.service;

import com.example.purplepeople.domain.Schedule;

import java.time.LocalDate;

public interface ScheduleService {
    public int register(Schedule schedule);
    public Long delete(Long idx);
    public Schedule getByDate(Schedule schedule);
}