package actions;

import javax.persistence.EntityManager;
import java.util.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Aluno;

public class BuscaUmAluno {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tabelas");
		EntityManager manager = factory.createEntityManager();
		
		System.out.println("Insira o Id para pesquisa do Aluno: ");
		Long id = sc.nextLong();
		
		Aluno al = manager.find(Aluno.class, id);
		System.out.println("Nome: "+ al.getNome() + 
				"\nCpf: " + al.getCpf() + 
				"\nEmail: " + al.getEmail()+ 
				"\nData de Nascimento:  " + al.getDatanascimento()+ 
				"\nNaturalidade: " + al.getNaturalidade()+ 
				"\nEndereço: " + al.getEndereco());
		
		
		manager.close();

	}
	

}
