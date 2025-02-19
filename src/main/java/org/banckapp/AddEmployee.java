package org.banckapp;

import org.entities.Employee;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.util.factory.SessionFactoryUtil;

public class AddEmployee {
    public static void main (String[] args) {
        //1 - get the session factory
        SessionFactory sessionFactory = SessionFactoryUtil.getSf();

        //2 - get the session from the session factory

        Session session = sessionFactory.openSession();

        //3 -  start transaction
        Transaction transaction = session.getTransaction();
        
        try {
            transaction.begin();

            Employee employee = new Employee(null, "mohamed", "rhziza", 1000, "It");
            Employee employee1 = new Employee(null, "mohamed", "rhziza", 1000, "Traning");
            Employee employee2 = new Employee(null, "mohamed", "rhziza", 1000, "Finance");
            Employee employee3 = new Employee(null, "mohamed", "rhziza", 1000, "Marketing");

            session.persist(employee);
            session.persist(employee1);
            session.persist(employee2);
            session.persist(employee3);

            transaction.commit();

        } catch (HibernateError e) {
            System.out.println(e.getMessage());
        }


        // closing the sessions
        session.close();
        sessionFactory.close();
    }
}
