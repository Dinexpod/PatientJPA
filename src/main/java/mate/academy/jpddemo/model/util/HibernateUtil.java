package mate.academy.jpddemo.model.util;

import mate.academy.jpddemo.model.devices.Device;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = createSessionFactory();

    private HibernateUtil() {}

    private static SessionFactory createSessionFactory() {
        try {
            Configuration configuration = new Configuration().configure();
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            configuration.addAnnotatedClass(Device.class);
            SessionFactory newSessionFactory = configuration.buildSessionFactory(serviceRegistry);
            return newSessionFactory;
        } catch (Exception ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
