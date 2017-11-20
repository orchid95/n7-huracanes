/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: InterfazHuracanes.java,v 1.4 2008/09/12 10:58:10 jua-gome Exp $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_huracanes
 * Autor: Juan Camilo Cortés M. - 21-ago-2008
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
 * Esta es la ventana principal de la aplicación.
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
     * Es una referencia al sistema de meteorología
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
     * Es el panel donde se muestran los datos de un huracán
     */
    private PanelDatosHuracan panelDatos;

    /**
     * Es el panel donde se introducen los datos para agregar un huracán
     */
    private PanelAgregarHuracan panelAgregar;

    /**
     * Es el panel donde están los botones para los puntos de extensión
     */
    private PanelExtension panelExtension;

    /**
     * Es el panel donde están los botones para la realización de ordenamientos y búsqueda
     */
    private PanelBusquedaOrdenamientos panelBusquedaOrdenamientos;

    /**
     * Es el panel donde están las opciones para la realización de consultas
     */
    private PanelConsultas panelConsultas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye la interfaz e inicializa todos sus componentes.
     * @param archivoHuracanes es el nombre del archivo de propiedades que contiene la información de los huracanes
     */
    public InterfazHuracanes( String archivoHuracanes )
    {
        // Crea la clase principal
        sistemaMeteorologia = new SistemaMeteorologia( );
        cargarHuracanes( archivoHuracanes );

        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setTitle( "Sistema Meteorología" );
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
    // Métodos
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
     * Ordena los huracanes por costo estimado en daños y actualiza la lista.
     */
    public void ordenarPorCostoDanios( )
    {
        sistemaMeteorologia.ordenarPorDanios( );
        panelDatos.limpiarDatos( );
        actualizarLista( );
    }

    /**
     * Busca un huracán usando el nombre y cuando lo encuentra lo selecciona en la lista y muestra sus datos.
     */
    public void buscar( )
    {
        String nombreBuscado = JOptionPane.showInputDialog( this, "Nombre del huracán" );
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
                JOptionPane.showMessageDialog( this, "No se encontró el huracán" );
            }
        }
    }

    /**
     * Muestra los datos de un huracán en el panel correspondiente.
     * @param huracan es el huracán del que se quieren ver los datos - huracán != null
     */
    public void verDatos( Huracan huracan )
    {
        panelDatos.mostrarDatos( huracan );
    }

    /**
     * Agrega un nuevo huracán.
     * @param nombreP es el nombre del huracán - nombreP != null
     * @param categoriaP es la categoría del huracán - 0 < categoriaP < 6
     * @param velocidadP es la velocidad del huracán - velocidadP > 0
     * @param costoEstimadoDaniosP es el costo estimado en daños del huracán - costoEstimadoDaniosP > 0
     * @param imagenP La ruta a la imagen del huracán - imagenP != null
     */
    public void agregarHuracan( String nombreP, int categoriaP, int velocidadP, double costoEstimadoDaniosP, String imagenP )
    {
        boolean agrego = sistemaMeteorologia.agregarHuracan( nombreP, categoriaP, velocidadP, costoEstimadoDaniosP, imagenP );
        if( !agrego )
            JOptionPane.showMessageDialog( this, "No se pudo agregar el huracán dado que el nombre " + nombreP + " ya lo tiene otro huracán", "Error", JOptionPane.ERROR_MESSAGE );
        else
        {
            actualizarLista( );
            panelLista.seleccionar( sistemaMeteorologia.darHuracanes( ).size( ) - 1 );
        }
    }

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
            int cantidadHuracanes = Integer.parseInt( aux );

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

                // Sólo se carga el huracán si los datos son correctos
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
            JOptionPane.showMessageDialog( null, "Se presentó un problema al cargar las imágenes", "Cargar huracanes", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Busca el huracán con mayor velocidad y muestra sus datos en el panel de datos.
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
     * Busca el huracán con mayor costo estimado en daños y muestra sus datos en el panel de datos.
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
     * Busca el huracán con menor costo estimado en daños y muestra sus datos en el panel de datos.
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
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1
     */
    public void reqFuncOpcion1( )
    {
        String resultado = sistemaMeteorologia.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método para la extensión 2
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
     * Este método ejecuta la aplicación, creando una nueva interfaz
     * @param args
     */
    public static void main( String[] args )
    {

        InterfazHuracanes interfaz = new InterfazHuracanes( ARCHIVO_HURACANES );
        interfaz.setVisible( true );
    }
}