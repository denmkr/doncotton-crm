package ru.dm.crm.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.dm.crm.domain.UserDetail;
import ru.dm.crm.entity.User;


/**
 * Created by Denis on 31/03/2018.
 */

@ControllerAdvice
public final class GlobalControllerAdvice {

    @ModelAttribute("username")
    public User getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user;
        if (authentication instanceof AnonymousAuthenticationToken) {
            user = null;
        }
        else {
            UserDetail userDetail = (UserDetail) authentication.getPrincipal();
            user = (User) userDetail.getUser();
        }

        return user;
    }

}
