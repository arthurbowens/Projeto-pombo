package br.sc.senac.pombo.service;

import br.sc.senac.pombo.model.entity.Usuario;
import br.sc.senac.pombo.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> listarUsuariosPorId(UUID id) {
        return usuarioRepository.findById(id);
    }

    public Usuario atualizarUsuario(UUID id, Usuario usuarioAtualizado) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        usuarioExistente.setName(usuarioAtualizado.getName());
        usuarioExistente.setEmail(usuarioAtualizado.getEmail());
        usuarioExistente.setCpf(usuarioAtualizado.getCpf());

        return usuarioRepository.save(usuarioExistente);
    }

    public void excluirUsuario(UUID id) {
        usuarioRepository.deleteById(id);
    }
}
