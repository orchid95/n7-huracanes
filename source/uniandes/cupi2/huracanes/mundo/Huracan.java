/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Huracan.java,v 1.4 2008/09/12 11:22:48 jua-gome Exp $
 * Universidad de los Andes (Bogotï¿½ - Colombia)
 * Departamento de Ingenierï¿½a de Sistemas y Computaciï¿½n
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_huracanes
 * Autor: Juan Camilo Cortï¿½s Medina - 05-ago-2008
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.huracanes.mundo;

/**
 * Esta clase representa un huracï¿½n. <br>
 * <b> inv: </b> <br>
 * TODO Definir y documentar el invariante de la clase
 */
public class Huracan
{
    // --------------------------------------------------------
    // Atributos
    // --------------------------------------------------------

    /**
     * Nombre del huracï¿½n
     */
    private String nombre;

    /**
     * Categorï¿½a del huracï¿½n segï¿½n el sistema Saffir - Simpson
     */
    private int categoria;

    /**
     * Velocidad del viento en km / h
     */
    private int velocidad;

    /**
     * Costo estimado en daï¿½os expresado en millones de dï¿½lares.
     */
    private double costoEstimadoDanios;

    /**
     * La ruta hasta la imagen del huracï¿½n
     */
    private String imagen;

    // --------------------------------------------------------
    // Constructores
    // --------------------------------------------------------

    /**
     * Construye un nuevo huracï¿½n con los parï¿½metros indicados <br>
     * <b>post: </b> Se construyï¿½ un huracï¿½n con los parï¿½metros indicados
     * @param nombreP es el nombre del huracï¿½n. nombreP != null.
     * @param categoriaP es la categorï¿½a del huracï¿½n. 1 <= categoriaP <= 5.
     * @param velocidadP es la velocidad del viento. 0 <= velocidadP.
     * @param costoEstimadoDaniosP es el costo estimado de daï¿½os. 0 <= costoEstimadoDaniosP.
     * @param imagenP es la ruta a la imagen del huracï¿½n. imagenP != null.
     */
    public Huracan( String nombreP, int categoriaP, int velocidadP, double costoEstimadoDaniosP, String imagenP )
    {
        nombre = nombreP;
        categoria = categoriaP;
        velocidad = velocidadP;
        costoEstimadoDanios = costoEstimadoDaniosP;
        imagen = imagenP;
    }

    // --------------------------------------------------------
    // Mï¿½todos
    // --------------------------------------------------------

    /**
     * Retorna el nombre del huracï¿½n
     * @return el nombre del huracï¿½n
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna la categorï¿½a del huracï¿½n
     * @return la categorï¿½a del huracï¿½n
     */
    public int darCategoria( )
    {
        return categoria;
    }

    /**
     * Retorna la velocidad del huracï¿½n
     * @return la velocidad del huracï¿½n
     */
    public int darVelocidad( )
    {
        return velocidad;
    }

    /**
     * Retorna el costoEstimadoDanios del huracï¿½n
     * @return el costoEstimadoDanios del huracï¿½n
     */
    public double darCostoEstimadoDanios( )
    {
        return costoEstimadoDanios;
    }

    /**
     * Retorna la ruta a la imagen del huracï¿½n.
     * @return La imagen del huracï¿½n
     */
    public String darImagen( )
    {
        return imagen;
    }

    /**
     * Compara dos huracanes segï¿½n el nombre. <br>
     * @param h es el huracï¿½n contra el que se estï¿½ comparando. h != null. <br>
     * @return Retorna 0 si los huracanes tienen el mismo nombre. <br>
     *         Retorna -1 si el huracï¿½n h tiene un valor "MAYOR" para el nombre. <br>
     *         Retorna 1 si el huracï¿½n h tiene un valor "MENOR" para el nombre. <br>
     */
    public int compararPorNombre( Huracan h )
    {
<<<<<<< HEAD
    	verificarInvariante();

    	return nombre.compareToIgnoreCase(h.darNombre());

=======
        // TODO Completar según la documentación del método
>>>>>>> parent of 4f42d80... creando metodos comparar
    }

    /**
     * Compara dos huracanes segï¿½n los daï¿½os estimados. <br>
     * @param h es el huracï¿½n contra el que se estï¿½ comparando. h != null. <br>
     * @return Retorna 0 si los huracanes tienen el mismo costo estimado en daï¿½os. <br>
     *         Retorna -1 si el huracï¿½n h tiene un valor "MAYOR" para el costo estimado en daï¿½os. <br>
     *         Retorna 1 si el huracï¿½n h tiene un valor "MENOR" para el costo estimado en daï¿½os. <br>
     */
    public int compararPorDanios( Huracan h )
    {
<<<<<<< HEAD
    	verificarInvariante();
    	if(costoEstimadoDanios==h.darCostoEstimadoDanios())
    			return 0;
    	else if(costoEstimadoDanios>h.darCostoEstimadoDanios())
    		return -1;
    	else
    		return 1;




=======
        // TODO Completar según la documentación del método
>>>>>>> parent of 4f42d80... creando metodos comparar
    }

    /**
     * Compara dos huracanes segï¿½n la velocidad. <br>
     * @param h es el huracï¿½n contra el que se estï¿½ comparando. h != null. <br>
     * @return Retorna 0 si los huracanes tienen la misma velocidad. <br>
     *         Retorna -1 si el huracï¿½n h tiene un valor "MAYOR" para la velocidad. <br>
     *         Retorna 1 si el huracï¿½n h tiene un valor "MENOR" para la velocidad. <br>
     */
    public int compararPorVelocidad( Huracan h )
    {
      verificarInvariante();

      if(velocidad==h.darVelocidad())
      return 0;
  else if(velocidad>h.darVelocidad())
    return -1;
  else
    return 1;
    }

    /**
     * Retorna una cadena con el nombre del huracï¿½n
     * @return La representaciï¿½n del huracï¿½n en String
     */
    public String toString( )
    {
        // TODO Completar segï¿½n la documentaciï¿½n del mï¿½todo
    }

    // --------------------------------------------------------
    // Invariantes
    // --------------------------------------------------------

    /**
     * @param nombreP es el nombre del huracï¿½n. nombreP != null.
     * @param categoriaP es la categorï¿½a del huracï¿½n. 1 <= categoriaP <= 5.
     * @param velocidadP es la velocidad del viento. 0 <= velocidadP.
     * @param costoEstimadoDaniosP es el costo estimado de daï¿½os. 0 <= costoEstimadoDaniosP.
     * @param imagenP es la ruta a la imagen del huracï¿½n. imagenP != null.
     * @param h es el huracï¿½n contra el que se estï¿½ comparando. h != null.
     */

    private boolean categoriaEsValida(){
    	if(1<=categoria&&categoria<=5)
    		return true;
    	else
		return false;
    }

    private boolean velocidadEsValida(){
    	if(0<=velocidad)
    		return true;
    	else
    		return false;
    }

    private boolean CostoEsValido(){
    	if(0<=costoEstimadoDanios)
    		return true;
    	else
    		return false;
    }



    private void verificarInvariante(){
    	assert nombre !=null:
    		"nombre es vacio";
    	assert categoriaEsValida():
    		"la categoria es invalida";
    	assert velocidadEsValida():
    		"la velocidad es menor que 0";
    	assert CostoEsValido():
    		"costo es menor a 0";
    	assert imagen!= null:
    		"imagen es vacia";

    }
}
