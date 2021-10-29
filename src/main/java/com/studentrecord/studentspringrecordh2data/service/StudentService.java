package com.studentrecord.studentspringrecordh2data.service;

import com.studentrecord.studentspringrecordh2data.entity.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService{

    public ResponseEntity<List<Student>> getAllRecords();

    Student saveStudent(Student student);

    ResponseEntity<Student> getRecordId(int id);

    ResponseEntity<Student> update(int id, Student student);

    ResponseEntity<Object> deleteByRecordId(int id);

    ResponseEntity<List<Student>> bulkInsert(List<Student> students);

    List<Student> getByAddressLocation(String name);

    List<Student> getRecordInReverse();
}
