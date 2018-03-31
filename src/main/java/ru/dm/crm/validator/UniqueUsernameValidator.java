package ru.dm.crm.validator;

/**
 * Created by Denis on 31.03.18.
 */

import org.springframework.beans.factory.annotation.Autowired;
import ru.dm.crm.entity.User;
import ru.dm.crm.service.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    @Autowired
    UserService userService;

    @Override
    public void initialize(UniqueUsername paramA) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext ctx) {
        if(email == null) {
            return false;
        }

        User user = userService.findByEmail(email);
        if (user == null) {
            return true;
        }

        return false;

    }

}