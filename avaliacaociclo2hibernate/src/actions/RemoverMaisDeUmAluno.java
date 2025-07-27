package actions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Aluno;
import java.util.*;
public class RemoverMaisDeUmAluno {

	public static void main(String[] args) {
		Aluno aluno1 = new Aluno();
		Long id; 
		Scanner sc = new Scanner(System.in);
		int op;
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tabelas");
		EntityManager manager = factory.createEntityManager();
		
		System.out.println("Insira aqui a opção: [1] - Excluir Aluno\n[2] - Sair do Programa");
		op = sc.nextInt();
		
		if(op == 1) { 
		
		
			while(op != 2) {
			
			op = sc.nextInt();
			
			System.out.println("Insira o id do aluno: ");
			id = sc.nextLong();
			
			aluno1.setId(id);
			aluno1 = manager.find(Aluno.class, id);
			
			manager.getTransaction().begin();
			manager.remove(aluno1);
			manager.getTransaction().commit();
			
			
			System.out.println("Aluno excluído");
			
			
			System.out.println("Insira aqui a opção: [1] - Excluir Aluno\n[2] - Sair do Programa");
			op = sc.nextInt();
			
			
			
			
			}
		}
		
		else
		
			manager.close();
		
		
		

	}

}
