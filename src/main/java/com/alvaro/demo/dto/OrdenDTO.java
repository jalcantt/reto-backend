package com.alvaro.demo.dto;

import com.alvaro.demo.entity.OrdenProducto;

import java.util.List;

public class OrdenDTO {
    private Long clienteId;
    private List<OrdenProducto> productos;

    // Getters y Setters
    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public List<OrdenProducto> getProductos() {
        return productos;
    }

    public void setProductos(List<OrdenProducto> productos) {
        this.productos = productos;
    }
}
