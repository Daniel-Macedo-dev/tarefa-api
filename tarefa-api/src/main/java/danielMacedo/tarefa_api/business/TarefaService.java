package danielMacedo.tarefa_api.business;

import danielMacedo.tarefa_api.infrastructure.entities.Tarefa;
import danielMacedo.tarefa_api.infrastructure.repository.TarefaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public Tarefa salvarTarefa(Tarefa tarefa){
        return tarefaRepository.saveAndFlush(tarefa);
    }

    public List<Tarefa> listarTarefas(){
        return tarefaRepository.findAll();
    }

    public Tarefa buscarTarefaPorId(Integer id){
        return tarefaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id não encontrado")
        );
    }

    public Tarefa substituirTarefa(Integer id, Tarefa novaTarefa){
        Tarefa tarefaBusca = tarefaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id não encontrado"));
        tarefaBusca.setTitulo(novaTarefa.getTitulo());
        tarefaBusca.setDescricao(novaTarefa.getDescricao());
        tarefaBusca.setStatus(novaTarefa.getStatus());
        tarefaBusca.setCreateAt(novaTarefa.getCreateAt());

        return tarefaRepository.saveAndFlush(tarefaBusca);
    }

    public Tarefa atualizarTarefa(Integer id, Tarefa tarefaAtualizada){
        Tarefa tarefaBusca = tarefaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id não encontrado"));
        tarefaBusca.setTitulo(tarefaAtualizada.getTitulo());
        tarefaBusca.setDescricao(tarefaAtualizada.getDescricao());

        return tarefaRepository.saveAndFlush(tarefaBusca);
    }
    public void deletarTarefaPorId(Integer id){
        tarefaRepository.deleteById(id);
    }



}