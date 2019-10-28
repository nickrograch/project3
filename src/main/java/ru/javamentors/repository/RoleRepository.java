package ru.javamentors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javamentors.entity.AppUser;
import ru.javamentors.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Transactional
    @Query("select b from Role b where b.role = :role")
    Role findByName(@Param("role") String role);

}
