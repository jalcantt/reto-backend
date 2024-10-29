package com.alvaro.demo.entity;

import java.io.Serializable;

public class OrdenProductoId implements Serializable {
    private Long orden;
    private Long producto;

    public OrdenProductoId() {
    }

    public OrdenProductoId(long l, long l1) {
    }

    // Getters, Setters, equals y hashCode
    public Long getOrden() {
        return orden;
    }

    public void setOrden(Long orden) {
        this.orden = orden;
    }

    public Long getProducto() {
        return producto;
    }

    public void setProducto(Long producto) {
        this.producto = producto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrdenProductoId)) return false;
        OrdenProductoId that = (OrdenProductoId) o;
        return orden.equals(that.orden) && producto.equals(that.producto);
    }

    @Override
    public int hashCode() {
        return 31 * orden.hashCode() + producto.hashCode();
    }
}
