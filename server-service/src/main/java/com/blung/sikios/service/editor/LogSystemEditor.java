package com.blung.sikios.service.editor;

import com.blung.sikios.domain.LogSystem;
import com.blung.sikios.service.LogService;

import java.beans.PropertyEditorSupport;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/20/13
 * Time: 8:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class LogSystemEditor extends PropertyEditorSupport {
    private LogService logService;

    public LogSystemEditor(LogService logService) {
        this.logService = logService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            long id = Long.parseLong(text);

            LogSystem result = logService.findLogSystem(id);

            if (result != null) {
                setValue(result);
            } else {
                throw new IllegalArgumentException("LogSystem with id " + id + " not Found!");
            }

        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    @Override
    public String getAsText() {
        if (getValue() != null) {
            LogSystem result = (LogSystem) getValue();
            return result.getId() + "";
        } else {
            return "";
        }
    }
}
