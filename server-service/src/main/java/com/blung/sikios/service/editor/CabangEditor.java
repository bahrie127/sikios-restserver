package com.blung.sikios.service.editor;

import com.blung.sikios.domain.Cabang;
import com.blung.sikios.service.CabangService;

import java.beans.PropertyEditorSupport;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/19/13
 * Time: 9:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class CabangEditor extends PropertyEditorSupport {
    private CabangService cabangService;

    public CabangEditor(CabangService cabangService) {
        this.cabangService = cabangService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            long id = Long.parseLong(text);

            Cabang result = cabangService.findCabang(id);

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
            Cabang result = (Cabang) getValue();
            return result.getId() + "";
        } else {
            return "";
        }
    }
}
