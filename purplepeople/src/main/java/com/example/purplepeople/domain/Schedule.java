package com.example.purplepeople.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "user")
public class Schedule {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
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
    private Date date;
    @Column
    @NotNull
    private Time starttime;
    @Column
    @NotNull
    private Time stoptime;
}
