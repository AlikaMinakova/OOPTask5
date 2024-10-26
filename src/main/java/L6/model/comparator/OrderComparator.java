package L6.model.comparator;

import L6.model.Order;

import java.util.Comparator;


/**
 * Сортировка книг по названию
 */
public class OrderComparator implements Comparator<Order> {

    @Override
    public int compare(Order o1, Order o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }

}
