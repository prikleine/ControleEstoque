package ada.tech.controle.estoque.Service;


import ada.tech.controle.estoque.DTOS.ItemRequest;
import ada.tech.controle.estoque.Model.Estoque;
import ada.tech.controle.estoque.Repository.EstoqueRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemEstoqueServiceImpl implements ItemEstoqueService {
//    @Autowired
    private final EstoqueRepository estoqueRepository;
    @Autowired
    ModelMapper modelMapper;


    @Override
    public Estoque saveOne(ItemRequest item) {
        Estoque estoque = modelMapper.map(item, Estoque.class);
        estoqueRepository.findEstoquesBySku("ABCDEF");
        return estoqueRepository.save(estoque);
    }
}
