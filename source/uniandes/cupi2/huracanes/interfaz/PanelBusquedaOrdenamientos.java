/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelBusquedaOrdenamientos.java,v 1.1 2008/08/23 10:25:41 ju-cort1 Exp $
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

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Este es el panel donde se encuentran los botones para realizar los ordenamientos por distintos criterios y las búsquedas.
 */
public class PanelBusquedaOrdenamientos extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    private static final String BUSCAR = "Buscar";

    private static final String ORDENAR_NOMBRE = "OrdenarNombre";

    private static final String ORDENAR_COSTO_DANIOS = "OrdenarCostoDanios";

    private static final String ORDENAR_VELOCIDAD = "OrdenarVelocidad";

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
     * Es el botón para ordenar la lista de huracanes por nombre
     */
    private JButton botonOrdenarNombre;

    /**
     * Es el botón para ordenar la lista de huracanes por costo estimado en daños
     */
    private JButton botonOrdenarCostoDanios;

    /**
     * Es el botón para ordenar la lista de huracanes por velocidad
     */
    private JButton botonOrdenarVelocidad;

    /**
     * Es el botón para realizar una búsqueda
     */
    private JButton botonBuscar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel e inicializa todos sus componentes.
     * @param ventanaPrincipal es una referencia a la clase principal de la interfaz - ventanaPrincipal != null
     */
    public PanelBusquedaOrdenamientos( InterfazHuracanes ventanaPrincipal )
    {
        principal = ventanaPrincipal;

        setPreferredSize( new Dimension( 200, 0 ) );
        setBorder( new CompoundBorder( new EmptyBorder( 4, 3, 3, 3 ), new TitledBorder( "Búsqueda y ordenamientos" ) ) );
        setLayout( new GridBagLayout( ) );

        botonOrdenarNombre = new JButton( "Ordenar por Nombre" );
        GridBagConstraints gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets( 0, 0, 10, 0 );
        gbc.fill = GridBagConstraints.BOTH;
        botonOrdenarNombre.setActionCommand( ORDENAR_NOMBRE );
        botonOrdenarNombre.addActionListener( this );
        add( botonOrdenarNombre, gbc );

        botonOrdenarCostoDanios = new JButton( "Ordenar por Costo en Daños" );
        botonOrdenarCostoDanios.setActionCommand( ORDENAR_COSTO_DANIOS );
        botonOrdenarCostoDanios.addActionListener( this );
        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets( 0, 0, 10, 0 );
        gbc.fill = GridBagConstraints.BOTH;
        add( botonOrdenarCostoDanios, gbc );

        botonOrdenarVelocidad = new JButton( "Ordenar por Velocidad" );
        botonOrdenarVelocidad.setActionCommand( ORDENAR_VELOCIDAD );
        botonOrdenarVelocidad.addActionListener( this );
        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets( 0, 0, 10, 0 );
        gbc.fill = GridBagConstraints.BOTH;
        add( botonOrdenarVelocidad, gbc );

        botonBuscar = new JButton( "Buscar Huracán" );
        botonBuscar.setActionCommand( BUSCAR );
        botonBuscar.addActionListener( this );
        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets( 0, 0, 10, 0 );
        gbc.fill = GridBagConstraints.BOTH;
        add( botonBuscar, gbc );
    }

    /**
     * Ejecuta una acción según el botón que se haya presionado.
     * @param evento es el evento de click sobre un botón
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( ORDENAR_VELOCIDAD.equals( comando ) )
        {
            principal.ordenarPorVelocidad( );
        }
        else if( ORDENAR_NOMBRE.equals( comando ) )
        {
            principal.ordenarPorNombre( );
        }
        else if( ORDENAR_COSTO_DANIOS.equals( comando ) )
        {
            principal.ordenarPorCostoDanios( );
        }
        else if( BUSCAR.equals( comando ) )
        {
            principal.buscar( );
        }
    }
}
