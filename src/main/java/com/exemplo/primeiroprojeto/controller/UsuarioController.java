package com.exemplo.primeiroprojeto.controller;

import com.exemplo.primeiroprojeto.model.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private List<Usuario> usuarios = new ArrayList<>();

    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        usuario.setId((long) usuarios.size() + 1);
        usuarios.add(usuario);
        return usuario;
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarios;
    }

    @GetMapping("/{id}")
    public Usuario buscarUsuario(@PathVariable Long id) {
        return usuarios.stream()
                .filter(usuario -> usuario.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {
        Usuario usuario = buscarUsuario(id);
        if (usuario != null) {
            usuario.setNome(usuarioAtualizado.getNome());
            usuario.setEmail(usuarioAtualizado.getEmail());
            return usuario;
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deletarUsuario(@PathVariable Long id) {
        usuarios.removeIf(usuario -> usuario.getId().equals(id));
        return "Usuário removido com sucesso!";
    }
}
