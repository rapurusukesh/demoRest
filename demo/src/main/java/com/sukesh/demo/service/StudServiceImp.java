package com.sukesh.demo.service;

import com.sukesh.demo.Model.Student;
import com.sukesh.demo.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudServiceImp {
    @Autowired
    private StudentRepository studentRepo;
    public String insert(Student student){
        studentRepo.save(student);
        return "success";
    }

    public String update(Student student){
        Student existingStudent = studentRepo.findById(student.getId()).orElse(null);
        existingStudent.setName(student.getName());
        existingStudent.setPlace(student.getPlace());
        studentRepo.save(existingStudent);
        return "updated successfully!";
    }
    public Student getById(Integer sid){
        Optional<Student> findById  = studentRepo.findById(sid);
        if(findById.isPresent()){
            return findById.get();
        }
        return null;

    }

    public List<Student> getAllStudents(){
        return studentRepo.findAll();

    }

    public String deleteById(Integer sid){
        if(studentRepo.existsById(sid)){
            studentRepo.deleteById(sid);
            return "Deleted";

        }
        else {
            return "No record found";
        }
    }


}
