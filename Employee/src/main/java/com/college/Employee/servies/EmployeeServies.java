package com.college.Employee.servies;

import com.college.Employee.dto.EmployeeDto;
import com.college.Employee.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeServies {
    public List<Employee> allEmployeeDetail();
    public Employee saveEmployee( EmployeeDto emp);

    public Employee updateEmployee(EmployeeDto emp, long id);
    public EmployeeDto EmployeeById(long id);
    public String changeRole(String Name);
}
