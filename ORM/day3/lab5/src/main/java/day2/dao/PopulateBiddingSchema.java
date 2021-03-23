package day2.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class PopulateBiddingSchema {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Category category1 = new Category("category1");
        category1.setDescription("This is a category");


        User buyerUser = new User("Email", "Address", new Date(), "buyerUser", "123456");
        User sellerUser = new User("Email", "Address", new Date(), "sellerUser", "123456");


        Seller seller = new Seller(sellerUser,"Seller User");


        Buyer buyer = new Buyer(buyerUser, "buyerUser");


        Product product = new Product("product1","manufacturingname",new Date(),5,new Date(),new Date());
        Product product2 = new Product("product2","manufacturingname",new Date(),5,new Date(),new Date());
        Product product3 = new Product("product3","manufacturingname",new Date(),5,new Date(),new Date());
        Product product4 = new Product("product4","manufacturingname",new Date(),5,new Date(),new Date());
        Set<Category> categorySet = new HashSet<>();
        categorySet.add(category1);
        product.setCategories(categorySet);

        product.setSeller(seller);
        product2.setSeller(seller);
        product3.setSeller(seller);
        product4.setSeller(seller);



        session.persist(buyerUser);
        session.persist(sellerUser);
        session.persist(seller);
        session.persist(buyer);
        session.persist(category1);
        session.persist(product);
        session.persist(product2);
        session.persist(product3);
        session.persist(product4);

        BuyerBuyProductId buyerBuyProductId = new BuyerBuyProductId();
        buyerBuyProductId.setProductId(product.getId());
        buyerBuyProductId.setBuyerId(buyer.getId());

        BuyerBuyProduct buyerBuyProduct = new BuyerBuyProduct(buyerBuyProductId,buyer,product,new Date(),33.3f,6);
        buyerBuyProduct.setBuyer(buyer);
        buyerBuyProduct.setProduct(product);
        buyerBuyProduct.setAmount(5);
        buyerBuyProduct.setPaymentDate(new Date());
        buyerBuyProduct.setQuantity(1);
        session.persist(buyerBuyProduct);

        BuyerBidProductId buyerBidProductId = new BuyerBidProductId();
        buyerBidProductId.setProductId(product.getId());
        buyerBidProductId.setBuyerId(buyer.getId());

        BuyerBidProduct buyerBidProduct = new BuyerBidProduct(buyerBidProductId,buyer,product,new Date(),5.5f,5
                );

        session.persist(buyerBidProduct);

        session.getTransaction().commit();
        System.out.println("Insertion Done");

    }
}
