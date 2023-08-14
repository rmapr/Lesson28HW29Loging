package coffee.order;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicInteger;
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Order {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id;
    private final String name;

    public Order( String name) {
        this.id = count.incrementAndGet();
        this.name = name;
    }
}
