package com.studentrecord.studentspringrecordh2data.repository;

import com.studentrecord.studentspringrecordh2data.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Optional<Student> getByStudentId(int id);

    @Query("select s from Student s")
    List<Student> findAllRecords();

    @Query("select s from Student s where s.studentAddress like %?1 ")
    List<Student> getAddressByLocation(String name);

    @Query(value = "select * from Student ORDER BY studentId DESC ", nativeQuery = true)
    List<Student> getReverseRecord();
}
