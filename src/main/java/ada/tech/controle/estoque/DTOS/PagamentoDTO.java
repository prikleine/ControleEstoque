package ada.tech.controle.estoque.DTOS;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
public class PagamentoDTO {
    private String id_compra;
    private String id_cliente;
    private List<ItemRequest> itens = new ArrayList<>();
    private EnvioRequest envio;

    @JsonCreator
    public PagamentoDTO(@JsonProperty("id_compra") String id_compra,
                        @JsonProperty("id_cliente") String id_cliente,
                        @JsonProperty("itens") List<ItemRequest> itens,
                        @JsonProperty("envio") EnvioRequest envio
    ) {
        this.id_compra = Objects.requireNonNull(id_compra);
        this.id_cliente = Objects.requireNonNull(id_cliente);
        this.itens = Objects.requireNonNull(itens);
        this.envio = Objects.requireNonNull(envio);
    }
}