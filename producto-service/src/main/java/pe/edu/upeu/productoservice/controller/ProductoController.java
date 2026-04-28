package pe.edu.upeu.productoservice.controller;

import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.productoservice.model.Producto;
import pe.edu.upeu.productoservice.service.ProductoService;

@RestController
@RequestMapping("/api/producto")
@RequiredArgsConstructor
public class ProductoController {
    private final ProductoService service;
    @GetMapping public ResponseEntity<List<Producto>> listar() { return ResponseEntity.ok(service.listar()); }
    @GetMapping("/{id}") public ResponseEntity<Producto> buscar(@PathVariable Long id) { return service.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); }
    @PostMapping public ResponseEntity<Producto> crear(@RequestBody @Valid Producto producto) { return ResponseEntity.status(201).body(service.crear(producto)); }
    @PutMapping("/{id}") public ResponseEntity<Producto> actualizar(@PathVariable Long id, @RequestBody @Valid Producto producto) { return service.actualizar(id, producto).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> eliminar(@PathVariable Long id) { return service.eliminar(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build(); }
    @GetMapping("/ping") public String ping() { return "producto-service OK"; }
}
