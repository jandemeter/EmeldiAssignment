package com.assignment.Assignment.controller.Request;

import com.assignment.Assignment.entity.Dayparts;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class VacationRequest {
    private LocalDate fromDate;
    private Dayparts fromDaypart;
    private LocalDate toDate;
    private Dayparts toDaypart;
    private Long createdById;
}
