package com.alvaro.demo.service;

import com.alvaro.demo.entity.Orden;
import java.util.List;

public interface OrdenService {
    List<Orden> findAll();
    Orden findById(Long id);
    Orden save(Orden orden);
    void delete(Long id);
}
