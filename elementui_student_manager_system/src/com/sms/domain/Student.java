package com.sms.domain;

import java.sql.Date;

public class Student {
    private String number;
    private String name;
    private Date birthday;
    private String address;

    @Override
    public String toString() {
        return "Student{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                '}';
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Student() {
    }

    public Student(String number, String name, Date birthday, String address) {
        this.number = number;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
    }
}
