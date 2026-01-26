package danielMacedo.tarefa_api.business;

import danielMacedo.tarefa_api.dto.TarefaCreateDTO;
import danielMacedo.tarefa_api.dto.TarefaReplaceDTO;
import danielMacedo.tarefa_api.dto.TarefaUpdateDTO;
import danielMacedo.tarefa_api.infrastructure.entities.Tarefa;
import danielMacedo.tarefa_api.infrastructure.repository.TarefaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    @Transactional
    public Tarefa salvarTarefa(TarefaCreateDTO dto){
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(dto.titulo());
        tarefa.setDescricao(dto.descricao());
        tarefa.setStatus(false);

        return tarefaRepository.save(tarefa);
    }

    @Transactional(readOnly = true)
    public List<Tarefa> listarTarefas(){
        return tarefaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Tarefa buscarTarefaPorId(Integer id){
        return tarefaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id não encontrado")
        );
    }

    @Transactional
    public Tarefa substituirTarefa(Integer id, TarefaReplaceDTO dto){
        Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id não encontrado"));
        tarefa.setTitulo(dto.titulo());
        tarefa.setDescricao(dto.descricao());
        tarefa.setStatus(dto.status());

        return tarefa;
    }

    @Transactional
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
        return tarefa;
    }

    @Transactional
    public void deletarTarefaPorId(Integer id){
        if (!tarefaRepository.existsById(id)) {
            throw new RuntimeException("id não encontrado");
        } else {
            tarefaRepository.deleteById(id);
        }
    }
}