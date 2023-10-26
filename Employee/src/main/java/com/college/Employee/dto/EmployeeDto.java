package com.college.Employee.dto;

import jakarta.persistence.Column;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDto {
    public long id;
    public String empName;
    public long empSalary;
    public String empAddress;

    public long getId() {
        return id;
    }

    public long getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(long empSalary) {
        this.empSalary = empSalary;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }
}
