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
    }

}
