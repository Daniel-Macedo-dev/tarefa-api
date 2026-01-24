package danielMacedo.tarefa_api.business;

import danielMacedo.tarefa_api.dto.TarefaCreateDTO;
import danielMacedo.tarefa_api.dto.TarefaReplaceDTO;
import danielMacedo.tarefa_api.dto.TarefaUpdateDTO;
import danielMacedo.tarefa_api.infrastructure.entities.Tarefa;
import danielMacedo.tarefa_api.infrastructure.repository.TarefaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public Tarefa salvarTarefa(TarefaCreateDTO dto){
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(dto.titulo());
        tarefa.setDescricao(dto.descricao());
        tarefa.setStatus(false);

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

    public Tarefa substituirTarefa(Integer id, TarefaReplaceDTO dto){
        Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id não encontrado"));
        tarefa.setTitulo(dto.titulo());
        tarefa.setDescricao(dto.descricao());
        tarefa.setStatus(dto.status());

        return tarefaRepository.saveAndFlush(tarefa);
    }

    public Tarefa atualizarTarefa(Integer id, TarefaUpdateDTO dto){
        Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id não encontrado"));
        if (dto.titulo()!=null){
            if (dto.titulo().isBlank()){
                throw new RuntimeException("Título não pode ser vazio");
            }
            tarefa.setTitulo(dto.titulo());
        }
        if(dto.descricao()!=null){
            if(dto.descricao().isBlank()){
                throw new RuntimeException("Descrição não pode ser vazia");
            }
            tarefa.setDescricao(dto.descricao());
        }
        if(dto.status()!=null){
            tarefa.setStatus(dto.status());
        }
        return tarefaRepository.saveAndFlush(tarefa);
    }

    public void deletarTarefaPorId(Integer id){
        tarefaRepository.deleteById(id);
    }
}