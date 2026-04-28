package pe.edu.upeu.pagoservice.service;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upeu.pagoservice.model.Pago;
import pe.edu.upeu.pagoservice.repository.PagoRepository;

@Service
@RequiredArgsConstructor
public class PagoService {
    private final PagoRepository repository;
    public List<Pago> listar() { return repository.findAll(); }
    public Optional<Pago> buscarPorId(Long id) { return repository.findById(id); }
    public Pago crear(Pago pago) { return repository.save(pago); }
    public Optional<Pago> actualizar(Long id, Pago pago) {
        return repository.findById(id).map(actual -> {
            actual.setPedidoId(pago.getPedidoId());
            actual.setMetodo(pago.getMetodo());
            actual.setMonto(pago.getMonto());
            actual.setEstado(pago.getEstado());
            return repository.save(actual);
        });
    }
    public boolean eliminar(Long id) {
        return repository.findById(id).map(p -> {
            repository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
