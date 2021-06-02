/**
 * Hoja de Trabajo #10 - Estructura de Datos
 * --------------------------------------------
 * @Author Esteban Aldana Guerra
 * Clase Main
 * Referencias de:
 * https://devs4j.com/2017/11/24/implementa-un-grafo-de-ciudades-en-java/
 *
 */

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Floyd matriz = new Floyd();
        int op = 0;
        int opcion;
        boolean salir = true;
        Scanner scan = new Scanner(System.in);

       
        while (salir) {
            try{
            System.out.println("----------------Respuesta al COVID 19-------------------");
            System.out.println("1. Ciudad de Origen-Ciudad de Destino");
            System.out.println("2. Centro del Grafo");
            System.out.println("3. Modificar el Grafo");
            System.out.println("4. Salir");
            System.out.println("Ingrese una opcion: ");
            op = scan.nextInt();

            if (op == 1) {
                matriz.CamCorto();
                System.out.println("Ciudad de Origen: ");
                String ciudad1 = scan.next();
                System.out.println("Ciudad de Destino: ");
                String ciudad2 = scan.next();
                if (matriz.D.contains(ciudad1) && matriz.D.contains(ciudad2)) {
                    System.out.println("\nEl recorrido mas corto es :" + matriz.D.getEdge(ciudad1, ciudad2));
                    if (matriz.D.getEdge(ciudad1, ciudad2) != 10000) {
                        System.out.println("La ruta es" + ciudad1);
                        try {
                            matriz.Intermedios(matriz.D.getIndex(ciudad1), matriz.D.getIndex(ciudad2));
                        } catch (Exception e) {
                            System.out.println("");
                        }
                        System.out.println("," + ciudad2);
                    }
                }
            } else if (op == 2) {
                System.out.println("El centro del grafo es: ");
                matriz.CentGrafo();
            } else if (op == 3) {
                System.out.println("1.Interrumpir el flujo entre ciudades");
                System.out.println("2. Fijar nueva conexión");
                System.out.println("Ingrese una opción: ");
                opcion = scan.nextInt();
                if (opcion == 1) {
                    System.out.println("Ciudad de Origen: ");
                    String ciudad1 = scan.next();
                    System.out.println("Ciudad de Destino: ");
                    String ciudad2 = scan.next();
                    if (matriz.D.contains(ciudad1) && matriz.D.contains(ciudad2)) {
                        matriz.D.addEdge(ciudad1, ciudad2, 10000);
                        try {
                            matriz.a.Write(ciudad1 + " " + ciudad2 + "10000");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }

                if (opcion == 2) {
                    System.out.println("Ciudad de Origen: ");
                    String ciudad1 = scan.next();
                    System.out.println("Ciudad de Destino: ");
                    String ciudad2 = scan.next();
                    System.out.println("Distancia en KM entre las dos ciudades: ");
                    int dist = scan.nextInt();
                    if (matriz.D.contains(ciudad1) && matriz.D.contains(ciudad2)) {
                        matriz.D.addEdge(ciudad1, ciudad2, dist);
                    } else {
                        matriz.D.add(ciudad1);
                        matriz.D.add(ciudad2);
                        matriz.D.addEdge(ciudad1, ciudad2, dist);
                    }
                    try {
                        matriz.a.Write(ciudad1 + " " + ciudad2 + " " + dist);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                matriz.CamCorto();
            } if (op == 4){
                System.out.println("Gracias por utilizar el programa :) ");
                salir = false;
            }
        } catch(Exception e) {
            System.out.println("Error, ha ingresado un termino incorrecto");
            scan.next();
        }
    }
    }
}