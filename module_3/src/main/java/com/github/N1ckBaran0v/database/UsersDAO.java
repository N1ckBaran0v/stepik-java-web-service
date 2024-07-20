package com.github.N1ckBaran0v.database;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

class UsersDAO {
    public static UsersDataSet get(Session session, String login) {
        Criteria criteria = session.createCriteria(UsersDataSet.class);
        return (UsersDataSet) criteria.add(Restrictions.eq("login", login)).uniqueResult();
    }

    public static void insertUser(Session session, String login, String password) throws HibernateException {
        session.save(new UsersDataSet(login, password));
    }
}
