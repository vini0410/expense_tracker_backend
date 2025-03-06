package com.project.expensetracker.adapters.web.controllers;

import com.project.expensetracker.adapters.web.dtos.UserDto;
import com.project.expensetracker.adapters.web.mappers.UserDtoMapper;
import com.project.expensetracker.domains.usecases.RestUserUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private RestUserUseCase useCase;

    @Autowired
    private UserDtoMapper mapper;

    @PostMapping
    public UserDto postUser(@RequestBody @Valid UserDto user) {
        LOGGER.info("POST User", user);
        var res = useCase.createUser(mapper.toModel(user));
        return mapper.toDto(res);
    }

    @PatchMapping("/{id}")
    public UserDto patchUser(@PathVariable String id, @RequestBody @Valid UserDto user) {
        LOGGER.info("PATCH User", id, user);
        var res = useCase.updateUser(id, (mapper.toModel(user)));
        return mapper.toDto(res);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable String id) {
        LOGGER.info("DELETE User", id);
        useCase.deleteUser(id);
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable String id) {
        LOGGER.info("GET User", id);
        var res = useCase.findUserById(id);
        return mapper.toDto(res);
    }

    @GetMapping("/email")
    public UserDto getUserByEmail(@RequestParam String email) {
        LOGGER.info("GET User", email);
        var res = useCase.findUserByEmail(email);
        return mapper.toDto(res);
    }

    @GetMapping
    public List<UserDto> getUsers() {
        LOGGER.info("GET Users");
        var res = useCase.listUsers();
        return res.stream().map(mapper::toDto).toList();
    }
}
