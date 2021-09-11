package com.myPractice.Sebas.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import com.myPractice.Sebas.student.*;

@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {

    private final studentService studentService;



    @Autowired
    public StudentController(studentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudent(){
        return this.studentService.getStudent();
    }

    @PostMapping
    public void  registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }
}
