package questao2;

import java.util.Scanner;


public class Questao2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Senha: ");
        String senhaString = scanner.next();
        scanner.close();
        Senha senha = new Senha(senhaString);
        System.out.println(senha.qtdMinimaCaracteresNecessarios());
    }

}
