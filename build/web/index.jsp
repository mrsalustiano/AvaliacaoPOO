<%-- 
    Document   : index
    Created on : 10/07/2020, 12:19:03
    Author     : re039859
--%>
<%@page import="controller.DisciplinaController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>Controle de Notas - Inicio</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        
    </head>
    <body>
              <h1>Controle de Notas </h1>
        <hr>
        <p> Nome: <strong>Marcelo Salustiano Silva</strong></p>
        <p>RA: <strong>1290481912043</strong></p>
        <p>Ciclo: <strong> 5° </strong></p>
        <hr>
        <p> Total de Disciplinas Matriculadas : <strong> <%= new DisciplinaController().buscar().size() %> </strong>
        <hr>
        
        <a class="btn btn-primary" href="listar.jsp"> Listagem de Disciplinas Matriculadas </a>
        
    </body>
</html>
