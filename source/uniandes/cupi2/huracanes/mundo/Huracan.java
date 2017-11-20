/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Huracan.java,v 1.4 2008/09/12 11:22:48 jua-gome Exp $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_huracanes
 * Autor: Juan Camilo Cortés Medina - 05-ago-2008
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.huracanes.mundo;

/**
 * Esta clase representa un huracán. <br>
 * <b> inv: </b> <br>
 * TODO Definir y documentar el invariante de la clase
 */
public class Huracan
{
    // --------------------------------------------------------
    // Atributos
    // --------------------------------------------------------

    /**
     * Nombre del huracán
     */
    private String nombre;

    /**
     * Categoría del huracán según el sistema Saffir - Simpson
     */
    private int categoria;

    /**
     * Velocidad del viento en km / h
     */
    private int velocidad;

    /**
     * Costo estimado en daños expresado en millones de dólares.
     */
    private double costoEstimadoDanios;

    /**
     * La ruta hasta la imagen del huracán
     */
    private String imagen;

    // --------------------------------------------------------
    // Constructores
    // --------------------------------------------------------

    /**
     * Construye un nuevo huracán con los parámetros indicados <br>
     * <b>post: </b> Se construyó un huracán con los parámetros indicados
     * @param nombreP es el nombre del huracán. nombreP != null.
     * @param categoriaP es la categoría del huracán. 1 <= categoriaP <= 5.
     * @param velocidadP es la velocidad del viento. 0 <= velocidadP.
     * @param costoEstimadoDaniosP es el costo estimado de daños. 0 <= costoEstimadoDaniosP.
     * @param imagenP es la ruta a la imagen del huracán. imagenP != null.
     */
    public Huracan( String nombreP, int categoriaP, int velocidadP, double costoEstimadoDaniosP, String imagenP )
    {
        nombre = nombreP;
        categoria = categoriaP;
        velocidad = velocidadP;
        costoEstimadoDanios = costoEstimadoDaniosP;
        imagen = imagenP;
    }

    // --------------------------------------------------------
    // Métodos
    // --------------------------------------------------------

    /**
     * Retorna el nombre del huracán
     * @return el nombre del huracán
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna la categoría del huracán
     * @return la categoría del huracán
     */
    public int darCategoria( )
    {
        return categoria;
    }

    /**
     * Retorna la velocidad del huracán
     * @return la velocidad del huracán
     */
    public int darVelocidad( )
    {
        return velocidad;
    }

    /**
     * Retorna el costoEstimadoDanios del huracán
     * @return el costoEstimadoDanios del huracán
     */
    public double darCostoEstimadoDanios( )
    {
        return costoEstimadoDanios;
    }

    /**
     * Retorna la ruta a la imagen del huracán.
     * @return La imagen del huracán
     */
    public String darImagen( )
    {
        return imagen;
    }

    /**
     * Compara dos huracanes según el nombre. <br>
     * @param h es el huracán contra el que se está comparando. h != null. <br>
     * @return Retorna 0 si los huracanes tienen el mismo nombre. <br>
     *         Retorna -1 si el huracán h tiene un valor "MAYOR" para el nombre. <br>
     *         Retorna 1 si el huracán h tiene un valor "MENOR" para el nombre. <br>
     */
    public int compararPorNombre( Huracan h )
    {
        // TODO Completar según la documentación del método
    }

    /**
     * Compara dos huracanes según los daños estimados. <br>
     * @param h es el huracán contra el que se está comparando. h != null. <br>
     * @return Retorna 0 si los huracanes tienen el mismo costo estimado en daños. <br>
     *         Retorna -1 si el huracán h tiene un valor "MAYOR" para el costo estimado en daños. <br>
     *         Retorna 1 si el huracán h tiene un valor "MENOR" para el costo estimado en daños. <br>
     */
    public int compararPorDanios( Huracan h )
    {
        // TODO Completar según la documentación del método
    }

    /**
     * Compara dos huracanes según la velocidad. <br>
     * @param h es el huracán contra el que se está comparando. h != null. <br>
     * @return Retorna 0 si los huracanes tienen la misma velocidad. <br>
     *         Retorna -1 si el huracán h tiene un valor "MAYOR" para la velocidad. <br>
     *         Retorna 1 si el huracán h tiene un valor "MENOR" para la velocidad. <br>
     */
    public int compararPorVelocidad( Huracan h )
    {
        // TODO Completar según la documentación del método
    }

    /**
     * Retorna una cadena con el nombre del huracán
     * @return La representación del huracán en String
     */
    public String toString( )
    {
        // TODO Completar según la documentación del método
    }

    // --------------------------------------------------------
    // Invariantes
    // --------------------------------------------------------

    // TODO Declarar, implementar y documentar el método verificarInvariante
}
