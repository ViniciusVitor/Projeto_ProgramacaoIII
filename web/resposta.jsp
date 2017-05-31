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
        <link rel="stylesheet" href="./css/respostas.css">
        <title>Respostas</title>
    </head>
    <body background="./imagens/absorvente-interno-externo.jpg">
        
       <div id="interface">
                    <header id="cabecalho">
                        <h2 id="mensagem">Esse é uma pagina de simples conferencia!</br>
                            Você não poderá alterar nada!.
                        </h2>
                    </header>
            <center>
                <table border = "1" id="tabela">
                    <%
                        if(!agenda.isEmpty()){   
                    %>
                    <tr>
                        <th>Nome</th>
                        <th>Idade</th>
                        <th>Ciclo</th>
                        <th>Última data</th>
                        <th>Proxima data</th>
                    </tr>

                    <%
                        for(Mulher m: agenda){%>

                        <tr>
                            <td><center><%= m.getNome() %></center></td>
                            <td><center><%= m.getIdade() %></center></td>
                            <td><center><%= m.getCiclo() %></center></td>
                            <td><center><%= m.getData() %></center></td>
                            <td><center><%= m.getDataFinal() %></center></td>


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
                </br>
                <input type="button" value="Voltar" onclick="history.go(-1)"/>
                </br>
                <footer id="rodape">Alef, Bianca, Matheus e Vinicius</footer>
            </center>
        </div>
    </body>
</html>
