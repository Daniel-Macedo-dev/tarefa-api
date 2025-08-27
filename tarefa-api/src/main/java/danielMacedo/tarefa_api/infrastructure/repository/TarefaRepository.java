package danielMacedo.tarefa_api.infrastructure.repository;

import danielMacedo.tarefa_api.infrastructure.entities.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa,Integer> {
}
