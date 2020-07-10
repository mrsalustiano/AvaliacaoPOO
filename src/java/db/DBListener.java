/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import controller.DisciplinaController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author re039859
 */
public class DBListener implements ServletContextListener {

    public static final String URL = "jdbc:sqlite:C:\\Users\\re039859\\Documents\\NetBeansProjects\\AvaliacaoPOO\\base.db";
    public static String exceptionMessage = null;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
          try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(URL);
            Statement sts = conn.createStatement();
            String SQL = "CREATE TABLE IF NOT EXISTS disciplina("
                    + "id int not null primary key,"
                    + "nome VARCHAR(100) NOT NULL,"
                    + "dia VARCHAR(50) NOT NULL,"
                    + "hora VARCHAR(10) NOT NULL,"
                    + "total_aulas INTEGER NOT NULL,"
                    + "nota REAL NOT NULL,"
                    + "codigo VARCHAR(10) NOT NULL" + ")";
            sts.executeUpdate(SQL);

            if (new DisciplinaController().buscar().isEmpty()) {
                sts.executeUpdate("INSERT INTO disciplina (id, codigo, nome, dia, hora, total_aulas, nota)"
                        + "VALUES (1,'IBD002' , 'Banco de Dados', 'Terça-Feira', '13:10', 4, 0 )");

                sts.executeUpdate("INSERT INTO disciplina (id, codigo, nome, dia, hora, total_aulas, nota)"
                        + "VALUES (2, 'IES300' , 'Engenharia de Software III', 'Quinta-Feira', '15:00', 4, 0 )");

                sts.executeUpdate("INSERT INTO disciplina (id, codigo, nome, dia, hora, total_aulas, nota)"
                        + "VALUES (3, 'IHC001' , 'Interação Humano Computador', 'Quarta-Feira', '16:50', 2, 0 )");

                sts.executeUpdate("INSERT INTO disciplina (id, codigo, nome, dia, hora, total_aulas, nota)"
                        + "VALUES (4, 'ILP007' , 'Programação Orientada a Objetos', 'Segunda-Feira', '13:10', 4, 0 )");

                sts.executeUpdate("INSERT INTO disciplina (id, codigo, nome, dia, hora, total_aulas, nota)"
                        + "VALUES (5, 'ISG003' , 'Segurança da Informação', 'Sexta-Feira', '16:50', 2, 0 )");

                sts.executeUpdate("INSERT INTO disciplina (id, codigo, nome, dia, hora, total_aulas, nota)"
                        + "VALUES (6, 'ISO200' , 'Sistemas Operacionais II ', 'Terça-Feira e Quarta-Feira', '16:50 e 13:10', 4, 0 )");
            }
            sts.close();
            conn.close();

        } catch (Exception ex) {
            exceptionMessage = ex.getMessage();
        }
        
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
