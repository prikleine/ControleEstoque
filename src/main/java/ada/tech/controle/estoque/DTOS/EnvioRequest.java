package ada.tech.controle.estoque.DTOS;

import lombok.Data;

@Data
public class EnvioRequest {

    private String cep;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String numero;
    private String destinatario;

}
