package ru.javamentors.DAO;

import ru.javamentors.entity.User;

import java.util.List;

public interface UserDAO {

    List<User> getUsers();

    void addUser(User user);

    User getUser (String name);

    void deleteUser(User user);

    void editUser (User user);

    User getUserById(long id);
}
