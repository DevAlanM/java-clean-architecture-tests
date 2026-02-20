package com.devalanm.demo.application.usecase;

import com.devalanm.demo.domain.gateway.UsuarioGateway;
import com.devalanm.demo.domain.model.Usuario;

public class BuscarUsuarioUseCase {

    private final UsuarioGateway gateway;

    public BuscarUsuarioUseCase(UsuarioGateway gateway) {
        this.gateway = gateway;
    }

    public String executar(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id invalido");
        }

        Usuario usuario = gateway.buscarPorId(id);

        if (usuario == null) {
            throw new RuntimeException("Usuario nao encontrado");
        }

        return usuario.getNome();
    }
}
