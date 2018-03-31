package ru.dm.crm.service;

import ru.dm.crm.entity.User;

import java.util.List;

/**
 * Created by Denis on 31.03.18.
 */

public interface UserService {
    User create(User user);
    User delete(long id);
    List<User> findAll();
    User findById(long id);
    User findByEmail(String email);
    Long countOfUsers();
    User update(User user);
}