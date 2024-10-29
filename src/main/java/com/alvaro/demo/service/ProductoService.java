package com.alvaro.demo.service;

import com.alvaro.demo.entity.Producto;
import java.util.List;

public interface ProductoService {
    List<Producto> findAll();
    Producto findById(Long id);
    Producto save(Producto producto);
    void delete(Long id);
}
