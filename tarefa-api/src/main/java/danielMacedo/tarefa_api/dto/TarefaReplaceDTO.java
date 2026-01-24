package danielMacedo.tarefa_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TarefaReplaceDTO(
        @NotBlank String titulo,
        @NotBlank String descricao,
        @NotNull Boolean status
) {}
