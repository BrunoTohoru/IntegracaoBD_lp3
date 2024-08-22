/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe de conexão com o banco de dados
 * Usuário: root
 * Senha: ""
 * 
 * Utilizamos esta estrutura para evitar repetição de codigo
 * e simplifacar a obtenção de conexão com o banco de dados.
 * 
 * @Bruno TS
 */
public class ConnectionFactory {
    
    //Nome do usuário do MySQL
    private static final String USERNAME = "root";
    
    //Senha do MySQL
    private static final String PASSWORD = "";
    
    //String de conexão com o banco de dados
    //Porta e nome do banco de dados no qual pretende-se conectar
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/ifpr";
    
    public static Connection createConnectionToMySQL(){
        
        try{
            
            // Criar uma conexão com o banco de dadoS
            Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            return connection;
        }catch(SQLException ex){
            System.out.println("Erro de conexão com o BD: "+ ex.getMessage());
            System.out.println(USERNAME);
            System.out.println(DATABASE_URL);
            return null;
        }
    }
    
    public static void main(String[] args) {
        Connection con = createConnectionToMySQL();
        if (con != null){
            System.out.println("Conexão foi! " + con);
        }else{
            System.out.println("Não deu! Fudeu!");
        }
    }
}
