package com.studentrecord.studentspringrecordh2data.service;

import com.studentrecord.studentspringrecordh2data.entity.Student;
import com.studentrecord.studentspringrecordh2data.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public ResponseEntity<List<Student>> getAllRecords() {
        List<Student> students =  studentRepository.findAllRecords();
        if(!students.isEmpty()){
            return new ResponseEntity<> (students, HttpStatus.OK);
        }
        return ResponseEntity.notFound().eTag("No records Present..").build();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public ResponseEntity<Student> getRecordId(int id) {
        Optional<Student> student = studentRepository.getByStudentId(id);
        if(student.isPresent()){
            return ResponseEntity.ok(student.get());
        }
        return ResponseEntity.notFound().eTag("Student Id not exists..").build();
    }

    @Override
    public ResponseEntity<Student> update(int id, Student student) {
        if(studentRepository.existsById(id)){
            return ResponseEntity.ok(studentRepository.save(student));
        }
        return ResponseEntity.notFound().eTag("Id not exists").build();
    }

    @Override
    public ResponseEntity<Object> deleteByRecordId(int id) {
        if(studentRepository.existsById(id)){
            studentRepository.deleteById(id);
            return ResponseEntity.ok().eTag("Id : "+id+" deleted").build();
        }
        return ResponseEntity.notFound().eTag("Id not Exists").build();
    }

    @Override
    public ResponseEntity<List<Student>> bulkInsert(List<Student> students) {
        if(students!=null){
            studentRepository.saveAll(students);
            return ResponseEntity.ok(students);
        }
        return ResponseEntity.badRequest().eTag("Records are not in format").build();
    }

    @Override
    public List<Student> getByAddressLocation(String name) {
        return studentRepository.getAddressByLocation(name);
    }

    @Override
    public List<Student> getRecordInReverse() {
        return studentRepository.getReverseRecord();
    }


}
