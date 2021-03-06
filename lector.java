/**
 * Hoja de Trabajo #10 - Estructura de Datos
 * --------------------------------------------
 * @Author Esteban Aldana Guerra
 * Clase para el lector del archivo txt
 */

import java.io.*;

public class lector {

    File doc;
    FileReader filer;
    BufferedReader buffer;
    FileWriter fw;
    PrintWriter pw;
    IntGraph graf = new Graph<>();

    public void ReadFile(String direccion) throws FileNotFoundException {
        doc = new File(direccion);
        filer = new FileReader(doc);
        buffer = new BufferedReader(filer);
        String linea;
        try {
            while ((linea = buffer.readLine()) != null) {
                String[] word;
                word = linea.split(" ");
                graf.add(word[0]);
                graf.add(word[1]);
            }
        } catch (IOException e) {
        }
        System.out.println("No se ha encontrado el archivo");
    }

    /**
     *
     * @return Los arcos
     * @throws IOException
     */
    public IntGraph<String, String> arreglosN() throws IOException {
        filer = new FileReader(doc);
        buffer = new BufferedReader(filer);
        String linea;
        while ((linea = buffer.readLine()) != null) {
            String[] arc;
            arc = linea.split(" ");
            graf.addEdge(arc[0], arc[1], arc[2]);
        }
        return graf;
    }

    /**
     * Escribe el archivo de texto
     *
     * @param cadena
     * @throws IOException
     */
    public void Write(String cadena) throws IOException {
        fw = new FileWriter(doc);
        pw = new PrintWriter(fw);
        pw.println(cadena);
    }

    public IntGraph<String, String> CostoM() throws IOException {
        // Lectura del fichero
        filer = new FileReader(doc);
        buffer = new BufferedReader(filer);
        String linea;

        while ((linea = buffer.readLine()) != null) {
            String[] tmp;
            tmp = linea.split(" ");
            graf.addEdge(tmp[0], tmp[1], tmp[2]);
        }
        return graf;
    }

}