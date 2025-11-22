package com.arriendos;

import com.arriendos.entity.Inmueble;
import com.arriendos.repository.InmuebleRepository;
import com.arriendos.service.Impl.InmuebleServiceImpl;
import com.arriendos.service.InmuebleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
public class InmuebleServiceTest {

    @Mock
    private InmuebleRepository repo;

    @InjectMocks
    private InmuebleServiceImpl service;

    @Test
    void crearInmueble_debeRetornarInmuebleCreado() {
        // Arrange
        Inmueble input = new Inmueble();
        input.setTitulo("Casa en el centro");
        input.setPrecio(500000L);
        // lo que necesites setear

        Inmueble saved = new Inmueble();
        saved.setId(1L);
        saved.setTitulo("Casa en el centro");
        saved.setPrecio(500000L);

        when(repo.save(any(Inmueble.class))).thenReturn(saved);

        // Act
        Inmueble resultado = service.crear(input);

        // Assert
        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals("Casa en el centro", resultado.getTitulo());

        // Verifica que el repositorio se llamó una vez con el objeto
        ArgumentCaptor<Inmueble> captor = ArgumentCaptor.forClass(Inmueble.class);
        verify(repo, times(1)).save(captor.capture());
        Inmueble guardado = captor.getValue();
        assertEquals("Casa en el centro", guardado.getTitulo());
    }
}
