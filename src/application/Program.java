package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		method1();
		System.out.println("Fim do programa");

	}

	public static void method1() {
		System.out.println("-----METHOD 1 START-----");
		method2();
		System.out.println("-----METHOD 1 end-----");

	}

	public static void method2() {

		Scanner sc = new Scanner(System.in);
		// DIGITA VÁRIOS NOMES E DPS DIGITA UMA POSIÇÃO, MOSTRA O NOME DA POSIÇÃO
		System.out.println("-----METHOD 2 START-----");
		try {

			String[] vect = sc.nextLine().split(" ");
			int position = sc.nextInt();
			System.out.println(vect[position]);
			sc.close();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid position!"); // posição fora
			e.printStackTrace(); //MOSTRA A PILHA DE ERRO, QUEM CHAMOU QUEM
		} catch (InputMismatchException e) {
			System.out.println("Input error (Somente num)"); // digitar letra
		}
		System.out.println("-----METHOD 2 END-----");

	}

}
