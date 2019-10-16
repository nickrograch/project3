package ru.javamentors.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javamentors.DAO.UserDAO;
import ru.javamentors.entity.User;
import ru.javamentors.util.ExistException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

//    @Autowired
//    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userDAO.findAll();
    }

    @Override
    public void addUser(User user) {

        User checkUser = getUser(user.getName());
        if (checkUser != null){
            throw new ExistException("User is already exist");
        }
        else{
            userDAO.saveAndFlush(user);
        }
    }

    @Override
    public User getUser(String name) {
        return userDAO.findByName(name);
    }

    @Override
    public void deleteUser(User user) {
        userDAO.delete(user);
    }

    @Override
    public void editUser(User user) {
        userDAO.saveAndFlush(user);
    }

    @Override
    public User getUserById(long id) {
        return userDAO.getById(id);
    }
}
