package com.alvaro.demo;

import com.alvaro.demo.entity.Cliente;
import com.alvaro.demo.repository.ClienteRepository;
import com.alvaro.demo.service.impl.ClienteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClienteServiceImplTest {

    @InjectMocks
    private ClienteServiceImpl clienteService;

    @Mock
    private ClienteRepository clienteRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        Cliente cliente1 = new Cliente();
        Cliente cliente2 = new Cliente();
        when(clienteRepository.findAll()).thenReturn(Arrays.asList(cliente1, cliente2));

        List<Cliente> clientes = clienteService.findAll();

        assertEquals(2, clientes.size());
        verify(clienteRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        Long id = 1L;
        Cliente cliente = new Cliente();
        when(clienteRepository.findById(id)).thenReturn(Optional.of(cliente));

        Cliente foundCliente = clienteService.findById(id);

        assertNotNull(foundCliente);
        verify(clienteRepository, times(1)).findById(id);
    }

    @Test
    void testSave() {
        Cliente cliente = new Cliente();
        when(clienteRepository.save(cliente)).thenReturn(cliente);

        Cliente savedCliente = clienteService.save(cliente);

        assertNotNull(savedCliente);
        verify(clienteRepository, times(1)).save(cliente);
    }

    @Test
    void testDelete() {
        Long id = 1L;
        doNothing().when(clienteRepository).deleteById(id);

        clienteService.delete(id);

        verify(clienteRepository, times(1)).deleteById(id);
    }
}