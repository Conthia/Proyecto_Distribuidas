package pe.edu.upeu.pagoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.pagoservice.model.Pago;

public interface PagoRepository extends JpaRepository<Pago, Long> {
}
