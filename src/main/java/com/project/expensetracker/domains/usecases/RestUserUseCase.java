package com.project.expensetracker.domains.usecases;

import com.project.expensetracker.domains.models.User;
import com.project.expensetracker.ports.repositorys.UserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RestUserUseCase {

    @Autowired
    private UserPort port;

    public List<User> listUsers() {
        var teste = User.builder().id("").name("").email("").password("").build();

        teste.toString();
        return port.listUsers();
    }

    public User createUser(User user) {

        return port.createUser(user);
    }
}
