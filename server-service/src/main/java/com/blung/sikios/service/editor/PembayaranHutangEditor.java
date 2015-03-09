package com.blung.sikios.service.editor;

import com.blung.sikios.domain.PembayaranHutang;
import com.blung.sikios.service.HutangService;

import java.beans.PropertyEditorSupport;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/20/13
 * Time: 8:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class PembayaranHutangEditor extends PropertyEditorSupport {
    private HutangService hutangService;

    public PembayaranHutangEditor(HutangService hutangService) {
        this.hutangService = hutangService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            long id = Long.parseLong(text);

            PembayaranHutang result = hutangService.findPembayaranHutang(id);

            if (result != null) {
                setValue(result);
            } else {
                throw new IllegalArgumentException("PembayaranHutang with id " + id + " not Found!");
            }

        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    @Override
    public String getAsText() {
        if (getValue() != null) {
            PembayaranHutang result = (PembayaranHutang) getValue();
            return result.getId() + "";
        } else {
            return "";
        }
    }
}
