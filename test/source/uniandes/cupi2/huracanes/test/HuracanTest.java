/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: HuracanTest.java,v 1.1 2008/08/23 10:25:42 ju-cort1 Exp $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_huracanes
 * Autor: Juan Camilo Cortés Medina - 05-ago-2008
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.huracanes.test;

import junit.framework.TestCase;
import uniandes.cupi2.huracanes.mundo.Huracan;

/**
 * Esta es la clase usada para verificar los métodos de la clase Huracan
 */
public class HuracanTest extends TestCase
{
    // --------------------------------------------------------
    // Atributos
    // --------------------------------------------------------

    /**
     * Huracán usado para los casos de prueba.
     */
    private Huracan huracan1;

    /**
     * Huracán usado para los casos de prueba.
     */
    private Huracan huracan2;

    // --------------------------------------------------------
    // Métodos
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
     * <b> Métodos a probar: </b> <br>
     * Huracán (constructor). <br>
     * <b> Objetivo: </b> Probar que el constructor crea un huracán de forma correcta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al crear un huracán los atributos del objeto deben quedar con el valor correcto.
     */
    public void testHuracan( )
    {
        setupEscenario1( );

        assertEquals( "El nombre del huracán está equivocado", "nombre1", huracan1.darNombre( ) );
        assertEquals( "La categoría del huracán está equivocada", 1, huracan1.darCategoria( ) );
        assertEquals( "La velocidad del huracán está equivocada", 100, huracan1.darVelocidad( ) );
        assertEquals( "El costo estimado de daños está equivocado", 1.1, huracan1.darCostoEstimadoDanios( ) );
        assertEquals( "La imagen del huracán está equivocada", "imagen1", huracan1.darImagen( ) );
    }

    // Prueba 2
    // TODO Declarar, implementar y documentar el caso de prueba para el método compararPorNombre

    // Prueba 3
    // TODO Declarar, implementar y documentar el caso de prueba para el método compararPorDanios

    // Prueba 4
    // TODO Declarar, implementar y documentar el caso de prueba para el método compararPorVelocidad
}
