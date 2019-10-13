package ru.javamentors.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javamentors.entity.User;

import org.hibernate.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getUsers() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery< User > cq = cb.createQuery(User.class);
        Root< User > root = cq.from(User.class);
        cq.select(root);
        Query query = session.createQuery(cq);
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
        Query query = session.createQuery("from User where name=:name");
        query.setParameter("name", name);
        User user =(User) query.uniqueResult();
        //User user = (User)session.load(User.class, name);
        return user;
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
        Query query = session.createQuery("from User where id=:id");
        query.setParameter("id", id);
        User user =(User) query.uniqueResult();
        return user;
    }
}
