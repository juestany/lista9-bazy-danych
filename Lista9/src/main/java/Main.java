import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.Transaction;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        // a) Wyświetl procent produktów, które dostarczają więcej niż 50% sumy żelaza i wapnia. Zwróć
        // wynik do dwóch miejsc po przecinku.
        var queryStringA = "SELECT ROUND(100.0 * COUNT(p) / ((SELECT COUNT(p2) FROM ProductsEntity p2)), 2) " +
                "FROM ProductsEntity p WHERE p.calcium + p.iron > 50";
        Query queryA = em.createQuery(queryStringA);
        Float resultA = (Float) queryA.getSingleResult();
        System.out.println("Odpowiedź z podpunktu a): " + resultA + "%");

        // b) Wyświetl średnią wartość kaloryczną produktów z bekonem w nazwie.
        var queryStringB = "SELECT AVG(p.calories) FROM ProductsEntity p WHERE p.itemName LIKE '%bacon%'";
        Query queryB = em.createQuery(queryStringB);
        Double resultB = (Double) queryB.getSingleResult();
        System.out.println("Odpowiedź z podpunktu b): " + resultB + " kcal");

        // c) Dla każdej z kategorii wyświetl produkt o największej wartości cholesterolu.
        var queryStringC = "SELECT c.catName, MAX(p.cholesterole) " +
                "FROM CategoriesEntity c " +
                "INNER JOIN ProductsEntity p ON c.catId = p.category " +
                "GROUP BY c.catName";
        Query queryC = em.createQuery(queryStringC);
        List<Object[]> resultC = queryC.getResultList();
        System.out.println("Odpowiedź z podpunktu c):");
        for (Object[] row : resultC) {
            String categoryName = (String) row[0];
            Integer maxCholesterol = (Integer) row[1];

            System.out.println("- " + categoryName + ": " + maxCholesterol + " mg");
        }

        // d) Wyświetl liczbę kaw (Mocha lub Coffee w nazwie) niezawierających błonnika.
        var queryStringD = "SELECT COUNT(p.itemName) " +
                "FROM ProductsEntity p " +
                "WHERE p.fiber = 0 " +
                "AND (p.itemName LIKE '%mocha%' " +
                "OR p.itemName LIKE '%coffee%')";
        Query queryD = em.createQuery(queryStringD);
        var resultD = queryD.getSingleResult();
        System.out.println("Odpowiedź z podpunktu d): " + resultD + " kaw niezawierających błonnika");

        // e) Wyświetl kaloryczność wszystkich McMuffinów. Wyniki wyświetl w kilodżulach (jedna
        // kaloria to 4184 dżule) rosnąco.
        var queryStringE = "SELECT p.itemName, SUM(p.calories * 4184) " +
                "FROM ProductsEntity p " +
                "WHERE p.itemName LIKE '%McMuffin%' " +
                "GROUP BY p.itemName " +
                "ORDER BY SUM(p.calories * 4184)";
        Query queryE = em.createQuery((queryStringE));
        List<Object[]> resultE = queryE.getResultList();
        System.out.println("Odpowiedź z podpunktu e):");
        for(Object[] row : resultE){
            String catName = (String) row[0];
            Long kj = (Long) row[1];

            System.out.println("- " + catName + ": " + kj + " kJ");
        }

        // f) Wyświetl liczbę różnych wartości węglowodanów.
        var queryStringF = "SELECT COUNT(DISTINCT p.carbs) " + // !!!!!
                "FROM ProductsEntity p " +
                "";
        Query queryF = em.createQuery(queryStringF);
        var resultF = queryF.getSingleResult();
        System.out.println("Odpowiedź z podpunktu f): " + resultF + " różnych wartości węglowodanów");
    }
}
