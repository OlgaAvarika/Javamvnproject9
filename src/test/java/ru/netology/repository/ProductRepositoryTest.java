package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.exeptions.NotFoundException;
import ru.netology.product.Book;
import ru.netology.product.Product;
import ru.netology.product.Smartphone;

public class ProductRepositoryTest {

    ProductRepository repo = new ProductRepository();

    Product product1 = new Book(12, "Над пропастью во ржи", 500, "Джером Сэлинджер");
    Product product2 = new Book(25, "Гарри Поттер", 400, "Джоан Кэтлин Роулинг");
    Product product3 = new Book(47, "Побег из Шоушенка", 550, "Стивен Кинг");
    Product product4 = new Smartphone(80, "Apple iPhone 13 Pro", 60000, "Apple Inc.");
    Product product5 = new Smartphone(9, "{Xiaomi 12 Pro", 20000, "Xiaomi Inc.");
    Product product6 = new Smartphone(31, "Sony Xperia 5 III", 10000, "Sony Mobile");

    @Test
    public void shouldRemoveById() {

        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);
        repo.save(product6);

        repo.removeById(25);

        Product[] expected = {product2};
        Product[] actual = repo.getProduct();
    }

    @Test
    public void shouldRemoveByIdWhenNoProduct() {

        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);
        repo.save(product6);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(100);
        });
    }

    @Test
    public void shouldShowAllProducts() {

        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);
        repo.save(product6);

        Product[] expected = {product1, product2, product3, product4, product5, product6};
        Product[] actual = repo.getProduct();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdTwoProducts() {

        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);
        repo.save(product6);

        repo.removeById(product1.getId());
        repo.removeById(product4.getId());

        Product[] expected = {product2, product3, product5, product6};
        Product[] actual = repo.getProduct();

        Assertions.assertArrayEquals(expected, actual);
    }
}
