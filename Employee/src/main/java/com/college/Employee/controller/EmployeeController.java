package com.college.Employee.controller;

import com.college.Employee.dto.EmployeeDto;
import com.college.Employee.entity.Employee;
import com.college.Employee.exception.EmployeeNotFoundException;
import com.college.Employee.repository.EmployeeRepository;
import com.college.Employee.servies.AuthService;
import com.college.Employee.serviesImple.EmployeeServiesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class EmployeeController {

    @Autowired
    private EmployeeServiesImpl employeeServiesImpl;
    @Autowired
    private AuthService authService;
    @Autowired
    private EmployeeRepository employeeRepository;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/addEmployee")

    public Employee saveEmplyoee(@RequestBody EmployeeDto emp) {
        return employeeServiesImpl.saveEmployee(emp);
    }

    @PreAuthorize("hasAuthority('USER') or hasAnyAuthority('ADMIN')")
    @GetMapping("/allEmployeeDetail")

    public List<Employee> allEmployeeDetail() {

        return employeeServiesImpl.allEmployeeDetail();
    }

    @PreAuthorize("hasAuthority('USER') or hasAnyAuthority('ADMIN')")
    @GetMapping("/EmployeeDetail/{id}")
    public ResponseEntity<EmployeeDto> employeesById(@PathVariable("id") long id) {
        EmployeeDto emp1 = employeeServiesImpl.EmployeeById(id);
        return ResponseEntity.ok(emp1);
    }

//    @PostMapping("/addEmployee")
//    public Employee saveEmplyoee(@RequestBody EmployeeDto emp) {
//        return employeeServiesImpl.saveEmployee(emp);
//    }
@PreAuthorize("hasAnyAuthority('ADMIN')")
    @PutMapping("/updateEmployee")
    public Employee updateEmployee(@RequestBody EmployeeDto emp) {
        return employeeServiesImpl.updateEmployee(emp, emp.getId());
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/changerole")
    public String changeRole(@RequestParam String username,String role) {

        return authService.changeRole(username,role);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {
        Optional<Employee> emp = employeeRepository.findById(id);
        emp.ifPresentOrElse(a -> {
            employeeRepository.deleteById(id);
        }, () -> {
            throw new EmployeeNotFoundException("Employee are not found for delete");
        });
        return ResponseEntity.ok("Employee "+emp.get().getEmpName()+" has delete successfully");
    }
}
