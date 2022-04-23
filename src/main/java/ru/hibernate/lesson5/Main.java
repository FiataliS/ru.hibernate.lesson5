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

        /*1 2.Создайте класс ProductDao и реализуйте в нем логику выполнения CRUD-операций над сущностью
        Product(Product findById(Long id),List<Product> findAll(),void deleteById(Long id),
        Product saveOrUpdate(Product product));

        3.*Вшить ProductDao в веб-проект,и показывать товары,лежащие в базе данных.Помните что в
        таком случае SessionFactory или обертку над ней надо будет делать в виде Spring бина.*/

