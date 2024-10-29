package com.alvaro.demo.service;

import com.alvaro.demo.entity.OrdenProducto;
import com.alvaro.demo.entity.OrdenProductoId;

import java.util.List;

public interface OrdenProductoService {
    List<OrdenProducto> findAll();
    OrdenProducto findById(OrdenProductoId id);
    OrdenProducto save(OrdenProducto ordenProducto);
    void delete(OrdenProductoId id);
}
