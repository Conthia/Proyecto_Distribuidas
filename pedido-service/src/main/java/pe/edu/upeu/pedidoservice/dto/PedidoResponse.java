package pe.edu.upeu.pedidoservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PedidoResponse {
    private Long id;
    private Long productoId;
    private Integer cantidad;
    private ProductoDto producto;
}
