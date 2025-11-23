package calcular.edad;
import java.util.Scanner;
public class CalcularEdad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int diaN, mesN, anioN, diaA, mesA, anioA;

        diaN = leerEntero(sc, "Daa nacimiento (1-31): ", 1, 31);
        mesN = leerEntero(sc, "Mes nacimiento (1-12): ", 1, 12);
        anioN = leerEntero(sc, "Año nacimiento (1900-2100): ", 1900, 2100);

        diaA = leerEntero(sc, "Daa actual (1-31): ", 1, 31);
        mesA = leerEntero(sc, "Mes actual (1-12): ", 1, 12);
        anioA = leerEntero(sc, "Año actual (1900-2100): ", 1900, 2100);

        int años = anioA - anioN;
        int meses = mesA - mesN;
        int dias = diaA - diaN;

        if(dias<0){ dias+=30; meses--; }
        if(meses<0){ meses+=12; años--; }

        if(años<1){
            System.out.println("Edad: "+meses+" meses y "+dias+" daas");
        } else {
            System.out.println("Edad: "+años+" años");
        }
    }

    static int leerEntero(Scanner sc, String mensaje, int min, int max){
        int valor;
        while(true){
            System.out.print(mensaje);
            if(sc.hasNextInt()){
                valor = sc.nextInt();
                sc.nextLine();
                if(valor>=min && valor<=max) return valor;
            }
            System.out.println("Entrada invalida. Intenta de nuevo.");
            sc.nextLine();
        }
    }
}
