package com.alvaro.demo;

import com.alvaro.demo.entity.Producto;
import com.alvaro.demo.repository.ProductoRepository;
import com.alvaro.demo.service.impl.ProductoServiceImpl;
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

class ProductoServiceImplTest {

    @InjectMocks
    private ProductoServiceImpl productoService;

    @Mock
    private ProductoRepository productoRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        Producto producto1 = new Producto();
        Producto producto2 = new Producto();
        when(productoRepository.findAll()).thenReturn(Arrays.asList(producto1, producto2));

        List<Producto> productos = productoService.findAll();

        assertEquals(2, productos.size());
        verify(productoRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        Long id = 1L;
        Producto producto = new Producto();
        when(productoRepository.findById(id)).thenReturn(Optional.of(producto));

        Producto foundProducto = productoService.findById(id);

        assertNotNull(foundProducto);
        verify(productoRepository, times(1)).findById(id);
    }

    @Test
    void testFindByIdNotFound() {
        Long id = 1L;
        when(productoRepository.findById(id)).thenReturn(Optional.empty());

        Producto foundProducto = productoService.findById(id);

        assertNull(foundProducto);
        verify(productoRepository, times(1)).findById(id);
    }

    @Test
    void testSave() {
        Producto producto = new Producto();
        when(productoRepository.save(producto)).thenReturn(producto);

        Producto savedProducto = productoService.save(producto);

        assertNotNull(savedProducto);
        verify(productoRepository, times(1)).save(producto);
    }

    @Test
    void testDelete() {
        Long id = 1L;
        doNothing().when(productoRepository).deleteById(id);

        productoService.delete(id);

        verify(productoRepository, times(1)).deleteById(id);
    }
}