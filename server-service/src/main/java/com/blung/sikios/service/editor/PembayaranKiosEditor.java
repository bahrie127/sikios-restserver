package com.blung.sikios.service.editor;

import com.blung.sikios.domain.PembayaranKios;
import com.blung.sikios.service.KiosService;

import java.beans.PropertyEditorSupport;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/19/13
 * Time: 9:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class PembayaranKiosEditor extends PropertyEditorSupport {
    private KiosService kiosService;

    public PembayaranKiosEditor(KiosService kiosService) {
        this.kiosService = kiosService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            long id = Long.parseLong(text);

            PembayaranKios result = kiosService.findPembayaranKios(id);

            if (result != null) {
                setValue(result);
            } else {
                throw new IllegalArgumentException("PembayaranKios with id " + id + " not Found!");
            }

        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    @Override
    public String getAsText() {
        if (getValue() != null) {
            PembayaranKios result = (PembayaranKios) getValue();
            return result.getId() + "";
        } else {
            return "";
        }
    }
}
