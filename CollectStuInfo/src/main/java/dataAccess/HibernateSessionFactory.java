package dataAccess;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by ML3426 on 2014/12/16 0016.
 *
 * @author ML3426
 */
public class HibernateSessionFactory {
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
    private static Configuration configuration = new Configuration();
    private static SessionFactory sessionFactory;

    static {
        configuration.configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder registryBuilder = new
                StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        StandardServiceRegistry serviceRegistry = registryBuilder.build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public HibernateSessionFactory() {
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Configuration getConfiguration() {
        return configuration;
    }

    public Session getSession() {
        Session session = threadLocal.get();
        if (session == null || !session.isOpen()) {
            if (sessionFactory == null) {
                rebuildSessionFactory();
            }
            session = (sessionFactory != null) ? sessionFactory.openSession() : null;
            threadLocal.set(session);
        }
        return session;
    }

    public void rebuildSessionFactory() {
        configuration.configure();
        StandardServiceRegistryBuilder registryBuilder = new
                StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        StandardServiceRegistry serviceRegistry = registryBuilder.build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public void closeSession() {
        Session session = threadLocal.get();
        threadLocal.set(null);
        if (session != null) {
            session.close();
        }
    }
}
