package com.devalanm.demo.application.usecase;

import com.devalanm.demo.domain.gateway.UsuarioGateway;
import com.devalanm.demo.domain.model.Usuario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BuscarUsuarioUseCaseTest {

    @Mock
    private UsuarioGateway gateway;

    @InjectMocks
    private BuscarUsuarioUseCase useCase;

    @Test
    void deveRetornarNomeQuandoUsuarioExiste() {
        when(gateway.buscarPorId(1L)).thenReturn(new Usuario(1L, "Alan"));

        String nome = useCase.executar(1L);

        assertEquals("Alan", nome);
        verify(gateway).buscarPorId(1L);
    }

    @Test
    void deveLancarExcecaoQuandoUsuarioNaoExiste() {
        when(gateway.buscarPorId(2L)).thenReturn(null);

        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> useCase.executar(2L));

        assertEquals("Usuario nao encontrado", ex.getMessage());
    }

    @Test
    void deveLancarExcecaoQuandoIdInvalidoNoUseCase() {
        assertThrows(IllegalArgumentException.class,
                () -> useCase.executar(null));
    }

    @Test
    void deveValidarDominioCompleto() {
        Usuario usuario = new Usuario(10L, "Carlos");

        assertEquals(10L, usuario.getId());
        assertEquals("Carlos", usuario.getNome());
        assertTrue(usuario.temNome("Carlos"));
    }

    @Test
    void deveLancarErroQuandoIdInvalidoNoDominio() {
        assertThrows(IllegalArgumentException.class,
                () -> new Usuario(null, "Alan"));
    }

    @Test
    void deveLancarErroQuandoNomeInvalido() {
        assertThrows(IllegalArgumentException.class,
                () -> new Usuario(1L, ""));
    }
}
