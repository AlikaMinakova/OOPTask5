package L6;



import L6.model.Order;
import L6.model.Person;
import L6.model.comparator.OrderComparator;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;



class OrderComparatorTest {

    private static Person first = new Person()
                .setName("name2")
                .setSurname("surname1")
                .setBirthday(LocalDate.parse("2000-02-03"));
    private static Person second = new Person()
                .setName("name2")
                .setSurname("surname2")
                .setBirthday(LocalDate.parse("1999-02-03"));
    private static Order one = new Order()
                .setTitle("good1")
                .setId(1)
                .setBuyer(first);
    private static Order two = new Order()
                .setTitle("good2")
                .setId(2)
                .setBuyer(second);


    @Test
    @DisplayName("Сортировка только по покупателю")
    void sortOrderByBuyer() {
        List<Order> orders = new ArrayList<>();
        orders.add(two);
        orders.add(one);
        orders.sort(Comparator.comparing(Order::getBuyer));
        Assertions.assertEquals(orders.get(0), one);
        Assertions.assertEquals(orders.get(1), two);
    }

    @Test
    @DisplayName("Сортировка только по id")
    void sortOrderById() {
        List<Order> orders = new ArrayList<>();
        orders.add(two);
        orders.add(one);
        orders.sort(Comparator.comparing(Order::getId));
        Assertions.assertEquals(orders.get(0), one);
        Assertions.assertEquals(orders.get(1), two);

    }
    @Test
    @DisplayName("Сортировка только по названию")
    void sortOrderByTitle() {
        List<Order> orders = new ArrayList<>();
        orders.add(two);
        orders.add(one);
        orders.sort(new OrderComparator());
        Assertions.assertEquals(orders.get(0), one);
        Assertions.assertEquals(orders.get(1), two);

    }
}