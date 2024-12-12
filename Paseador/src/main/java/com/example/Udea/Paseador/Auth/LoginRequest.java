package com.example.Udea.Paseador.Auth;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginRequest {
    String userName;
    String password;
}
