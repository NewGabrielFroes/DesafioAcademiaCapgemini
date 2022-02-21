package questao3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Arrays;

public class Questao3 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Palavra: ");
		String palavra = scanner.next();
		int paresDeAnagramas = 0;
		scanner.close();
		
		Map<String, Integer> hashMap = new HashMap<String, Integer>();
		for (int i = 0; i < palavra.length(); i++) {
			for (int j = i; j < palavra.length(); j++) {
				char[] letras = palavra.substring(i, j+1).toCharArray();
				Arrays.sort(letras);
				String palavraEmOrdemAlfabetica = new String(letras);
				
				if (hashMap.containsKey(palavraEmOrdemAlfabetica)) {
					paresDeAnagramas += hashMap.get(palavraEmOrdemAlfabetica);
					hashMap.put(palavraEmOrdemAlfabetica, hashMap.get(palavraEmOrdemAlfabetica) + 1);
				}
				else {
					hashMap.put(palavraEmOrdemAlfabetica, 1);
				}
			}
		}

		
		System.out.println(paresDeAnagramas);
	}
}
