import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CityDAOImpl implements CityDAO{

    final EntityManager entityManager = CreatingEntityManager.create();

    @Override
    public void createCity(City city) {
        entityManager.getTransaction().begin();
        entityManager.persist(city);
        entityManager.getTransaction().commit();
    }

    @Override
    public City getCityById(int id) {
        entityManager.getTransaction().begin();
        City city = entityManager.find(City.class, id);
        entityManager.getTransaction().commit();
        return city;
    }

    @Override
    public List<City> getAllCities() {
        entityManager.getTransaction().begin();
        String jpqlQuery = "SELECT s FROM City s";
        TypedQuery<City> query = entityManager.createQuery(jpqlQuery, City.class);
        List<City> cityList = query.getResultList();
        entityManager.getTransaction().commit();
        return cityList;
    }

    @Override
    public void updateCity(City city) {
        entityManager.getTransaction().begin();
        City city1 = entityManager.find(City.class, city.getCityId());
        SelectingChangings.changeCity(city1);
        entityManager.merge(city1);
        entityManager.getTransaction().commit();
        System.out.println("город №" + city.getCityId() + " изменен");

    }

    @Override
    public void deleteCity(City city) {
        entityManager.getTransaction().begin();
        City city1 = entityManager.find(City.class, city.getCityId());
        entityManager.remove(city1);
        entityManager.getTransaction().commit();
        System.out.println("город " + city.getNameCity() + " удален");

    }
}
