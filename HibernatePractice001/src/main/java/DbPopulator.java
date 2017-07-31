import model.Color;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import tablePopulators.*;

import javax.persistence.EntityManager;
import java.util.List;

public class DbPopulator
{
    private static final Logger logger = Logger.getLogger(DbPopulator.class);

    public static void main(String[] args)
    {
        // read configuration and build session factory
        final StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder()
                        .configure("hibernate_cfg.xml")
                        .build();

        SessionFactory sessionFactory = null;

        try {
            sessionFactory = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();
        }
        catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
            logger.error("cannot create sessionFactory", e);
            System.exit(1);
        }

        // create session, open transaction and save test entity to db
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {

            TablePopulator tp = new ProductsPopulator();
            tp.populate(session);
            tx.commit();
        }
        catch (Exception e) {
            tx.rollback();
            logger.error("cannot commit transaction", e);
        }
        finally {
            session.close();
        }




        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        try {

            TablePopulator tp = new ColorPopulator();
            tp.populate(session);
            tx.commit();
        }
        catch (Exception e) {
            tx.rollback();
            logger.error("cannot commit transaction", e);
        }
        finally {
            session.close();
        }




        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        try {

            TablePopulator tp = new ProductColorsPopulator();
            tp.populate(session);
            tx.commit();
        }
        catch (Exception e) {
            tx.rollback();
            logger.error("cannot commit transaction", e);
        }
        finally {
            session.close();
        }




        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        try {

            TablePopulator tp = new PricePopulator();
            tp.populate(session);
            tx.commit();
        }
        catch (Exception e) {
            tx.rollback();
            logger.error("cannot commit transaction", e);
        }
        finally {
            session.close();
        }

        // clean up

        session = sessionFactory.openSession();

        Query q = session.createQuery("select e from Color e");
        List<Color> list = q.list();
        for(Color c : list)
        {
            System.out.println(c.name);
        }
        sessionFactory.close();
    }
}