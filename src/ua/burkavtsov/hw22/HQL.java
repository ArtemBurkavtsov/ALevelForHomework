package ua.burkavtsov.hw22;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.burkavtsov.hw22.User;
import ua.burkavtsov.hw22.Order;

public class HQL {
    public void HqlQueries(Session session) {
        Query<User> query1 = session.createQuery(hql1, User.class);
        List<User> usersWithMoreThan5Orders = query1.getResultList();

        Query<Order> query2 = session.createQuery(hql2, Order.class);
        query2.setParameter("user", someUserObject);
        query2.setParameter("startDate", startDate);
        query2.setParameter("endDate", endDate);
        List<Order> ordersForUserInDateRange = query2.getResultList();

        Query<Object[]> query3 = session.createQuery(hql3, Object[].class);
        List<Object[]> usernameOrderCountList = query3.getResultList();
        for (Object[] result : usernameOrderCountList) {
            String username = (String) result[0];
            Long orderCount = (Long) result[1];
            System.out.println("Username: " + username + ", Order Count: " + orderCount);
        }
    }
}
