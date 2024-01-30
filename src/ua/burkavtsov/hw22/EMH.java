package ua.burkavtsov.hw22;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EMH {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("yourPersistenceUnitName");
             EntityManager em = emf.createEntityManager()) {

            User user = new User();
            user.setUsername("John Doe");

            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();

                em.persist(user);

                tx.commit();
            } catch (Exception e) {
                if (tx.isActive()) {
                    tx.rollback();
                }
                e.printStackTrace();
            }

            User retrievedUser = em.find(User.class, user.getId());
            System.out.println("Retrieved User: " + retrievedUser.getUsername());

            tx = em.getTransaction();
            try {
                tx.begin();

                retrievedUser.setUsername("Updated Name");

                tx.commit();
            } catch (Exception e) {
                if (tx.isActive()) {
                    tx.rollback();
                }
                e.printStackTrace();
            }

            tx = em.getTransaction();
            try {
                tx.begin();

                em.remove(retrievedUser);

                tx.commit();
            } catch (Exception e) {
                if (tx.isActive()) {
                    tx.rollback();
                }
                e.printStackTrace();
            }
        }
    }
}