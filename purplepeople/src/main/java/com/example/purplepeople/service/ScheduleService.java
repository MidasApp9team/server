package com.example.purplepeople.service;

import com.example.purplepeople.domain.Schedule;

import java.time.LocalDate;

public interface ScheduleService {
    public int register(Schedule schedule);
    public Schedule getByDate(LocalDate date);
}