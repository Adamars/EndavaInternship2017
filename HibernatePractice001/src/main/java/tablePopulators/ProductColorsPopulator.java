package tablePopulators;

import model.ProductColor;
import org.hibernate.Session;

public class ProductColorsPopulator implements TablePopulator{
    @Override
    public void populate(Session session) {
        session.persist(new ProductColor(1,2));
        session.persist(new ProductColor(2,4));
        session.persist(new ProductColor(3,3));
        session.persist(new ProductColor(4,5));
        session.persist(new ProductColor(5,1));
    }
}
