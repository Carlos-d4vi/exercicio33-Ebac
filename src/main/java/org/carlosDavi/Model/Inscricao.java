package org.carlosDavi.Model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Inscricao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate dataInscricao;

    /*várias inscrições tem o mesmo aluno*/
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Aluno aluno;

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public LocalDate getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(LocalDate dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /*Vários cursos podem ter o mesmo aluno*/
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
}
