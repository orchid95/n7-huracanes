/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: SistemaMeteorologia.java,v 1.2 2008/09/10 11:59:46 jua-gome Exp $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_huracanes
 * Autor: Juan Camilo Cort�s M. - 21-ago-2008
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
     * Construye un nuevo sistema de meteorolog�a vac�o.
     */
    public SistemaMeteorologia( )
    {
        huracanes = new ArrayList( );
    }

    // -----------------------------------------------------------------
    // M�todos
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
     * <b>post: </b>La lista de huracanes est� ordenada por nombre (orden ascendente).
     */
    public void ordenarPorNombre( )
    {
        // TODO Completar seg�n documentaci�n
    }

    /**
     * Organiza la lista de huracanes por velocidad del viento usando el algoritmo de inserci�n. <br>
     * <b>post: </b>La lista de huracanes est� ordenada por velocidad del viento (orden ascendente).
     */
    public void ordenarPorVelocidad( )
    {
        // TODO Completar seg�n documentaci�n
    }

    /**
     * Organiza la lista de huracanes por edad usando el algoritmo de selecci�n. <br>
     * <b>post: </b>La lista de huracanes est� ordenada por edad (orden ascendente).
     */
    public void ordenarPorDanios( )
    {
        // TODO Completar seg�n documentaci�n
    }

    /**
     * Busca un hurac�n seg�n su nombre y retorna la posici�n en la que se encuentra.
     * @param nombre es el nombre del hurac�n buscado. nombre!=null
     * @return Retorna la posici�n donde se encuentra un hurac�n con el nombre dado. Si no se encuentra ning�n hurac�n con ese nombre retorna -1
     */
    public int buscarHuracan( String nombre )
    {
        // TODO Completar seg�n documentaci�n
    }

    /**
     * Busca un hurac�n utilizando una b�squeda binaria. <br>
     * <b>pre: </b> La lista de huracanes se encuentra ordenada por nombre.
     * @param nombre es el nombre del hurac�n que se va a buscar. nombre!=null
     * @return La posici�n del hurac�n con el nombre dado. Si el hurac�n no existe se retorna -1.
     */
    public int buscarBinarioPorNombre( String nombre )
    {
        // TODO Completar seg�n documentaci�n
    }

    /**
     * Busca el hurac�n que tenga el mayor costo estimado en da�os.
     * @return Retorna la posici�n donde se encuentra el hurac�n con el mayor costo estimado en da�os. Si no hay huracanes en el sistema se retorna -1
     */
    public int buscarHuracanMayorCostoDanios( )
    {
        // TODO Completar seg�n documentaci�n
    }

    /**
     * Busca el hurac�n que tenga el menor costo estimado en da�os.
     * @return Retorna la posici�n donde se encuentra el hurac�n con el menor costo estimado en da�os. Si no hay huracanes en el sistema se retorna -1
     */
    public int buscarHuracanMenorCostoDanios( )
    {
        // TODO Completar seg�n documentaci�n
    }

    /**
     * Busca el hurac�n que tenga la mayor velocidad.
     * @return Retorna la posici�n donde se encuentra el hurac�n con la mayor velocidad. Si no hay huracanes en el sistema se retorna -1
     */
    public int buscarHuracanMayorVelocidad( )
    {
        // TODO Completar seg�n documentaci�n
    }

    /**
     * Agrega un nuevo hurac�n en el sistema. <b> post: </b> El hurac�n fue agregado a la exposici�n si no existe otro hurac�n con el mismo nombre.
     * @param nombreP es el nombre del hurac�n. nombreP != null.
     * @param categoriaP es la categor�a del hurac�n. 1 <= categoriaP <= 5.
     * @param velocidadP es la velocidad del viento. 0 <= velocidadP.
     * @param costoEstimadoDaniosP es el costo estimado de da�os. 0 <= costoEstimadoDaniosP.
     * @param imagenP es la ruta a la imagen del hurac�n. imagenP != null.
     * @return true si el hurac�n fue agregado y false de lo contrario.
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

    // TODO Declarar, implementar y documentar el m�todo verificarInvariante
    // Si utiliza m�todos auxiliares, decl�relos e implem�ntelos en esta secci�n

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1
     * @return respuesta1
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * M�todo para la extensi�n2
     * @return respuesta2
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }

}