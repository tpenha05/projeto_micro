// ProdutoOut.java
package store.product;

import lombok.Builder;
import lombok.experimental.Accessors;

@Builder @Accessors(fluent = true)
public record ProdutoOut(
    String id,
    String nome,
    Double preco,
    String unidade
) {
}