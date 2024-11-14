package com.Movieweb.Models;

import jakarta.persistence.*;
import lombok.*;

import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long movieId;
    @Column
    String movieName;
    @Column
    String movieProduced;
    @Column
    String movieReview;
}
