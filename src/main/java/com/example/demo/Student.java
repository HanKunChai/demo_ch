package com.example.demo;

import org.springframework.data.jdbc.core.JdbcAggregateTemplate;

import java.time.LocalDate;
import java.util.Date;
public class Student {
    private String name;
    private String address;
    private LocalDate dob;
    private String course;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    public void setDob(String dob){
        setDob(LocalDate.parse(dob));
    }
    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
