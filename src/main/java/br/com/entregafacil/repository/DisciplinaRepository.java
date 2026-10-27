package br.com.entregafacil.repository;

import br.com.entregafacil.model.Disciplina;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
    List<Disciplina> findByUsuario_IdOrderByNomeAsc(Long usuarioId);
}
