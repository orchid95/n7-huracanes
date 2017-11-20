/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelAgregarHuracan.java,v 1.2 2008/09/10 15:51:34 ju-cort1 Exp $
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
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;

/**
 * Este es el panel donde se agregan huracanes
 */
public class PanelAgregarHuracan extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    private static final String RUTA_SIN_IMAGEN = "./data/imagenes/sinImagen.png";

    private static final String AGREGAR = "AgregarHuracan";

    private static final String BUSCAR = "BuscarImagen";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia a la clase principal de la interfaz
     */
    private InterfazHuracanes principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Es el campo para la ruta hasta la imagen del huracán
     */
    private JTextField txtImagen;

    /**
     * Es el campo para el nombre del huracán
     */
    private JTextField txtNombre;

    /**
     * Es el campo para la categoría del huracán
     */
    private JTextField txtCategoria;

    /**
     * Es el campo para la velocidad del huracán
     */
    private JTextField txtVelocidad;

    /**
     * Es el campo para el costo estimado en daños del huracán
     */
    private JTextField txtDanios;

    /**
     * Es la etiqueta para la imagen del huracán
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
     * Es la etiqueta para el costo estimado en daños del huracán
     */
    private JLabel etiquetaDanios;

    /**
     * Es la etiqueta para la velocidad del huracán
     */
    private JLabel etiquetaVelocidad;

    /**
     * Es el botón que se usa para agregar un huracán
     */
    private JButton botonAgregar;

    /**
     * Es el botón que se usa para examinar el disco buscando la imagen del huracán
     */
    private JButton botonExaminar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel e inicializa sus componentes.
     * @param iec es una referencia a la clase principal de la interfaz
     */
    public PanelAgregarHuracan( InterfazHuracanes iec )
    {
        principal = iec;

        setLayout( new GridBagLayout( ) );
        setBorder( new CompoundBorder( new EmptyBorder( 4, 3, 3, 3 ), new TitledBorder( "Agregar Huracán" ) ) );

        JPanel panelDatos = new JPanel( new GridBagLayout( ) );

        // Nombre
        etiquetaNombre = new JLabel( "Nombre: " );
        GridBagConstraints gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelDatos.add( etiquetaNombre, gbc );
        txtNombre = new JTextField( "" );
        gbc = new GridBagConstraints( );
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;

        panelDatos.add( txtNombre, gbc );

        // Categoría
        etiquetaCategoria = new JLabel( "Categoría: " );
        etiquetaCategoria.setBorder( new EmptyBorder( 0, 5, 0, 0 ) );
        gbc = new GridBagConstraints( );
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.EAST;

        panelDatos.add( etiquetaCategoria, gbc );
        txtCategoria = new JTextField( "" );
        gbc = new GridBagConstraints( );
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        panelDatos.add( txtCategoria, gbc );

        // Velocidad
        etiquetaVelocidad = new JLabel( "Velocidad: " );
        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelDatos.add( etiquetaVelocidad, gbc );
        txtVelocidad = new JTextField( "" );
        gbc = new GridBagConstraints( );
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        panelDatos.add( txtVelocidad, gbc );

        // Costo en daños
        etiquetaDanios = new JLabel( "Costo en Daños: " );
        etiquetaDanios.setBorder( new EmptyBorder( 0, 5, 0, 0 ) );
        gbc = new GridBagConstraints( );
        gbc.gridx = 2;
        gbc.gridy = 1;
        panelDatos.add( etiquetaDanios, gbc );
        txtDanios = new JTextField( "" );
        gbc = new GridBagConstraints( );
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.ipadx = 160;
        panelDatos.add( txtDanios, gbc );

        // Imagen
        etiquetaImagen = new JLabel( "Imagen: " );
        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelDatos.add( etiquetaImagen, gbc );
        txtImagen = new JTextField( "" );
        botonExaminar = new JButton( "Examinar" );
        botonExaminar.setActionCommand( BUSCAR );
        botonExaminar.addActionListener( this );

        // Botón agregar
        JPanel panelBoton = new JPanel( );
        botonAgregar = new JButton( "Agregar Huracán" );
        botonAgregar.setActionCommand( AGREGAR );
        botonAgregar.addActionListener( this );
        panelBoton.add( botonAgregar );

        JPanel panelImagen = new JPanel( new GridLayout( ) );

        gbc = new GridBagConstraints( );
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 2;
        panelImagen.add( txtImagen );
        gbc = new GridBagConstraints( );
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 2;
        panelImagen.add( botonExaminar );
        gbc = new GridBagConstraints( );
        gbc.gridx = 1;
        gbc.gridy = 2;
        panelDatos.add( panelImagen, gbc );

        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        add( panelDatos, gbc );

        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add( panelBoton, gbc );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Este es el método que se ejecuta cuando se hace click sobre un botón.
     * @param evento es el evento del click sobre el botón
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( AGREGAR.equals( comando ) )
        {
            try
            {
                String nombre = txtNombre.getText( );
                int categoria = Integer.parseInt( txtCategoria.getText( ) );
                String imagen = txtImagen.getText( );
                double danios = Double.parseDouble( txtDanios.getText( ) );
                int velocidad = Integer.parseInt( txtVelocidad.getText( ) );

                File archivo = new File( imagen );
                if( !archivo.exists( ) )
                {
                    imagen = RUTA_SIN_IMAGEN;
                    JOptionPane.showMessageDialog( null, "La ruta de la imagen no es válida. Se utilizará una imagen por defecto", "Agregar Huracán", JOptionPane.INFORMATION_MESSAGE );
                }
                else
                {
                    try
                    {
                        BufferedImage bImagen = ImageIO.read( archivo );
                        if( bImagen == null )
                        {
                            imagen = RUTA_SIN_IMAGEN;
                            JOptionPane.showMessageDialog( null, "La ruta de la imagen no es válida. Se utilizará una imagen por defecto", "Agregar Huracán", JOptionPane.INFORMATION_MESSAGE );
                        }
                    }
                    catch( IOException e )
                    {
                        imagen = RUTA_SIN_IMAGEN;
                        JOptionPane.showMessageDialog( null, "La ruta de la imagen no es válida. Se utilizará una imagen por defecto", "Agregar Huracán", JOptionPane.INFORMATION_MESSAGE );
                    }
                }

                if( nombre == null || nombre.equals( "" ) )
                {
                    JOptionPane.showMessageDialog( this, "Debe ingresar el nombre del huracán", "Error", JOptionPane.ERROR_MESSAGE );
                }
                else if( categoria < 1 || categoria > 5 )
                {
                    JOptionPane.showMessageDialog( this, "La categoría del huracán ingresada es incorrecta", "Error", JOptionPane.ERROR_MESSAGE );
                }
                else if( danios < 0 )
                {
                    JOptionPane.showMessageDialog( this, "El costo estimado en daños del huracán ingresado es incorrecto", "Error", JOptionPane.ERROR_MESSAGE );
                }
                else if( velocidad < 0 )
                {
                    JOptionPane.showMessageDialog( this, "La velocidad del huracán ingresada es incorrecta", "Error", JOptionPane.ERROR_MESSAGE );
                }
                else if( imagen == null || imagen.equals( "" ) )
                {
                    JOptionPane.showMessageDialog( this, "Debe ingresar la imagen del huracán", "Error", JOptionPane.ERROR_MESSAGE );
                }
                else
                {
                    principal.agregarHuracan( nombre, categoria, velocidad, danios, imagen );

                    txtNombre.setText( "" );
                    txtCategoria.setText( "" );
                    txtImagen.setText( "" );
                    txtDanios.setText( "" );
                    txtVelocidad.setText( "" );
                }
            }
            catch( NumberFormatException e )
            {
                JOptionPane.showMessageDialog( this, "Los campos de categoría, daños y velocidad deben ser números", "Error", JOptionPane.ERROR_MESSAGE );
            }
        }
        else if( BUSCAR.equals( comando ) )
        {
            JFileChooser fc = new JFileChooser( "./data" );
            fc.setDialogTitle( "Buscar imagen de huracán" );
            fc.setMultiSelectionEnabled( false );

            int resultado = fc.showOpenDialog( this );
            if( resultado == JFileChooser.APPROVE_OPTION )
            {
                String imagen = fc.getSelectedFile( ).getAbsolutePath( );
                txtImagen.setText( imagen );
            }
        }

    }

}
