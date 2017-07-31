package tablePopulators;
import org.hibernate.Session;
import org.hibernate.Transaction;

public interface TablePopulator {
    public void populate(Session session);
}
