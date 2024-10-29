package com.alvaro.demo.service.impl;

import com.alvaro.demo.entity.OrdenProducto;
import com.alvaro.demo.entity.OrdenProductoId;
import com.alvaro.demo.repository.OrdenProductoRepository;
import com.alvaro.demo.service.OrdenProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenProductoServiceImpl implements OrdenProductoService {

    @Autowired
    private OrdenProductoRepository ordenProductoRepository;

    @Override
    public List<OrdenProducto> findAll() {
        return ordenProductoRepository.findAll();
    }

    @Override
    public OrdenProducto findById(OrdenProductoId id) {
        return ordenProductoRepository.findById(id).orElse(null);
    }

    @Override
    public OrdenProducto save(OrdenProducto ordenProducto) {
        return ordenProductoRepository.save(ordenProducto);
    }

    @Override
    public void delete(OrdenProductoId id) {
        ordenProductoRepository.deleteById(id);
    }
}
