/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: HuracanTest.java,v 1.1 2008/08/23 10:25:42 ju-cort1 Exp $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_huracanes
 * Autor: Juan Camilo Cort�s Medina - 05-ago-2008
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.huracanes.test;

import junit.framework.TestCase;
import uniandes.cupi2.huracanes.mundo.Huracan;

/**
 * Esta es la clase usada para verificar los m�todos de la clase Huracan
 */
public class HuracanTest extends TestCase
{
    // --------------------------------------------------------
    // Atributos
    // --------------------------------------------------------

    /**
     * Hurac�n usado para los casos de prueba.
     */
    private Huracan huracan1;

    /**
     * Hurac�n usado para los casos de prueba.
     */
    private Huracan huracan2;

    // --------------------------------------------------------
    // M�todos
    // --------------------------------------------------------

    /**
     * Construye los huracanes 1 y 2
     */
    private void setupEscenario1( )
    {
        huracan1 = new Huracan( "nombre1", 1, 100, 1.1, "imagen1" );
        huracan2 = new Huracan( "nombre2", 2, 200, 2.2, "imagen2" );
    }

    /**
     * Verifica el constructor. <br>
     * <b> M�todos a probar: </b> <br>
     * Hurac�n (constructor). <br>
     * <b> Objetivo: </b> Probar que el constructor crea un hurac�n de forma correcta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al crear un hurac�n los atributos del objeto deben quedar con el valor correcto.
     */
    public void testHuracan( )
    {
        setupEscenario1( );

        assertEquals( "El nombre del hurac�n est� equivocado", "nombre1", huracan1.darNombre( ) );
        assertEquals( "La categor�a del hurac�n est� equivocada", 1, huracan1.darCategoria( ) );
        assertEquals( "La velocidad del hurac�n est� equivocada", 100, huracan1.darVelocidad( ) );
        assertEquals( "El costo estimado de da�os est� equivocado", 1.1, huracan1.darCostoEstimadoDanios( ) );
        assertEquals( "La imagen del hurac�n est� equivocada", "imagen1", huracan1.darImagen( ) );
    }

    // Prueba 2
    // TODO Declarar, implementar y documentar el caso de prueba para el m�todo compararPorNombre

    // Prueba 3
    // TODO Declarar, implementar y documentar el caso de prueba para el m�todo compararPorDanios

    // Prueba 4
    // TODO Declarar, implementar y documentar el caso de prueba para el m�todo compararPorVelocidad
}
