package ru.javamentors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.javamentors.entity.Role;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRole(String role);

//    @Query("select r from Role as r join fetch r.userRoles where r.id")
//    List<String> getRoleNames(@Param("userId") long userId);
}
