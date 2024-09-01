package br.sc.senac.pombo.controller;

import br.sc.senac.pombo.model.entity.Denuncia;
import br.sc.senac.pombo.service.DenunciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/denuncias")
public class DenunciaController {

    @Autowired
    private DenunciaService denunciaService;

    @PostMapping
    public Denuncia criarDenuncia(@RequestBody Denuncia denuncia) {
        return denunciaService.criarDenuncia(denuncia);
    }

    @GetMapping
    public List<Denuncia> listarTodasDenuncias() {
        return denunciaService.listarTodasDenuncias();
    }

    @GetMapping("/pruu/{pruuId}")
    public List<Denuncia> listarDenunciasPorPruu(@PathVariable UUID pruuId) {
        return denunciaService.listarDenunciasPorPruu(pruuId);
    }

    @DeleteMapping("/{id}")
    public void excluirDenuncia(@PathVariable UUID id) {
        denunciaService.excluirDenuncia(id);
    }
}