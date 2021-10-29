package com.studentrecord.studentspringrecordh2data.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int studentId;

    @NotBlank(message = "Please Add Student Name")
    @Length(min=3, max = 10, message = "Student name exist its limit of 10")
    private String studentName;
    private String studentAddress;
    private long studentPhoneNo;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public long getStudentPhoneNo() {
        return studentPhoneNo;
    }

    public void setStudentPhoneNo(long studentPhoneNo) {
        this.studentPhoneNo = studentPhoneNo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentAddress='" + studentAddress + '\'' +
                ", studentPhoneNo=" + studentPhoneNo +
                '}';
    }
}
