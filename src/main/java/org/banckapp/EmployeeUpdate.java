package org.banckapp;

import org.entities.Employee;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.util.factory.SessionFactoryUtil;

public class EmployeeUpdate {


    public static void main (String[] args) {
        SessionFactory sf = SessionFactoryUtil.getSf();


        Session s = sf.openSession();
        Transaction trx = s.getTransaction();


        try {
            trx.begin();
            // Update
            Employee employeeToUpdate = s.get(Employee.class, 2);
            employeeToUpdate.setFirstName("zakaria");
            employeeToUpdate.setSalary(9900);
            s.update(employeeToUpdate);
            trx.commit();
        } catch (HibernateError e) {
            e.printStackTrace();
        }

        sf.close();


    }
}
