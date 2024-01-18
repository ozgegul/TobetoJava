package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.JwtService;

import com.tobeto.rentacar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentacar.entities.User;
import com.tobeto.rentacar.enums.Role;
import com.tobeto.rentacar.services.abstracts.AuthenticationService;
import com.tobeto.rentacar.services.abstracts.UserService;
import com.tobeto.rentacar.services.dtos.authentication.requests.AuthenticationRequest;
import com.tobeto.rentacar.services.dtos.authentication.requests.RegisterRequest;
import com.tobeto.rentacar.services.dtos.authentication.responses.AuthenticationResponse;
import com.tobeto.rentacar.services.dtos.user.requests.AddUserRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticateManager implements AuthenticationService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapperService modelMapperService;
    private final JwtService jwtService;
    private final org.springframework.security.authentication.AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                        .role(Role.USER)
                        .build();
        userService.add(this.modelMapperService.forRequest().map(user, AddUserRequest.class));
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userService.getByEmail(request.getEmail());
        var jwtToken = jwtService.generateToken(modelMapperService.forResponse().map(user, User.class));
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
