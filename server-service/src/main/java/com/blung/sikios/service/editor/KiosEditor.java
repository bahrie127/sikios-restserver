package com.blung.sikios.service.editor;

import com.blung.sikios.domain.Kios;
import com.blung.sikios.service.KiosService;

import java.beans.PropertyEditorSupport;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/19/13
 * Time: 9:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class KiosEditor extends PropertyEditorSupport {
    private KiosService kiosService;

    public KiosEditor(KiosService kiosService) {
        this.kiosService = kiosService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            long id = Long.parseLong(text);

            Kios result = kiosService.findKios(id);

            if (result != null) {
                setValue(result);
            } else {
                throw new IllegalArgumentException("Kios with id " + id + " not Found!");
            }

        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    @Override
    public String getAsText() {
        if (getValue() != null) {
            Kios result = (Kios) getValue();
            return result.getId() + "";
        } else {
            return "";
        }
    }
}
