package com.project.expensetracker.adapters.repositorys.services;

import com.project.expensetracker.adapters.repositorys.jpa.UserRepository;
import com.project.expensetracker.adapters.repositorys.mappers.UserEntityMapper;
import com.project.expensetracker.domains.models.User;
import com.project.expensetracker.ports.repositorys.UserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserPortImpl implements UserPort {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserEntityMapper mapper;

    public User saveUser(User user) {
        var savedUser = repository.save(mapper.toEntity(user));
        return mapper.toModel(savedUser);

    }

    @Override
    public void deleteUser(String id) {
        repository.deleteById(id);
    }

    @Override
    public User findUserById(String id) {
        var res = repository.findById(id).orElse(null);
        return mapper.toModel(res);
    }

    @Override
    public User findUserByEmail(String email) {
        var res = repository.findByEmail(email).orElse(null);
        if (Objects.isNull(res)) {
            return null;
        }
        return mapper.toModel(res);
    }

    @Override
    public List<User> listUsers() {
        var res = repository.findAll();
        return res.stream().map(mapper::toModel).toList();
    }
}
