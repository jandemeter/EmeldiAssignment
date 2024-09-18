package com.assignment.Assignment.controller;

import com.assignment.Assignment.entity.Employee;
import com.assignment.Assignment.entity.Team;
import com.assignment.Assignment.service.EmployeeService;
import com.assignment.Assignment.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    TeamService teamService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Team>> getAllTeams() {
        List<Team> teams = this.teamService.getAllTeams();
        return ResponseEntity.ok(teams);
    }

    @PostMapping
    public ResponseEntity<Team> saveTeam(@RequestBody Team team) {
        Team newTeam = this.teamService.saveTeam(team);
        return ResponseEntity.ok(newTeam);
    }

    @GetMapping("/{teamId}/employees")
    public ResponseEntity<List<Employee>> getTeamEmployees(@PathVariable("teamId") Long teamId) {
        List<Employee> employees = this.employeeService.getTeamEmployees(teamId);
        if (employees.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(employees);
    }
}
