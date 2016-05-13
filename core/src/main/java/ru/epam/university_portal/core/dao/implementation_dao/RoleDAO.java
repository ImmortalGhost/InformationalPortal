package ru.epam.university_portal.core.dao.implementation_dao;

/**
 * Created by Владос on 08.05.2016.
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.epam.university_portal.core.dao.interface_dao.IRoleDAO;
import ru.epam.university_portal.model.entity.Role;
import java.util.List;

@Repository
public class RoleDAO extends BaseDAO implements IRoleDAO {
    public RoleDAO() {
        super();
    }

    private SessionFactory sessionFactory;
    @Autowired
    public RoleDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void create(String name) {
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        Role r = new Role();
        r.setName(name);
        session.save(r);
        t.commit();
        session.close();
    }

    public void remove(String name) {
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        List<Role> l = session
                .createQuery("FROM Role r where r.name = :parameter")
                .setParameter("parameter", name).list();
        if (l.size() > 0) {
            for (Role r : l) {
                session.delete(r);
            }
            t.commit();
        }
        session.close();
    }

    public Role get(String name) {
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        List<Role> l = session
                .createQuery("FROM Role r where r.name = :parameter")
                .setParameter("parameter", name).list();
        if (l.size() > 0) {
            return l.get(0);
        }
        else {
            return null;
        }
    }

    public Role get(int id) {
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        List<Role> l = session
                .createQuery("FROM Role r where r.name = :parameter")
                .setParameter("parameter", id).list();
        if (l.size() > 0) {
            return l.get(0);
        }
        else {
            return null;
        }
    }

    public List<Role> getAll(){
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        List<Role> l = session.createQuery("FROM Role").list();
        return l;
    }
}