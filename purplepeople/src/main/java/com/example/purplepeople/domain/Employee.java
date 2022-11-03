package com.example.purplepeople.domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "cause")
public class Cause {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    @NonNull
    @Column
    private String title;
    @NonNull
    @Column
    private String contents;
}
