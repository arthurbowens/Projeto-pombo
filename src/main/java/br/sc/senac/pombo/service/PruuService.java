package br.sc.senac.pombo.service;

import br.sc.senac.pombo.model.entity.Pruu;
import br.sc.senac.pombo.model.entity.Usuario;
import br.sc.senac.pombo.model.repository.PruuRepository;
import br.sc.senac.pombo.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PruuService {

    @Autowired
    private PruuRepository pruuRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Pruu criarPruu(String content, UUID usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        content = content.trim();
        if (content.length() < 1 || content.length() > 300) {
            throw new IllegalArgumentException("O texto deve ter entre 1 e 300 caracteres.");
        }

        Pruu pruu = new Pruu();
        pruu.setConteudo(content);
        pruu.setUsuario(usuario);

        return pruuRepository.save(pruu);
    }

    public List<Pruu> listarTodosPruus() {
        return pruuRepository.findAllByOrderByCreatedAtDesc();
    }

    public List<Pruu> listarPruusPorUsuario(UUID usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
        return pruuRepository.findByUsuarioOrderByCreatedAtDesc(usuario);
    }

    public void likePruu(UUID pruuId, UUID usuarioId) {
        Pruu pruu = pruuRepository.findById(pruuId)
                .orElseThrow(() -> new IllegalArgumentException("Pruu não encontrado"));
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        if (pruu.getLikes().contains(usuario)) {
            throw new IllegalArgumentException("Usuário já deu like neste Pruu.");
        }

        pruu.getLikes().add(usuario);
        pruuRepository.save(pruu);
    }

    public void unlikePruu(UUID pruuId, UUID usuarioId) {
        Pruu pruu = pruuRepository.findById(pruuId)
                .orElseThrow(() -> new IllegalArgumentException("Pruu não encontrado"));
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        if (!pruu.getLikes().contains(usuario)) {
            throw new IllegalArgumentException("Usuário não deu like neste Pruu.");
        }

        pruu.getLikes().remove(usuario);
        pruuRepository.save(pruu);
    }

    public Optional<Pruu> listarPruuPorId(UUID id) {
        return pruuRepository.findById(id);
    }

    public void bloquearPruu(UUID pruuId) {
        Pruu pruu = pruuRepository.findById(pruuId)
                .orElseThrow(() -> new IllegalArgumentException("Pruu não encontrado"));
        pruu.setBloqueado(true);
        pruuRepository.save(pruu);
    }

    public void desbloquearPruu(UUID pruuId) {
        Pruu pruu = pruuRepository.findById(pruuId)
                .orElseThrow(() -> new IllegalArgumentException("Pruu não encontrado"));
        pruu.setBloqueado(false);
        pruuRepository.save(pruu);
    }

    public void excluirPruu(UUID id) {
        pruuRepository.deleteById(id);
    }
}
