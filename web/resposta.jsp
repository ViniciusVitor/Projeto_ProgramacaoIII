<%-- 
    Document   : resposta
    Created on : 27/05/2017, 22:12:52
    Author     : vinicius
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="pessoa.Mulher"%>
<% 
    ArrayList<Mulher> agenda = (ArrayList<Mulher>) request.getAttribute("agenda");

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Respostas</title>
    </head>
    <body>
        <table border = "1">
            <%
                if(!agenda.isEmpty()){   
            %>
            <tr>
                <th>Nome</th>
                <th>Idade</th>
                <th>Ciclo</th>
                <th>Data</th>
            </tr>
            
            <%
                for(Mulher m: agenda){%>
              
                <tr>
                    <td><%= m.getNome() %></td>
                    <td><%= m.getIdade() %></td>
                    <td><%= m.getCiclo() %></td>
                    <td><%= m.getData() %></td>
                    
                </tr>
            <%
                }            
          
            }
            else{%>
            <tr>
                <td>Não há informacao</td>
            </tr>
                <%}%>
        </table>
    </body>
</html>
