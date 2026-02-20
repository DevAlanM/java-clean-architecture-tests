package com.devalanm.demo.domain.gateway;

import com.devalanm.demo.domain.model.Usuario;

public interface UsuarioGateway {
    Usuario buscarPorId(Long id);
}
