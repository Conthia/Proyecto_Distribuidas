package pe.edu.upeu.pedidoservice.service;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upeu.pedidoservice.client.ProductoClient;
import pe.edu.upeu.pedidoservice.dto.PedidoResponse;
import pe.edu.upeu.pedidoservice.dto.ProductoDto;
import pe.edu.upeu.pedidoservice.model.Pedido;
import pe.edu.upeu.pedidoservice.repository.PedidoRepository;

@Service
@RequiredArgsConstructor
public class PedidoService {
    private final PedidoRepository repository;
    private final ProductoClient productoClient;

    public List<PedidoResponse> listar() {
        return repository.findAll().stream().map(this::mapResponse).toList();
    }

    public Optional<PedidoResponse> buscarPorId(Long id) {
        return repository.findById(id).map(this::mapResponse);
    }

    public PedidoResponse crear(Pedido pedido) {
        return mapResponse(repository.save(pedido));
    }

    public Optional<PedidoResponse> actualizar(Long id, Pedido pedido) {
        return repository.findById(id).map(actual -> {
            actual.setProductoId(pedido.getProductoId());
            actual.setCantidad(pedido.getCantidad());
            return mapResponse(repository.save(actual));
        });
    }

    public boolean eliminar(Long id) {
        return repository.findById(id).map(p -> {
            repository.deleteById(id);
            return true;
        }).orElse(false);
    }

    private PedidoResponse mapResponse(Pedido pedido) {
        ProductoDto producto = productoClient.obtenerPorId(pedido.getProductoId());
        return new PedidoResponse(pedido.getId(), pedido.getProductoId(), pedido.getCantidad(), producto);
    }
}
