package com.github.N1ckBaran0v.database;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.Session;

public class DatabaseService {
    private final SessionFactory sessionFactory;

    public DatabaseService() {
        Configuration configuration = getH2Configuration();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    private Configuration getH2Configuration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(UsersDataSet.class);
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:h2:./h2db");
        configuration.setProperty("hibernate.connection.username", "test");
        configuration.setProperty("hibernate.connection.password", "test");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        return configuration;
    }

    public UsersDataSet getUser(String login) {
        try {
            Session session = sessionFactory.openSession();
            UsersDataSet dataSet = UsersDAO.get(session, login);
            session.close();
            return dataSet;
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    public void addUser(String login, String password) {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            UsersDAO.insertUser(session, login, password);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
}
