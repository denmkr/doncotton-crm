package ru.dm.crm.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dm.crm.entity.User;
import ru.dm.crm.entity.UserRole;
import ru.dm.crm.repository.UserRoleRepository;
import ru.dm.crm.service.UserRoleService;

import javax.annotation.Resource;

/**
 * Created by Denis on 31.03.18.
 */

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Resource
    public UserRoleRepository userRoleRepository;

    @Override
    @Transactional
    public UserRole createUser(User user) {
        UserRole role = new UserRole();
        role.setUserId(user.getId());
        role.setAuthority("ROLE_USER");
        return userRoleRepository.saveAndFlush(role);
    }

    @Override
    @Transactional
    public UserRole createAdmin(User user) {
        UserRole role = new UserRole();
        role.setUserId(user.getId());
        role.setAuthority("ROLE_ADMIN");
        return userRoleRepository.saveAndFlush(role);
    }

    @Override
    public UserRole createPartner(User user) {
        UserRole role = new UserRole();
        role.setUserId(user.getId());
        role.setAuthority("ROLE_PARTNER");
        return userRoleRepository.saveAndFlush(role);
    }

    @Override
    public UserRole findByUserId(Long userId) {
        return userRoleRepository.findByUserId(userId);
    }

    @Override
    public void deleteByUserId(Long userId) {
        userRoleRepository.deleteByUserId(userId);
    }

    @Override
    public void changeUserRole(String authority, Long userId) {
        userRoleRepository.updateAuthorityByUserId(authority, userId);
    }

}
