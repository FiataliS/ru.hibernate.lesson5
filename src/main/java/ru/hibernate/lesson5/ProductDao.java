package ru.hibernate.lesson5;

import org.hibernate.Session;

import java.util.List;

public class ProductDao {

    private SessionFactoryUtils sessionFactoryUtils;

    public ProductDao(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    public Product findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    public List<Product> findAll() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("select u from Product u").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    public void deleteById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.createQuery("DELETE Product u WHERE u.id = :id")
                                .setParameter("id", id)
                                .executeUpdate();
            session.getTransaction().commit();
        }
    }

    public Product saveOrUpdate(Product product) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
            return product;
        }
    }
}
