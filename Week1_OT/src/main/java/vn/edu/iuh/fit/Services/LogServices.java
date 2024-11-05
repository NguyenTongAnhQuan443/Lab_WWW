package vn.edu.iuh.fit.Services;

import vn.edu.iuh.fit.models.Log;
import vn.edu.iuh.fit.repositories.LogRepository;

import java.util.List;


public class LogServices {
    private LogRepository logRepository;

    public boolean add(Log log) {
        return logRepository.add(log);
    }

    public boolean deleteByID(Long id) {
        return logRepository.deleteByID(id);
    }

    public boolean update(Log log) {
        return logRepository.update(log);
    }

    public Log findByID(Long id) {
        return logRepository.findByID(id);
    }

    public List<Log> findAll() {
        return logRepository.findAll();
    }
}
