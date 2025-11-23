import java.util.Scanner;
public class FechasCortas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] meses = {"enero","febrero","marzo","abril","mayo","junio",
                          "julio","agosto","septiembre","octubre","noviembre","diciembre"};
        int[][] fechas = new int[3][3];

        for(int i=0;i<3;i++){
            System.out.println("Ingrese fecha #" + (i+1));

            int dia;
            while(true){
                System.out.print("Día (1-31): ");
                if(sc.hasNextInt()){
                    dia = sc.nextInt();
                    if(dia>=1 && dia<=31) break;
                }
                System.out.println("Día inválido.");
                sc.nextLine();
            }
            sc.nextLine(); 
            
            int mesNum=0;
            while(mesNum==0){
                System.out.print("Mes (nombre completo): ");
                String mesTexto = sc.nextLine().toLowerCase();
                for(int j=0;j<12;j++)
                    if(mesTexto.equals(meses[j])) mesNum=j+1;
                if(mesNum==0) System.out.println("Mes inválido.");
            }
            int anio;
            while(true){
                System.out.print("Año (1900-2100): ");
                if(sc.hasNextInt()){ 
                    anio = sc.nextInt(); 
                    sc.nextLine(); 
                    if(anio >= 1900 && anio <= 2100) break;
                }
                System.out.println("Año inválido.");
                sc.nextLine();
            }
            fechas[i] = new int[]{dia, mesNum, anio};
        }
        System.out.println("\nFechas en números:");
        for(int[] f : fechas)
            System.out.println(f[0]+" "+f[1]+" "+f[2]);
        int min=0,max=0;
        for(int i=1;i<3;i++){
            if(esMenor(fechas[i],fechas[min])) min=i;
            if(esMayor(fechas[i],fechas[max])) max=i;
        }
        System.out.println("Fecha más baja: "+fechas[min][0]+" "+fechas[min][1]+" "+fechas[min][2]);
        System.out.println("Fecha más alta: "+fechas[max][0]+" "+fechas[max][1]+" "+fechas[max][2]);
    }
    static boolean esMenor(int[] a,int[] b){
        return a[2]!=b[2]? a[2]<b[2] : a[1]!=b[1]? a[1]<b[1] : a[0]<b[0];
    }
    static boolean esMayor(int[] a,int[] b){
        return a[2]!=b[2]? a[2]>b[2] : a[1]!=b[1]? a[1]>b[1] : a[0]>b[0];
    }
}


