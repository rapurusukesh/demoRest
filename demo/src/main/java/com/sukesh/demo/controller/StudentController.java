package com.sukesh.demo.controller;

import com.sukesh.demo.Model.Student;
import com.sukesh.demo.service.StudServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudServiceImp studService;
    @PostMapping("/student")
    public ResponseEntity<String> createStud(@RequestBody Student student){
        String status = studService.insert(student);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }


    @GetMapping("/student/{sid}")
    public ResponseEntity<Student> getStudent(@PathVariable Integer sid){
       Student student = studService.getById(sid);
       return new ResponseEntity<>(student, HttpStatus.OK);
    }
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> allStudents = studService.getAllStudents();
        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }
    @DeleteMapping("/student/{sid}")
    public ResponseEntity<String> deleteStud(@PathVariable Integer sid){
        String status = studService.deleteById(sid);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
    @PutMapping("/updatestudent")
    public ResponseEntity<String> updateStudent(@RequestBody Student student){
        String status = studService.update(student);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

}
