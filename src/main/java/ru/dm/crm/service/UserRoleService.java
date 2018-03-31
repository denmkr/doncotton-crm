package ru.dm.crm.service;

import ru.dm.crm.entity.User;
import ru.dm.crm.entity.UserRole;

/**
 * Created by Denis on 31.03.18.
 */

public interface UserRoleService {
    UserRole createUser(User user);
    UserRole createAdmin(User user);
    UserRole createPartner(User user);

    UserRole findByUserId(Long userId);

    void deleteByUserId(Long userId);

    void changeUserRole(String authority, Long userId);
}