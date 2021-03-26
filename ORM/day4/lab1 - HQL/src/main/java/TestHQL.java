import dao.Product;
import dao.Seller;
import dao.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class TestHQL {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        /*Binding first way*/

 /*       System.out.println("==================================================");
        String queryString1 = "FROM User u WHERE u.address = :address";
        List<User> users = session.createQuery(queryString1, User.class)
                .setParameter("address", "cairo")
                .list();

        users.stream().forEach(user -> System.out.println("User name is " +  user.getUserName()));*/


     /* *//*Binding second way*//*
        System.out.println("==================================================");
        String queryString2 = "FROM Product p WHERE p.name = ?0";
        List<Product> productList2 = session.createQuery(queryString2, Product.class).setParameter(0, "Ereader").list();
        productList2.stream().forEach(product -> System.out.println("Product ManufacturingName is " + product.getManufacturingName()));
*/
/*
        System.out.println("==================================================");
        String queryString3 = "FROM Product p WHERE p.manufacturingName like ?0 and p.quantity > ?1";
        List<Product> productsList3 = session.createQuery(queryString3).setParameter(0, "manufacturingname").setParameter(1, 0).list();
        productsList3.stream().forEach(product -> System.out.println("\nProduct name is " + product.getName()));*/


/*        System.out.println("==================================================");
        String queryString4 = "FROM Product p WHERE p.manufacturingName like ?0 ORDER BY p.name DESC";
        List<Product> productList4 = session.createQuery(queryString4, Product.class).setParameter(0, "manufacturingname").list();
        productList4.stream().forEach(pr -> System.out.println("\nProduct name is " + pr.getName()));*/

/*        System.out.println("==================================================");
        String queryString5= "FROM Product p WHERE p.description IS NOT EMPTY";
        List<Product> productList = session.createQuery(queryString5, Product.class).list();
        productList.stream().forEach(prod -> System.out.println("\nProduct name is " + prod.getName()));*/

/*        System.out.println("==================================================");
        String queryString6 = "FROM Product p WHERE p.name IN ('Mp3', 'File', 'Game')";
        List<Product> productList6 = session.createQuery(queryString6, Product.class).list();
        productList6.stream().forEach(pr -> System.out.println("\nProduct ManufacturingName is " + pr.getManufacturingName()));*/


  /*      System.out.println("==================================================");
        User user = new User("test@gmail.com", "Alex", new Date(), "trika", "12345");
        Seller seller = new Seller(user,"usetTest",productList.stream().collect(Collectors.toSet()));
        session.save(seller);
        String queryString7 = "FROM User u WHERE u.seller = :seller";
        List<User> usersList7 = session.createQuery(queryString7, User.class).setParameter("seller", seller).list();
        usersList7.stream().forEach(u -> System.out.println("\nUser name is " + u.getUserName()));*/

/*
        System.out.println("==================================================");
        String queryString8 = "SELECT count(*) FROM User";
        Long countUsers = ((Long) session.createQuery(queryString8).uniqueResult());
        System.out.println("Number of users : " + countUsers.intValue());*/

/*
        System.out.println("==================================================");
        String queryString9 = "FROM Product p JOIN p.seller s WHERE p.name IN ('File', 'Game')";
        List<Object[]> productJoinList = session.createQuery(queryString9).list();
        for (Object[] rec : productJoinList) {
            Product product = (Product) rec[0];
            Seller seller = (Seller) rec[1];
            System.out.println("\nProduct name is " + product.getName() + " with amount " + seller.getProducts().size());
        }*/

/*
        System.out.println("==================================================");
        String queryString10 = "FROM Product p WHERE p.seller = ANY( FROM Seller s WHERE s.value LIKE '%e%')";
        List<Product> productList10 = session.createQuery(queryString10, Product.class).list();
        productList10.stream().forEach(pr -> System.out.println("\nProduct ManufacturingName is " + pr.getManufacturingName()));
*/


        System.out.println("==================================================");
        String queryString11 = "FROM Product p WHERE p.seller = ALL( FROM Seller s WHERE s.value LIKE '%e%')";
        List<Product> productList11 = session.createQuery(queryString11, Product.class).list();
        if(!productList11.isEmpty()) {
            productList11.stream().forEach(pr -> System.out.println("\nProduct ManufacturingName is " + pr.getManufacturingName()));
        }
        else {
            System.out.println("List is empty");
        }

//
//        System.out.println("==================================================");
//        String queryString12 = "FROM Product p WHERE p.seller = SOME( FROM Seller s WHERE s.value LIKE '%e%')";
//        List<Product> productList12 = session.createQuery(queryString12, Product.class).list();
//        productList12.stream().forEach(pr -> System.out.println("\nProduct ManufacturingName is " + pr.getManufacturingName()));


        session.getTransaction().commit();
    }
}
