package grupo5;

import java.util.Arrays;
import java.util.Scanner;

public class CadaOvejaConSuPareja {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int dificultad = 2;
		
		int[] cartas = new int[dificultad];
		
		for (int i = 0; i < dificultad; i++) {
			cartas[i] = i;
		}
		
		int[] parejas = new int[cartas.length * 2];
		
		for (int i = 0; i < cartas.length; i++) {
			parejas[i * 2] = parejas[i * 2 + 1] = cartas[i];
		}
		
		int[][] tablero = new int[dificultad][dificultad];
		
		for (int i = 0; i < parejas.length; i++) {
            int randomIndex = (int) (Math.random() * parejas.length);
            int temp = parejas[i];
            parejas[i] = parejas[randomIndex];
            parejas[randomIndex] = temp;
        }
		
		int indice = 0;
		
		for (int fila = 0; fila < tablero.length; fila++) {
			for (int columna = 0; columna < tablero[0].length; columna++) {
				tablero[fila][columna] = parejas[indice++];
				
			}
		}
		
		for (int i = 0; i < tablero.length; i++) {
			System.out.println(Arrays.toString(tablero[i]));
		}
		buscarCarta();
		sc.close();
	}
	public static void buscarCarta () {
		System.out.println("Introduce la columna de la carta 1 a emparejar");
		int columnaCarta1 = sc.nextInt();
		System.out.println("Introduce la fila de la carta 1 a emparejar");
		int filaCarta1 = sc.nextInt();
		System.out.println("Introduce la columna de la carta 2 a emparejar");
		int columnaCarta2 = sc.nextInt();
		System.out.println("Introduce la fila de la carta 2 a emparejar");
		int filaCarta2 = sc.nextInt();
		if (columnaCarta1 < 0 || columnaCarta1 > dificultad && columnaCarta2 < 0 || columnaCarta2 > dificultad && filaCarta1 < 0 || filaCarta1 > dificultad && filaCarta2 < 0 || filaCarta2 > dificultad) {
			System.out.println("La carta introducida no existe");
		} else {

		}
	}
}
