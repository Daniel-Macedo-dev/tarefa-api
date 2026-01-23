package danielMacedo.tarefa_api.dto;

public record TarefaUpdateDTO(
        String titulo,
        String descricao,
        Boolean status
) {}
