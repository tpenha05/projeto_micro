// OrderItemOut.java
package store.order;

import lombok.Builder;
import lombok.experimental.Accessors;
import store.product.ProdutoOut;

@Builder @Accessors(fluent = true)
public record OrderItemOut(
    String id,
    ProdutoOut produto,
    Integer quantidade,
    Double total
) {
}