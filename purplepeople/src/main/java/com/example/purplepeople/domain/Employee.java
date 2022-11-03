package com.example.purplepeople.domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "employee")
public class Employee {
    @Id
    @NotNull
    private String empnum;
    @NonNull
    @Column
    private String manager;
}
