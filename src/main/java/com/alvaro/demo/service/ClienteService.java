package com.alvaro.demo.service;

import com.alvaro.demo.entity.Cliente;
import java.util.List;

public interface ClienteService {
    List<Cliente> findAll();
    Cliente findById(Long id);
    Cliente save(Cliente cliente);
    void delete(Long id);
}
