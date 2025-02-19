package org.banckapp;

import org.entities.Employee;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.util.factory.SessionFactoryUtil;

public class EmployeeDelete {


    public static void main (String[] args) {
        SessionFactory sf = SessionFactoryUtil.getSf();


        Session s = sf.openSession();
        Transaction trx = s.getTransaction();


        try {
            trx.begin();
            // delete
            for (int i = 4; i <= 8; i++) {
                Employee employeeToUpdate = s.get(Employee.class, i);
                s.delete(employeeToUpdate);
            }
            trx.commit();
        } catch (HibernateError e) {
            e.printStackTrace();
        }

        sf.close();


    }
}
