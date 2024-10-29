package com.alvaro.demo.controller;

import com.alvaro.demo.dto.OrdenDTO;
import com.alvaro.demo.entity.Cliente;
import com.alvaro.demo.entity.Orden;
import com.alvaro.demo.entity.OrdenProducto;
import com.alvaro.demo.service.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/ordenes")
public class OrdenController {

    @Autowired
    private OrdenService ordenService;

    @GetMapping
    public List<Orden> getAllOrdenes() {
        return ordenService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orden> getOrdenById(@PathVariable Long id) {
        Orden orden = ordenService.findById(id);
        return orden != null ? ResponseEntity.ok(orden) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Orden createOrden(@RequestBody OrdenDTO ordenDTO) {
        Orden orden = new Orden();
        Cliente cliente = new Cliente();
        cliente.setId(ordenDTO.getClienteId());
        orden.setCliente(cliente);
        orden.setFechaOrden(LocalDateTime.now());

        List<OrdenProducto> productos = ordenDTO.getProductos();
        for (OrdenProducto op : productos) {
            op.setOrden(orden); // Asociar la orden
        }
        orden.setProductos(productos);
        return ordenService.save(orden);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orden> updateOrden(@PathVariable Long id, @RequestBody OrdenDTO ordenDTO) {
        Orden orden = ordenService.findById(id);
        if (orden == null) {
            return ResponseEntity.notFound().build();
        }
        Cliente cliente = new Cliente();
        cliente.setId(ordenDTO.getClienteId());
        orden.setCliente(cliente);
        orden.setFechaOrden(LocalDateTime.now());
        orden.getProductos().clear(); // Limpiar productos existentes
        for (OrdenProducto op : ordenDTO.getProductos()) {
            op.setOrden(orden); // Asociar la orden
            orden.getProductos().add(op); // Agregar nuevos productos
        }
        return ResponseEntity.ok(ordenService.save(orden));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrden(@PathVariable Long id) {
        ordenService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

