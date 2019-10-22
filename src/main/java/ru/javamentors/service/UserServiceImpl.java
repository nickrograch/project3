package ru.javamentors.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javamentors.entity.AppUser;
import ru.javamentors.repository.UserRepository;
import ru.javamentors.util.ExistException;

import java.util.List;

import ru.javamentors.entity.Role;
import ru.javamentors.repository.RoleRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRespository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<AppUser> getUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public void addUser(AppUser appUser) {

        AppUser checkAppUser = getUser(appUser.getName());
        if (checkAppUser != null){
            throw new ExistException("User is already exist");
        }
        else{
            appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
            Role userRole = roleRespository.findByRole("USER");
            appUser.setRoles(userRole);
            userRepository.save(appUser);
        }
    }


    @Override
    public AppUser getUser(String name) {
        return userRepository.findByName(name);
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
