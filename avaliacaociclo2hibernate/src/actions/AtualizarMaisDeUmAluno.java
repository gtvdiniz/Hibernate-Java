package actions;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Aluno;

public class AtualizarMaisDeUmAluno {
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
		int op; 
		
		System.out.println("Insira aqui a opção: [1] - Atualizar Aluno\n[2] - Sair do Programa");
		op = sc.nextInt();
		
		if(op == 1) { 
		
		
			while(op != 2) {
		
		
		System.out.println("Insira o id do aluno: ");
		id = sc.nextLong();
		
		System.out.println("Insira o novo nome: ");
		nome = sc.next();
		
		System.out.println("Insira o novo cpf: ");
		cpf = sc.next();
		
		System.out.println("Insira o novo email: ");
		email = sc.next();
	
		System.out.println("Insira a nova data nascimento formato: dd/mm/aaaa: ");
		datanasc = sc.next();
		
		System.out.println("Insira a nova naturalidade: ");
		naturalidade = sc.next();
		
		System.out.println("Insira o novo endereço: ");
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
		
		System.out.println("Insira aqui a opção: [1] - Atualizar Aluno\n[2] - Sair do Programa");
		op = sc.nextInt();
		
		
			}
		}
		
		
		manager.close();
	}
}
