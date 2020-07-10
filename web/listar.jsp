<%-- 
    Document   : listar
    Created on : 10/07/2020, 12:26:29
    Author     : re039859
--%>
<%@page import="model.Disciplina"%>
<%@page import="controller.DisciplinaController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           <title>Controle de Notas - Listagem</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        
    </head>
    <body>
            <h1>Listagem de Disciplinas em Curso</h1>
        <br>
        <a class="btn btn-primary" href="index.jsp">Home </a>
        <br>
        <hr>
        <table class="table" >
            <thead class="thead-dark">
                <tr>
                    <th>Codigo </th>
                    <th>Nome </th>
                    <th>Dia da Semana </th>
                    <th>Horario </th>
                    <th>Quantidade de Aulas </th>
                    <th>Nota </th>
                    <th>Ações</th>
                        
                </tr>
            </thead>
            
            <tbody>
                <%for(Disciplina dis : new DisciplinaController().buscar()) {%>
                <tr>
                    <td> <%= dis.getCodigo() %> </td>
                    <td> <%= dis.getNome() %> </td>
                    <td> <%= dis.getDia()%> </td>
                    <td> <%= dis.getHora()%> </td>
                    <td> <%= dis.getTotal_aulas()%> </td>
                    <td> <%= dis.getNota() %> </td>
                    <td> <a class="btn btn-primary" href="consulta.jsp?id=<%=dis.getId()%>">Editar </a></td>
                    
                    
                    
                </tr>
                <%} %>
                
                
            </tbody>
        </table>
    </body>
</html>
