import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * La clase representa a una tienda on-line en la
 * que se publican los juegos que se van lanzando al mercado
 * 
 * Un objeto de esta clase guarda en un array los juegos 
 *
 * @author -
 */
public class RevistaOnLineJuegos 
{
    private String nombre;
    private Juego[] juegos;
    private int total;

    /**
     * Constructor  
     * Crea el array de juegos al tamaño máximo indicado por la constante
     * e inicializa el resto de atributos
     */
    public RevistaOnLineJuegos(String nombre, int n) {
        juegos = new Juego[n];
        this.nombre = nombre;
        total = 0;
    }

    /**
     * Devuelve true si el array está completo, false en otro caso
     */
    public boolean estaCompleta() {
        return total == juegos.length;
    }

    /**
     *    Añade un nuevo juego solo si el array no está completo y no existe otro juego
     *    ya con el mismo nombre.  Si no se puede añadir se muestra los mensajes adecuados 
     *    (diferentes en cada caso)
     *    
     *    El juego se añade de tal forma que queda insertado en orden alfabético de título
     *    (de menor a mayor)
     *     !!OJO!! No hay que ordenar ni utilizar ningún algoritmo de ordenación
     *    Hay que insertar en orden 
     *    
     */
    public void add(Juego juego) {
        if (estaCompleta()) {
            System.out.println("El array esta completo, es decir, el juego no se puede añadir");
        }

        if (existeJuego(juego.getTitulo()) >= 0) {
            System.out.println("El juego ya esta añadido, es decir no se puede duplicar");
        }

        if (!estaCompleta() && existeJuego(juego.getTitulo()) < 0) {

        }
    }

    /**
     * Efectúa una búsqueda en el array del juego cuyo titulo se
     * recibe como parámetro. Es indiferente mayúsculas y minúsculas
     * Si existe el juego devuelve su posición, si no existe devuelve -1
     */
    public int existeJuego(String titulo) {
        int existe = -1;
        for (int i = 0; i < total; i++) {
            existe = juegos[i].getTitulo().compareToIgnoreCase(titulo);
        }
        return existe;
    }

    /**
     * Representación textual de la revista
     * Utiliza StringBuilder como clase de apoyo.
     * Se incluye el nombre de la  revista on-line.
     * (Ver resultados de ejecución)
     */
    public String toString() {
        StringBuilder sb = new StringBuilder ("");
        for (int i = 0; i < total; i++) {
            sb.append(juegos[i].getTitulo()).append("\n").append("Genero: ").append(juegos[i].getGenero()).append(" | ").append("Lanzamiento: ").append(juegos[i].getYear()).append("\n").append("Valoración").append("(").append(juegos[i].getVotos()).append("votos").append("): ").append(juegos[i].getValoracionMedia());
        }
        String str = String.valueOf(sb);
        return str;
    }

    /**
     *  Se puntúa el juego de título indicado con 
     *  la puntuación recibida como parámetro. 
     *  La puntuación es un valor entre 1 y 10 (asumimos esto como correcto)
     *  Si el juego no existe se muestra un mensaje en pantalla
     */
    public void puntuar(String titulo, int puntuacion) {
        for (int i = 0; i < total; i++) {
            if (juegos[i].getTitulo().equalsIgnoreCase(titulo)) {
                juegos[i].puntuar(puntuacion);
            } else {
                System.out.println("Eljuego que quieres puntuar no existe, por favor intentalo de nuevo");
            }
        }
    }

    /**
     * Devuelve un array con los nombres de los juegos 
     * con una valoración media mayor a la indicada  
     * 
     * El array se devuelve todo en mayúsculas y ordenado ascendentemente
     */
    public String[] valoracionMayorQue(double valoracion) {
        String aux = String.valueOf(valoracion);
        int contador = 0;
        for (int i = 0; i < total; i++) {
            for (int j = 0;j < juegos[i].getValoraciones().length; j++) {
                if (j > valoracion) {
                    contador++;
                }
            }
        }
        String[] array = new String[contador];
        int pos = 0;
        for (int k = 0; k < array.length; k++) {
            for (int j = 0;j < juegos[k].getValoraciones().length; j++) {
                if (j > valoracion) {
                    array[pos] = aux;
                }
            }
            
        }
        return array;
    }

    /**
     * Borrar los juegos del género indicado devolviendo
     * el nº de juegos borradas
     */
    public int borrarDeGenero(Genero genero) {
        
        return 0;
    }

    /**
     * Lee de un fichero de texto los datos de los juegos
     * con ayuda de un objeto de la  clase Scanner
     * y los guarda en el array. 
     */
    public void leerDeFichero() {
        Scanner sc = null;
        try {
            sc = new Scanner(new File("juegos.txt"));
            while (sc.hasNextLine()) {
                Juego juego = new Juego(sc.nextLine());
                this.add(juego);

            }

        } catch (IOException e) {
            System.out.println("Error al leer del fichero");
        } finally {
            sc.close();
        }

    }

}
