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
        revista.toString();
        revista.puntuar("Planet Zoo", 8);
        revista.puntuar("Steep", 7);
        revista.puntuar("Catastronauts", 9);
        revista.puntuar("Wattam", 9);
        revista.toString();
        revista.valoracionMayorQue(8.2);
        //revista.borrarDeGenero(ROL);
        revista.toString();
    }

}
