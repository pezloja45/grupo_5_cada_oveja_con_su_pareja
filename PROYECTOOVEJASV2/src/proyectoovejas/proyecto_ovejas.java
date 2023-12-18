package proyectoovejas;

import java.util.Random;
import java.util.Scanner;

public class proyecto_ovejas {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);

		System.out.println("Introduzca la dificultad (2, 4, 6)");
		int dificultad = sc.nextInt();
		
		//Este metodo valida si la dificultad introducida por el usuario es valida y si no pide otra
		while (selectorDificultad(dificultad) == false) {
			System.out.println("Dificultad no válida seleccione un valor válido (2, 4, 6)");
			dificultad = sc.nextInt();
		}
	
		char[][] matriz = new char[dificultad][dificultad];
		
		//Este bucle asigna valores unicos por parejas a la matriz
		for (int i = 0; i < dificultad; i++) {
			for (int j = 0; j < dificultad; j += 2) {
				char caracter = generarCaracterUnico(matriz);
				matriz[i][j] = caracter;
				matriz[i][j + 1] = caracter;
			}
		}
		
	}

	public static char generarCaracterUnico(char[][] matriz) {
		//Este metodo genera un caracter aleatorio de la a hasta 
		Random random = new Random();
		char caracter;
		caracter = (char) (random.nextInt(25) + 'a');
		return caracter;
	}	
	
	public static boolean selectorDificultad(int dificultad) {
		//Este metodo retorna true si el numero que le pides al usuario es 2, 4 o 6
		return dificultad == 2 || dificultad == 4 || dificultad == 6;
	}
}