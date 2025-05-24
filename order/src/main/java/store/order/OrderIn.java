// OrderIn.java
package store.order;

import java.util.List;

import lombok.Builder;
import lombok.experimental.Accessors;

@Builder @Accessors(fluent = true)
public record OrderIn(
    List<OrderItemIn> items
) {
    
}