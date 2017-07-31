package tablePopulators;

import model.Color;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ColorPopulator implements TablePopulator {
    @Override
    public void populate(Session session) {
        session.persist(new Color("Red"));
        session.persist(new Color("Green"));
        session.persist(new Color("White"));
        session.persist(new Color("Black"));
        session.persist(new Color("Yellow"));
        session.persist(new Color("Blue"));
    }
}
