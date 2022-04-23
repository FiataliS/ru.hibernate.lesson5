package ru.hibernate.lesson5;

public class Main {

    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
        try {
            ProductDao product = new ProductDao(sessionFactoryUtils);
            System.out.println(product.findById(2l));
            System.out.println(product.saveOrUpdate(new Product(1l,"Coca", 23)));
            System.out.println(product.saveOrUpdate(new Product("Mars", 55)));
            System.out.println(product.findAll());
            product.deleteById(1l);
            System.out.println(product.findAll());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactoryUtils.shotdown();
        }
    }
}