package pe.edu.upeu.productoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.productoservice.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
