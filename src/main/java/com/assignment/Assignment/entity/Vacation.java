package com.assignment.Assignment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Vacation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long dateDuration;
    private LocalDate createDate;
    private Boolean approved;
    private LocalDate fromDate;
    private Dayparts fromDaypart;
    private LocalDate toDate;
    private Dayparts toDaypart;
    @ManyToOne
    @JoinColumn(name = "created_by")
    private Employee createdBy;
    @ManyToOne
    @JoinColumn(name = "approved_by")
    private Employee approvedBy;
}
