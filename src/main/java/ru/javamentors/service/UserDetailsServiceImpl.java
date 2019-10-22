package ru.javamentors.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import ru.javamentors.entity.AppUser;
import ru.javamentors.entity.Role;
import ru.javamentors.repository.RoleRepository;
import ru.javamentors.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        AppUser appUser = userRepository.findByName(name);

        if (appUser == null){
            throw new UsernameNotFoundException("User " + name + " was not found in the database");
        }
        Set<Role> userRoles = appUser.getRoles();
        List<String> roles = new ArrayList<>();
        for (Role role : userRoles) {
            roles.add(role.getRole());
        }

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (!CollectionUtils.isEmpty(roles)){
            for (String role : roles) {
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }
        UserDetails userDetails = new User(appUser.getName(), appUser.getPassword(), grantList);

        return userDetails;
    }
}
