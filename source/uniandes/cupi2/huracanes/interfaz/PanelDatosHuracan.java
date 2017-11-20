/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelDatosHuracan.java,v 1.3 2008/09/10 15:52:25 ju-cort1 Exp $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_huracanes
 * Autor: Juan Camilo Cortés Medina - 05-ago-2008
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.huracanes.interfaz;

import java.awt.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.*;
import javax.swing.*;
import javax.swing.border.*;

import uniandes.cupi2.huracanes.mundo.Huracan;

/**
 * Es el panel donde se muestran los datos de un huracán
 */
public class PanelDatosHuracan extends JPanel
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Esta constante indica la altura que debe tener la imagen de un huracán
     */
    private static final int ALTURA = 200;

    /**
     * Esta constante indica el ancho que debe tener la imagen de un huracán
     */
    private static final int ANCHO = 200;
    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Es la etiqueta donde se muestra la imagen del huracán
     */
    private JLabel etiquetaImagen;

    /**
     * Es la etiqueta para el nombre del huracán
     */
    private JLabel etiquetaNombre;

    /**
     * Es la etiqueta para la categoría del huracán
     */
    private JLabel etiquetaCategoria;

    /**
     * Es la etiqueta donde se muestra el costo estimado en daños del huracán
     */
    private JLabel etiquetaDanios;

    /**
     * Es la etiqueta para la velocidad del huracán
     */
    private JLabel etiquetaVelocidad;

    /**
     * Es el campo para el nombre del huracán
     */
    private JTextField txtNombre;

    /**
     * Es el campo para la categoría del huracán
     */
    private JTextField txtCategoria;

    /**
     * Es el campo para el costo estimado en daños del huracán
     */
    private JTextField txtDanios;

    /**
     * Es el campo para la velocidad del huracán
     */
    private JTextField txtVelocidad;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel e inicializa sus componentes.
     */
    public PanelDatosHuracan( )
    {
        setLayout( new GridBagLayout( ) );
        setBorder( new TitledBorder( "Datos Huracán" ) );

        etiquetaNombre = new JLabel( "Nombre: " );
        GridBagConstraints gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets( 5, 0, 5, 0 );
        add( etiquetaNombre, gbc );

        txtNombre = new JTextField( );
        txtNombre.setEnabled( false );
        gbc = new GridBagConstraints( );
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets( 5, 0, 5, 0 );
        add( txtNombre, gbc );

        etiquetaCategoria = new JLabel( "Categoría: " );
        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets( 5, 0, 5, 0 );
        add( etiquetaCategoria, gbc );

        txtCategoria = new JTextField( );
        txtCategoria.setEnabled( false );
        gbc = new GridBagConstraints( );
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets( 5, 0, 5, 0 );
        add( txtCategoria, gbc );

        etiquetaVelocidad = new JLabel( "Velocidad: " );
        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets( 5, 0, 5, 0 );
        add( etiquetaVelocidad, gbc );

        txtVelocidad = new JTextField( );
        txtVelocidad.setEnabled( false );
        gbc = new GridBagConstraints( );
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets( 5, 0, 5, 0 );
        add( txtVelocidad, gbc );

        etiquetaDanios = new JLabel( "Costo daños: " );
        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets( 5, 0, 5, 0 );
        add( etiquetaDanios, gbc );

        txtDanios = new JTextField( );
        txtDanios.setEnabled( false );
        gbc = new GridBagConstraints( );
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets( 5, 0, 5, 0 );
        add( txtDanios, gbc );

        etiquetaImagen = new JLabel( );
        etiquetaImagen.setBorder( new LineBorder( Color.BLACK, 1 ) );
        etiquetaImagen.setMinimumSize( new Dimension( 230, 153 ) );
        etiquetaImagen.setMaximumSize( new Dimension( 230, 153 ) );

        gbc = new GridBagConstraints( );
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridheight = 5;
        gbc.insets = new Insets( 5, 5, 5, 5 );
        add( etiquetaImagen, gbc );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Muestra los datos del huracán en los campos.
     * @param huracan es el huracán del que se quieren mostrar los datos - huracan!= null
     */
    public void mostrarDatos( Huracan huracan )
    {
        try
        {
            String imagen = huracan.darImagen( );
            BufferedImage bImagen = ImageIO.read( new File( imagen ) );

            Image laImagen = null;
            laImagen = bImagen.getScaledInstance( ( int ) ( ANCHO * 0.85 ), ( int ) ( ALTURA * 0.85 ), Image.SCALE_AREA_AVERAGING );
            etiquetaImagen.setIcon( new ImageIcon( laImagen ) );

            txtNombre.setText( huracan.darNombre( ) );
            txtCategoria.setText( "" + huracan.darCategoria( ) );
            txtVelocidad.setText( "" + huracan.darVelocidad( ) + "km/h" );
            txtDanios.setText( "" + huracan.darCostoEstimadoDanios( ) + " MUS" );

            validate( );
        }
        catch( IOException e )
        {
            JOptionPane.showMessageDialog( null, "La ruta de la imagen ingresada no es válida. Operación cancelada", "Agregar huracán", JOptionPane.ERROR_MESSAGE );
        }

    }

    /**
     * Limpia todos los campos.
     */
    public void limpiarDatos( )
    {
        etiquetaImagen.setIcon( null );
        txtNombre.setText( "" );
        txtCategoria.setText( "" );
        txtVelocidad.setText( "" );
        txtDanios.setText( "" );
    }
}