package br.com.entregafacil.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.*;
import java.time.LocalDate;

@Entity
public class Trabalho {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Column(nullable = false, length = 180)
    private String titulo;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    @NotNull @Column(nullable = false)
    private LocalDate dataEntrega;
    @NotNull @Enumerated(EnumType.STRING) @Column(nullable = false, length = 20)
    private StatusTrabalho status = StatusTrabalho.PENDENTE;
    @NotNull @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "disciplina_id", nullable = false)
    private Disciplina disciplina;
    @Column(nullable = false, updatable = false)
    private LocalDateTime criadoEm;
    @OneToMany(mappedBy = "trabalho")
    private List<Comentario> comentarios = new ArrayList<>();
    @OneToMany(mappedBy = "trabalho")
    private List<TrabalhoCategoria> categorias = new ArrayList<>();

    @PrePersist
    void aoCriar() { if (criadoEm == null) criadoEm = LocalDateTime.now(); }

    public Trabalho() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public java.time.LocalDate getDataEntrega() { return dataEntrega; }
    public void setDataEntrega(java.time.LocalDate dataEntrega) { this.dataEntrega = dataEntrega; }
    public StatusTrabalho getStatus() { return status; }
    public void setStatus(StatusTrabalho status) { this.status = status; }
    public Disciplina getDisciplina() { return disciplina; }
    public void setDisciplina(Disciplina disciplina) { this.disciplina = disciplina; }
}
