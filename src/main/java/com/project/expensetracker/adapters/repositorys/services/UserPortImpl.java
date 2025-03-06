package com.project.expensetracker.adapters.repositorys.services;

import com.project.expensetracker.adapters.repositorys.jpa.UserRepository;
import com.project.expensetracker.adapters.repositorys.mappers.UserEntityMapper;
import com.project.expensetracker.domains.models.User;
import com.project.expensetracker.ports.repositorys.UserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserPortImpl implements UserPort {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserEntityMapper mapper;

    @Override
    public List<User> listUsers() {
        var res = repository.findAll();
        return res.stream().map(mapper::toModel).toList();
    }

    @Override
    public User createUser(User user) {
        var savedUser = repository.save(mapper.toEntity(user));
        return mapper.toModel(savedUser);

    }
}
