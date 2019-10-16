package ru.javamentors.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javamentors.DAO.UserDAO;
import ru.javamentors.entity.User;
import ru.javamentors.repository.UserRepository;
import ru.javamentors.util.ExistException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

//    @Autowired
//    private UserDAO userDAO;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void addUser(User user) {

        User checkUser = getUser(user.getName());
        if (checkUser != null){
            throw new ExistException("User is already exist");
        }
        else{
            userRepository.saveAndFlush(user);
        }
    }

    @Override
    public User getUser(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public void editUser(User user) {
        userRepository.saveAndFlush(user);
    }

    @Override
    public User getUserById(long id) {
        return userRepository.getById(id);
    }
}
