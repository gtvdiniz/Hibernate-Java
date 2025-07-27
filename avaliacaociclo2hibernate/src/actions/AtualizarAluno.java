package actions;

import javax.persistence.EntityManager;
import java.util.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Aluno;

public class AtualizarAluno {

	public static void main(String[] args) {
		Aluno aluno4 = new Aluno();
		Scanner sc = new Scanner(System.in);
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tabelas");
		EntityManager manager = factory.createEntityManager();
		String nome; 
		String cpf; 
		String email; 
		String datanasc; 
		String naturalidade; 
		String endereco;
		Long id; 
		
		System.out.println("Insira o id do aluno: ");
		id = sc.nextLong();
		
		
		System.out.println(" ------------------------------");
		
		
		
		
		System.out.println("Insira o novo nome: ");
		nome = sc.next();
	
		
		System.out.println("Insira o novo cpf: ");
		cpf = sc.next();
		System.out.println("");
		
		System.out.println("Insira o novo email: ");
		email = sc.next();
		System.out.println("");
		
		System.out.println("Insira a nova data nascimento formato: dd/mm/aaaa: ");
		datanasc = sc.next();
		System.out.println("");
		
		System.out.println("Insira a nova naturalidade: ");
		naturalidade = sc.next();
		System.out.println("");
		
		System.out.println("Insira o novo endereco: ");
		endereco = sc.next();
		
		aluno4.setId(id);
		aluno4.setNome(nome);
		aluno4.setCpf(cpf);
		aluno4.setEmail(email);
		aluno4.setDatanascimento(datanasc);
		aluno4.setNaturalidade(naturalidade);
		aluno4.setEndereco(endereco);
		manager.getTransaction().begin();
		manager.merge(aluno4);
		manager.getTransaction().commit();
		
		
		System.out.println("Aluno atualizado, ID: " +aluno4.getId());
		
		manager.close();
	}

}
