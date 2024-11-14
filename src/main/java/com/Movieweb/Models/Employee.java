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
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long employeeId;
    @Column(unique = true,columnDefinition = "VARCHAR(255) COLLATE utf8mb4_unicode_ci")
    String employeeName;
    String password;

}
