package vn.edu.iuh.fit.Services;

import vn.edu.iuh.fit.models.Role;
import vn.edu.iuh.fit.repositories.RoleRepository;

import java.util.List;

public class RoleServices {
    private RoleRepository roleRepository;

    public boolean add(Role role) {
        return roleRepository.add(role);
    }

    public boolean deleteByID(String id) {
        return roleRepository.deleteByID(id);
    }

    public boolean update(Role role) {
        return roleRepository.update(role);
    }

    public Role findByID(String id) {
        return roleRepository.findByID(id);
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
