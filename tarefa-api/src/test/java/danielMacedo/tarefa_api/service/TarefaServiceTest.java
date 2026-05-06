package danielMacedo.tarefa_api.service;

import danielMacedo.tarefa_api.business.TarefaService;
import danielMacedo.tarefa_api.infrastructure.repository.TarefaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TarefaServiceTest {

    @Mock
    private TarefaRepository tarefaRepository;

    @InjectMocks
    private TarefaService tarefaService;

    @Test
    void deveSalvarTarefaComStatusFalse(){

    }

}
