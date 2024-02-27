package com.praveen.repo;

import com.praveen.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class EmployeeRepoImp implements EmployeeRepo
{

    public static HashMap<Integer, Employee> maps = new HashMap<>();


    public static void addTempEmps(HashMap<Integer, Employee> maps) {
        Employee employee1 = new Employee(1, "praveen", 50000.0, "Developer");
        Employee employee2 = new Employee(2, "rama", 40000.0, "pilot");
        Employee employee3 = new Employee(3, "ravi", 195000, "president");
        Employee employee4 = new Employee(4, "sravani", 60000, "Analyst");
        maps.put(employee1.getId(), employee1);
        maps.put(employee2.getId(), employee2);
        maps.put(employee3.getId(), employee3);
        maps.put(employee4.getId(), employee4);
    }
}
