import day2.dao.Product;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.*;

import java.util.List;

public class CriteriaTest {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session firstSession = sessionFactory.openSession();
    /*    Session secondSession = sessionFactory.openSession();

        Seller s = firstSession.load(Seller.class, 2);
        Seller s1 = secondSession.load(Seller.class, 2);*/

/*        Criteria criteria = firstSession.createCriteria(Product.class);

        List<Product> result = criteria.list();

        result.stream().forEach(product -> System.out.println(product.getName()));*/
/*
        Criteria criteria = firstSession
                .createCriteria(Product.class)
                .addOrder(Order.desc("name"));

        List<Product> result = criteria.list();

        result.stream().forEach(product -> System.out.println(product.getName()));
        */

 /*       Criterion name = Restrictions.eq("name", "mp3");

        Criteria criteria = firstSession.createCriteria(Product.class).add(name);

        Product product = (Product) criteria.uniqueResult();

        System.out.println(product.getName()); */


      /*  Criteria criteria = firstSession.createCriteria(Product.class)
                .add(Restrictions.eq("name", "mp3"));

        Product product = (Product) criteria.uniqueResult();

        System.out.println(product.getName()); */

/*        Criteria criteria = firstSession.createCriteria(Product.class)
                .add(Restrictions.between("id", 3,4));

        List<Product> result =  criteria.list();

        result.stream().forEach(product -> System.out.println(product.getName()));*/

 /*       Criteria criteria = firstSession.createCriteria(Product.class)
                .add(Restrictions.isNotNull("description"));

        List<Product> result =  criteria.list();

        result.stream().forEach(product -> System.out.println(product.getDescription()));
*/
/*        Criteria criteria = firstSession.createCriteria(Product.class)
                .add(Restrictions.like("description","d", MatchMode.ANYWHERE));

        List<Product> result =  criteria.list();

        result.stream().forEach(product -> System.out.println(product.getDescription()));*/
/*

        Criteria criteria = firstSession.createCriteria(Product.class)
                .add(Restrictions.or(
                        Restrictions.eq("name","mp3")
                ,Restrictions.eq("description","edu"))
                );

        List<Product> result =  criteria.list();

        result.stream().forEach(product -> System.out.println(product.getDescription()));

*/

/*        Criteria criteria = firstSession.createCriteria(Product.class)
                .add(Restrictions.or(
                        Restrictions.eq("name","mp3")
                ,Restrictions.eq("description","edu"))
                );

        List<Product> result =  criteria.list();

        result.stream().forEach(product -> System.out.println(product.getDescription()));*/

        /*DetachedCriteria subquery =
                DetachedCriteria.forClass(Product.class,"p")
                .add(Restrictions.eq("p.seller.id","s.id"))
                .add(Restrictions.isNotNull("p.buyerBidProducts"))
                .setProjection(Property.forName("p.id").count());

        Criteria criteria = firstSession.createCriteria(Seller.class,"s")
                .add(Subqueries.gt(1L,subquery));



        System.out.println("Count of products that have more than 1 bid = "+criteria.uniqueResult().toString());
*/

/*        Criteria sellerCriteria = firstSession.createCriteria(Seller.class);

        sellerCriteria.add(Restrictions.eq("value","first"));

        //todo this produces only a seller table, Ask Amin
        Criteria productCriteria = sellerCriteria.createCriteria("products");

        productCriteria = productCriteria.add(Restrictions.like("name","b",MatchMode.ANYWHERE));

        List<Seller> result = productCriteria.list();
        List<Seller> productList = sellerCriteria.list();

        result.stream().forEach(seller -> System.out.println(seller.getValue()));

        productList.stream().forEach(seller -> System.out.println(seller.getValue()));*/


        // PROJECTIONS
        Criteria criteria = firstSession.createCriteria(Product.class)
                .setProjection(Projections.projectionList()
                        .add(Projections.id())
                        .add(Projections.property("name"))
                        .add((Projections.property("description"))));

        List<Object[]> productList = criteria.list();

        productList.stream().forEach(Object ->{

            System.out.println(Object[2]);
        } );


        // Find Product by example

    /*    Product toFind = new Product();
        toFind.setDescription("food");

        Example exampleProduct = Example.create(toFind)
                .excludeProperty("manufacturingName")
                .ignoreCase().enableLike(MatchMode.ANYWHERE);

        List<Product> result =  firstSession.createCriteria(Product.class).add(exampleProduct).list();

        result.stream().forEach(product -> System.out.println(product.getName()));*/
    }

}
