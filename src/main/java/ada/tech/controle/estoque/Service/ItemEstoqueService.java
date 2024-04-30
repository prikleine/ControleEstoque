package ada.tech.controle.estoque.Service;


import ada.tech.controle.estoque.DTOS.ItemRequest;
import ada.tech.controle.estoque.Model.Estoque;

import java.util.List;

public interface ItemEstoqueService {
    Boolean disponivel(List<ItemRequest> items);
    Void remove(List<ItemRequest> items);
    Estoque saveOne(ItemRequest item);
}
