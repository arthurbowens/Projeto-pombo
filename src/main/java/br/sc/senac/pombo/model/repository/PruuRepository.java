package br.sc.senac.pombo.model.repository;

import br.sc.senac.pombo.model.entity.Pruu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Repository
public interface PruuRepository extends JpaRepository<Pruu, String> {

    // Set<Pruu> findByUserId(UUID userId);
}