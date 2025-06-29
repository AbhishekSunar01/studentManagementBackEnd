package com.abhishek.studentmanagementbackend.service;

import com.abhishek.studentmanagementbackend.model.Student;
import com.abhishek.studentmanagementbackend.respository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Optional<Student> getStudentById(long id){
        return studentRepo.findById(id);
    }

    public List<Student> getStudents(){
        return studentRepo.findAll();
    }

    public Student createStudent(Student student){
        return studentRepo.save(student);
    }

    public Student updateStudent(long id,Student student){
        Optional<Student> optionalStudent = studentRepo.findById(id);
        if(optionalStudent.isPresent()){
            Student studentToUpdate = optionalStudent.get();
            studentToUpdate.setName(student.getName());
            studentToUpdate.setSection(student.getSection());
            studentToUpdate.setEmail(student.getEmail());
            studentRepo.save(studentToUpdate);
            return studentToUpdate;
        } else return null;
    }

    public void deleteStudent(long id){
        studentRepo.deleteById(id);
    }

}
