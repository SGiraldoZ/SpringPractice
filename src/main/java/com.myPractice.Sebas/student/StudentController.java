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

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id){
        this.studentService.deleteStudent(id);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId,
                              @RequestParam(required = false) String newName,
                              @RequestParam(required = false) String newEmail){
        studentService.updateStudent(studentId, newName, newEmail);
    }
}
