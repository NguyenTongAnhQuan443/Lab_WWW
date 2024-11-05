package vn.edu.iuh.fit.dao;

import vn.edu.iuh.fit.models.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    List<User> userList = new ArrayList<>();

    public List<User> dumyData() throws ParseException {
        userList.add(new User("A1", "123", "Nguyen Van A1", 22, simpleDateFormat.parse("04/04/2003"), false));
        userList.add(new User("A2", "124", "Nguyen Van A2", 22, simpleDateFormat.parse("04/04/2003"), false));
        userList.add(new User("A3", "125", "Nguyen Van A3", 22, simpleDateFormat.parse("04/04/2003"), false));
        userList.add(new User("A4", "126", "Nguyen Van A4", 22, simpleDateFormat.parse("04/04/2003"), false));
        userList.add(new User("A5", "127", "Nguyen Van A5", 22, simpleDateFormat.parse("04/04/2003"), false));
        return userList;
    }

    public List<User> getAll() {
        return userList;
    }
}
