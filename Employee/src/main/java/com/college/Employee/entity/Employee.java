package com.college.Employee.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "EmpName")
    private String empName;
    @Column(name = "EmpSalary")
    private long empSalary;
    @Column(name = "EmpAddress")
    private String empAddress;


}
