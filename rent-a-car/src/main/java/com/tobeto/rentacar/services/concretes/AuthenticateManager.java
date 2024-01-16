package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.JwtService;

import com.tobeto.rentacar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentacar.entities.Customer;
import com.tobeto.rentacar.enums.Role;
import com.tobeto.rentacar.services.abstracts.AuthenticationService;
import com.tobeto.rentacar.services.abstracts.CustomerService;
import com.tobeto.rentacar.services.dtos.authentication.requests.AuthenticationRequest;
import com.tobeto.rentacar.services.dtos.authentication.requests.RegisterRequest;
import com.tobeto.rentacar.services.dtos.authentication.responses.AuthenticationResponse;
import com.tobeto.rentacar.services.dtos.customer.requests.AddCustomerRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticateManager implements AuthenticationService {
    private final CustomerService customerService;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapperService modelMapperService;
    private final JwtService jwtService;
    private final org.springframework.security.authentication.AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        Customer customer = Customer.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                        .role(Role.USER)
                        .build();
        customerService.add(this.modelMapperService.forRequest().map(customer, AddCustomerRequest.class));
        var jwtToken = jwtService.generateToken(customer);
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
        var customer = customerService.getByEmail(request.getEmail());
        var jwtToken = jwtService.generateToken(modelMapperService.forResponse().map(customer, Customer.class));
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
