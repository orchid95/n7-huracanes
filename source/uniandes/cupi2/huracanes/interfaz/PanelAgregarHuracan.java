/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelAgregarHuracan.java,v 1.2 2008/09/10 15:51:34 ju-cort1 Exp $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_huracanes
 * Autor: Juan Camilo Cort�s Medina - 05-ago-2008
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
     * Es el campo para la ruta hasta la imagen del hurac�n
     */
    private JTextField txtImagen;

    /**
     * Es el campo para el nombre del hurac�n
     */
    private JTextField txtNombre;

    /**
     * Es el campo para la categor�a del hurac�n
     */
    private JTextField txtCategoria;

    /**
     * Es el campo para la velocidad del hurac�n
     */
    private JTextField txtVelocidad;

    /**
     * Es el campo para el costo estimado en da�os del hurac�n
     */
    private JTextField txtDanios;

    /**
     * Es la etiqueta para la imagen del hurac�n
     */
    private JLabel etiquetaImagen;

    /**
     * Es la etiqueta para el nombre del hurac�n
     */
    private JLabel etiquetaNombre;

    /**
     * Es la etiqueta para la categor�a del hurac�n
     */
    private JLabel etiquetaCategoria;

    /**
     * Es la etiqueta para el costo estimado en da�os del hurac�n
     */
    private JLabel etiquetaDanios;

    /**
     * Es la etiqueta para la velocidad del hurac�n
     */
    private JLabel etiquetaVelocidad;

    /**
     * Es el bot�n que se usa para agregar un hurac�n
     */
    private JButton botonAgregar;

    /**
     * Es el bot�n que se usa para examinar el disco buscando la imagen del hurac�n
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
        setBorder( new CompoundBorder( new EmptyBorder( 4, 3, 3, 3 ), new TitledBorder( "Agregar Hurac�n" ) ) );

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

        // Categor�a
        etiquetaCategoria = new JLabel( "Categor�a: " );
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

        // Costo en da�os
        etiquetaDanios = new JLabel( "Costo en Da�os: " );
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

        // Bot�n agregar
        JPanel panelBoton = new JPanel( );
        botonAgregar = new JButton( "Agregar Hurac�n" );
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
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Este es el m�todo que se ejecuta cuando se hace click sobre un bot�n.
     * @param evento es el evento del click sobre el bot�n
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
                    JOptionPane.showMessageDialog( null, "La ruta de la imagen no es v�lida. Se utilizar� una imagen por defecto", "Agregar Hurac�n", JOptionPane.INFORMATION_MESSAGE );
                }
                else
                {
                    try
                    {
                        BufferedImage bImagen = ImageIO.read( archivo );
                        if( bImagen == null )
                        {
                            imagen = RUTA_SIN_IMAGEN;
                            JOptionPane.showMessageDialog( null, "La ruta de la imagen no es v�lida. Se utilizar� una imagen por defecto", "Agregar Hurac�n", JOptionPane.INFORMATION_MESSAGE );
                        }
                    }
                    catch( IOException e )
                    {
                        imagen = RUTA_SIN_IMAGEN;
                        JOptionPane.showMessageDialog( null, "La ruta de la imagen no es v�lida. Se utilizar� una imagen por defecto", "Agregar Hurac�n", JOptionPane.INFORMATION_MESSAGE );
                    }
                }

                if( nombre == null || nombre.equals( "" ) )
                {
                    JOptionPane.showMessageDialog( this, "Debe ingresar el nombre del hurac�n", "Error", JOptionPane.ERROR_MESSAGE );
                }
                else if( categoria < 1 || categoria > 5 )
                {
                    JOptionPane.showMessageDialog( this, "La categor�a del hurac�n ingresada es incorrecta", "Error", JOptionPane.ERROR_MESSAGE );
                }
                else if( danios < 0 )
                {
                    JOptionPane.showMessageDialog( this, "El costo estimado en da�os del hurac�n ingresado es incorrecto", "Error", JOptionPane.ERROR_MESSAGE );
                }
                else if( velocidad < 0 )
                {
                    JOptionPane.showMessageDialog( this, "La velocidad del hurac�n ingresada es incorrecta", "Error", JOptionPane.ERROR_MESSAGE );
                }
                else if( imagen == null || imagen.equals( "" ) )
                {
                    JOptionPane.showMessageDialog( this, "Debe ingresar la imagen del hurac�n", "Error", JOptionPane.ERROR_MESSAGE );
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
                JOptionPane.showMessageDialog( this, "Los campos de categor�a, da�os y velocidad deben ser n�meros", "Error", JOptionPane.ERROR_MESSAGE );
            }
        }
        else if( BUSCAR.equals( comando ) )
        {
            JFileChooser fc = new JFileChooser( "./data" );
            fc.setDialogTitle( "Buscar imagen de hurac�n" );
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
