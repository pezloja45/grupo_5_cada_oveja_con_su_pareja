package proyectoovejas;

import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

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
		char[][] tablaResuelta = new char [dificultad][dificultad];
		char[][] matriz = new char[dificultad][dificultad];
		//Este bucle asigna valores unicos por parejas a la matriz
		for (int i = 0; i < dificultad; i++) {
			for (int j = 0; j < dificultad; j += 2) {
				char caracter = generarCaracterUnico(matriz);
				matriz[i][j] = caracter;
				matriz[i][j + 1] = caracter;
			}
		}

		System.out.println("Matriz mezclada:");
		mezclarMatriz(matriz);
		imprimirMatriz(matriz);
		//limpiaPantalla();
		
		System.out.println("Introduce la fila de la carta 1 a emparejar");
		int filaCarta1 = sc.nextInt();
		System.out.println("Introduce la columna de la carta 1 a emparejar");
		int columnaCarta1 = sc.nextInt();
		System.out.println("Introduce la fila de la carta 2 a emparejar") ;
		int filaCarta2 = sc.nextInt();
		System.out.println("Introduce la columna de la carta 2 a emparejar");
		int columnaCarta2 = sc.nextInt();
		for (int i = 0; i < tablaResuelta.length; i++) {
			for (int k = 0; k < tablaResuelta.length; k++) {
				tablaResuelta[i][k] = 'z';
			}
		}
		if (comprobarCartas(columnaCarta1, columnaCarta2, filaCarta1, filaCarta2, matriz) == true) {
			tablaResuelta[filaCarta1][columnaCarta1] = matriz[filaCarta1][columnaCarta1];
			tablaResuelta[filaCarta2][columnaCarta2] = matriz[filaCarta2][columnaCarta2];
		}
		
		imprimirMatriz(matriz);
		imprimirMatriz(tablaResuelta);
		
	}

	public static void mezclarMatriz(char[][] matriz) {
		Random rand = new Random();
		for (int i = matriz.length - 1; i > 0; i--) {
			for (int j = matriz[i].length - 1; j > 0; j--) {
				int filaAleatoria = rand.nextInt(i + 1);
				int columnaAleatoria = rand.nextInt(j + 1);

				// Intercambiar elementos
				char temp = matriz[i][j];
				matriz[i][j] = matriz[filaAleatoria][columnaAleatoria];
				matriz[filaAleatoria][columnaAleatoria] = temp;
			}
		}
	}
	//Este metodo genera un caracter aleatorio de la a hasta 
	public static char generarCaracterUnico(char[][] matriz) {
		Random random = new Random();
		char caracter;
		do {
			caracter = (char) (random.nextInt(25) + 'a');
		} while (existeCaracterEnMatriz(matriz, caracter));
		return caracter;
	}
	//Este metodo comprueba que el caracter generado en el metodo generarCaracter no existe en la matriz
	public static boolean existeCaracterEnMatriz(char[][] matriz, char caracter) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] == caracter) {
					return true;
				}
			}
		}
		return false;
	}

	// Este metodo limpia la pantalla a base de lineas vacías con un bucle for
	// el metodo ha sido buscado por internet debido al desconocimiento de esta funcion
	public static void limpiaPantalla() {
		Timer timer = new Timer();

		TimerTask tarea = new TimerTask() {
			@Override
			public void run() {
				for (int i = 0; i < 50; i++) {
					System.out.println(" ");
				}

			}
		};

		timer.schedule(tarea, 3000);
	}
	// Este metodo imprime la matriz de una forma bonita
	public static void imprimirMatriz(char[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j]);
			}
			System.out.println();
		}
	}
	
	public static boolean comprobarCartas(int columnaCarta1, int columnaCarta2, int filaCarta1, int filaCarta2, char[][] matriz) {
		return matriz[filaCarta1][columnaCarta1] == matriz[filaCarta2][columnaCarta2];
	}
	
	//Este metodo retorna true si el numero que le pides al usuario es 2, 4 o 6
	public static boolean selectorDificultad(int dificultad) {
		return dificultad == 2 || dificultad == 4 || dificultad == 6;
	}

	
}