/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.DBListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Disciplina;

/**
 *
 * @author re039859
 */
public class DisciplinaController {
    
      public ArrayList<Disciplina> buscar() throws SQLDataException, ClassNotFoundException, SQLException {
        ArrayList<Disciplina> listar = new ArrayList<>();
        String SQL = "Select id,codigo, nome, dia, hora, nota, total_aulas from disciplina";
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(DBListener.URL);
        PreparedStatement pstm = conn.prepareStatement(SQL);

        ResultSet result = pstm.executeQuery();

        while (result.next()) {
            Disciplina disciplina = new Disciplina();
            disciplina.setNome(result.getString("nome"));
            disciplina.setCodigo(result.getString("codigo"));
            disciplina.setDia(result.getString("dia"));
            disciplina.setHora(result.getString("hora"));
            disciplina.setNota(result.getDouble("nota"));
            disciplina.setTotal_aulas(result.getInt("total_aulas"));
            disciplina.setId(result.getInt("id"));
            listar.add(disciplina);
        }
        result.close();
        pstm.close();
        conn.close();

        return listar;

    }

    @SuppressWarnings("ConvertToTryWithResources")
    public Disciplina buscaDisciplina(Integer id) throws SQLException, ClassNotFoundException {
        Disciplina disciplina = new Disciplina();
        String query = "SELECT id,codigo, nome, dia, hora, nota, total_aulas FROM disciplina WHERE id = ?";

        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(DBListener.URL);
        PreparedStatement pstm = conn.prepareStatement(query);
        pstm.setInt(1, id);
        ResultSet result = pstm.executeQuery();

        if (result.next()) {
             disciplina.setNome(result.getString("nome"));
            disciplina.setCodigo(result.getString("codigo"));
            disciplina.setDia(result.getString("dia"));
            disciplina.setHora(result.getString("hora"));
            disciplina.setNota(result.getDouble("nota"));
            disciplina.setTotal_aulas(result.getInt("total_aulas"));
            disciplina.setId(result.getInt("id"));

        }

        result.close();
        pstm.close();
        conn.close();

        return disciplina;
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public void atualizaNota(Double notaFinal, Integer id) throws SQLException, ClassNotFoundException {
        String query = "UPDATE disciplina SET nota = ? WHERE id = ?";
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(DBListener.URL);
        PreparedStatement pstm = conn.prepareStatement(query);

        pstm.setDouble(1, notaFinal);
        pstm.setInt(2, id);
        pstm.execute();

        pstm.close();
        conn.close();

    }
    
}
