package com.assignment.Assignment.controller;

import com.assignment.Assignment.controller.Request.VacationRequest;
import com.assignment.Assignment.entity.Vacation;
import com.assignment.Assignment.service.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vacation")
public class VacationController {

    @Autowired
    VacationService vacationService;

    @GetMapping
    public ResponseEntity<List<Vacation>> getVacations(){
        List<Vacation> vacations = this.vacationService.getAllVacations();
        return ResponseEntity.ok(vacations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vacation> getVacation(@PathVariable("id") Long vacationId){
        Optional<Vacation> vacation = this.vacationService.getVacation(vacationId);
        return vacation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<Vacation>> getVacationsByEmployeeId(@PathVariable Long employeeId) {
        List<Vacation> vacations = vacationService.getVacationsByEmployeeId(employeeId);
        if (vacations.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(vacations);
    }


    @PostMapping
    public ResponseEntity<Vacation> saveVacation(@RequestBody VacationRequest vacationRequest){
        Vacation newVacation = this.vacationService.saveVacation(vacationRequest);
        return ResponseEntity.ok(newVacation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVacation(@PathVariable("id") Long vacationId){
        vacationService.deleteVacation(vacationId);
        return ResponseEntity.ok("Vacation deleted successfully");
    }
}
