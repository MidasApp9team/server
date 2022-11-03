package com.example.purplepeople.service.impl;

import com.example.purplepeople.domain.Cause;
import com.example.purplepeople.mapper.EmployeeMapper;
import com.example.purplepeople.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public String getManager(String empnum) {
        return employeeMapper.getManager(empnum);
    }
}
