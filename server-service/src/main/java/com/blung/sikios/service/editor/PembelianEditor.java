package com.blung.sikios.service.editor;

import com.blung.sikios.domain.Pembelian;
import com.blung.sikios.service.PembelianService;

import java.beans.PropertyEditorSupport;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/20/13
 * Time: 8:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class PembelianEditor extends PropertyEditorSupport {
    private PembelianService pembelianService;

    public PembelianEditor(PembelianService pembelianService) {
        this.pembelianService = pembelianService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            long id = Long.parseLong(text);

            Pembelian result = pembelianService.findPembelian(id);

            if (result != null) {
                setValue(result);
            } else {
                throw new IllegalArgumentException("Pembelian with id " + id + " not Found!");
            }

        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    @Override
    public String getAsText() {
        if (getValue() != null) {
            Pembelian result = (Pembelian) getValue();
            return result.getId() + "";
        } else {
            return "";
        }
    }
}
