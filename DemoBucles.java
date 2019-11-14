import java.util.Random;
/**
 *    @author - Asier Gogorza
 */
public class DemoBucles
{
    private final char ASTERISCO = '*';
    private final char ESPACIO = ' ';
    private Random generador;
    /**
     * Constructor  
     */
    public DemoBucles()
    {
        generador = new Random();
    }

    /**
     * Calcular la mayor potencia de 2 que es menor o igual a numero
     * Asumimos numero > 0
     * 
     * Si numero = 7 devuelve 4             numero = 8 devuelve 8
     *    numero = 19 devuelve 16           numero = 32 devuelve 32
     *    numero = 74 devuelve 64           numero = 1 devuelve 1
     *    numero = 190 devuelve 128
     *    
     *  Usa bucles while
     */
    public int mayorPotencia2(int numero) {
        int pot = 1;
        while (pot * 2 <= numero) {
            pot = pot * 2;
        }
        return pot;

    }

    /**
     * Escribir numero como suma de potencias de 2 
     * tal como indica el enunciado (Se asume numero > 0)
     * 
     * Todos los valores se muestran en pantalla fomateados a 6 posiciones 
     * y ajustados a la derecha
     * 
     * Hay que usar el método anterior - 
     * Utiliza bucles while
     * 
     *  77 =    64     8     4     1
     * 215 =   128    64    16     4     2     1
     *  18 =    16     2
     *  64 =    64
     */
    public void escribirSumaPotencias(int numero) {
        System.out.println();
        String imprimir = String.format("%6d =%6d", numero, 
                mayorPotencia2(numero));
        while (numero != mayorPotencia2(numero)) {
            numero = numero - mayorPotencia2(numero);
            imprimir = imprimir + String.format("%6d", mayorPotencia2(numero));
        }
        System.out.println(imprimir);
    }

    /**
     * Generar aleatorios entre 0 y 255
     * y escribir cada aleatorio como suma de potencias de 2
     * Parar al salir el 255 o despues de generar n aleatorios
     * (ver enunciado)
     * 
     * Hay que usar el método anterior
     * 
     * Utiliza bucles while
     * 
     */
    public void generarAleatorios(int n) {
        int cont = 1;
        int al = generador.nextInt(256);
        while (al != 0 && cont <= n) {
            escribirSumaPotencias(al);
            al = generador.nextInt(256);
            cont++;
        }
        if (al == 0) {
            System.out.println("El bucle ha finalizado porque el número 0 ha salido.");
        } else{
            System.out.println("El bucle ha finalizado porque han sido generados" 
                + n + " números aleatorios.");
        }  
    }

    /**
     *  Escribe en pantalla caracter n veces en la misma línes
     *  
     *  Usa bucles for
     */
    public void escribirCaracter(int n, char caracter)
    {
        for(int f = 2; f <= n; f++){
            System.out.printf("%2c", caracter);
        }
    }

    /**
     *  Genera la figura tal como muestra el enunciado 
     *  con ayuda del método anterior
     *  
     *   Usa bucles for
     */
    public  void mostrarEscalera(int escalones, int alto, int ancho) {
        System.out.println();
        for(int esc = 1; esc <= escalones; esc++){
            for(int a = 1; a <= alto; a++){
                System.out.printf("\n%c", ASTERISCO);
                escribirCaracter(ancho, ASTERISCO);
            }
            for(int f = 2; f <= alto; f++){
                  System.out.printf("\n%c", ESPACIO);
                    escribirCaracter(ancho, ESPACIO);
            }
        }
        // NO sé hacerlo. Es todo lo que he sabido hacer.
    }

}

