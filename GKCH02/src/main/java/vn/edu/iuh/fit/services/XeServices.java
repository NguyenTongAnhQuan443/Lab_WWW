package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.models.Xe;
import vn.edu.iuh.fit.repositories.XeRepository;

import java.util.List;

public class XeServices {
    private XeRepository xeRepository;

    public XeServices() {
        xeRepository = new XeRepository();
    }

    public boolean add(Xe xe) {
        return xeRepository.add(xe);
    }

    public boolean delete(String id) {
        return xeRepository.delete(id);
    }

    public boolean update(Xe xe) {
        return xeRepository.update(xe);
    }

    public Xe findByID(String id) {
        return xeRepository.findByID(id);
    }

    public List<Xe> getAll() {
        return xeRepository.getAll();
    }
}
