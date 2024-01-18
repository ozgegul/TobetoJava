package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.services.abstracts.UserService;
import com.tobeto.rentacar.services.dtos.user.requests.AddUserRequest;
import com.tobeto.rentacar.services.dtos.user.requests.DeleteUserRequest;
import com.tobeto.rentacar.services.dtos.user.requests.UpdateUserRequest;
import com.tobeto.rentacar.services.dtos.user.responses.GetByIdUserResponse;
import com.tobeto.rentacar.services.dtos.user.responses.GetAllUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserManager implements UserService {


    @Override
    public void add(AddUserRequest request) {

    }

    @Override
    public void delete(DeleteUserRequest request) {

    }

    @Override
    public void update(UpdateUserRequest request) {

    }

    @Override
    public List<GetAllUserResponse> getAll() {
        return null;
    }

    @Override
    public GetByIdUserResponse getById(int id) {
        return null;
    }

    @Override
    public GetByIdUserResponse getByEmail(String email) {
        return null;
    }
}
