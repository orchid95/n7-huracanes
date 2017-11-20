/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelConsultas.java,v 1.2 2008/09/10 11:59:46 jua-gome Exp $
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

import javax.swing.*;
import javax.swing.border.*;

/**
 * Este es el panel donde se encuentran los botones para hacer consulta sobre el sistema
 */
public class PanelConsultas extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    private static final String MAYOR_VELOCIDAD = "Mayor velocidad";

    private static final String MAYOR_DANIOS = "Mayor costo en da�os";

    private static final String MENOR_DANIOS = "Menos costo en da�os";

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
     * Es el bot�n para mostrar el nombre del hurac�n con mayor velocidad
     */
    private JButton botonMayorVelocidad;

    /**
     * Es el bot�n para mostrar el hurac�n con mayor costo estimado en da�os
     */
    private JButton botonMayorDanios;

    /**
     * Es el bot�n para mostrar el nombre del hurac�n con menor costo estimado en da�os
     */
    private JButton botonMenorDanios;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Construye el panel e inicializa sus componentes.
     * @param ventanaPrincipal es una referencia a la clase principal de la interfaz - ventanaPrincipal != null
     */
    public PanelConsultas( InterfazHuracanes ventanaPrincipal )
    {
        principal = ventanaPrincipal;
        setLayout( new GridLayout( 4, 1, 10, 10 ) );
        setBorder( new CompoundBorder( new EmptyBorder( 4, 3, 3, 3 ), new TitledBorder( "Consultas Sistema" ) ) );

        // Mayor Velocidad
        botonMayorVelocidad = new JButton( "Mayor Velocidad" );
        botonMayorVelocidad.addActionListener( this );
        botonMayorVelocidad.setActionCommand( MAYOR_VELOCIDAD );
        add( botonMayorVelocidad );

        // Mayor costo da�os
        botonMayorDanios = new JButton( "Mayor costo da�os" );
        botonMayorDanios.addActionListener( this );
        botonMayorDanios.setActionCommand( MAYOR_DANIOS );
        add( botonMayorDanios );

        // Menor costo en da�os
        botonMenorDanios = new JButton( "Menor costo en da�os" );
        botonMenorDanios.addActionListener( this );
        botonMenorDanios.setActionCommand( MENOR_DANIOS );
        add( botonMenorDanios );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Ejecuta una acci�n seg�n el bot�n que se haya presionado.
     * @param evento es el evento de click sobre un bot�n
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( MAYOR_VELOCIDAD.equals( comando ) )
        {
            principal.buscarMayorVelocidad( );
        }
        else if( MAYOR_DANIOS.equals( comando ) )
        {
            principal.buscarMayorCostoDanios( );
        }
        else if( MENOR_DANIOS.equals( comando ) )
        {
            principal.buscarMenorCostoDanios( );
        }
    }
}