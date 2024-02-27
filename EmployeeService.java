package com.praveen.service;

import com.praveen.model.Employee;

import java.util.List;

public interface EmployeeService {


    boolean saveRecord(Employee employee);

    Employee getOneRecord(int id);

    List<Employee> getAllRecord();

    void deleteEmployeeByName(String name);
}
