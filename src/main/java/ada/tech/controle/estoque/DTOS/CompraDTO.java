package ada.tech.controle.estoque.DTOS;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
public class CompraDTO {
    private String id_compra;
    private String id_cliente;
    private List<ada.tech.controle.estoque.DTOS.ItemRequest> itens = new ArrayList<>();
    private ada.tech.controle.estoque.DTOS.EnvioRequest envio;

    @JsonCreator
    public CompraDTO(@JsonProperty("id_compra") String id_compra,
                     @JsonProperty("id_cliente") String id_cliente,
                     @JsonProperty("itens") List<ada.tech.controle.estoque.DTOS.ItemRequest> itens,
                     @JsonProperty("envio") ada.tech.controle.estoque.DTOS.EnvioRequest envio
    ) {
        this.id_compra = Objects.requireNonNull(id_compra);
        this.id_cliente = Objects.requireNonNull(id_cliente);
        this.itens = Objects.requireNonNull(itens);
        this.envio = Objects.requireNonNull(envio);
    }
}