package com.project.expensetracker.ports.repositorys;

import com.project.expensetracker.domains.models.User;

import java.util.List;

public interface UserPort {

    List<User> listUsers();

    User createUser(User user);
}
