package com.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(City.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            //select * from city
            //List<City> cities = session.createQuery("from City").getResultList();
            //List<City> cities = session.createQuery("from City c where c.countryCode='TUR' and c.district='Ankara'").getResultList();
            //List<City> cities = session.createQuery("from City c where c.name like 'kar%'").getResultList();
            /*List<String> countryCodes = session.createQuery("select c.countryCode from City c group by c.countryCode").getResultList();

            for (String countryCode : countryCodes) {
                System.out.println(countryCode);
            }*/
            //insert
            /*City city=new City();
            city.setName("iznik");
            city.setCountryCode("TUR");
            city.setDistrict("Anadolu");
            city.setPopulation(150000);
            session.save(city);*/

            //update
            /*City city =session.get(City.class,4056);
            city.setPopulation(99000);
            session.save(city);
            System.out.println(city.getName());*/

            //Delete
            City city=session.get(City.class,4056);
            session.delete(city);

            session.getTransaction().commit();
            System.out.println(city.getName()+" "+"şehir silindi");

        } finally {
            sessionFactory.close();
        }
    }
}
