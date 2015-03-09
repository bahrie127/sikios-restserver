package com.blung.sikios.service.editor;

import com.blung.sikios.domain.User;
import com.blung.sikios.service.UserService;

import java.beans.PropertyEditorSupport;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/20/13
 * Time: 8:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserEditor extends PropertyEditorSupport {
    private UserService userService;

    public UserEditor(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            long id = Long.parseLong(text);

            User result = userService.findUser(id);

            if (result != null) {
                setValue(result);
            } else {
                throw new IllegalArgumentException("User with id " + id + " not Found!");
            }

        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    @Override
    public String getAsText() {
        if (getValue() != null) {
            User result = (User) getValue();
            return result.getId() + "";
        } else {
            return "";
        }
    }
}
