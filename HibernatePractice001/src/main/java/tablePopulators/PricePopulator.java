package tablePopulators;

import model.Price;
import org.hibernate.Session;

public class PricePopulator implements TablePopulator {
    @Override
    public void populate(Session session) {
        session.persist(new Price(1,10.0,"EURO",0));
        session.persist(new Price(2,50.0,"RON",17));
        session.persist(new Price(3,20.0,"USD",0));
        session.persist(new Price(4,40.0,"PESOS",0));
        session.persist(new Price(5,53.0,"RON",17));
    }
}
