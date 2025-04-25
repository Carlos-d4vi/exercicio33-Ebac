package org.carlosDavi.Model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    /*Um aluno pode ter várias inscricoes*/
    @OneToMany(mappedBy = "aluno")
    private List<Inscricao> inscricoes = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Inscricao> getInscricoes() {
        return inscricoes;
    }

    public void setInscricoes(List<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }
}
