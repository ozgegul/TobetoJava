package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.authentication.requests.AuthenticationRequest;
import com.tobeto.rentacar.services.dtos.authentication.requests.RegisterRequest;
import com.tobeto.rentacar.services.dtos.authentication.responses.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);
    AuthenticationResponse authenticate(AuthenticationRequest request);
}
