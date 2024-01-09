package com.computa.Utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.computa.domain.User;
import com.computa.service.UserService;

@Component
public class UserValidator implements Validator {

    private final UserService userService;

    @Autowired
    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nickname", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ssid", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty");

        User existingUserById = userService.getUserById(user.getId());
        if (existingUserById != null) {
            errors.rejectValue("id", "Duplicate.userForm.id");
        }

        User existingUserByEmail = userService.getUserByEmail(user.getEmail());
        if (existingUserByEmail != null) {
            errors.rejectValue("email", "Duplicate.userForm.email");
        }

        User existingUserBySsid = userService.getUserBySsid(user.getSsid());
        if (existingUserBySsid != null) {
            errors.rejectValue("ssid", "Duplicate.userForm.ssid");
        }
    }
}