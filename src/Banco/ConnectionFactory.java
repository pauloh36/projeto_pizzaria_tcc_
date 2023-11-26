/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jaime
 */
public class ConnectionFactory {

    /*
     * public ConnectionFactory(String newServer, String newPorta, String
     * newSenha) throws FileNotFoundException, IOException {
     * setConnection(newServer, newPorta, newSenha);
    }
     */
    public ConnectionFactory() {
        setConnection("", "", "");
    }
    static String server;
    static String door;
    static String dataBase;
    static String user;
    static String password;

    public String getDataBase() {
        return dataBase;
    }

    public void setDataBase(String dataBase) {
        this.dataBase = dataBase;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public final void setConnection(String newServer, String newPorta, String newSenha) {
        server = newServer;
        door = newPorta;
        dataBase = "mysql";
        user = "root";
        password = newSenha;
    }

    public Connection getConnection(String newServer, String newPorta, String newSenha) {
        try {
            setConnection(newServer, newPorta, newSenha);
            return DriverManager.getConnection("jdbc:mysql://" + server + ":" + door + "/" + dataBase, user, password);
               
        } catch (SQLException excecao) {
            JOptionPane.showMessageDialog(null, "Não foi possivel realizar a conexão!\n Verficar Senha.");
            throw new RuntimeException(excecao);
        }
    }
}
