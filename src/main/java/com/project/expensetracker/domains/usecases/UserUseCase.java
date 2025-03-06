package com.project.expensetracker.domains.usecases;

import com.project.expensetracker.domains.models.User;
import com.project.expensetracker.ports.repositorys.UserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class UserUseCase {

    @Autowired
    private UserPort port;

    public User createUser(User user) {
        return port.saveUser(user);
    }

    public User updateUser(String id, User model) {
        var user = port.findUserById(id);
        if (Objects.isNull(user)) {
            return null; // throw error
        }
        model.setId(id);
        return port.saveUser(model);
    }

    public void deleteUser(String id) {
        var user = port.findUserById(id);
        if (Objects.isNull(user)) {
            return; // throw error
        }
        port.deleteUser(id);
    }

    public User findUserById(String id) {
        var user = port.findUserById(id);
        if (Objects.isNull(user)) {
            return null; // throw error
        }
        return user;
    }

    public User findUserByEmail(String email) {
        var user = port.findUserByEmail(email);
        if (Objects.isNull(user)) {
            return null; // throw error
        }
        return user;
    }

    public List<User> listUsers() {
        return port.listUsers();
    }


}
