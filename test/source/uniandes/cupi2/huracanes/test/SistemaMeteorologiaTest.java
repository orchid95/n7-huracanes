/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: SistemaMeteorologiaTest.java,v 1.3 2008/09/10 15:54:50 ju-cort1 Exp $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_huracanes
 * Autor: Juan Camilo Cortés M. - 21-ago-2008
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
 * Esta es la clase usada para verificar que los métodos de la clase SistemaMeteorologia estén correctamente implementados
 */
public class SistemaMeteorologiaTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la clase donde se harán las pruebas
     */
    private SistemaMeteorologia sistemaMeteorologia;

    /**
     * La cantidad de huracanes que hay en el sistema.
     */
    private int cantidadHuracanes;

    // -----------------------------------------------------------------
    // Métodos
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
     * Crea un sistema vacío
     */
    private void setupEscenario3( )
    {
        sistemaMeteorologia = new SistemaMeteorologia( );
        cantidadHuracanes = 0;
    }

    /**
     * Verifica el método agregarHuracan agregando correctamente un huracán. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarHuracan, buscarHuracan, darHuracanes. <br>
     * <b> Objetivo: </b> Probar que el método agregarHuracan() sea capaz de registrar un huracán en el sistema. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar (por nombre) un huracán previamente agregado se debe obtener una posición diferente de -1 (se debe encontrar) y los datos del huracán en esa posición deben
     * corresponder a los del huracán con el nombre correspondiente. <br>
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
        // Agrega un huracán y luego verifica que se haya agregado de forma correcta
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

            assertTrue( "El huracán no se agregó de forma correcta", agregado );
            assertEquals( "El huracán no se agregó de forma correcta", cont - 1, pos );
            assertEquals( "El huracán no se agregó de forma correcta", nombre, huracan.darNombre( ) );
            assertEquals( "El huracán no se agregó de forma correcta", categoria, huracan.darCategoria( ) );
            assertEquals( "El huracán no se agregó de forma correcta", velocidad, huracan.darVelocidad( ) );
            assertEquals( "El huracán no se agregó de forma correcta", costoDanios, huracan.darCostoEstimadoDanios( ) );
            assertEquals( "El huracán no se agregó de forma correcta", imagen, huracan.darImagen( ) );
        }
    }

    /**
     * Verifica el método agregarHuracan agregando un huracán con nombre repetido. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarHuracan, buscarHuracan, darHuracanes. <br>
     * <b> Objetivo: </b> Probar que el método agregarHuracan() no agregue un huracán en el sistema cuando su nombre ya pertenece a otro huracán registrado. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al agregar un huracán con nombre repetido el número de huracanes se debe mantener igual y la información de los huracanes existentes no debe haberse alterado.
     */
    public void testAgregarHuracan2( )
    {
        setupEscenario1( );

        ArrayList huracanes = sistemaMeteorologia.darHuracanes( );
        Huracan h = ( Huracan )huracanes.get( 0 );
        String nombreHuracan = h.darNombre( );

        int i = Integer.parseInt( nombreHuracan );
        boolean agregado = sistemaMeteorologia.agregarHuracan( nombreHuracan, i, i, i, nombreHuracan );
        assertFalse( "El huracán no debería haberse agregado", agregado );

        String nombre;
        int categoria;
        int velocidad;
        double costoDanios;
        String imagen;
        // Busca un huracán y verifica que sus datos estén correctos
        for( int cont = 0; cont < cantidadHuracanes; cont++ )
        {
            nombre = "" + ( cont + 1 );
            categoria = ( cont + 1 );
            velocidad = ( cont + 1 );
            costoDanios = ( cont + 1 );
            imagen = "" + ( cont + 1 );

            Huracan huracan = ( Huracan )sistemaMeteorologia.darHuracanes( ).get( cont );

            assertEquals( "El huracán no se agregó de forma correcta", nombre, huracan.darNombre( ) );
            assertEquals( "El huracán no se agregó de forma correcta", categoria, huracan.darCategoria( ) );
            assertEquals( "El huracán no se agregó de forma correcta", velocidad, huracan.darVelocidad( ) );
            assertEquals( "El huracán no se agregó de forma correcta", costoDanios, huracan.darCostoEstimadoDanios( ) );
            assertEquals( "El huracán no se agregó de forma correcta", imagen, huracan.darImagen( ) );
        }
    }

    /**
     * Verifica el método buscarHuracan buscando un huracán que se sabe que debería encontrarse. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarHuracan. <br>
     * <b> Objetivo: </b> Probar que el método buscarHuracan() sea capaz de encontrar huracanes registrados en el sistema. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar un huracán previamente agregado se debe obtener una posición diferente de -1. <br>
     * 2. Al buscar un huracán que no exista la posición retornada debe ser -1.
     */
    public void testBuscarHuracan( )
    {
        // TODO Completar según documentación
    }

    /**
     * Verifica el método buscarBinarioPorNombre buscando un huracán que se sabe que debería encontrarse. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarBinarioPorNombre. <br>
     * <b> Objetivo: </b> Probar que el método buscarBinarioPorNombre() sea capaz de encontrar huracanes registrados en el sistema. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar un huracán previamente agregado se debe obtener una posición diferente de -1. <br>
     * 2. Al buscar un huracán que no exista la posición retornada debe ser -1.
     */
    public void testBuscarBinarioPorNombre( )
    {
        // TODO Completar según documentación
    }

    /**
     * Verifica el método de ordenar por nombre <b> Métodos a probar: </b> <br>
     * ordenarPorNombre. <br>
     * <b> Objetivo: </b> Probar que el método ordenarPorNombre() ordena el sistema de forma correcta (en orden ascendente por nombre). <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al ordenar el sistema por nombre los huracanes deben quedar ordenados por orden alfabético de acuerdo a su nombre. <br>
     */
    public void testOrdenarPorNombre( )
    {
        // TODO Completar según documentación
    }

    /**
     * Verifica el método de ordenar por velocidad <b> Métodos a probar: </b> <br>
     * ordenarPorVelocidad. <br>
     * <b> Objetivo: </b> Probar que el método ordenarPorVelocidad() ordena el sistema de forma correcta (en orden ascendente por velocidad). <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al ordenar el sistema por velocidad el huracán con la menor velocidad debe quedar de primero y el de mayor velocidad de último.
     */
    public void testOrdenarPorVelocidad( )
    {
        // TODO Completar según documentación
    }

    /**
     * Verifica el método de ordenar por costo estimado en daños <b> Métodos a probar: </b> <br>
     * ordenarPorDanios. <br>
     * <b> Objetivo: </b> Probar que el método ordenarPorDanios() ordena el sistema de forma correcta (en orden ascendente por costo estimado en daños). <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al ordenar el sistema por costo en daños el huracán con el menor costo estimado en daños debe quedar de primero y el de mayor costo en daños de último.
     */
    public void testOrdenarPorDanios( )
    {
        // TODO Completar según documentación
    }

    /**
     * Verifica el método buscarHuracanMayorCostoDanios funcione correctamente. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarHuracanMayorCostoDanios. <br>
     * <b> Objetivo: </b> Probar que el método buscarHuracanMayorCostoDanios() retorna el huracán correcto (el que tiene mayor costo estimado en daños). <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar el huracán con mayor costo estimado en daños se debe obtener la posición del huracán con el costo estimado en daños en el sistema. <br>
     * 2. Al buscar el huracán con mayor costo estimado en daños en un sistema vacío la posición retornada debe ser -1.
     */
    public void testBuscarHuracanMayorCostoDanios( )
    {
        // TODO Completar según documentación
    }

    /**
     * Verifica el método buscarHuracanMenorCostoDanios funcione correctamente. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarHuracanMenorCostoDanios. <br>
     * <b> Objetivo: </b> Probar que el método buscarHuracanMenorCostoDanios() retorna el huracán correcto (el que tiene menor costo estimado en daños). <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar el huracán con menor costo estimado en daños se debe obtener la posición del huracán con el costo estimado en daños más pequeño en el sistema. <br>
     * 2. Al buscar el huracán con menor costo estimado en daños en un sistema vacío la posición retornada debe ser -1.
     */
    public void testBuscarHuracanMenorCostoDanios( )
    {
        // TODO Completar según documentación
    }

    /**
     * Verifica el método buscarHuracanMayorVelocidad funcione correctamente. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarHuracanMayorVelocidad. <br>
     * <b> Objetivo: </b> Probar que el método buscarHuracanMayorVelocidad() retorna el huracán correcto (el que tiene mayor velocidad). <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar el huracán con mayor velocidad se debe obtener la posición del huracán con la velocidad en el sistema. <br>
     * 2. Al buscar el huracán con mayor velocidad en un sistema vacío la posición retornada debe ser -1.
     */
    public void testBuscarHuracanMayorVelocidad( )
    {
        // TODO Completar según documentación
    }

    // -----------------------------------------------------------------
    // Métodos Auxiliares
    // -----------------------------------------------------------------
    /**
     * Carga los huracanes del sistema especificada a partir de un archivo de propiedades.
     * @param archivo es el nombre del archivo de propiedades que contiene la información de los huracanes
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
                // Carga un huracán
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