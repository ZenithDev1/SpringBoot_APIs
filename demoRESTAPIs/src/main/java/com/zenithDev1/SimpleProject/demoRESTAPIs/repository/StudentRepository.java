package com.zenithDev1.SimpleProject.demoRESTAPIs.repository;

import com.zenithDev1.SimpleProject.demoRESTAPIs.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
