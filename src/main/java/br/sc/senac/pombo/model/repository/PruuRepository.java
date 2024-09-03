package br.sc.senac.pombo.model.repository;

import br.sc.senac.pombo.model.entity.Pruu;
import br.sc.senac.pombo.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PruuRepository extends JpaRepository<Pruu, UUID> {
    List<Pruu> findByUsuarioOrderByCreatedAtDesc(Usuario usuario);
    List<Pruu> findAllByOrderByCreatedAtDesc();
}