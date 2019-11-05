package ru.javamentors.service;

import org.springframework.stereotype.Service;
import ru.javamentors.entity.AppUser;

import java.util.List;

@Service
public interface UserService {

    List<AppUser> getUsers();

    void addUser(AppUser appUser);

    void deleteUser(AppUser appUser);

    void editUser(AppUser appUser);

    AppUser getUserById(long id);

}