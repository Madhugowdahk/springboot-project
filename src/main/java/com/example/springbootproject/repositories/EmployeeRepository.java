package com.example.springbootproject.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootproject.entities.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

