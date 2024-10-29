package com.alvaro.demo.service.impl;

import com.alvaro.demo.entity.Orden;
import com.alvaro.demo.repository.OrdenRepository;
import com.alvaro.demo.service.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenServiceImpl implements OrdenService {

    @Autowired
    private OrdenRepository ordenRepository;

    @Override
    public List<Orden> findAll() {
        return ordenRepository.findAll();
    }

    @Override
    public Orden findById(Long id) {
        return ordenRepository.findById(id).orElse(null);
    }

    @Override
    public Orden save(Orden orden) {
        return ordenRepository.save(orden);
    }

    @Override
    public void delete(Long id) {
        ordenRepository.deleteById(id);
    }
}
