import java.util.Random;

public class LaberintoUniversitario {

    public static void main(String[] args) {
        int size = 5;
        int[][] laberinto = new int[size][size];

        llenarMatriz(laberinto);

        System.out.println("Laberinto:");
        mostrarMatriz(laberinto);

        int cantidadParesMayores = contarParesMayoresA4(laberinto);
        System.out.println("Cantidad de números pares mayores a 4: " + cantidadParesMayores);
        double promedioImpares = calcularPromedioImpares(laberinto);
        System.out.println("Promedio de números impares: " + promedioImpares);
        sumarFilas(laberinto);
        indicarMaximo(laberinto);
    }

    public static void llenarMatriz(int[][] matriz) {
        Random rand = new Random();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = rand.nextInt(9) + 1; 
            }
        }
    }

    public static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int contarParesMayoresA4(int[][] matriz) {
        int contador = 0;
        for (int[] fila : matriz) {
            for (int valor : fila) {
                if (valor % 2 == 0 && valor > 4) {
                    contador++;
                }
            }
        }
        return contador;
    }

    public static double calcularPromedioImpares(int[][] matriz) {
        int suma = 0;
        int cantidadImpares = 0;
        for (int[] fila : matriz) {
            for (int valor : fila) {
                if (valor % 2 != 0) {
                    suma += valor;
                    cantidadImpares++;
                }
            }
        }
        if (cantidadImpares == 0) {
            return 0; 
        }
        return (double) suma / cantidadImpares;
    }

    public static void sumarFilas(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            int sumaFila = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                sumaFila += matriz[i][j];
            }
            System.out.println("Suma de fila " + i + ": " + sumaFila);
        }
        System.out.println();
    }
    public static void indicarMaximo(int[][] matriz) {
        int maxValor = Integer.MIN_VALUE;
        int filaMax = -1;
        int columnaMax = -1;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > maxValor) {
                    maxValor = matriz[i][j];
                    filaMax = i;
                    columnaMax = j;
                }
            }
        }
        System.out.println("El valor más alto es: " + maxValor + " en la posición [" + filaMax + "][" + columnaMax + "]");
    }
}