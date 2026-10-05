package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
//        // to see how IntelliJ IDEA suggests fixing it.
//        Student s1 = new Student();
//        s1.setAge(19);
//        s1.setFirstName("Akanshya");
//        s1.setLastName("B");
//        s1.setRollNo(44611069);
//
//        try{
//            // steps : first configure then build the factory and then open session from factory and save simple bwahahaha
////            Configuration cfg = new Configuration();
////            cfg.addAnnotatedClass(org.example.Student.class);
////            cfg.configure(); // this loads the xml
////            SessionFactory factory = cfg.buildSessionFactory() ; // 'SessionFactory' used without 'try'-with-resources statement
////            Session session = factory.openSession(); // to open session we need session factory
//
//            SessionFactory sf = new Configuration()
//                                    .addAnnotatedClass(org.example.Student.class)
//                                    .configure()
//                                    .buildSessionFactory();
//
//            Session session = sf.openSession();
//
//            Transaction tx = session.beginTransaction(); // this returns the obkect pf transaction
////            session.merge(s1); for update
////            session.persist(s1); for saving
////            session.remove(s1); for deleting the object or tuple/row
//            tx.commit(); // if u just do this it will give error because table does not exist
//
//            sf.close();
//        } catch(Exception e){
//            System.out.println("Exception occured: " + e.getMessage());;
//        }
//
//        // step2: how do u fetch the data
////        Student s2 = null;
////
////        SessionFactory sf = new Configuration()
////                .addAnnotatedClass(org.example.Student.class)
////                .configure()
////                .buildSessionFactory();
////
////        Session session = sf.openSession();
////
////        s2 = session.find(Student.class, 44611061);
////        sf.close();
//
////        System.out.println(s2);
//        System.out.println(s1);

        // NOW WORKING WITH ALIEN CLASS

        Laptop l1 = new Laptop();
        l1.setId(1);
        l1.setBrand("Lenovo");
        l1.setModel("LOQ");
        l1.setRam(16);

        Laptop l2 = new Laptop();
        l2.setId(2);
        l2.setBrand("Lenovo");
        l2.setModel("Legion");
        l2.setRam(32);


        Alien a1 = new Alien();
        a1.setAid(101);
        a1.setAname("Harsha");
        a1.setTech("Java");
        a1.setLaptops(Arrays.asList(l1, l2));// we need to embed the laptop inside alien table from the class file

        l1.setAlien(a1);
        l2.setAlien(a1);

        SessionFactory factory = new Configuration()
                                    .addAnnotatedClass(Laptop.class)
                                    .addAnnotatedClass(org.example.Alien.class)
                                    .configure("hibernate.cfg.xml")
                                    .buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.persist(a1);
        session.persist(l1);
        session.persist(l2);

        tx.commit();

        Alien a2 = null;
        Session session2 = factory.openSession();
        Alien s5 = session2.find(Alien.class, 101);
        System.out.println(s5);

        factory.close();
        System.out.println(a2);
    }
}