/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelListaHuracanes.java,v 1.1 2008/08/23 10:25:41 ju-cort1 Exp $
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
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

import uniandes.cupi2.huracanes.mundo.Huracan;

/**
 * Es el panel donde se muestra la lista de huracanes y están los botones para interactuar con la lista
 */
public class PanelListaHuracanes extends JPanel implements ListSelectionListener
{
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
     * Es la lista que se muestra
     */
    // TODO Declarar atributo que modela la lista de huracanes
    // nombre: listaHuracanes

    /**
     * Componente de desplazamiento para contener la lista gráfica
     */
    private JScrollPane scroll;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel e inicializa todos sus componentes
     * @param ventanaPrincipal es una referencia a la clase principal de la interfaz - ventanaPrincipal != null
     */
    public PanelListaHuracanes( InterfazHuracanes ventanaPrincipal )
    {
        principal = ventanaPrincipal;

        setLayout( new BorderLayout( ) );
        setBorder( new CompoundBorder( new EmptyBorder( 4, 3, 3, 3 ), new TitledBorder( "Huracanes en el sistema" ) ) );

        // TODO
        // (1) Crear la lista y (2) agregar al panel como listener de la lista

        // TODO
        // (1) Crear y configurar un scroll pane para que contenga la lista
        // (2) Agregar el scroll al panel en el centro (Tener en cuenta que el layout es BorderLayout)
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza la lista de huracanes que se está mostrando
     * @param nuevaLista es una lista con los huracanes que deben mostrarse
     */
    public void refrescarLista( ArrayList nuevaLista )
    {
        // TODO Completar según enunciado
        // Agregue los nuevos elementos (entran como parámetro),
        // y recuerde establecer el índice seleccionado en el 0.
    }

    /**
     * Selecciona un elemento de la lista
     * @param seleccionado es la posición del elemento que se debe seleccionar
     */
    public void seleccionar( int seleccionado )
    {
        listaHuracanes.setSelectedIndex( seleccionado );
        listaHuracanes.ensureIndexIsVisible( seleccionado );
    }

    /**
     * actualiza la información del panel de información de huracanes, según el huracán que se seleccionó en la lista de huracanes
     * @param e es el evento de cambio el ítem seleccionado en la lista
     */
    public void valueChanged( ListSelectionEvent e )
    {
        // TODO Completar según enunciado
        // Apoyese en el método InterfazHuracanes.verDatos( Huracan )
    }
}