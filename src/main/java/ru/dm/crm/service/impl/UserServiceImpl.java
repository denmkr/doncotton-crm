package ru.dm.crm.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dm.crm.entity.User;
import ru.dm.crm.repository.UserRepository;
import ru.dm.crm.service.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Denis on 31.03.18.
 */

@Service
public class UserServiceImpl implements UserService {

    @Resource
    public UserRepository userRepository;

    @Override
    @Transactional
    public User create(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    @Transactional
    public User findById(long id) {
        return userRepository.findOne(id);
    }

    @Override
    @Transactional
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Long countOfUsers() {
        return userRepository.countOfUsers();
    }

    @Override
    public User update(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    @Transactional
    public User delete(long id) {
        User deletedUser = userRepository.findOne(id);
        userRepository.delete(deletedUser);
        return deletedUser;
    }

    @Override
    @Transactional
    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        return users;
    }

}