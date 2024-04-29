package ada.tech.controle.estoque.Service;


import ada.tech.controle.estoque.DTOS.ItemRequest;
import ada.tech.controle.estoque.Model.Estoque;

public interface ItemEstoqueService {
    Estoque saveOne(ItemRequest item);
}
