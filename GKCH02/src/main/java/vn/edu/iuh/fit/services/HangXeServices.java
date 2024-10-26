package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.models.HangXe;
import vn.edu.iuh.fit.repositories.HangXeRepository;

import java.util.List;

public class HangXeServices {
    private HangXeRepository hangXeRepository;

    public HangXeServices() {
        hangXeRepository = new HangXeRepository();
    }

    public boolean add(HangXe hangXe) {
        return hangXeRepository.add(hangXe);
    }

    public boolean delete(String id) {
        return hangXeRepository.delete(id);
    }

    public boolean update(HangXe hangXe) {
        return hangXeRepository.update(hangXe);
    }

    public HangXe findByID(String id) {
        return hangXeRepository.findByID(id);
    }

    public List<HangXe> getAll() {
        return hangXeRepository.getAll();
    }
}
