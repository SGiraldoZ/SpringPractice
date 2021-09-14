package com.myPractice.Sebas.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;


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
//        studentRepository.save(student);


            //SERVER SIDE VALIDATIONS
            if (this.studentRepository.findStudentByEmail(student.getEmail()).isPresent()) {
                throw new IllegalStateException("Email taken");
            }
            studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        boolean exists = studentRepository.existsById(id);
        if(!exists) {
            throw new IllegalStateException(
                    "Student id " + id + " does not exist"
            );
        }
        studentRepository.deleteById(id);

    }

    @Transactional
    public void updateStudent(Long studentId, String newName, String newEmail){



        Optional<Student> optionalStudent =studentRepository.findById(studentId);

        if(optionalStudent.isEmpty()) {
            throw new IllegalStateException(
                    "Student id " + studentId + " does not exist"
            );
        }

        Student s = optionalStudent.get();

        if(newEmail!=null && !newEmail.isBlank() && s.getEmail().compareTo(newEmail) != 0){

            if (studentRepository.findStudentByEmail(newEmail).isPresent()){
                throw new IllegalStateException("Email taken");
            }

            s.setEmail(newEmail);
        }


        if(newName!= null && !newName.isBlank())
            s.setName(newName);
    }
}
