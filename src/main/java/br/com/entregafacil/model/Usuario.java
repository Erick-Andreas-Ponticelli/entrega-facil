package br.com.entregafacil.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.*;
import java.time.LocalDateTime;

@Entity
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Column(nullable = false, length = 120)
    private String nome;
    @NotBlank @Email @Column(nullable = false, unique = true, length = 180)
    private String email;
    @NotBlank @Column(nullable = false, length = 255)
    private String senhaHash;
    @Column(nullable = false, updatable = false)
    private LocalDateTime criadoEm;
    @OneToMany(mappedBy = "usuario")
    private List<Disciplina> disciplinas = new ArrayList<>();
    @OneToMany(mappedBy = "autor")
    private List<Comentario> comentarios = new ArrayList<>();

    @PrePersist
    void aoCriar() { if (criadoEm == null) criadoEm = LocalDateTime.now(); }

    public Usuario() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSenhaHash() { return senhaHash; }
    public void setSenhaHash(String senhaHash) { this.senhaHash = senhaHash; }
    public java.time.LocalDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(java.time.LocalDateTime criadoEm) { this.criadoEm = criadoEm; }
}
