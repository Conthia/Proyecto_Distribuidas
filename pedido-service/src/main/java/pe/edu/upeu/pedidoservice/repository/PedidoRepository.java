package pe.edu.upeu.pedidoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.pedidoservice.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
