package com.itheima.pojo;

public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private Classes c;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", c=" + c +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Classes getC() {
        return c;
    }

    public void setC(Classes c) {
        this.c = c;
    }

    public Student() {
    }

    public Student(Integer id, String name, Integer age, Classes c) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.c = c;
    }
}
