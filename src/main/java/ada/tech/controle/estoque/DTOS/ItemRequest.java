package ada.tech.controle.estoque.DTOS;

import lombok.Data;

@Data
public class ItemRequest {
    private String sku;
    private Integer quantidade;
}
