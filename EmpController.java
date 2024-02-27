package com.praveen.controller;


import com.praveen.model.Employee;

import com.praveen.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class EmpController {
    @Autowired
    private EmployeeService service;




    @PostMapping("/employees")
    public String saveData(@RequestBody Employee employee) {

        boolean flag = service.saveRecord(employee);
        String msg;
        if (!flag) {
            msg = "Error employee already exist...";
        } else {
            msg = "Employee record saved successfully...";
        }
        return msg;
    }

    @GetMapping("/get/{id}")
    public Employee getOne(@PathVariable int id) {
        return service.getOneRecord(id);
    }

    @GetMapping("/getAll")
    public List<Employee> getAll() {
        return service.getAllRecord();
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<String> deleteEmployeeByName(@PathVariable String name) {
        try {
            service.deleteEmployeeByName(name);
            return ResponseEntity.ok("Employee deleted successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting employee");
        }
    }


}
