package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.user.requests.AddUserRequest;
import com.tobeto.rentacar.services.dtos.user.requests.DeleteUserRequest;
import com.tobeto.rentacar.services.dtos.user.requests.UpdateUserRequest;
import com.tobeto.rentacar.services.dtos.user.responses.GetByIdUserResponse;
import com.tobeto.rentacar.services.dtos.user.responses.GetAllUserResponse;

import java.util.List;

public interface UserService {
    void add(AddUserRequest request);
    void delete(DeleteUserRequest request);
    void update(UpdateUserRequest request);
    List<GetAllUserResponse> getAll();
    GetByIdUserResponse getById(int id);
    GetByIdUserResponse getByEmail(String email);
}
