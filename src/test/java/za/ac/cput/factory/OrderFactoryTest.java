package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import za.ac.cput.domain.Author;
import za.ac.cput.domain.ComicBook;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.User;


import static org.junit.jupiter.api.Assertions.*;

class OrderFactoryTest {
    private Order order1;
    private Order order2;
    private Order order3;
    private User user1;
    private ComicBook comicBook1;
    private ComicBook comicBook2;

    @BeforeEach
    void setUp() {
        user1 = new User("001", "John Doe");
        comicBook1 = ComicBookFactory.buildBuilder("CMB01", "Thor", 3.4, LocalDate.now(), new Author(1, "Jack", "Kirby"), 300.00);
        comicBook2 = ComicBookFactory.buildBuilder("CMB02", "Hulk", 3.4, LocalDate.now(), new Author(2, "Stan", "Lee"), 350.00);

        order1 = OrderFactory.buildOrder("ORD001", LocalDate.now(), user1, Arrays.asList(comicBook1, comicBook2), 650.00);
        order2 = OrderFactory.buildOrder("ORD002", LocalDate.of(2024, 7, 17), user1, Arrays.asList(comicBook1, comicBook2), 650.00);
        order3 = OrderFactory.buildOrder("ORD003", LocalDate.now(), user1, Arrays.asList(comicBook1, comicBook2), -100.00);
    }

    @Test
    void buildOrder() {
        assertNotNull(order1);
        System.out.println(order1);
    }

    @Test
    void buildOrderWithFutureDateMustFail() {
        assertNull(order2);
        System.out.println(order2);
    }

    @Test
    void buildOrderWithInvalidTotalAmountMustFail() {
        assertNull(order3);
        System.out.println(order3);
    }
}

