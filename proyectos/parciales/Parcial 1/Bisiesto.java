package bisiesto;

import java.util.Scanner;

public class Bisiesto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int anio = leerEntero(sc, "Ingrese un año (1900-2100): ", 1900, 2100);

        if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)) {
            System.out.println("El año " + anio + " es bisiesto.");
        } else {
            System.out.println("El año " + anio + " no es bisiesto.");
        }
    }

    static int leerEntero(Scanner sc, String mensaje, int min, int max) {
        int valor;
        while(true) {
            System.out.print(mensaje);
            if(sc.hasNextInt()) {
                valor = sc.nextInt();
                sc.nextLine(); // limpiar buffer
                if(valor >= min && valor <= max) return valor;
            }
            System.out.println("Entrada inválida. Intenta de nuevo.");
            sc.nextLine();
        }
    }
}

