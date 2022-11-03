package com.example.purplepeople.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long idx;
    @Column
    @NotNull
    private Long useridx;
    @Column
    @NotNull
    private String type;
    @Column
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @Column
    @NotNull
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime start_time;
    @Column
    @NotNull
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime stop_time;
}
