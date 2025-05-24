// OrderItemIn.java
package store.order;

import lombok.Builder;
import lombok.experimental.Accessors;

@Builder @Accessors(fluent = true)
public record OrderItemIn(
    String idProduto,
    Integer quantidade
) {
    
}