package com.itheima.domain;

public class Student {
        private Integer id;
        private String firstName;
        private String fullName;
        private Integer age;
        private Integer rowNum;
        private Integer colNum;

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", firstName='" + firstName + '\'' +
                    ", fullName='" + fullName + '\'' +
                    ", age=" + age +
                    ", rowNum=" + rowNum +
                    ", colNum=" + colNum +
                    '}';
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Integer getRowNum() {
            return rowNum;
        }

        public void setRowNum(Integer rowNum) {
            this.rowNum = rowNum;
        }

        public Integer getColNum() {
            return colNum;
        }

        public void setColNum(Integer colNum) {
            this.colNum = colNum;
        }

        public Student() {
        }

        public Student(Integer id, String firstName, String fullName, Integer age, Integer rowNum, Integer colNum) {
            this.id = id;
            this.firstName = firstName;
            this.fullName = fullName;
            this.age = age;
            this.rowNum = rowNum;
            this.colNum = colNum;
        }
    }
