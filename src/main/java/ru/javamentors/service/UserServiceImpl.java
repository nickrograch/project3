package ru.javamentors.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.javamentors.entity.AppUser;
import ru.javamentors.repository.UserRepository;
import ru.javamentors.util.ExistException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<AppUser> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void addUser(AppUser appUser) {

        AppUser checkAppUser = userRepository.findByName(appUser.getName());
        if (checkAppUser != null){
            throw new ExistException("User is already exist");
        }
        else{
            appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
            userRepository.save(appUser);
       }
    }

    @Override
    public void deleteUser(AppUser appUser) {
        userRepository.delete(appUser);
    }

    @Override
    public void editUser(AppUser appUser) {
        AppUser user = appUser;
        user.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        userRepository.saveAndFlush(user);
    }

    @Override
    public AppUser getUserById(long id) {
        return userRepository.getById(id);
    }
}
