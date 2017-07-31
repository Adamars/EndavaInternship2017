package tablePopulators;

import model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductsPopulator implements TablePopulator {
    @Override
    public void populate(Session session) {

        session.persist(new Product("Plane","A blue plane",10));
        session.persist(new Product("Car","A red car",20));
        session.persist(new Product("Doll","A black doll",30));
        session.persist(new Product("Lego","A green lego set",40));
        session.persist(new Product("Plane","A red plane",50));
    }
}
