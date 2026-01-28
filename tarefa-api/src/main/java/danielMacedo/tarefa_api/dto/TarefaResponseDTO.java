package danielMacedo.tarefa_api.dto;

import danielMacedo.tarefa_api.infrastructure.entities.Tarefa;

import java.time.LocalDateTime;

public record TarefaResponseDTO(
        Integer id,
        String titulo,
        String descricao,
        Boolean status,
        LocalDateTime creatAt
) {
    public static TarefaResponseDTO fromEntity (Tarefa tarefa){
        return new TarefaResponseDTO(
                tarefa.getId(),
                tarefa.getTitulo(),
                tarefa.getDescricao(),
                tarefa.getStatus(),
                tarefa.getCreateAt()
        );
    }
}
