package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.models.LoaiThuoc;
import vn.edu.iuh.fit.repositories.QuanLyLoaiThuocRepsitory;

import java.util.List;

public class QuanLyLoaiThuocServices {
    private QuanLyLoaiThuocRepsitory quanLyLoaiThuocRepsitory;

    public QuanLyLoaiThuocServices() {
        quanLyLoaiThuocRepsitory = new QuanLyLoaiThuocRepsitory();
    }

    public List<LoaiThuoc> getAll(){
        return quanLyLoaiThuocRepsitory.getAll();
    }
}
