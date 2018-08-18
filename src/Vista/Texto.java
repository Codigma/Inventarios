/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.ConecRemoto;
import java.io.*;
import java.net.URL;
import java.sql.PreparedStatement;
import java.util.Vector;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author luism
 */
public class Texto {

    public void escribir(String consulta) {

        File f;
        f = new File("src/Modelo/Consulta.txt");
        if (f.exists()) {
            try {
                FileWriter w = new FileWriter(f, true);
                BufferedWriter bw = new BufferedWriter(w);
                PrintWriter wr = new PrintWriter(bw);
                wr.write(consulta);//escribimos en el archivo
                wr.append("\r\n"); //concatenamos en el archivo sin borrar lo existente
                wr.close();
                bw.close();
            } catch (IOException e) {
            };
        } else {
            System.out.println("No se encontro");
        }
    }

    public void Leer() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            ConecRemoto conex = new ConecRemoto();
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("src/Modelo/Consulta.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            if (archivo.length() > 0) {
                // Lectura del fichero
                String linea, aux = "";
                int pos = 0;
                while ((linea = br.readLine()) != null) {
                    aux.concat(linea + " ");
                    pos++;

                    if (aux.contains(";")) {
                        PreparedStatement preparedStatement = conex.getConn().prepareStatement(aux);
                        preparedStatement.executeQuery();
                        aux = "";
                    } else {
                        System.out.println("Continua consulta");
                    }
                    BorrarLinea(pos);

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void BorrarLinea(int n) {
        Vector lineas = new Vector();
        try {
            File archivo = new File("src/Modelo/Consulta.txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            int cont = 0;
            while ((linea = br.readLine()) != null) {
                cont++;
                if (cont != n) {
                    lineas.addElement(linea);//AGREGAR LINEAS A UN VECTOR
                }
            }
            br.close();
            fr.close();
            //Se guarda de nuevo el archivo
            GuardarArchivo(lineas);
            lineas.clear();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void GuardarArchivo(Vector ln) {
        try {
            FileWriter fichero = new FileWriter("src/Modelo/Consulta.txt");
            PrintWriter escribe = new PrintWriter(fichero);
            for (int i = 0; i < ln.size(); i++) {
                escribe.println(ln.elementAt(i));
            }
            fichero.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        Integer amount;
        String textCant = "2";
        if (!textCant.equals("")) {
            System.out.print("No tiene nada");
            amount = Integer.parseInt(textCant);
            System.out.print(amount);
        }
    }

}
