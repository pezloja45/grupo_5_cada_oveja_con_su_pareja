package proyectoovejas;

import java.util.Scanner;

public class proyecto_ovejas {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);

		System.out.println("Introduzca la dificultad (2,4,6)");
		int dificultad = sc.nextInt();
		//Este metodo valida si la dificultad introducida por el usuario es valida y si no pide otra
		while (selectorDificultad(dificultad) == false) {
			System.out.println("Dificultad no válida seleccione un valor válido (2, 4, 6)");
			dificultad = sc.nextInt();
		}
	}

		
	//Este metodo retorna true si el numero que le pides al usuario es 2, 4 o 6
	public static boolean selectorDificultad(int dificultad) {
		return dificultad == 2 || dificultad == 4 || dificultad == 6;
	}
}