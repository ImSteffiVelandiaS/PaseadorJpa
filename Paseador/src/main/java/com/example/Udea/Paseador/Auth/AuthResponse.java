package com.example.Udea.Paseador.Auth;

import com.example.Udea.Paseador.Entidades.Rol;
import com.example.Udea.Paseador.Entidades.User;
import com.example.Udea.Paseador.Entidades.UserRepository;
import com.example.Udea.Paseador.JWT.JwtService;
import lombok.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    String token;

    @Service
    @RequiredArgsConstructor
    public static class AuthService {

        private final UserRepository userRepository; // Inyecta el repositorio
        private  final JwtService jwtservice;
        private final AuthenticationManager authenticationManager;

        public AuthResponse login(LoginRequest request) {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
            UserDetails user=userRepository.findByUserName(request.getUserName()).orElseThrow();
            String token=jwtservice.getToken(user);
           //retorno de respuesta
            return builder()
                    .token(token)
                    .build();

        }

        public AuthResponse register(RegisterRequest request) {
            // Crear usuario
            User user = new User();
            user.setUserName(request.getUsername());
            user.setPassword(request.getPassword()); //passenconder
            user.setFirstname(request.getFirstname());
            user.setLastname(request.getLastname());
            user.setCountry(request.getCountry());
            user.setRole(Rol.USER);

            // Guardar usuario en la base de datos
            userRepository.save(user);

            // Retornar respuesta
            return builder()
                    .token(jwtservice.getToken(user))
                    .build();
        }
    }
}
