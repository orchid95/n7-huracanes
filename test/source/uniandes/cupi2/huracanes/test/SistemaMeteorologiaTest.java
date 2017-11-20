/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: SistemaMeteorologiaTest.java,v 1.3 2008/09/10 15:54:50 ju-cort1 Exp $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_huracanes
 * Autor: Juan Camilo Cort�s M. - 21-ago-2008
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.huracanes.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

import junit.framework.TestCase;
import uniandes.cupi2.huracanes.mundo.Huracan;
import uniandes.cupi2.huracanes.mundo.SistemaMeteorologia;

/**
 * Esta es la clase usada para verificar que los m�todos de la clase SistemaMeteorologia est�n correctamente implementados
 */
public class SistemaMeteorologiaTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la clase donde se har�n las pruebas
     */
    private SistemaMeteorologia sistemaMeteorologia;

    /**
     * La cantidad de huracanes que hay en el sistema.
     */
    private int cantidadHuracanes;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Crea un sistema a partir del archivo huracanes1.txt
     */
    private void setupEscenario1( )
    {
        sistemaMeteorologia = new SistemaMeteorologia( );
        cargarHuracanes( "./test/data/huracanes1.txt" );
    }

    /**
     * Crea un sistema a partir del archivo huracanes2.txt
     */
    private void setupEscenario2( )
    {
        sistemaMeteorologia = new SistemaMeteorologia( );
        cargarHuracanes( "./test/data/huracanes2.txt" );
    }

    /**
     * Crea un sistema vac�o
     */
    private void setupEscenario3( )
    {
        sistemaMeteorologia = new SistemaMeteorologia( );
        cantidadHuracanes = 0;
    }

    /**
     * Verifica el m�todo agregarHuracan agregando correctamente un hurac�n. <br>
     * <b> M�todos a probar: </b> <br>
     * agregarHuracan, buscarHuracan, darHuracanes. <br>
     * <b> Objetivo: </b> Probar que el m�todo agregarHuracan() sea capaz de registrar un hurac�n en el sistema. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar (por nombre) un hurac�n previamente agregado se debe obtener una posici�n diferente de -1 (se debe encontrar) y los datos del hurac�n en esa posici�n deben
     * corresponder a los del hurac�n con el nombre correspondiente. <br>
     */
    public void testAgregarHuracan1( )
    {
        // Configura los datos de prueba
        setupEscenario3( );

        String nombre;
        int categoria;
        int velocidad;
        double costoDanios;
        String imagen;
        boolean agregado;
        // Agrega un hurac�n y luego verifica que se haya agregado de forma correcta
        for( int cont = 1; cont <= cantidadHuracanes; cont++ )
        {
            nombre = "nombre" + cont;
            categoria = cont % 5;
            velocidad = cont;
            costoDanios = cont;
            imagen = "imagen" + cont;

            agregado = sistemaMeteorologia.agregarHuracan( nombre, categoria, velocidad, costoDanios, imagen );
            int pos = sistemaMeteorologia.buscarHuracan( nombre );
            Huracan huracan = ( Huracan )sistemaMeteorologia.darHuracanes( ).get( pos );

            assertTrue( "El hurac�n no se agreg� de forma correcta", agregado );
            assertEquals( "El hurac�n no se agreg� de forma correcta", cont - 1, pos );
            assertEquals( "El hurac�n no se agreg� de forma correcta", nombre, huracan.darNombre( ) );
            assertEquals( "El hurac�n no se agreg� de forma correcta", categoria, huracan.darCategoria( ) );
            assertEquals( "El hurac�n no se agreg� de forma correcta", velocidad, huracan.darVelocidad( ) );
            assertEquals( "El hurac�n no se agreg� de forma correcta", costoDanios, huracan.darCostoEstimadoDanios( ) );
            assertEquals( "El hurac�n no se agreg� de forma correcta", imagen, huracan.darImagen( ) );
        }
    }

    /**
     * Verifica el m�todo agregarHuracan agregando un hurac�n con nombre repetido. <br>
     * <b> M�todos a probar: </b> <br>
     * agregarHuracan, buscarHuracan, darHuracanes. <br>
     * <b> Objetivo: </b> Probar que el m�todo agregarHuracan() no agregue un hurac�n en el sistema cuando su nombre ya pertenece a otro hurac�n registrado. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al agregar un hurac�n con nombre repetido el n�mero de huracanes se debe mantener igual y la informaci�n de los huracanes existentes no debe haberse alterado.
     */
    public void testAgregarHuracan2( )
    {
        setupEscenario1( );

        ArrayList huracanes = sistemaMeteorologia.darHuracanes( );
        Huracan h = ( Huracan )huracanes.get( 0 );
        String nombreHuracan = h.darNombre( );

        int i = Integer.parseInt( nombreHuracan );
        boolean agregado = sistemaMeteorologia.agregarHuracan( nombreHuracan, i, i, i, nombreHuracan );
        assertFalse( "El hurac�n no deber�a haberse agregado", agregado );

        String nombre;
        int categoria;
        int velocidad;
        double costoDanios;
        String imagen;
        // Busca un hurac�n y verifica que sus datos est�n correctos
        for( int cont = 0; cont < cantidadHuracanes; cont++ )
        {
            nombre = "" + ( cont + 1 );
            categoria = ( cont + 1 );
            velocidad = ( cont + 1 );
            costoDanios = ( cont + 1 );
            imagen = "" + ( cont + 1 );

            Huracan huracan = ( Huracan )sistemaMeteorologia.darHuracanes( ).get( cont );

            assertEquals( "El hurac�n no se agreg� de forma correcta", nombre, huracan.darNombre( ) );
            assertEquals( "El hurac�n no se agreg� de forma correcta", categoria, huracan.darCategoria( ) );
            assertEquals( "El hurac�n no se agreg� de forma correcta", velocidad, huracan.darVelocidad( ) );
            assertEquals( "El hurac�n no se agreg� de forma correcta", costoDanios, huracan.darCostoEstimadoDanios( ) );
            assertEquals( "El hurac�n no se agreg� de forma correcta", imagen, huracan.darImagen( ) );
        }
    }

    /**
     * Verifica el m�todo buscarHuracan buscando un hurac�n que se sabe que deber�a encontrarse. <br>
     * <b> M�todos a probar: </b> <br>
     * buscarHuracan. <br>
     * <b> Objetivo: </b> Probar que el m�todo buscarHuracan() sea capaz de encontrar huracanes registrados en el sistema. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar un hurac�n previamente agregado se debe obtener una posici�n diferente de -1. <br>
     * 2. Al buscar un hurac�n que no exista la posici�n retornada debe ser -1.
     */
    public void testBuscarHuracan( )
    {
        // TODO Completar seg�n documentaci�n
    }

    /**
     * Verifica el m�todo buscarBinarioPorNombre buscando un hurac�n que se sabe que deber�a encontrarse. <br>
     * <b> M�todos a probar: </b> <br>
     * buscarBinarioPorNombre. <br>
     * <b> Objetivo: </b> Probar que el m�todo buscarBinarioPorNombre() sea capaz de encontrar huracanes registrados en el sistema. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar un hurac�n previamente agregado se debe obtener una posici�n diferente de -1. <br>
     * 2. Al buscar un hurac�n que no exista la posici�n retornada debe ser -1.
     */
    public void testBuscarBinarioPorNombre( )
    {
        // TODO Completar seg�n documentaci�n
    }

    /**
     * Verifica el m�todo de ordenar por nombre <b> M�todos a probar: </b> <br>
     * ordenarPorNombre. <br>
     * <b> Objetivo: </b> Probar que el m�todo ordenarPorNombre() ordena el sistema de forma correcta (en orden ascendente por nombre). <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al ordenar el sistema por nombre los huracanes deben quedar ordenados por orden alfab�tico de acuerdo a su nombre. <br>
     */
    public void testOrdenarPorNombre( )
    {
        // TODO Completar seg�n documentaci�n
    }

    /**
     * Verifica el m�todo de ordenar por velocidad <b> M�todos a probar: </b> <br>
     * ordenarPorVelocidad. <br>
     * <b> Objetivo: </b> Probar que el m�todo ordenarPorVelocidad() ordena el sistema de forma correcta (en orden ascendente por velocidad). <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al ordenar el sistema por velocidad el hurac�n con la menor velocidad debe quedar de primero y el de mayor velocidad de �ltimo.
     */
    public void testOrdenarPorVelocidad( )
    {
        // TODO Completar seg�n documentaci�n
    }

    /**
     * Verifica el m�todo de ordenar por costo estimado en da�os <b> M�todos a probar: </b> <br>
     * ordenarPorDanios. <br>
     * <b> Objetivo: </b> Probar que el m�todo ordenarPorDanios() ordena el sistema de forma correcta (en orden ascendente por costo estimado en da�os). <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al ordenar el sistema por costo en da�os el hurac�n con el menor costo estimado en da�os debe quedar de primero y el de mayor costo en da�os de �ltimo.
     */
    public void testOrdenarPorDanios( )
    {
        // TODO Completar seg�n documentaci�n
    }

    /**
     * Verifica el m�todo buscarHuracanMayorCostoDanios funcione correctamente. <br>
     * <b> M�todos a probar: </b> <br>
     * buscarHuracanMayorCostoDanios. <br>
     * <b> Objetivo: </b> Probar que el m�todo buscarHuracanMayorCostoDanios() retorna el hurac�n correcto (el que tiene mayor costo estimado en da�os). <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar el hurac�n con mayor costo estimado en da�os se debe obtener la posici�n del hurac�n con el costo estimado en da�os en el sistema. <br>
     * 2. Al buscar el hurac�n con mayor costo estimado en da�os en un sistema vac�o la posici�n retornada debe ser -1.
     */
    public void testBuscarHuracanMayorCostoDanios( )
    {
        // TODO Completar seg�n documentaci�n
    }

    /**
     * Verifica el m�todo buscarHuracanMenorCostoDanios funcione correctamente. <br>
     * <b> M�todos a probar: </b> <br>
     * buscarHuracanMenorCostoDanios. <br>
     * <b> Objetivo: </b> Probar que el m�todo buscarHuracanMenorCostoDanios() retorna el hurac�n correcto (el que tiene menor costo estimado en da�os). <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar el hurac�n con menor costo estimado en da�os se debe obtener la posici�n del hurac�n con el costo estimado en da�os m�s peque�o en el sistema. <br>
     * 2. Al buscar el hurac�n con menor costo estimado en da�os en un sistema vac�o la posici�n retornada debe ser -1.
     */
    public void testBuscarHuracanMenorCostoDanios( )
    {
        // TODO Completar seg�n documentaci�n
    }

    /**
     * Verifica el m�todo buscarHuracanMayorVelocidad funcione correctamente. <br>
     * <b> M�todos a probar: </b> <br>
     * buscarHuracanMayorVelocidad. <br>
     * <b> Objetivo: </b> Probar que el m�todo buscarHuracanMayorVelocidad() retorna el hurac�n correcto (el que tiene mayor velocidad). <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar el hurac�n con mayor velocidad se debe obtener la posici�n del hurac�n con la velocidad en el sistema. <br>
     * 2. Al buscar el hurac�n con mayor velocidad en un sistema vac�o la posici�n retornada debe ser -1.
     */
    public void testBuscarHuracanMayorVelocidad( )
    {
        // TODO Completar seg�n documentaci�n
    }

    // -----------------------------------------------------------------
    // M�todos Auxiliares
    // -----------------------------------------------------------------
    /**
     * Carga los huracanes del sistema especificada a partir de un archivo de propiedades.
     * @param archivo es el nombre del archivo de propiedades que contiene la informaci�n de los huracanes
     */
    private void cargarHuracanes( String archivo )
    {
        try
        {
            FileInputStream fis = new FileInputStream( new File( archivo ) );
            Properties propiedades = new Properties( );
            propiedades.load( fis );

            // Cargar los huracanes
            String dato;
            String nombre;
            int categoria;
            int velocidad;
            double costoDanios;
            String imagen;
            String aux;
            dato = "total.huracanes";
            aux = propiedades.getProperty( dato );
            cantidadHuracanes = Integer.parseInt( aux );

            for( int cont = 1; cont <= cantidadHuracanes; cont++ )
            {
                // Carga un hurac�n
                dato = "huracan" + cont + ".nombre";
                nombre = propiedades.getProperty( dato );

                dato = "huracan" + cont + ".categoria";
                categoria = Integer.parseInt( propiedades.getProperty( dato ) );

                dato = "huracan" + cont + ".velocidad";
                velocidad = Integer.parseInt( propiedades.getProperty( dato ) );

                dato = "huracan" + cont + ".costoDanios";
                costoDanios = Double.parseDouble( propiedades.getProperty( dato ) );

                dato = "huracan" + cont + ".imagen";
                imagen = propiedades.getProperty( dato );

                sistemaMeteorologia.agregarHuracan( nombre, categoria, velocidad, costoDanios, imagen );
                fis.close( );
            }
        }
        catch( Exception e )
        {
            fail( "No se pudo cargar el archivo de huracanes: " + e.getMessage( ) );
        }
    }

}