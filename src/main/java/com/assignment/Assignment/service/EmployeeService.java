package com.assignment.Assignment.service;

import com.assignment.Assignment.controller.Request.EmployeeRequest;
import com.assignment.Assignment.entity.Employee;
import com.assignment.Assignment.entity.Team;
import com.assignment.Assignment.repository.EmployeeRepository;
import com.assignment.Assignment.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    TeamRepository teamRepository;

    public List<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }

    public List<Employee> getTeamEmployees(Long teamId) {
        return this.employeeRepository.findByTeamId(teamId);
    }

    public Employee saveEmployee(EmployeeRequest request){

        Team team = teamRepository.findById(request.getTeamId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        Employee employee = new Employee();

        employee.setName(request.getName());
        employee.setNick(request.getNick());
        employee.setTeam(team);

        return employeeRepository.save(employee);
    }
}
