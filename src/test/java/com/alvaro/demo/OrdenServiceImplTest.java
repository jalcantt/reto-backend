package com.alvaro.demo;

import com.alvaro.demo.entity.Orden;
import com.alvaro.demo.repository.OrdenRepository;
import com.alvaro.demo.service.impl.OrdenServiceImpl;
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

class OrdenServiceImplTest {

    @InjectMocks
    private OrdenServiceImpl ordenService;

    @Mock
    private OrdenRepository ordenRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        Orden orden1 = new Orden();
        Orden orden2 = new Orden();
        when(ordenRepository.findAll()).thenReturn(Arrays.asList(orden1, orden2));

        List<Orden> ordenes = ordenService.findAll();

        assertEquals(2, ordenes.size());
        verify(ordenRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        Long id = 1L;
        Orden orden = new Orden();
        when(ordenRepository.findById(id)).thenReturn(Optional.of(orden));

        Orden foundOrden = ordenService.findById(id);

        assertNotNull(foundOrden);
        verify(ordenRepository, times(1)).findById(id);
    }

    @Test
    void testFindByIdNotFound() {
        Long id = 1L;
        when(ordenRepository.findById(id)).thenReturn(Optional.empty());

        Orden foundOrden = ordenService.findById(id);

        assertNull(foundOrden);
        verify(ordenRepository, times(1)).findById(id);
    }

    @Test
    void testSave() {
        Orden orden = new Orden();
        when(ordenRepository.save(orden)).thenReturn(orden);

        Orden savedOrden = ordenService.save(orden);

        assertNotNull(savedOrden);
        verify(ordenRepository, times(1)).save(orden);
    }

    @Test
    void testDelete() {
        Long id = 1L;
        doNothing().when(ordenRepository).deleteById(id);

        ordenService.delete(id);

        verify(ordenRepository, times(1)).deleteById(id);
    }
}
