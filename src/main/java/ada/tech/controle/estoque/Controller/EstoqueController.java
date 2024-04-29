package ada.tech.controle.estoque.Controller;

import ada.tech.controle.estoque.DTOS.CompraDTO;
import ada.tech.controle.estoque.DTOS.ItemRequest;
import ada.tech.controle.estoque.Model.Estoque;
import ada.tech.controle.estoque.Service.ItemEstoqueServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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


//    @PostMapping("/adicionar")
//    @Operation(summary = "Adicionar um item ao Estoque")
//    public ResponseEntity<List<Estoque>> adicionarItensEstoque(@Valid @RequestBody CompraDTO request) {
//        List<Estoque> estoquesAtualizados = new ArrayList<>();
//
//        // Itera sobre os itens da solicitação
//        for(ItemRequest item : request.getItens()) {
//            // Chama o serviço para adicionar o item ao estoque
//            Estoque estoqueAtualizado = serviceItemEstoque.save(item);
//            // Adiciona o estoque atualizado à lista de resposta
//            estoquesAtualizados.add(estoqueAtualizado);
//        }
//
//        // Retorna a resposta com a lista de estoques atualizados e o status 202 ACCEPTED
//        return ResponseEntity.status(HttpStatus.ACCEPTED).body(estoquesAtualizados);
//    }
//
//    @Operation(summary = "Retirar Itens")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "201", description = "Item retirado com sucesso"),
//            @ApiResponse(responseCode = "400", description = "Erro ao tentar retirar um item"),
//    })
//    @PostMapping("/retirar")
//    public ResponseEntity<List<Estoque>> removerItemEstoque(@Valid @RequestBody CompraDTO request) {
//        List<Estoque> estoquesAtualizados = new ArrayList<>();
//
//        // Itera sobre os itens da solicitação
//        for(ItemRequest item : request.getItens()) {
//            // Chama o serviço para remover o item do estoque
//            Estoque estoqueAtualizado = serviceItemEstoque.remove(item);
//            // Adiciona o estoque atualizado à lista de resposta
//            estoquesAtualizados.add(estoqueAtualizado);
//        }
//
//        // Retorna a resposta com a lista de estoques atualizados e o status 202 ACCEPTED
//        return ResponseEntity.status(HttpStatus.ACCEPTED).body(estoquesAtualizados);
//    }

}


