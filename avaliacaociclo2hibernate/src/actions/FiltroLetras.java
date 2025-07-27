package actions;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.Aluno;

public class FiltroLetras {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String Letra; 
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tabelas");
		EntityManager manager = factory.createEntityManager();
		
		System.out.println("Informe a Letra");
		Letra = sc.next().toUpperCase();
		String jpql = "SELECT * FROM aluno WHERE aluno_nome LIKE '"+Letra+"'";
		Query query = manager.createQuery(jpql);
		
		
		List<Aluno> alunos = query.getResultList();
		
		if (alunos != null && !alunos.isEmpty()) {
            for (Aluno al : alunos) {
            	System.out.println(
        				"Nome: " + al.getNome() 
        			+ "\nCPF: " + al.getCpf()
        			+ "\nEmail: " + al.getEmail() + 
        			"\nData de Nascimento: " + al.getDatanascimento() + 
        			"\nNaturalidade: " + al.getNaturalidade() + 
        			"\nEndereço: " + al.getEndereco()
        					);
            }
        } else {
            System.out.println("Nenhum cliente encontrado.");
        }
		
		
		
		manager.close();
		
	}

}
