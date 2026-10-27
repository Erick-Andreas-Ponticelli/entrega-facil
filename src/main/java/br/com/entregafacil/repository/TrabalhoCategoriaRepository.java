package br.com.entregafacil.repository;

import br.com.entregafacil.model.TrabalhoCategoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrabalhoCategoriaRepository extends JpaRepository<TrabalhoCategoria, Long> {
    List<TrabalhoCategoria> findByTrabalho_Id(Long trabalhoId);
    List<TrabalhoCategoria> findByCategoria_Id(Long categoriaId);
    boolean existsByTrabalho_IdAndCategoria_Id(Long trabalhoId, Long categoriaId);
}
