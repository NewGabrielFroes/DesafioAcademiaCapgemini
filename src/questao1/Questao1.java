package questao1;

import java.util.Scanner;

public class Questao1 {

	public static void main(String[] args) {
		Scanner n = new Scanner(System.in);

		System.out.print("n = ");
		int qtdDegraus = n.nextInt();
		n.close();
		
		for (int i = 0; i < qtdDegraus; i++) {
			int qtdEspacos = qtdDegraus - (i + 1);
			int qtdAsteriscos = i + 1;
			String piramede = (" ".repeat(qtdEspacos) + "*".repeat(qtdAsteriscos));
			System.out.println(piramede);
		} 

	}

}
