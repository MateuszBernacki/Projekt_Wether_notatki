package weather;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class LocationRepository implements ILocationRepository {

    private SessionFactory sessionFactory;

    public LocationRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Location save(Location entry) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(entry);

        transaction.commit();
        session.close();
        return entry;
    }

    @Override
    public List<Location> getAllLocations() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Location> locations = session.createQuery("Select 1 from locations 1", Location.class)
                .getResultList();
        transaction.commit();
        session.close();
        return locations;
    }

    @Override
    public Optional<Location> findById(Long id) {
    Session session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();

    Optional<Location> location = Optional.ofNullable(session.find(Location.class,id));
    transaction.commit();
    session.close();
        return location;
    }
}

