package ru.javamentors.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javamentors.entity.User;

import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getUsers() {
        Session session = sessionFactory.getCurrentSession();

        Query<User> query = session.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    @Override
    public User getUser(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("from User where name=:name", User.class);
        query.setParameter("name", name);
        return query.uniqueResult();
    }

    @Override
    public void deleteUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        User userToDelete = session.byId(User.class).load(user.getId());
        session.delete(userToDelete);
    }

    @Override
    public void editUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    public User getUserById(long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("from User where id=:id", User.class);
        query.setParameter("id", id);
        User user =(User) query.uniqueResult();
        return user;
    }
}
