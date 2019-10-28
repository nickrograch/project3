package ru.javamentors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javamentors.entity.AppUser;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

    @Query("select b from AppUser b left join fetch b.roles where b.name = :name")
    AppUser findByName(@Param("name") String name);

    @Query("select b from AppUser b left join fetch b.roles where b.id = :id")
    AppUser getById(@Param("id") long id);

    @Query("from AppUser as b left join fetch b.roles ")
    List<AppUser> findAll();


//    @Modifying
//    @Query("update User u set u.name = ?1, u.password = ?2 where u.id = ?4")
//    void update(String name, String password, long userId);
}
