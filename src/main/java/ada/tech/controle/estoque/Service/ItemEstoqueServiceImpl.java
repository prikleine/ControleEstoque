package ada.tech.controle.estoque.Service;


import ada.tech.controle.estoque.DTOS.ItemRequest;
import ada.tech.controle.estoque.Model.Estoque;
import ada.tech.controle.estoque.Repository.EstoqueRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemEstoqueServiceImpl implements ItemEstoqueService {
    private final EstoqueRepository estoqueRepository;
    private final ModelMapper modelMapper;

    public ItemEstoqueServiceImpl(EstoqueRepository estoqueRepository, ModelMapper modelMapper) {
        this.estoqueRepository = estoqueRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean disponivel(List<ItemRequest> items) {
        boolean disponivel = true;

        for (ItemRequest item : items) {
            Estoque e = estoqueRepository.findEstoqueBySku(item.getSku());
            if (e == null || e.getQuantidade() < item.getQuantidade()) {
                disponivel = false;
                break;
            }
        }
        return disponivel;
    }

    @Override
    public Void remove(List<ItemRequest> items){
        for (ItemRequest item : items) {
            estoqueRepository.removeItemBySku(item.getQuantidade(), item.getSku());
        }

        return null;
    }

    @Override
    public Estoque saveOne(ItemRequest item) {
        Estoque estoque = modelMapper.map(item, Estoque.class);
        return estoqueRepository.save(estoque);
    }
}
