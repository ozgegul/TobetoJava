package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.services.abstracts.UserService;
import com.tobeto.rentacar.services.dtos.user.requests.AddUserRequest;
import com.tobeto.rentacar.services.dtos.user.requests.DeleteUserRequest;
import com.tobeto.rentacar.services.dtos.user.requests.UpdateUserRequest;
import com.tobeto.rentacar.services.dtos.user.responses.GetAllUserResponse;
import com.tobeto.rentacar.services.dtos.user.responses.GetByIdUserResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UsersController {
    private final UserService userService;

    @PostMapping("/add")
    public void add(@RequestBody AddUserRequest request){
        userService.add(request);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody @Valid DeleteUserRequest request){
        userService.delete(request);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateUserRequest request){
        userService.update(request);
    }

    @GetMapping("/getAll")
    public List<GetAllUserResponse> getAll(){
        return userService.getAll();
    }

    @GetMapping("/getById")
    public GetByIdUserResponse getById(@RequestParam int id){
        return userService.getById(id);
    }
}
