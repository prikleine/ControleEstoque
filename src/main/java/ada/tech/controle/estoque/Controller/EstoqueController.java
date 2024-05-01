package ada.tech.controle.estoque.Controller;

import ada.tech.controle.estoque.ControleEstoqueApplication;
import ada.tech.controle.estoque.DTOS.PagamentoDTO;
import ada.tech.controle.estoque.Service.ItemEstoqueServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.ArrayList;

@Validated
@RestController
@RequestMapping("/items")
public class EstoqueController {
    private final ItemEstoqueServiceImpl serviceItemEstoque;
    private final RabbitTemplate rabbitTemplate;

    public EstoqueController(ItemEstoqueServiceImpl serviceItemEstoque, RabbitTemplate rabbitTemplate) {
        this.serviceItemEstoque = serviceItemEstoque;
        this.rabbitTemplate=rabbitTemplate;

    }

    @PostMapping
    public ResponseEntity removerItensEstoque(@RequestBody @Valid PagamentoDTO request) {
        boolean disponivel = serviceItemEstoque.disponivel(request.getItens());

        if (disponivel) {
            serviceItemEstoque.remove(request.getItens());
            // Manda msg de sucesso para serviço envio
        } else {
            rabbitTemplate.convertAndSend(
                    "Informar-Erro-Estoque",
                    "informar-erro-estoque",
                    "Mensagem Teste");
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ArrayList<>());
    }

}
