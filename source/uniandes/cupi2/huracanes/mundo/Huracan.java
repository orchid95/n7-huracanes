/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Huracan.java,v 1.4 2008/09/12 11:22:48 jua-gome Exp $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_huracanes
 * Autor: Juan Camilo Cort�s Medina - 05-ago-2008
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.huracanes.mundo;

/**
 * Esta clase representa un hurac�n. <br>
 * <b> inv: </b> <br>
 * TODO Definir y documentar el invariante de la clase
 */
public class Huracan
{
    // --------------------------------------------------------
    // Atributos
    // --------------------------------------------------------

    /**
     * Nombre del hurac�n
     */
    private String nombre;

    /**
     * Categor�a del hurac�n seg�n el sistema Saffir - Simpson
     */
    private int categoria;

    /**
     * Velocidad del viento en km / h
     */
    private int velocidad;

    /**
     * Costo estimado en da�os expresado en millones de d�lares.
     */
    private double costoEstimadoDanios;

    /**
     * La ruta hasta la imagen del hurac�n
     */
    private String imagen;

    // --------------------------------------------------------
    // Constructores
    // --------------------------------------------------------

    /**
     * Construye un nuevo hurac�n con los par�metros indicados <br>
     * <b>post: </b> Se construy� un hurac�n con los par�metros indicados
     * @param nombreP es el nombre del hurac�n. nombreP != null.
     * @param categoriaP es la categor�a del hurac�n. 1 <= categoriaP <= 5.
     * @param velocidadP es la velocidad del viento. 0 <= velocidadP.
     * @param costoEstimadoDaniosP es el costo estimado de da�os. 0 <= costoEstimadoDaniosP.
     * @param imagenP es la ruta a la imagen del hurac�n. imagenP != null.
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
    // M�todos
    // --------------------------------------------------------

    /**
     * Retorna el nombre del hurac�n
     * @return el nombre del hurac�n
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna la categor�a del hurac�n
     * @return la categor�a del hurac�n
     */
    public int darCategoria( )
    {
        return categoria;
    }

    /**
     * Retorna la velocidad del hurac�n
     * @return la velocidad del hurac�n
     */
    public int darVelocidad( )
    {
        return velocidad;
    }

    /**
     * Retorna el costoEstimadoDanios del hurac�n
     * @return el costoEstimadoDanios del hurac�n
     */
    public double darCostoEstimadoDanios( )
    {
        return costoEstimadoDanios;
    }

    /**
     * Retorna la ruta a la imagen del hurac�n.
     * @return La imagen del hurac�n
     */
    public String darImagen( )
    {
        return imagen;
    }

    /**
     * Compara dos huracanes seg�n el nombre. <br>
     * @param h es el hurac�n contra el que se est� comparando. h != null. <br>
     * @return Retorna 0 si los huracanes tienen el mismo nombre. <br>
     *         Retorna -1 si el hurac�n h tiene un valor "MAYOR" para el nombre. <br>
     *         Retorna 1 si el hurac�n h tiene un valor "MENOR" para el nombre. <br>
     */
    public int compararPorNombre( Huracan h )
    {
<<<<<<< HEAD
    	verificarInvariante();

    	return nombre.compareToIgnoreCase(h.darNombre());

=======
        // TODO Completar seg�n la documentaci�n del m�>>>>>>> parent of 4f42d80... creando metodos comparar
    }

    /**
     * Compara dos huracanes seg�n los da�os estimados. <br>
     * @param h es el hurac�n contra el que se est� comparando. h != null. <br>
     * @return Retorna 0 si los huracanes tienen el mismo costo estimado en da�os. <br>
     *         Retorna -1 si el hurac�n h tiene un valor "MAYOR" para el costo estimado en da�os. <br>
     *         Retorna 1 si el hurac�n h tiene un valor "MENOR" para el costo estimado en da�os. <br>
     */
    public int compararPorDanios( Huracan h )
    {
    	verificarInvariante();
    	if(costoEstimadoDanios==h.darCostoEstimadoDanios())
    			return 0;
    	else if(costoEstimadoDanios>h.darCostoEstimadoDanios())
    		return -1;
    	else
    		return 1;




    }

    /**
     * Compara dos huracanes seg�n la velocidad. <br>
     * @param h es el hurac�n contra el que se est� comparando. h != null. <br>
     * @return Retorna 0 si los huracanes tienen la misma velocidad. <br>
     *         Retorna -1 si el hurac�n h tiene un valor "MAYOR" para la velocidad. <br>
     *         Retorna 1 si el hurac�n h tiene un valor "MENOR" para la velocidad. <br>
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
     * Retorna una cadena con el nombre del hurac�n
     * @return La representaci�n del hurac�n en String
     */
    public String toString( )
    {
        // TODO Completar seg�n la documentaci�n del m�todo
    }

    // --------------------------------------------------------
    // Invariantes
    // --------------------------------------------------------

    /**
     * @param nombreP es el nombre del hurac�n. nombreP != null.
     * @param categoriaP es la categor�a del hurac�n. 1 <= categoriaP <= 5.
     * @param velocidadP es la velocidad del viento. 0 <= velocidadP.
     * @param costoEstimadoDaniosP es el costo estimado de da�os. 0 <= costoEstimadoDaniosP.
     * @param imagenP es la ruta a la imagen del hurac�n. imagenP != null.
     * @param h es el hurac�n contra el que se est� comparando. h != null.
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
