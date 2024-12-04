package com.Movieweb.DTO.Requests;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.FetchProfile;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationRequest {
    String username;
    String password;
}
