package ru.dm.crm.controller;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.dm.crm.entity.SignUpForm;
import ru.dm.crm.entity.User;
import ru.dm.crm.service.UserRoleService;
import ru.dm.crm.service.UserService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;
import java.sql.Timestamp;

/**
 * Created by Denis on 31.03.18.
 */

@Controller
public class SignUpController {
    @Autowired
    UserService userService;
    @Autowired
    UserRoleService userRoleService;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signupPage(ModelMap model) {
        model.addAttribute("signup_form", new SignUpForm());
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signup(@ModelAttribute("signup_form") @Valid SignUpForm form, BindingResult result) {
        if (!result.hasErrors()) {
            User user = new User();
            user.setName(StringEscapeUtils.escapeHtml4(form.getName()));
            user.setPosition(StringEscapeUtils.escapeHtml4(form.getPosition()));
            user.setEmail(StringEscapeUtils.escapeHtml4(form.getEmail()));
            user.setPhone(StringEscapeUtils.escapeHtml4(form.getPhone()));
            BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder(12);
            user.setPassword(bcryptEncoder.encode(form.getPassword()));
            user.setEnabled(true);

            java.util.Date date = new java.util.Date();
            user.setDate(new Timestamp(date.getTime()));

            userService.create(user);
            userRoleService.createUser(user);

            return "redirect:/signup_success";
        } else {
            return "signup";
        }
    }

    @RequestMapping(value = "/signup_success", method = RequestMethod.GET)
    public String signupSuccess() {
        return "signup_success";
    }

}

