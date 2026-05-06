package danielMacedo.tarefa_api.service;

import danielMacedo.tarefa_api.business.TarefaService;
import danielMacedo.tarefa_api.dto.TarefaCreateDTO;
import danielMacedo.tarefa_api.infrastructure.entities.Tarefa;
import danielMacedo.tarefa_api.infrastructure.repository.TarefaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TarefaServiceTest {

    @Mock
    private TarefaRepository tarefaRepository;

    @InjectMocks
    private TarefaService tarefaService;

    @Test
    void deveSalvarTarefaComStatusFalse(){
        TarefaCreateDTO dto = new TarefaCreateDTO("Estudar testes", "Aprender Mockito");

        when(tarefaRepository.save(any(Tarefa.class))).thenAnswer(invocationOnMock -> {
            Tarefa tarefaRecebida = invocationOnMock.getArgument(0);
            tarefaRecebida.setId(1);
            return tarefaRecebida;
        });

        Tarefa resultado = tarefaService.salvarTarefa(dto);

        assertNotNull(resultado);
        assertEquals(1, resultado.getId());
        assertEquals("Estudar testes", resultado.getTitulo());
        assertEquals("Aprender Mockito", resultado.getDescricao());
        assertFalse(resultado.getStatus());

        verify(tarefaRepository).save(any(Tarefa.class));

    }

}
