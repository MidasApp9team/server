package com.example.purplepeople.controller;

import com.example.purplepeople.domain.Cause;
import com.example.purplepeople.domain.Grant;
import com.example.purplepeople.domain.Schedule;
import com.example.purplepeople.mapper.CauseMapper;
import com.example.purplepeople.mapper.GrantMapper;
import com.example.purplepeople.mapper.ScheduleMapper;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import purple.common.controller.CommonRestControllerPrototype;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/schedule")
public class RestScheduleController extends CommonRestControllerPrototype {
    @Autowired
    private ScheduleMapper scheduleMapper;
    @Autowired
    private GrantMapper grantMapper;
    @Autowired
    private CauseMapper causeMapper;

    @PostMapping("/create")
    @ApiOperation("스케쥴 생성")
    public int CreateSchedule(
            @RequestBody
            Schedule schedule) {
        return scheduleMapper.register(schedule);
    }
    @PostMapping("/delete")
    @ApiOperation("스케쥴 제거")
    public Long DeleteSchedule(
            @RequestBody
            Schedule Schedule) {
        return scheduleMapper.delete(Schedule.getIdx());
    }
    @PostMapping("/get")
    @ApiOperation("스케쥴 조회")
    public Object getSchedule(
            @RequestBody
            Schedule schedule) {
        return scheduleMapper.getByDate(schedule);
    }
}
