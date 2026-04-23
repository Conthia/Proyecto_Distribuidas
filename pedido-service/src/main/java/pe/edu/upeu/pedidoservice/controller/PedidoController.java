package pe.edu.upeu.pedidoservice.controller;

import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.pedidoservice.dto.PedidoResponse;
import pe.edu.upeu.pedidoservice.model.Pedido;
import pe.edu.upeu.pedidoservice.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {
    private final PedidoService service;
    @GetMapping public ResponseEntity<List<PedidoResponse>> listar() { return ResponseEntity.ok(service.listar()); }
    @PostMapping public ResponseEntity<PedidoResponse> crear(@RequestBody @Valid Pedido pedido) { return ResponseEntity.status(201).body(service.crear(pedido)); }
    @PutMapping("/{id}") public ResponseEntity<PedidoResponse> actualizar(@PathVariable Long id, @RequestBody @Valid Pedido pedido) { return service.actualizar(id, pedido).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); }
    @GetMapping("/ping") public String ping() { return "pedido-service OK"; }
}
