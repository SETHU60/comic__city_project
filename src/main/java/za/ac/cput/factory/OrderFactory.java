package za.ac.cput.factory;

import java.time.LocalDate;
import java.util.List;
import  za.ac.cput.domain.Order;
import za.ac.cput.util.Helper;

public class OrderFactory {
    public static Order buildOrder(String orderId, LocalDate orderDate, User user, List<ComicBook> comicBooks, double totalAmount) {
        if (Helper.isStringNullOrEmpty(orderId) || user == null || comicBooks == null || comicBooks.isEmpty() || totalAmount <= 0.0 || !Helper.isValidDate(orderDate)) {
            return null;
        }

        return new Order.OrderBuilder()
                .setOrderId(orderId)
                .setOrderDate(orderDate)
                .setUser(user)
                .setComicBooks(comicBooks)
                .setTotalAmount(totalAmount)
                .build();
    }
}

