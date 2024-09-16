package vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.services;

import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.entities.Log;
import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.respositories.Impl.LogRespository;

import java.util.List;

public class LogServices {
    private LogRespository logRespository;

    public LogServices() {
        logRespository = new LogRespository();
    }

    public void add(Log log) {
        logRespository.add(log);
    }

    public void deleteByID(Long id) {
        logRespository.deleteByID(Log.class, id);
    }

    public void update(Log log) {
        logRespository.update(log);
    }

    public void findById(Long id) {
        logRespository.findById(Log.class, id);
    }

    public void findAll() {
        logRespository.findAll(Log.class);
    }
}
