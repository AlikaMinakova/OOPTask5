package L6.comparator;

import L6.model.Order;

import java.util.Comparator;


/**
 * Сортировка книг по названию
 */
public class OrderComparator implements Comparator<Order> {

    @Override
    public int compare(Order o1, Order o2) {
        return (o1.getBuyer().equals(o2.getBuyer())) ? 0 :
                (o1.getBuyer().getSurname().compareTo(o2.getBuyer().getSurname())) > 0 ? 1 : -1;
    }

}
