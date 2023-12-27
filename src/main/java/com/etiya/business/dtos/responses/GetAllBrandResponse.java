package com.etiya.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBrandResponse {
    private int id;
    private String name;
    private LocalDateTime createdDate;
}