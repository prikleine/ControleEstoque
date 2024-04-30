package ada.tech.controle.estoque.Repository;

import ada.tech.controle.estoque.Model.Estoque;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.UUID;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

    @Query("SELECT e FROM Estoque e WHERE e.sku = ?1")
    Estoque findEstoqueBySku(String sku);

    @Transactional
    @Modifying
    @Query("UPDATE Estoque e set e.quantidade = e.quantidade - ?1 where e.sku = ?2")
    Integer removeItemBySku(Integer quantidade, String sku);
}
