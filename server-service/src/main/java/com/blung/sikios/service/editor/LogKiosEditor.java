package com.blung.sikios.service.editor;

import com.blung.sikios.domain.LogKios;
import com.blung.sikios.service.LogService;

import java.beans.PropertyEditorSupport;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/20/13
 * Time: 8:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class LogKiosEditor extends PropertyEditorSupport {
    private LogService logService;

    public LogKiosEditor(LogService logService) {
        this.logService = logService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            long id = Long.parseLong(text);

            LogKios result = logService.findLogKios(id);

            if (result != null) {
                setValue(result);
            } else {
                throw new IllegalArgumentException("Supplier with id " + id + " not Found!");
            }

        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    @Override
    public String getAsText() {
        if (getValue() != null) {
            LogKios result = (LogKios) getValue();
            return result.getId() + "";
        } else {
            return "";
        }
    }
}
