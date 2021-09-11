package com.myPractice.Sebas.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


//@Service permite que se realize el autowired
@Service
public class studentService {

    private final StudentRepository studentRepository;

    @Autowired
    public studentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

//    public studentService() {
//    }

    public List<Student> getStudent(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        studentRepository.save(student);
    }
}
