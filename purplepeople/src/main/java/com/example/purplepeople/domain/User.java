package com.example.purplepeople.domain;


import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @NotNull
    private Long idx;
    @Column
    @NotNull
    private String name;
    @Column
    @NotNull
    private String telephone;
    @Column
    @NotNull
    private String password;
    @Column
    @NotNull
    private char access;
    @Column
    @NotNull
    private String empnum;

    public Long getIdx() {
        return idx;
    }
    public String getName() {
        return name;
    }
    public String getTelephone() {
        return telephone;
    }
    public String getPassword() {
        return password;
    }
    public char getAccess() {
        return access;
    }
    public String getEmpnum() {
        return empnum;
    }
}
