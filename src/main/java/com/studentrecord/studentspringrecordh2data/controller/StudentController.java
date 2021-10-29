package com.studentrecord.studentspringrecordh2data.controller;

import com.studentrecord.studentspringrecordh2data.entity.Student;
import com.studentrecord.studentspringrecordh2data.service.StudentService;
import com.studentrecord.studentspringrecordh2data.service.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // GET

    // All Records
    @GetMapping(value = "/all")
    public ResponseEntity<List<Student>> getAllTheRecords(){
        return studentService.getAllRecords();
    }

    // GET by Id
    @GetMapping(value = "/{studentId}")
    public ResponseEntity<Student> getRecordById(@PathVariable("studentId") int id){
        return studentService.getRecordId(id);
    }

    // GET by Address
    @GetMapping(value = "address/{name}")
    public List<Student> getAllRecordByAddress(@PathVariable("name") String name){
        return studentService.getByAddressLocation(name);
    }

    // GET arrange in descending order
    @GetMapping(value = "/reverseAll")
    public List<Student> getAllRecordInReverse(){
        return studentService.getRecordInReverse();
    }

    // POST
    @PostMapping(value="/")
    @ResponseBody
    public Student createOrSave(@Valid @RequestBody Student student){
        return studentService.saveStudent(student);
    }
    // Bulk
    @PostMapping(value="/more")
    @ResponseBody
    public ResponseEntity<List<Student>> bulkInsert(@RequestBody List<Student> students){
        return studentService.bulkInsert(students);
    }

    // PUT
    @PutMapping(value="/{studentId}")
    public ResponseEntity<Student> updateOrSave(@PathVariable("studentId") int id, @RequestBody Student student){
        return studentService.update(id,student);
    }

    // DELETE
    @DeleteMapping(value="/{studentId}")
    public ResponseEntity<Object> deleteById(@PathVariable("studentId") int id){
        return studentService.deleteByRecordId(id);
    }
}
