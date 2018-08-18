/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author luism
 */
public class SystemDao {

    public SystemVo getUser(String id, String pass) {

        Conectarse conn = new Conectarse();

        SystemVo usuario = new SystemVo();
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT id_user, user, password  "
                    + "FROM users_system "
                    + "WHERE user =? and password =? ");

            preparedStatement.setString(1, id);
            preparedStatement.setString(2, pass);
            ResultSet resultSet = preparedStatement.executeQuery();

            //Muestra resultados de la consulta SQL
            while (resultSet.next()) {

                usuario.setId_user(resultSet.getInt(1));
                usuario.setUser(resultSet.getString(2));
                usuario.setPassword(resultSet.getString(3));

            }
            //Cierra todo
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //Retorna el usuario
        return usuario;
    }

}
