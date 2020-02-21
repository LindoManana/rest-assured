package io.javatricks.restassured.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.javatricks.restassured.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}