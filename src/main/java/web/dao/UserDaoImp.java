package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    private SessionFactory sessionFactory;

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    public User getUserById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.find(User.class, id);
    }

    @Override
    public void updateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    public void deleteUser(long id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.find(User.class, id));
    }

    @Override
    public List<User> userList() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User").list();
    }
}
