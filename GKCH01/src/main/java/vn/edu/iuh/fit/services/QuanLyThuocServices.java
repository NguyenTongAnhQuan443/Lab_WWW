package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.models.Thuoc;
import vn.edu.iuh.fit.repositories.QuanLyThuocRepository;

import java.util.List;

public class QuanLyThuocServices {
    private QuanLyThuocRepository quanLyThuocRepository;

    public QuanLyThuocServices() {
        quanLyThuocRepository = new QuanLyThuocRepository();
    }

    public List<Thuoc> getAll() {
        return quanLyThuocRepository.getAll();
    }

    public Thuoc getThuocByMaLoai(String maLoai) {
        return quanLyThuocRepository.getThuocByMaLoai(maLoai);
    }

    public boolean addThuoc(Thuoc thuoc) {
        return quanLyThuocRepository.addThuoc(thuoc);
    }
}
