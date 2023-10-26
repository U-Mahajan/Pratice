package com.college.Employee.serviesImple;

import com.college.Employee.dto.EmployeeDto;
import com.college.Employee.entity.Employee;
import com.college.Employee.exception.EmployeeNotFoundException;
import com.college.Employee.repository.EmployeeRepository;
import com.college.Employee.servies.EmployeeServies;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiesImpl implements EmployeeServies {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Employee> allEmployeeDetail() {
        List<Employee> l1 = employeeRepository.findAll();
        if (l1.size() == 0) {
            throw new EmployeeNotFoundException("Data arenot found in Employee table");
        } else {
            return employeeRepository.findAll();
        }

//        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(EmployeeDto emp) {
        Employee emp1 = modelMapper.map(emp, Employee.class);
        employeeRepository.save(emp1);
        return employeeRepository.save(emp1);
    }

    @Override
    public Employee updateEmployee(EmployeeDto emp, long id) {

        Optional<Employee> employee = employeeRepository.findById(id);

        Employee emp2 = employee.orElseThrow(() -> new EmployeeNotFoundException("Not Found Employee"));
        emp2.setEmpName(emp.getEmpName());
        emp2.setEmpAddress(emp.getEmpAddress());
        employeeRepository.save(emp2);

        return employeeRepository.save(emp2);
    }

    @Override
    public EmployeeDto EmployeeById(long id) {
        Employee emp = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Not Found Employee"));
        EmployeeDto emp1 = modelMapper.map(emp, EmployeeDto.class);
        return emp1;
    }

    @Override
    public String changeRole(String Name) {
        Employee emp = employeeRepository.findByEmpName(Name);
        System.out.println(emp);
        return "S";
    }


}
