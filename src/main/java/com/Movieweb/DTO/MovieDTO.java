package com.Movieweb.DTO;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieDTO {
    private String moviename;
    private String movieproduced;
    private String moviereview;
}
