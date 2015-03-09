package com.blung.sikios.service.editor;

import com.blung.sikios.domain.Karyawan;
import com.blung.sikios.service.KaryawanService;

import java.beans.PropertyEditorSupport;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/19/13
 * Time: 9:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class KaryawanEditor extends PropertyEditorSupport {
    private KaryawanService karyawanService;

    public KaryawanEditor(KaryawanService karyawanService) {
        this.karyawanService = karyawanService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            long id = Long.parseLong(text);

            Karyawan result = karyawanService.findKaryawan(id);

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
            Karyawan result = (Karyawan) getValue();
            return result.getId() + "";
        } else {
            return "";
        }
    }
}
