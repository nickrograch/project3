package ru.javamentors.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javamentors.DAO.UserDAO;
import ru.javamentors.entity.User;
import ru.javamentors.util.ExistException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    @Override
    @Transactional
    public void addUser(User user) {

        User checkUser = userDAO.getUser(user.getName());
        if (checkUser != null){
            throw new ExistException("User is already exist");
        }
        else{
            userDAO.addUser(user);
        }
    }

    @Override
    @Transactional
    public User getUser(String name) {
        return userDAO.getUser(name);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        userDAO.deleteUser(user);
    }

    @Override
    public void editUser(User user) {
        userDAO.editUser(user);
    }

    @Override
    public User getUserById(long id) {
        return userDAO.getUserById(id);
    }
}
