package com.clone.petclinic.controller.dto;

import com.clone.petclinic.domain.Visit;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetsVisitResponseDto {
    private String visitDate;
    private String description;

    public PetsVisitResponseDto(Visit visit){
        this.visitDate = visit.getDate().toString();
        description = visit.getDescription();
    }
}
