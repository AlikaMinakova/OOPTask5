package L6.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;

import java.util.Objects;

@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Order{
    @NonNull
    private int id;
    @NonNull
    private String title;
    @NonNull
    private Person buyer;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && title.equals(order.title) && buyer.equals(order.buyer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, buyer);
    }
}
