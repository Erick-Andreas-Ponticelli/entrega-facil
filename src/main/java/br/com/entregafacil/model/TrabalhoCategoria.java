package br.com.entregafacil.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "trabalho_categoria", uniqueConstraints = @UniqueConstraint(name = "uk_trabalho_categoria", columnNames = {"trabalho_id", "categoria_id"}))
public class TrabalhoCategoria {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trabalho_id", nullable = false)
    private Trabalho trabalho;
    @NotNull @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;
    @Column(nullable = false, updatable = false)
    private LocalDateTime associadoEm;

    @PrePersist
    void aoCriar() { if (associadoEm == null) associadoEm = LocalDateTime.now(); }

    public TrabalhoCategoria() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Trabalho getTrabalho() { return trabalho; }
    public void setTrabalho(Trabalho trabalho) { this.trabalho = trabalho; }
    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
    public java.time.LocalDateTime getAssociadoEm() { return associadoEm; }
    public void setAssociadoEm(java.time.LocalDateTime associadoEm) { this.associadoEm = associadoEm; }
}
