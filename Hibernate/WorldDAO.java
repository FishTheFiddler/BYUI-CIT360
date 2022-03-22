package WesHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.*;
import org.hibernate.Query;

public class WorldDAO {

    SessionFactory factory = null;
    Session session = null;

    private static WorldDAO single_instance = null;

    private WorldDAO()
    {
        factory = HibernateUtils.getSessionFactory();
    }

    public static WorldDAO getInstance()
    {
        if (single_instance == null) {
            single_instance = new WorldDAO();
        }

        return single_instance;
    }

    public int getCityCount() {
        int cityCount = 0;
        try {
            session = factory.openSession();
            Query query = session.createQuery("select count(*) from city");
            Iterator count = query.iterate();
            cityCount = (int)count.next();
            System.out.println("No. of rows : "+cityCount);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return -1;
        } finally {
            session.close();
        }
        return cityCount;
    }

    public void updateCity(int id, String name, int population, String countryCode){
        try{
            Session session = factory.openSession();
            session.beginTransaction();

            //Add new City object
            City hughson = new City();
            hughson.setId(id);
            hughson.setName(name);
            hughson.setPopulation(population);
            hughson.setCountryCode(countryCode);

            //Save the city in database
            session.update(hughson);

            //Commit the transaction
            session.getTransaction().commit();

        }
        catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public void insertCity(int id, String name, int population, String countryCode){
        try {
            Session session = factory.openSession();
            session.beginTransaction();

            //Add new City object
            City hughson = new City();
            hughson.setId(id);
            hughson.setName(name);
            hughson.setPopulation(population);
            hughson.setCountryCode(countryCode);

            //Save the city in database
            session.save(hughson);

            //Commit the transaction
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }


    public City getCity(int id) {

        try {
            session = factory.openSession();
            session.getTransaction().begin();
            String sql = "from WesHibernate.City where id=" + Integer.toString(id);
            City c = (City)session.createQuery(sql).getSingleResult();
            session.getTransaction().commit();
            return c;

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

}
