package com.example.prueba.clientes.service;

import com.example.prueba.clientes.exception.ResourceNotFoundException;
import com.example.prueba.clientes.model.Cliente;
import com.example.prueba.clientes.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    private Cliente cliente;

    @BeforeEach
    void setUp() {
        cliente = Cliente.builder()
                .id(1L)
                .nombre("Juan")
                .apellido("Perez")
                .email("juan@test.com")
                .build();
    }

    @Test
    void guardarCliente_Exito() {
        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);
        Cliente clienteGuardado = clienteService.guardar(cliente);
        assertNotNull(clienteGuardado);
        assertEquals("Juan", clienteGuardado.getNombre());
    }

    @Test
    void buscarPorId_Falla_LanzaExcepcion() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> clienteService.buscarPorId(1L));
    }
}
