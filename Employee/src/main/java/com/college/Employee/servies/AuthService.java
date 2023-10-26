package com.college.Employee.servies;

import com.college.Employee.dto.LoginDto;
import com.college.Employee.dto.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);

    String changeRole(String name,String role);
}
