package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ConecRemoto {

    private Connection conn = null;

    private final String hostremoto = "codigma.com.mx";
    private final String dbremoto = "codigmac_genesysmi";
    private final String userremoto = "codigmac_codigma";
    private final String passremoto = "departamento03";
    private final String error = "";

    private final String host = "localhost";
    private final String db = "genesysmi";
    private final String user = "root";
    private final String pass = "";

    public ConecRemoto() {
        MySQLAccess();
    }

    private void MySQLAccess() {

        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            conn = DriverManager.getConnection("jdbc:mysql://" + hostremoto + "/" + dbremoto, userremoto, passremoto);
            // Check the state of connection
            if (conn != null) {
                System.out.println("Conexión remota exitosa");
            }

        } catch (ClassNotFoundException | SQLException e) {

            //JOptionPane.showMessageDialog(null,"Error en al conexión"+" "+ e.getMessage(),"ERROR",JOptionPane.INFORMATION_MESSAGE);
            //System.out.println(e);  
        }
    }

    private void MySQLAcceso() {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            conn = DriverManager.getConnection("jdbc:mysql://" + hostremoto + "/" + dbremoto, userremoto, passremoto);
            // Check the state of connection
            if (conn != null) {
                System.out.println("Conexión exitosa");
            }

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en al conexión" + " " + e.getMessage(), "ERROR", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(e);
        }
    }

    public boolean hasError() {
        if (this.error.length() > 0) {
            return true;
        }
        return false;
    }

    public String getError() {
        return this.error;
    }

    public Connection getConn() {
        return conn;
    }

    public boolean executeQuery(String query) {

        Statement sentencias = null;
        ConecRemoto connector = new ConecRemoto();

        Connection con = connector.getConn();

        if (connector.hasError()) {
            return false;
        }

        try {
            //sentencias = con.createStatement(); 
            //sentencias.executeUpdate(query); 
            String[] lista = query.split(";");
            for (int i = 0; i <= lista.length; i++) {
                PreparedStatement preparedStatement = connector.getConn().prepareStatement(lista[i]);
                System.out.println(lista[i]);
                preparedStatement.executeUpdate();
                System.out.println("Exito");
            }
            //sentencias.close(); 
            con.close();

        } catch (Exception e) {
            return false;
        }
        System.out.println("ejecuta");
        return true;

    }

    public String obtenerContenido(java.io.File documento) {
        String sCadena = "";
        String retorno = "";

        if (!documento.exists()) {
            return null;
        }

        try {

            BufferedReader bf = new BufferedReader(new FileReader(documento));
            while ((sCadena = bf.readLine()) != null) {
                retorno += sCadena;
            }

        } catch (FileNotFoundException fnfe) {
            return null;
        } catch (IOException ioe) {
            return null;
        }
        System.out.println("Lee archivo");
        return retorno;
    }

    public boolean importarQuery(java.io.File documento) {
        String query = obtenerContenido(documento);
        borrarContenido(documento);
        return executeQuery(query);
    }

    public void borrarContenido(java.io.File documento) {

        if (documento.exists()) {
            try {
                FileWriter w = new FileWriter(documento);
                BufferedWriter bw = new BufferedWriter(w);
                PrintWriter wr = new PrintWriter(bw);
//escribimos en el archivo una línea vacía
                wr.write("");

                wr.close();
                bw.close();
            } catch (IOException e) {
            };
        } else {
            System.out.println("No se encontro");
        }
    }
}
