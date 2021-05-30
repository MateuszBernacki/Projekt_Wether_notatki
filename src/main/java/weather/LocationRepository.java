package weather;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class LocationRepository implements ILocationRepository {

    private SessionFactory sessionFactory;

    public LocationRepository() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
    }

    @Override
    public Location save(Location entry) {
        Session session= sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(entry);

        transaction.commit();
        session.close();
        return entry;
    }
}
