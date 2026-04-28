package pe.edu.upeu.pagoservice.controller;

import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.pagoservice.model.Pago;
import pe.edu.upeu.pagoservice.service.PagoService;

@RestController
@RequestMapping("/api/pago")
@RequiredArgsConstructor
public class PagoController {
    private final PagoService service;
    @GetMapping public ResponseEntity<List<Pago>> listar() { return ResponseEntity.ok(service.listar()); }
    @GetMapping("/{id}") public ResponseEntity<Pago> buscarPorId(@PathVariable Long id) { return service.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); }
    @PostMapping public ResponseEntity<Pago> crear(@RequestBody @Valid Pago pago) { return ResponseEntity.status(201).body(service.crear(pago)); }
    @PutMapping("/{id}") public ResponseEntity<Pago> actualizar(@PathVariable Long id, @RequestBody @Valid Pago pago) { return service.actualizar(id, pago).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> eliminar(@PathVariable Long id) { return service.eliminar(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build(); }
    @GetMapping("/ping") public String ping() { return "pago-service OK"; }
}
