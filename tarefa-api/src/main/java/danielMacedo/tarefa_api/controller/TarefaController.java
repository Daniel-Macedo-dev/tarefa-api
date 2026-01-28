package danielMacedo.tarefa_api.controller;

import danielMacedo.tarefa_api.business.TarefaService;
import danielMacedo.tarefa_api.dto.TarefaCreateDTO;
import danielMacedo.tarefa_api.dto.TarefaReplaceDTO;
import danielMacedo.tarefa_api.dto.TarefaResponseDTO;
import danielMacedo.tarefa_api.dto.TarefaUpdateDTO;
import danielMacedo.tarefa_api.infrastructure.entities.Tarefa;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<Void> salvarTarefa(@RequestBody TarefaCreateDTO dto){
        tarefaService.salvarTarefa(dto);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<TarefaResponseDTO> buscarTarefaPorId(@PathVariable Integer id){
        return ResponseEntity.ok(tarefaService.buscarTarefaPorId(id));
    }
    @GetMapping
    public ResponseEntity<List<TarefaResponseDTO>> listarTarefas(){
        return ResponseEntity.ok(tarefaService.listarTarefas());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> substituirTarefa(
            @PathVariable Integer id,
            @RequestBody TarefaReplaceDTO dto){
        Tarefa atualizada = tarefaService.substituirTarefa(id, dto);
        return ResponseEntity.ok().build();
    }
    @PatchMapping("/{id}/status")
    public ResponseEntity<Tarefa> atualizarTarefa(
            @PathVariable Integer id,
            @RequestBody TarefaUpdateDTO dto){
        Tarefa atualizada = tarefaService.atualizarTarefa(id, dto);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefaPorId(@PathVariable Integer id){
        tarefaService.deletarTarefaPorId(id);
        return ResponseEntity.noContent().build();
    }
}
