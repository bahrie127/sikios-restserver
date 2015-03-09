package com.blung.sikios.service.editor;

import com.blung.sikios.domain.Supplier;
import com.blung.sikios.service.BarangService;

import java.beans.PropertyEditorSupport;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/19/13
 * Time: 9:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class SupplierEditor extends PropertyEditorSupport {
    private BarangService barangService;

    public SupplierEditor(BarangService barangService) {
        this.barangService = barangService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            long id = Long.parseLong(text);

            Supplier result = barangService.findSupplier(id);

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
            Supplier result = (Supplier) getValue();
            return result.getId() + "";
        } else {
            return "";
        }
    }
}
