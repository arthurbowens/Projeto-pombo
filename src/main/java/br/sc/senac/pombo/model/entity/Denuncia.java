package br.sc.senac.pombo.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "denuncias")
@Data
public class Denuncia {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "pruu_id")
    private Pruu pruu;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String motivo;

    @CreationTimestamp
    private LocalDateTime dataHoraDenuncia;
}