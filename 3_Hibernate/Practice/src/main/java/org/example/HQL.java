package org.example;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.SelectionQuery;

import java.util.List;

public class HQL {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .addAnnotatedClass(Laptop.class)
                .addAnnotatedClass(org.example.Alien.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session3 = factory.openSession();

        Transaction tx = session3.beginTransaction();

        // select * from laptop where ram = 32
        // from laptop where ram = 32


        SelectionQuery<Object[]> query = session3.createSelectionQuery("select brand, model from Laptop where brand " +
                        "like ?1"
                , Object[].class);

        String brand = "Lenovo";
        query.setParameter(1, brand);

        List<Object[]> list = query.getResultList();
        for(Object[] obj : list){
            System.out.println(obj[0] + " " +  obj[1]);
        }

        factory.close();
    }
}
