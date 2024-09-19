package com.Movieweb.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor

@Component
@Entity
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long movieid;
    @Column
    private String moviename;
    @Column
    private String movieproduced;
    @Column
    private String moviereview;
}
