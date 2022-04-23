package ru.hibernate.lesson5;

public class Main {

    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
            try {


            } catch (Exception e){
                e.printStackTrace();
            } finally {
                sessionFactoryUtils.shotdown();
            }
    }
}

        /*1.Создайте сущность Product(Long id,String title,int price)и таблицу в базе данных
        для хранения объектов этой сущности;

        2.Создайте класс ProductDao и реализуйте в нем логику выполнения CRUD-операций над сущностью
        Product(Product findById(Long id),List<Product> findAll(),void deleteById(Long id),
        Product saveOrUpdate(Product product));

        3.*Вшить ProductDao в веб-проект,и показывать товары,лежащие в базе данных.Помните что в
        таком случае SessionFactory или обертку над ней надо будет делать в виде Spring бина.*/

