package com.revature.foundations.services;

import com.revature.foundations.daos.ERSUsersDAO;
import com.revature.foundations.models.ERSUsers;

import java.util.List;
import java.util.stream.Collectors;

public class ERSUsersService {

    private ERSUsersDAO userDAO;

    public ERSUsersService(ERSUsersDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<ERSUsers> getAllUsers() {

        return ERSUsersDAO.getAll()
                .stream()
                .map(ERSUsersDAO::new) // intermediate operation
                .collect(Collectors.toList());
    }

}
