package com.itheima.pojo;

import java.util.Date;

public class Employee {
    private Integer empno;
    private String ename;
    private String job;
    private Date hiredate;
    private Double sal;
    private Double comm;
    private Integer deptno;

    @Override
    public String toString() {
        return "Employee{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", hiredate=" + hiredate +
                ", sal=" + sal +
                ", comm=" + comm +
                ", deptno=" + deptno +
                '}';
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public void setComm(Double comm) {
        this.comm = comm;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public Integer getEmpno() {
        return empno;
    }

    public String getEname() {
        return ename;
    }

    public String getJob() {
        return job;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public Double getSal() {
        return sal;
    }

    public Double getComm() {
        return comm;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public Employee() {
    }

    public Employee(Integer empno, String ename, String job, Date hiredate, Double sal, Double comm, Integer deptno) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.deptno = deptno;
    }
}
