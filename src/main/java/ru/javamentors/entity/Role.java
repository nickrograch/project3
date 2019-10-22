package ru.javamentors.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_id")
    private long id;

    @Column(name="role")
    private String role;

    @ManyToMany(mappedBy = "roles")
    private Set<AppUser> appUsers;



    public Set<AppUser> getAppUsers() {
        return appUsers;
    }

    public void setUserRoles(Set<AppUser> appUserRoles) {
        this.appUsers = appUserRoles;
    }

    @Override
    public String toString() {
        return role;
    }


    public Role(){
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
