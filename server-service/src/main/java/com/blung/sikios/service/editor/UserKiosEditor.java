package com.blung.sikios.service.editor;

import com.blung.sikios.domain.UserKios;
import com.blung.sikios.service.UserService;

import java.beans.PropertyEditorSupport;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/20/13
 * Time: 8:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserKiosEditor extends PropertyEditorSupport {
    private UserService userService;

    public UserKiosEditor(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            long id = Long.parseLong(text);

            UserKios result = userService.findUserKios(id);

            if (result != null) {
                setValue(result);
            } else {
                throw new IllegalArgumentException("UserKios with id " + id + " not Found!");
            }

        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    @Override
    public String getAsText() {
        if (getValue() != null) {
            UserKios result = (UserKios) getValue();
            return result.getId() + "";
        } else {
            return "";
        }
    }
}
