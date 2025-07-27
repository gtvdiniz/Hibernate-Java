package actions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Aluno;
import java.util.*;
public class RemoverAluno {

	public static void main(String[] args) {
		Aluno aluno1 = new Aluno();
		Long id; 
		Scanner sc = new Scanner(System.in);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tabelas");
		EntityManager manager = factory.createEntityManager();
		
		
		System.out.println("Insira o id do aluno: ");
		id = sc.nextLong();
		
		aluno1.setId(id);
		aluno1 = manager.find(Aluno.class, id);
		
		manager.getTransaction().begin();
		manager.remove(aluno1);
		manager.getTransaction().commit();
		
		
		System.out.println("Aluno excluído");
		
		manager.close();
		
		
		

	}

}
