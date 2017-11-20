/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: InterfazHuracanes.java,v 1.4 2008/09/12 10:58:10 jua-gome Exp $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_huracanes
 * Autor: Juan Camilo Cort�s M. - 21-ago-2008
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.huracanes.interfaz;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.cupi2.huracanes.mundo.Huracan;
import uniandes.cupi2.huracanes.mundo.SistemaMeteorologia;

/**
 * Esta es la ventana principal de la aplicaci�n.
 */
public class InterfazHuracanes extends JFrame
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * ruta al archivo de persistencia del sistema
     */
    public static final String ARCHIVO_HURACANES = "./data/huracanes.txt";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia al sistema de meteorolog�a
     */
    private SistemaMeteorologia sistemaMeteorologia;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Es el panel donde se muestra la lista de huracanes
     */
    private PanelListaHuracanes panelLista;

    /**
     * Es el panel donde se muestran los datos de un hurac�n
     */
    private PanelDatosHuracan panelDatos;

    /**
     * Es el panel donde se introducen los datos para agregar un hurac�n
     */
    private PanelAgregarHuracan panelAgregar;

    /**
     * Es el panel donde est�n los botones para los puntos de extensi�n
     */
    private PanelExtension panelExtension;

    /**
     * Es el panel donde est�n los botones para la realizaci�n de ordenamientos y b�squeda
     */
    private PanelBusquedaOrdenamientos panelBusquedaOrdenamientos;

    /**
     * Es el panel donde est�n las opciones para la realizaci�n de consultas
     */
    private PanelConsultas panelConsultas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye la interfaz e inicializa todos sus componentes.
     * @param archivoHuracanes es el nombre del archivo de propiedades que contiene la informaci�n de los huracanes
     */
    public InterfazHuracanes( String archivoHuracanes )
    {
        // Crea la clase principal
        sistemaMeteorologia = new SistemaMeteorologia( );
        cargarHuracanes( archivoHuracanes );

        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setTitle( "Sistema Meteorolog�a" );
        setSize( new Dimension( 800, 550 ) );
        setResizable( false );

        setLayout( new GridBagLayout( ) );

        JPanel panelSuperior = new JPanel( );
        panelSuperior.setLayout( new GridBagLayout( ) );

        panelLista = new PanelListaHuracanes( this );
        GridBagConstraints gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.ipadx = 120;
        panelSuperior.add( panelLista, gbc );

        panelDatos = new PanelDatosHuracan( );
        gbc = new GridBagConstraints( );
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.ipadx = 45;
        gbc.ipady = 40;
        gbc.fill = GridBagConstraints.BOTH;
        panelSuperior.add( panelDatos, gbc );

        panelBusquedaOrdenamientos = new PanelBusquedaOrdenamientos( this );
        gbc = new GridBagConstraints( );
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.ipadx = 10;
        gbc.ipady = 100;
        gbc.fill = GridBagConstraints.BOTH;
        panelSuperior.add( panelBusquedaOrdenamientos, gbc );

        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        getContentPane( ).add( panelSuperior, gbc );

        JPanel panelCentral = new JPanel( );
        panelCentral.setLayout( new GridBagLayout( ) );

        panelAgregar = new PanelAgregarHuracan( this );
        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipady = 35;
        gbc.ipadx = 20;
        gbc.fill = GridBagConstraints.BOTH;
        panelCentral.add( panelAgregar, gbc );

        panelConsultas = new PanelConsultas( this );
        gbc = new GridBagConstraints( );
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.ipadx = 85;
        gbc.fill = GridBagConstraints.BOTH;
        panelCentral.add( panelConsultas, gbc );

        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        getContentPane( ).add( panelCentral, gbc );

        panelExtension = new PanelExtension( this );
        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        getContentPane( ).add( panelExtension, gbc );
        actualizarLista( );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Actualiza la lista de huracanes mostrada.
     */
    private void actualizarLista( )
    {
        panelLista.refrescarLista( sistemaMeteorologia.darHuracanes( ) );
    }

    /**
     * Ordena los huracanes por velocidad y actualiza la lista.
     */
    public void ordenarPorVelocidad( )
    {
        sistemaMeteorologia.ordenarPorVelocidad( );
        panelDatos.limpiarDatos( );
        actualizarLista( );
    }

    /**
     * Ordena los huracanes por nombre y actualiza la lista.
     */
    public void ordenarPorNombre( )
    {
        sistemaMeteorologia.ordenarPorNombre( );
        panelDatos.limpiarDatos( );
        actualizarLista( );
    }

    /**
     * Ordena los huracanes por costo estimado en da�os y actualiza la lista.
     */
    public void ordenarPorCostoDanios( )
    {
        sistemaMeteorologia.ordenarPorDanios( );
        panelDatos.limpiarDatos( );
        actualizarLista( );
    }

    /**
     * Busca un hurac�n usando el nombre y cuando lo encuentra lo selecciona en la lista y muestra sus datos.
     */
    public void buscar( )
    {
        String nombreBuscado = JOptionPane.showInputDialog( this, "Nombre del hurac�n" );
        if( nombreBuscado != null )
        {
            int posicion = sistemaMeteorologia.buscarHuracan( nombreBuscado );

            if( posicion != -1 )
            {
                actualizarLista( );
                panelLista.seleccionar( posicion );
                Huracan p = ( Huracan )sistemaMeteorologia.darHuracanes( ).get( posicion );
                verDatos( p );
            }
            else
            {
                JOptionPane.showMessageDialog( this, "No se encontr� el hurac�n" );
            }
        }
    }

    /**
     * Muestra los datos de un hurac�n en el panel correspondiente.
     * @param huracan es el hurac�n del que se quieren ver los datos - hurac�n != null
     */
    public void verDatos( Huracan huracan )
    {
        panelDatos.mostrarDatos( huracan );
    }

    /**
     * Agrega un nuevo hurac�n.
     * @param nombreP es el nombre del hurac�n - nombreP != null
     * @param categoriaP es la categor�a del hurac�n - 0 < categoriaP < 6
     * @param velocidadP es la velocidad del hurac�n - velocidadP > 0
     * @param costoEstimadoDaniosP es el costo estimado en da�os del hurac�n - costoEstimadoDaniosP > 0
     * @param imagenP La ruta a la imagen del hurac�n - imagenP != null
     */
    public void agregarHuracan( String nombreP, int categoriaP, int velocidadP, double costoEstimadoDaniosP, String imagenP )
    {
        boolean agrego = sistemaMeteorologia.agregarHuracan( nombreP, categoriaP, velocidadP, costoEstimadoDaniosP, imagenP );
        if( !agrego )
            JOptionPane.showMessageDialog( this, "No se pudo agregar el hurac�n dado que el nombre " + nombreP + " ya lo tiene otro hurac�n", "Error", JOptionPane.ERROR_MESSAGE );
        else
        {
            actualizarLista( );
            panelLista.seleccionar( sistemaMeteorologia.darHuracanes( ).size( ) - 1 );
        }
    }

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
            int cantidadHuracanes = Integer.parseInt( aux );

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

                // S�lo se carga el hurac�n si los datos son correctos
                if( nombre != null && categoria > 0 && categoria < 6 && velocidad > 0 && costoDanios > 0 && imagen != null )
                    sistemaMeteorologia.agregarHuracan( nombre, categoria, velocidad, costoDanios, imagen );
                fis.close( );
            }
        }
        catch( FileNotFoundException e )
        {
            JOptionPane.showMessageDialog( null, "El archivo de los huracanes no existe", "Cargar huracanes", JOptionPane.ERROR_MESSAGE );
        }
        catch( IOException e )
        {
            JOptionPane.showMessageDialog( null, "Se present� un problema al cargar las im�genes", "Cargar huracanes", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Busca el hurac�n con mayor velocidad y muestra sus datos en el panel de datos.
     */
    public void buscarMayorVelocidad( )
    {
        int posicion = sistemaMeteorologia.buscarHuracanMayorVelocidad( );

        actualizarLista( );
        if( posicion != -1 )
        {
            panelLista.seleccionar( posicion );
            Huracan h = ( Huracan )sistemaMeteorologia.darHuracanes( ).get( posicion );
            verDatos( h );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "No hay huracanes registrados en el sistema" );
        }
    }

    /**
     * Busca el hurac�n con mayor costo estimado en da�os y muestra sus datos en el panel de datos.
     */
    public void buscarMayorCostoDanios( )
    {
        int posicion = sistemaMeteorologia.buscarHuracanMayorCostoDanios( );

        actualizarLista( );
        if( posicion != -1 )
        {
            panelLista.seleccionar( posicion );
            Huracan h = ( Huracan )sistemaMeteorologia.darHuracanes( ).get( posicion );
            verDatos( h );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "No hay huracanes registrados en el sistema" );
        }
    }

    /**
     * Busca el hurac�n con menor costo estimado en da�os y muestra sus datos en el panel de datos.
     */
    public void buscarMenorCostoDanios( )
    {
        int posicion = sistemaMeteorologia.buscarHuracanMenorCostoDanios( );

        actualizarLista( );
        if( posicion != -1 )
        {
            panelLista.seleccionar( posicion );
            Huracan h = ( Huracan )sistemaMeteorologia.darHuracanes( ).get( posicion );
            verDatos( h );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "No hay huracanes registrados en el sistema" );
        }
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1
     */
    public void reqFuncOpcion1( )
    {
        String resultado = sistemaMeteorologia.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * M�todo para la extensi�n 2
     */
    public void reqFuncOpcion2( )
    {
        String resultado = sistemaMeteorologia.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Este m�todo ejecuta la aplicaci�n, creando una nueva interfaz
     * @param args
     */
    public static void main( String[] args )
    {

        InterfazHuracanes interfaz = new InterfazHuracanes( ARCHIVO_HURACANES );
        interfaz.setVisible( true );
    }
}