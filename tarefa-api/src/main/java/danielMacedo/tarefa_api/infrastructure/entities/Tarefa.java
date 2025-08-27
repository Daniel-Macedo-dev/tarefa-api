package danielMacedo.tarefa_api.infrastructure.entities;


import jakarta.persistence.*;

import java.util.Date;

@Table(name = "tarefa_table")
@Entity
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer _id;
    private String _titulo;
    private String _descricao;
    private Boolean _status;
    private Date _dataCriacao;

    public Tarefa(){}
    public Tarefa(Integer id, String titulo, String descricao, Boolean status, Date dataCriacao) {
        _id = id;
        _titulo = titulo;
        _descricao = descricao;
        _status = status;
        _dataCriacao = dataCriacao;
    }

    public Integer getId() {return _id;}

    public void setId(Integer id) {_id = id;}

    public String getTitulo() {return _titulo;}

    public void setTitulo(String titulo) {_titulo = titulo;}

    public String getDescricao() {return _descricao;}

    public void setDescricao(String descricao) {_descricao = descricao;}

    public Boolean getStatus() {return _status;}

    public void setStatus(Boolean status) {_status = status;}

    public Date getDataCriacao() {return _dataCriacao;}

    public void setDataCriacao(Date dataCriacao) {_dataCriacao = dataCriacao;}

    @PrePersist
    public void salvaData(){
        _dataCriacao = new Date();
    }
}

