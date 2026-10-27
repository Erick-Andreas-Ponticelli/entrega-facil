package br.com.entregafacil.repository;

import br.com.entregafacil.model.StatusTrabalho;
import br.com.entregafacil.model.Trabalho;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrabalhoRepository extends JpaRepository<Trabalho, Long> {
    List<Trabalho> findByDisciplina_Usuario_IdOrderByDataEntregaAsc(Long usuarioId);
    List<Trabalho> findByDisciplina_IdOrderByDataEntregaAsc(Long disciplinaId);
    List<Trabalho> findByDisciplina_Usuario_IdAndStatusOrderByDataEntregaAsc(Long usuarioId, StatusTrabalho status);
}
