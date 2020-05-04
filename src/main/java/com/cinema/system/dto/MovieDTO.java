package com.cinema.system.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDTO {

    private Integer id;

    private String name;

    private String producer;

    private double duration;
}
