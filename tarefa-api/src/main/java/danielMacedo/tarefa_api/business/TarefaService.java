package danielMacedo.tarefa_api.business;

import danielMacedo.tarefa_api.infrastructure.entities.Tarefa;
import danielMacedo.tarefa_api.infrastructure.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    private final TarefaRepository _tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {_tarefaRepository = tarefaRepository;}

    public Tarefa salvarTarefa(Tarefa tarefa){
        return _tarefaRepository.saveAndFlush(tarefa);}

    public List<Tarefa> listarTarefas(){
        return _tarefaRepository.findAll();
    }

    public Tarefa buscarTarefaPorId(Integer _id){
        return _tarefaRepository.findById(_id).orElseThrow(
                () -> new RuntimeException("id não encontrado")
        );
    }

    public Tarefa substituirTarefa(Integer _id, Tarefa novaTarefa){
        Tarefa tarefaBusca = _tarefaRepository.findById(_id).orElseThrow(
                () -> new RuntimeException("id não encontrado"));
        tarefaBusca.setTitulo(novaTarefa.getTitulo());
        tarefaBusca.setDescricao(novaTarefa.getDescricao());
        tarefaBusca.setStatus(novaTarefa.getStatus());
        tarefaBusca.setDataCriacao(novaTarefa.getDataCriacao());

        return _tarefaRepository.saveAndFlush(tarefaBusca);
    }

    public Tarefa atualizarTarefa(Integer _id, Tarefa novaTarefa){
        Tarefa tarefaBusca = _tarefaRepository.findById(_id).orElseThrow(
                () -> new RuntimeException("id não encontrado"));
        tarefaBusca.setStatus(novaTarefa.getStatus());

        return _tarefaRepository.saveAndFlush(tarefaBusca);
    }

    public void deletarTarefaPorId(Integer _id){
        _tarefaRepository.deleteById(_id);
    }
}
