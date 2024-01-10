package ua.burkavtsov.HW24;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class Hib {
    private SessionFactory sessionFactory;

    public HibernateEntityDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(Entity entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        }
    }

    public Entity read(int entityId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Entity.class, entityId);
        }
    }

    public void update(Entity entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        }
    }

    public void delete(int entityId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Entity entity = session.get(Entity.class, entityId);
            if (entity != null) {
                session.delete(entity);
            }
            transaction.commit();
        }
    }
}