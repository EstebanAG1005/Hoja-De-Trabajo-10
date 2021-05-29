/**
 * Hoja de Trabajo #10 - Estructura de Datos
 * --------------------------------------------
 * @Author Esteban Aldana Guerra
 * Clase de Interfaz del grafo
 * Referencias de:
 * https://devs4j.com/2017/11/24/implementa-un-grafo-de-ciudades-en-java/
 */

public interface IntGraph<K, E> {

    public void add(K label);

    /**
     * Agregar subgrafo
     */
    public void addEdge(K ciudad1, K ciudad2, E label);

    public void show();

    public int getIndex(K label);

    /**
     *
     * @param label
     * @return la etiqueta dependiendo de la posicion de la matriz
     */
    public K get(int label);

    /**
     *
     * @param ciudad1
     * @param ciudad2
     * @return la distancia
     */
    public int getEdge(K ciudad1, K ciudad2);

    public boolean contains(K label);

    public int size();
}