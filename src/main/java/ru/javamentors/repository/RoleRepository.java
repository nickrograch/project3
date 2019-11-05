package ru.javamentors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.javamentors.entity.AppUser;
import ru.javamentors.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<AppUser, Long> {
    @Query("select a from Role a where a.role = :role")
    Role findByName(@Param("role") String role);
}

