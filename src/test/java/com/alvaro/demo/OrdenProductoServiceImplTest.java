package com.alvaro.demo;

import com.alvaro.demo.entity.OrdenProducto;
import com.alvaro.demo.entity.OrdenProductoId;
import com.alvaro.demo.repository.OrdenProductoRepository;
import com.alvaro.demo.service.impl.OrdenProductoServiceImpl;
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

class OrdenProductoServiceImplTest {

    @InjectMocks
    private OrdenProductoServiceImpl ordenProductoService;

    @Mock
    private OrdenProductoRepository ordenProductoRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        OrdenProducto ordenProducto1 = new OrdenProducto();
        OrdenProducto ordenProducto2 = new OrdenProducto();
        when(ordenProductoRepository.findAll()).thenReturn(Arrays.asList(ordenProducto1, ordenProducto2));

        List<OrdenProducto> ordenes = ordenProductoService.findAll();

        assertEquals(2, ordenes.size());
        verify(ordenProductoRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        OrdenProductoId id = new OrdenProductoId(1L, 2L); // Asumiendo que tienes un constructor para esto
        OrdenProducto ordenProducto = new OrdenProducto();
        when(ordenProductoRepository.findById(id)).thenReturn(Optional.of(ordenProducto));

        OrdenProducto foundOrden = ordenProductoService.findById(id);

        assertNotNull(foundOrden);
        verify(ordenProductoRepository, times(1)).findById(id);
    }

    @Test
    void testFindByIdNotFound() {
        OrdenProductoId id = new OrdenProductoId(1L, 2L);
        when(ordenProductoRepository.findById(id)).thenReturn(Optional.empty());

        OrdenProducto foundOrden = ordenProductoService.findById(id);

        assertNull(foundOrden);
        verify(ordenProductoRepository, times(1)).findById(id);
    }

    @Test
    void testSave() {
        OrdenProducto ordenProducto = new OrdenProducto();
        when(ordenProductoRepository.save(ordenProducto)).thenReturn(ordenProducto);

        OrdenProducto savedOrden = ordenProductoService.save(ordenProducto);

        assertNotNull(savedOrden);
        verify(ordenProductoRepository, times(1)).save(ordenProducto);
    }

    @Test
    void testDelete() {
        OrdenProductoId id = new OrdenProductoId(1L, 2L);
        doNothing().when(ordenProductoRepository).deleteById(id);

        ordenProductoService.delete(id);

        verify(ordenProductoRepository, times(1)).deleteById(id);
    }
}
