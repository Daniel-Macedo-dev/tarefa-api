package danielMacedo.tarefa_api.controller;

import danielMacedo.tarefa_api.business.TarefaService;
import danielMacedo.tarefa_api.infrastructure.entities.Tarefa;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService _tarefaService;

    @PostMapping
    public ResponseEntity<Void> salvarTarefa(@RequestBody Tarefa tarefa){
        _tarefaService.salvarTarefa(tarefa);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarTarefaPorId(@PathVariable Integer id){
        return ResponseEntity.ok(_tarefaService.buscarTarefaPorId(id));
    }
    @GetMapping
    public ResponseEntity<List<Tarefa>> listarTarefas(){
        return ResponseEntity.ok(_tarefaService.listarTarefas());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefaPorId(@PathVariable Integer id) {
        _tarefaService.deletarTarefaPorId(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> substituirTarefa(
            @PathVariable Integer id,
            @RequestBody Tarefa novaTarefa){
        _tarefaService.substituirTarefa(id, novaTarefa);
        return ResponseEntity.ok().build();
    }
    @PatchMapping("/{id}/status")
    public ResponseEntity<Tarefa> atualizarTarefa(
            @RequestParam Integer id,
            @RequestBody Tarefa novaTarefa){
        _tarefaService.atualizarTarefa(id, novaTarefa);
        return ResponseEntity.ok().build();
    }
}
