package actions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Aluno;
import java.util.*;
public class InserirAluno {
	public static void main(String[] args) {
		String nome; 
		String cpf; 
		String email; 
		String datanasc; 
		String naturalidade; 
		String endereco;
		
		Aluno aluno1 = new Aluno();
		Scanner sc = new Scanner(System.in);
		System.out.println("Insira o nome: ");
		nome = sc.nextLine();
		
		System.out.println("Insira o cpf: ");
		cpf = sc.nextLine();
		
		System.out.println("Insira o email: ");
		email = sc.nextLine();
	
		System.out.println("Insira a data nascimento formato: dd/mm/aaaa: ");
		datanasc = sc.nextLine();
		
		System.out.println("Insira a naturalidade: ");
		naturalidade = sc.nextLine();
		
		System.out.println("Insira o endereco: ");
		endereco = sc.nextLine();
		
		aluno1.setNome(nome);
		aluno1.setCpf(cpf);
		aluno1.setEmail(email);
		aluno1.setDatanascimento(datanasc);
		aluno1.setNaturalidade(naturalidade);
		aluno1.setEndereco(endereco);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tabelas");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(aluno1);
		manager.getTransaction().commit();
		
		System.out.println("Aluno Inserido, ID: "+ aluno1.getId());
		
		manager.close();
		
	}

}
