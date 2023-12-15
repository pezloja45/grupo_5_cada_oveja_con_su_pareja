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
		
		sc.close();
	}
}
