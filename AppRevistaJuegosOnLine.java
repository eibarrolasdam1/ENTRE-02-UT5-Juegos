import java.util.Arrays;
/**
 * Punto de entrada a la aplicación
 * 
 * @author - 
 */
public class AppRevistaJuegosOnLine 
{
    public static void main(String[] args)
    {
        if (args.length != 2) {
            System.out.println("Error en argumentos" + "\n" + 
                "Sintaxis: java AppRevistaJuegosOnLine <nombre> <n>"); 
        }
        int aux = Integer.parseInt(args[1]);
        RevistaOnLineJuegos revista = new RevistaOnLineJuegos(args[0], aux);
        revista.leerDeFichero();
        revista.puntuar("PlanetZoo", 8);
        revista.puntuar("Steep", 7);
        revista.puntuar("Catastronauts", 9);
        revista.puntuar("Wattam", 9);
        System.out.println("Después de puntuar la revista queda\n");
        System.out.println();
        System.out.println(revista.toString());
        System.out.println();
        Arrays.toString(revista.valoracionMayorQue(8.2));
        System.out.println();
        revista.borrarDeGenero(Genero.ROL);
        System.out.println(revista.toString());
    }

}
