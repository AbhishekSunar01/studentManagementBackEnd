package com.abhishek.studentmanagementbackend.respository;

import com.abhishek.studentmanagementbackend.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Long> {
}
