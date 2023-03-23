package ru.netology.javaqa.javaqamvn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShopRepositoryTest {

    private ShopRepository repository;
    private Product product1;
    private Product product2;
    private Product product3;
    private Product product4;
    private Product product5;

    @BeforeEach
    public void setUp() {
        repository = new ShopRepository();
        product1 = new Product(1, "Телевизор", 25000);
        product2 = new Product(2, "Кофеварка", 8000);
        product3 = new Product(3, "Холодильник", 46000);
        product4 = new Product(4, "Стиральная машина", 29500);
        product5 = new Product(5, "Автомобиль", 899999);
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.add(product4);
        repository.add(product5);
    }

    @Test
    void shouldRemoveById() {
        repository.remove(3);
        Product[] expected = new Product[] {product1, product2, product4, product5};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);

        repository.remove(5);
        expected = new Product[] {product1, product2, product4};
        actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldThrowNotFoundException() {
        Assertions.assertThrows(NotFoundException.class, () -> repository.remove(6));
        Assertions.assertThrows(NotFoundException.class, () -> repository.remove(-1));
    }
}