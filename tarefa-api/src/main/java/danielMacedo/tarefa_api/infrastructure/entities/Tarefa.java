package danielMacedo.tarefa_api.infrastructure.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Table(name = "tarefa_table")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String descricao;
    private Boolean status;
    private LocalDateTime createAt = LocalDateTime.now();
}

