package ua.burkavtsov.hw22;

public class HQL {
    String hql1 = "SELECT u FROM User u WHERE size(u.orders) > 5";
    String hql2 = "SELECT o FROM Order o WHERE o.user = :user AND o.orderDate BETWEEN :startDate AND :endDate";
    String hql3 = "SELECT u.username, COUNT(o) FROM User u LEFT JOIN u.orders o GROUP BY u.username";
}
