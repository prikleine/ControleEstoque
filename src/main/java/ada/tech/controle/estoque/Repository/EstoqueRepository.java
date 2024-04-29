package ada.tech.controle.estoque.Repository;

import ada.tech.controle.estoque.Model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
    public List<Estoque> findEstoquesBySku(String sku);
}
