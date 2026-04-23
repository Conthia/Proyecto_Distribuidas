package pe.edu.upeu.pagoservice.controller;

import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.pagoservice.model.Pago;
import pe.edu.upeu.pagoservice.service.PagoService;

@RestController
@RequestMapping("/pagos")
@RequiredArgsConstructor
public class PagoController {
    private final PagoService service;
    @GetMapping public ResponseEntity<List<Pago>> listar() { return ResponseEntity.ok(service.listar()); }
    @PostMapping public ResponseEntity<Pago> crear(@RequestBody @Valid Pago pago) { return ResponseEntity.status(201).body(service.crear(pago)); }
    @PutMapping("/{id}") public ResponseEntity<Pago> actualizar(@PathVariable Long id, @RequestBody @Valid Pago pago) { return service.actualizar(id, pago).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); }
    @GetMapping("/ping") public String ping() { return "pago-service OK"; }
}
