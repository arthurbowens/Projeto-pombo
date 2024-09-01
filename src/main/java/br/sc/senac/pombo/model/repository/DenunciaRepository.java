package br.sc.senac.pombo.model.repository;

import br.sc.senac.pombo.model.entity.Denuncia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DenunciaRepository extends JpaRepository<Denuncia, UUID> {
    List<Denuncia> findByPruuId(UUID pruuId);
}
