package salariosemanal;

import java.util.Scanner;
import java.text.DecimalFormat;

public class SalarioSemanal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.00");

        int n;
        do { System.out.print("¿Cuántos trabajadores?: "); n = sc.nextInt(); sc.nextLine(); } 
        while(n < 1 || n > 1000);

        for(int i = 1; i <= n; i++) {
            System.out.println("\nTrabajador #" + i);

            int horas;
            do { System.out.print("Horas trabajadas (0-168): "); horas = sc.nextInt(); sc.nextLine(); } 
            while(horas < 0 || horas > 168);

            double tasa;
            do { System.out.print("Tasa por hora (0.01-10000): "); tasa = sc.nextDouble(); sc.nextLine(); } 
            while(tasa < 0.01 || tasa > 10000);

            double bruto = horas <= 40 ? horas * tasa : 40 * tasa + (horas - 40) * tasa * 1.5;
            double impuesto = bruto > 750 ? bruto * 0.10 : 0;
            double neto = bruto - impuesto;

            System.out.println("Salario bruto: B/. " + df.format(bruto));
            System.out.println("Impuesto: B/. " + df.format(impuesto));
            System.out.println("Salario neto: B/. " + df.format(neto));
        }
    }
}
