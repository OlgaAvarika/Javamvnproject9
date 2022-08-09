package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.product.Book;
import ru.netology.product.Product;
import ru.netology.product.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product product1 = new Book(12, "Над пропастью во ржи", 500, "Джером Сэлинджер");
    Product product2 = new Book(25, "Гарри Поттер", 400, "Джоан Кэтлин Роулинг");
    Product product3 = new Book(47, "Побег из Шоушенка", 550, "Стивен Кинг");
    Product product4 = new Smartphone(80, "Apple iPhone 13 Pro", 60000, "Apple Inc.");
    Product product5 = new Smartphone(9, "{Xiaomi 12 Pro", 20000, "Xiaomi Inc.");
    Product product6 = new Smartphone(31, "Sony Xperia 5 III", 10000, "Sony Mobile");

    @BeforeEach
    public void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
        manager.add(product6);
    }

    @Test
    public void shouldAddAllProducts() {

        Product[] expected = {product1, product2, product3, product4, product5, product6};
        Product[] actual = manager.getProduct();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchProductIfYes1() {

        Product[] expected = {product2};
        Product[] actual = manager.searchBy("Гарри");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchProductIfNo() {

        Product[] expected = {};
        Product[] actual = manager.searchBy("Samsung");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchProductIfYes2() {

        Product[] expected = {product4, product5};
        Product[] actual = manager.searchBy("Pro");

        Assertions.assertArrayEquals(expected, actual);
    }
}
