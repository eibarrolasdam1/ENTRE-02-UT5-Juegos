/**
 * Un objeto de esta clase guarda informaci�n relativa a un juego
 * 
 * @author -
 */
public class Juego {
    private static final String SEPARADOR = ":";
    private String titulo;
    private Genero genero;
    private int year;
    private int[] valoraciones;

    /**
     *  Inicializa los atributos a partir de la informaci�n recibida
     *  Esta informaci�n se encuentra en linea
     */
    public Juego(String linea) {
        linea.trim();
        String[] array = linea.split(SEPARADOR);
        this.titulo = array[0];
        titulo.toUpperCase();
        String aux = array[1].toUpperCase();
        this.genero = Genero.valueOf(aux);
        int a�o = Integer.parseInt(array[2]);
        this.year = a�o;
        for (int i = 0; i < valoraciones.length; i++) {
            int puntos = Integer.parseInt(array[i + 3]);
            valoraciones[i] = puntos;
        }        
    }

    /**
     * accesor t�tulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * accesor g�nero
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * accesor year
     */
    public int getYear() {
        return year;
    }

    /**
     * accesor valoraciones
     */
    public int[] getValoraciones() {
        return valoraciones;
    }

    /**
     * total votos emitidos
     */
    public int getVotos() {
        int contador = 0;
        for (int i = 0; i < valoraciones.length; i++) {
            contador += valoraciones[i];
        }
        return contador;
    }

    /**
     *  obtener valoraci�n media
     */
    public double getValoracionMedia() {
        int contador = 0;
        for (int i = 0; i < valoraciones.length; i++) {
            contador += valoraciones[i];
        }
        double media = (double) contador/getVotos();
        return media;
    }

    /**
     *  Un usuario punt�a el juego con un valor entre 1 y 10 
     */
    public void puntuar(int puntuacion) {
        for (int i = 0; i < valoraciones.length; i++) {

        }
    }

    /**
     * Representaci�n textual del juego 
     * (Ver enunciado)
     */
    public String toString() {
        return titulo + "\nG�nero: " + this.genero +
        "| Lanzamiento: " + this.year +
        "\nValoraci�n (" + getVotos() + " votos): "
        + String.format("%.2f", this.getValoracionMedia());

    }

    public static void main(String[] args) {
        Juego juego1 = new Juego(
                "Steep: deporte: 2016  : 0:0:0:0: 0: 0:0:0:12:  10");
        System.out.println(juego1.toString());

        Juego juego2 = new Juego(
                "For the King: estrategia: 2018  : 0:0:0:7: 12: 0:33:13:2: 0");
        System.out.println(juego2.toString());

    }
}
