package com.project.expensetracker.ports.repositorys;

import com.project.expensetracker.domains.models.User;

import java.util.List;

public interface UserPort {

    User saveUser(User user);

    void deleteUser(String id);

    User findUserById(String id);

    User findUserByEmail(String email);

    List<User> listUsers();
}
