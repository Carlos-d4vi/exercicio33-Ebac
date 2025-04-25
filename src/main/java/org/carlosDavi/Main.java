package org.carlosDavi;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.carlosDavi.Model.*;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("teste");
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();

            Marca marca = new Marca();
            marca.setNome("marca 1");

            Acessorio acessorio = new Acessorio();
            acessorio.setNome("Acessorio 1");

            Acessorio acessorio2 = new Acessorio();
            acessorio2.setNome("Acessório 2");

            List<Acessorio> acessorios = new ArrayList<>();

            acessorios.add(acessorio);
            acessorios.add(acessorio2);

            Carro carro = new Carro();
            carro.setNome("Carro exemplo");
            carro.setMarca(marca);
            carro.setAcessorios(acessorios);

            em.persist(marca);
            em.persist(acessorio);
            em.persist(acessorio2);
            em.persist(carro);

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