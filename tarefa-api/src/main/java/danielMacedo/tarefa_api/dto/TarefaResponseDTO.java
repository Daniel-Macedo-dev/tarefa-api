package danielMacedo.tarefa_api.dto;

import java.time.LocalDateTime;

public record TarefaResponseDTO(
        Integer id,
        String titulo,
        String descricao,
        Boolean status,
        LocalDateTime creatAt
) {}
