package org.carlosDavi;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.carlosDavi.Model.Aluno;
import org.carlosDavi.Model.Curso;
import org.carlosDavi.Model.Inscricao;


import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("teste");
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();

            Aluno aluno = new Aluno();
            aluno.setNome("Carlos");

            Curso curso = new Curso();
            curso.setTitulo("Java JPA");

            em.persist(aluno);
            em.persist(curso);

            Inscricao inscricao = new Inscricao();
            inscricao.setAluno(aluno);
            inscricao.setCurso(curso);
            inscricao.setDataInscricao(LocalDate.now());

            em.persist(inscricao);

            em.getTransaction().commit();

            System.out.println("Dados salvos com sucesso!");
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            em.close();
            emf.close();
        }
    }
}