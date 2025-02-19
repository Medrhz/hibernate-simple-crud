package org.banckapp;

import org.entities.EmployeeDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.util.factory.SessionFactoryUtil;

import java.util.List;

public class GetEmployees {
    public static void main (String[] args) {


        // get the session factory
        SessionFactory sf = SessionFactoryUtil.getSf();
        // get and start the session
        Session session = sf.openSession();

        // start the transaction   not need that while reading the records

        System.out.println("Employees list :");


        // ORM HQL
        // =========== for getting all records ===============
        // List<Employee> employees = session.createQuery("select  e from Employee e", Employee.class).getResultList();
        //employees.forEach(e -> System.out.println(e));


        // =========== for getting the names only of employees =============== //
        //        List<String> employeesNames = session.createQuery("select  e.firstName from Employee e", String.class).getResultList();
        //        employeesNames.forEach(name -> System.out.println(name));


        // =========== for getting the names and salar only of employees =============== //
        //        List<Object[]> employeesNamesAndSalary = session.createQuery("select  e.firstName, e.salary from Employee e", Object[].class).getResultList();
        //
        //        for (Object[] oArray : employeesNamesAndSalary) {
        //            System.out.println(oArray[0] + " : " + oArray[1]);
        //        }


        // =========== for getting the names and salar only of employees v2 =============== //
        List<EmployeeDto> employeesNamesAndSalaryDto = session.createQuery("select  new org.entities.EmployeeDto(e.firstName, e.salary) from Employee e", EmployeeDto.class).getResultList();
        for (EmployeeDto employeeDto1 : employeesNamesAndSalaryDto) {
            System.out.println(employeeDto1.getFirstName() + " : " + employeeDto1.getSalary());
        }


        // closing sessions
        session.close();
        sf.close();
    }
}
