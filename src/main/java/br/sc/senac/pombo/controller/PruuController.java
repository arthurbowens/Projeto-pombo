package br.sc.senac.pombo.controller;

import br.sc.senac.pombo.exception.PomboException;
import br.sc.senac.pombo.model.entity.Pruu;
import br.sc.senac.pombo.service.PruuService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/pruu")
public class PruuController {

    @Autowired
    private PruuService pruuService;

    @PostMapping
    public Pruu create(@Valid @RequestBody Pruu pruu) throws PomboException {
        return ResponseEntity.ok(pruuService.create(pruu)).getBody();
    }

    @GetMapping
    public List<Pruu> findAll() {
        return pruuService.findAll();
    }
}