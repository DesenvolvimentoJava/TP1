package TPs;

import java.util.Scanner;

public class TP1 {
	private static String[] nomes;
	private static float[] av1;
	private static float[] av2;
	private static final int TAMANHO = 100;
	
	private static void imprimir() {	
		for (int i = 0; i < TAMANHO; i++) {	
			if(nomes[i] != null) {
			imprimir(i);
			}
		}
	}
	
	private static void imprimir(int index) {
			float media = mediaFinal(index);
		
			System.out.println("Nome do Aluno: " + nomes[index] +
								"\nNota da AV1: " + av1[index] +
								"\nNota da AV1: " + av2[index] +
								"\nMédia Final: " + media +
								"\nSituação: " + situacao(media));
			System.out.println("\n--------------------\n");
	}
	
	private static float mediaFinal(int index) {
		return (av1[index] + av2[index]) / 2;
	}
	
	private static String situacao(float media) {
		if (media >= 7.0) {
			return "Aprovado";
		}else if (media >= 4.0 && media < 7.0 ) {
			return "Prova final";
		} else {
			return "Reprovado";
		}
	}
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		nomes = new String[TAMANHO];
		av1 = new float[TAMANHO];
		av2 = new float[TAMANHO];
		
		String opcao;
		int pos = 0;
		
		do {	
		System.out.println("\n[1] Registrar as notas de um novo aluno.");
		System.out.println("[2] Consultar boletim de um aluno.");
		System.out.println("[3] Consultar notas da turma.");
		System.out.println("[4] Sair");

		
		System.out.print("\nInforme a Opção: ");
		opcao = in.next();
		System.out.println("\n--------------------\n");
	
		switch(opcao) {
		case "1":
			if (pos < TAMANHO) {
				System.out.print("Informe o Nome do Aluno(a): ");
				nomes[pos] = in.next();
			
				System.out.print("Informe a AV1: ");
				av1[pos] = in.nextFloat();
				
				System.out.print("Informe a AV2: ");
				av2[pos] = in.nextFloat();
			} else {
				System.out.println("Impossivel de Inserir Novo Registro!!!");
			}
			System.out.println("\nAluno(a) Registrado com Código: " + pos);
			System.out.println("\n--------------------\n");
			pos++;
			break;
			
		case "2":
			System.out.print("Informe Código de Registro do Aluno(a): ");
			int registro = in.nextInt();
			
			if(registro >= 0 && registro < pos) {
				imprimir(registro);	
			} else {
				System.out.println("O índice [" + registro + "] é invalido !!!");
			}
			break;

		case "3":
			imprimir();
			break;
			
		case "4":
			System.out.println("Saída");
			break;
			
		default:
			System.out.println("A opção [" + opcao + "] é inválida!!!");
			break;
		}
		
		} while(!"4".equals(opcao));
		
		System.out.println("Finalizado!!!");
		
		in.close();
	}


}
