package br.sc.senac.pombo.model.entity;


import br.sc.senac.pombo.model.enums.PerfolAcesso;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @UuidGenerator
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PerfolAcesso perfolAcesso;


    @Column(nullable = false)
    private String nome;

    @Email
    @Column(nullable = false)
    private String email;

    @CPF
    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String senha;


}
