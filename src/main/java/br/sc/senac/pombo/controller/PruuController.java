package br.sc.senac.pombo.controller;

import br.sc.senac.pombo.model.entity.Pruu;
import br.sc.senac.pombo.service.PruuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/pruus")
public class PruuController {

    @Autowired
    private PruuService pruuService;

    @PostMapping
    public Pruu criarPruu(@RequestBody String content, @RequestParam UUID usuarioId) {
        return pruuService.criarPruu(content, usuarioId);
    }

    @GetMapping
    public List<Pruu> listarTodosPruus() {
        return pruuService.listarTodosPruus();
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Pruu> listarPruusPorUsuario(@PathVariable UUID usuarioId) {
        return pruuService.listarPruusPorUsuario(usuarioId);
    }

    @GetMapping("/{id}")
    public Optional<Pruu> listarPruuPorId(@PathVariable UUID id) {
        return pruuService.listarPruuPorId(id);
    }

    @PostMapping("/{id}/like")
    public void likePruu(@PathVariable UUID id, @RequestParam UUID usuarioId) {
        pruuService.likePruu(id, usuarioId);
    }

    @PostMapping("/{id}/unlike")
    public void unlikePruu(@PathVariable UUID id, @RequestParam UUID usuarioId) {
        pruuService.unlikePruu(id, usuarioId);
    }

    @PutMapping("/{id}/bloquear")
    public void bloquearPruu(@PathVariable UUID id) {
        pruuService.bloquearPruu(id);
    }

    @PutMapping("/{id}/desbloquear")
    public void desbloquearPruu(@PathVariable UUID id) {
        pruuService.desbloquearPruu(id);
    }

    @DeleteMapping("/{id}")
    public void excluirPruu(@PathVariable UUID id) {
        pruuService.excluirPruu(id);
    }
}