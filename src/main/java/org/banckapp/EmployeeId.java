package org.banckapp;

import org.entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.util.factory.SessionFactoryUtil;

public class EmployeeId {
    public static void main (String[] args) {


        SessionFactory sf = SessionFactoryUtil.getSf();
        Session session = sf.openSession();


        Employee e = session.get(Employee.class, 2);
        System.out.println("id : " + e.getId());
        System.out.println("first name  : " + e.getFirstName());
        System.out.println("last name : " + e.getLastName());
        System.out.println("salary : " + e.getSalary());
        System.out.println("department : " + e.getDept());


        session.close();
        sf.close();

    }
}
