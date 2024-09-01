package br.sc.senac.pombo.service;

import br.sc.senac.pombo.model.entity.Denuncia;
import br.sc.senac.pombo.model.repository.DenunciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DenunciaService {

    @Autowired
    private DenunciaRepository denunciaRepository;

    public Denuncia criarDenuncia(Denuncia denuncia) {
        return denunciaRepository.save(denuncia);
    }

    public List<Denuncia> listarTodasDenuncias() {
        return denunciaRepository.findAll();
    }

    public List<Denuncia> listarDenunciasPorPruu(UUID pruuId) {
        return denunciaRepository.findByPruuId(pruuId);
    }

    public void excluirDenuncia(UUID id) {
        denunciaRepository.deleteById(id);
    }
}
