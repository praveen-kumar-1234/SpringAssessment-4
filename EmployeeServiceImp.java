package com.praveen.service;

import com.praveen.model.Employee;
//import com.praveen.repo.EmployeeRepo;



import org.springframework.stereotype.Service;
import java.util.*;

import static com.praveen.repo.EmployeeRepoImp.addTempEmps;
import static com.praveen.repo.EmployeeRepoImp.*;


@Service
public class EmployeeServiceImp implements EmployeeService{





    @Override
    public boolean saveRecord(Employee employee) {
        addTempEmps(maps);

        boolean flag = false;
        if(!maps.containsKey(employee.getId()))
        {
         maps.put(employee.getId(), employee);
         flag=true;
        }

        return flag;
    }

    @Override
    public Employee getOneRecord(int id) {
        addTempEmps(maps);
        return maps.get(id);
    }

    @Override
    public List<Employee> getAllRecord() {
        addTempEmps(maps);
        return maps.values().stream().toList();
    }

    @Override
    public void deleteEmployeeByName(String name) {
        addTempEmps(maps);
        for (Employee employee : maps.values().stream().toList()) {
            if (employee.getName().equalsIgnoreCase(name)) {
                maps.remove(employee.getId());
                System.out.println("Employee deleted successfully.....");
            }
        }

    }


}
