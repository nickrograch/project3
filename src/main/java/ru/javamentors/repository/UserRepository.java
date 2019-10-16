package ru.javamentors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.javamentors.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select b from User b where b.name = :name")
    User findByName(@Param("name") String name);

    @Query("select b from User b where b.id = :id")
    User getById(@Param("id") long id);

    @Modifying
    @Query("update User u set u.name = ?1, u.password = ?2, u.role = ?3 where u.id = ?4")
    void update(String name, String password, String role, long userId);
}
