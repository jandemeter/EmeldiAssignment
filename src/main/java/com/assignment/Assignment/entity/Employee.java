package com.assignment.Assignment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Employee{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String nick;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}
