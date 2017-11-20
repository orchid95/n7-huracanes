/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: SistemaMeteorologia.java,v 1.2 2008/09/10 11:59:46 jua-gome Exp $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_huracanes
 * Autor: Juan Camilo Cortés M. - 21-ago-2008
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.huracanes.mundo;

import java.util.ArrayList;

/**
 * Es la clase que se encarga de manejar, organizar, cargar y salvar los huracanes. <br>
 * <b> inv: </b> <br>
 * TODO Definir y documentar el invariante de la clase
 */
public class SistemaMeteorologia
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es el vector que contiene los huracanes.
     */
    private ArrayList huracanes;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo sistema de meteorología vacío.
     */
    public SistemaMeteorologia( )
    {
        huracanes = new ArrayList( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna una lista de huracanes. La lista que se retorna no es la misma que la almacenada en esta clase, pero si tiene el mismo orden.
     * @return Lista de huracanes
     */
    public ArrayList darHuracanes( )
    {
        ArrayList copiaLista = new ArrayList( huracanes );
        return copiaLista;
    }

    /**
     * Organiza la lista de huracanes por nombre usando el algoritmo de burbuja. <br>
     * <b>post: </b>La lista de huracanes está ordenada por nombre (orden ascendente).
     */
    public void ordenarPorNombre( )
    {
        // TODO Completar según documentación
    }

    /**
     * Organiza la lista de huracanes por velocidad del viento usando el algoritmo de inserción. <br>
     * <b>post: </b>La lista de huracanes está ordenada por velocidad del viento (orden ascendente).
     */
    public void ordenarPorVelocidad( )
    {
        // TODO Completar según documentación
    }

    /**
     * Organiza la lista de huracanes por edad usando el algoritmo de selección. <br>
     * <b>post: </b>La lista de huracanes está ordenada por edad (orden ascendente).
     */
    public void ordenarPorDanios( )
    {
        // TODO Completar según documentación
    }

    /**
     * Busca un huracán según su nombre y retorna la posición en la que se encuentra.
     * @param nombre es el nombre del huracán buscado. nombre!=null
     * @return Retorna la posición donde se encuentra un huracán con el nombre dado. Si no se encuentra ningún huracán con ese nombre retorna -1
     */
    public int buscarHuracan( String nombre )
    {
        // TODO Completar según documentación
    }

    /**
     * Busca un huracán utilizando una búsqueda binaria. <br>
     * <b>pre: </b> La lista de huracanes se encuentra ordenada por nombre.
     * @param nombre es el nombre del huracán que se va a buscar. nombre!=null
     * @return La posición del huracán con el nombre dado. Si el huracán no existe se retorna -1.
     */
    public int buscarBinarioPorNombre( String nombre )
    {
        // TODO Completar según documentación
    }

    /**
     * Busca el huracán que tenga el mayor costo estimado en daños.
     * @return Retorna la posición donde se encuentra el huracán con el mayor costo estimado en daños. Si no hay huracanes en el sistema se retorna -1
     */
    public int buscarHuracanMayorCostoDanios( )
    {
        // TODO Completar según documentación
    }

    /**
     * Busca el huracán que tenga el menor costo estimado en daños.
     * @return Retorna la posición donde se encuentra el huracán con el menor costo estimado en daños. Si no hay huracanes en el sistema se retorna -1
     */
    public int buscarHuracanMenorCostoDanios( )
    {
        // TODO Completar según documentación
    }

    /**
     * Busca el huracán que tenga la mayor velocidad.
     * @return Retorna la posición donde se encuentra el huracán con la mayor velocidad. Si no hay huracanes en el sistema se retorna -1
     */
    public int buscarHuracanMayorVelocidad( )
    {
        // TODO Completar según documentación
    }

    /**
     * Agrega un nuevo huracán en el sistema. <b> post: </b> El huracán fue agregado a la exposición si no existe otro huracán con el mismo nombre.
     * @param nombreP es el nombre del huracán. nombreP != null.
     * @param categoriaP es la categoría del huracán. 1 <= categoriaP <= 5.
     * @param velocidadP es la velocidad del viento. 0 <= velocidadP.
     * @param costoEstimadoDaniosP es el costo estimado de daños. 0 <= costoEstimadoDaniosP.
     * @param imagenP es la ruta a la imagen del huracán. imagenP != null.
     * @return true si el huracán fue agregado y false de lo contrario.
     */
    public boolean agregarHuracan( String nombreP, int categoriaP, int velocidadP, double costoEstimadoDaniosP, String imagenP )
    {
        int huracanBuscado = buscarHuracan( nombreP );
        boolean agregado = false;
        if( huracanBuscado == -1 )
        {
            Huracan nuevoHuracan = new Huracan( nombreP, categoriaP, velocidadP, costoEstimadoDaniosP, imagenP );
            huracanes.add( nuevoHuracan );
            agregado = true;
        }

        return agregado;
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    // TODO Declarar, implementar y documentar el método verificarInvariante
    // Si utiliza métodos auxiliares, declárelos e impleméntelos en esta sección

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1
     * @return respuesta1
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método para la extensión2
     * @return respuesta2
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }

}