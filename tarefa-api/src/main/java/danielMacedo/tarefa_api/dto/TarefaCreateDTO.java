package danielMacedo.tarefa_api.dto;

import jakarta.validation.constraints.NotBlank;

public record TarefaCreateDTO (
        @NotBlank String titulo,
        @NotBlank String descricao
        ){}
