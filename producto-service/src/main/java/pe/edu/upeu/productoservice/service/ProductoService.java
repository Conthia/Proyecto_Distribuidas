package pe.edu.upeu.productoservice.service;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upeu.productoservice.model.Producto;
import pe.edu.upeu.productoservice.repository.ProductoRepository;

@Service
@RequiredArgsConstructor
public class ProductoService {
    private final ProductoRepository repository;
    public List<Producto> listar() { return repository.findAll(); }
    public Optional<Producto> buscarPorId(Long id) { return repository.findById(id); }
    public Producto crear(Producto producto) { return repository.save(producto); }
    public Optional<Producto> actualizar(Long id, Producto producto) {
        return repository.findById(id).map(actual -> {
            actual.setNombre(producto.getNombre());
            actual.setDescripcion(producto.getDescripcion());
            actual.setPrecio(producto.getPrecio());
            actual.setStock(producto.getStock());
            return repository.save(actual);
        });
    }
    public void eliminar(Long id) { repository.deleteById(id); }
}
