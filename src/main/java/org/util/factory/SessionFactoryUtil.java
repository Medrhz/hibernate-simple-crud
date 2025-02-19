package org.util.factory;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryUtil {
    private static SessionFactory sf = null;

    public SessionFactoryUtil () {
    }

    public static SessionFactory getSf () {
        StandardServiceRegistry reg = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

        sf = new MetadataSources(reg).buildMetadata().buildSessionFactory();
        return sf;

    }
}
