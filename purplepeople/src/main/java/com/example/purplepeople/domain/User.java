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
    private String empnum;
    @Column
    @NotNull
    private String name;
    @Column
    @NotNull
    private String email;
    @Column
    @NotNull
    private String telephone;
    @Column
    @NotNull
    private String password;
    @Column
    private char access;
    @Column
    private char grant_emp;

    public Long getIdx() {
        return idx;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
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
    public char getGrant_emp() {
        return grant_emp;
    }

    public void setEmpnum(String empnum) {
        this.empnum = empnum;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
