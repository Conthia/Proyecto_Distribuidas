package pe.edu.upeu.pedidoservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.edu.upeu.pedidoservice.dto.ProductoDto;

@FeignClient(name = "producto")
public interface ProductoClient {
    @GetMapping("/productos/{id}")
    ProductoDto obtenerPorId(@PathVariable("id") Long id);
}
