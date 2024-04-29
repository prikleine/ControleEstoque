package ada.tech.controle.estoque.Controller;

import ada.tech.controle.estoque.DTOS.CompraDTO;
import ada.tech.controle.estoque.DTOS.ItemRequest;
import ada.tech.controle.estoque.Service.ItemEstoqueServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Validated
@RestController
@RequestMapping("/items")
public class EstoqueController {
    private final ItemEstoqueServiceImpl serviceItemEstoque;

    public EstoqueController(ItemEstoqueServiceImpl serviceItemEstoque) {
        this.serviceItemEstoque = serviceItemEstoque;
    }

    @PostMapping
    public ResponseEntity removerItensEstoque(@RequestBody @Valid CompraDTO request) {

        for(ItemRequest item: request.getItens()) {
            serviceItemEstoque.saveOne(item);
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ArrayList<>());
    }

}
