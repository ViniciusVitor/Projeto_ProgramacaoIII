<%-- 
    Document   : index1
    Created on : 27/05/2017, 22:12:10
    Author     : vinicius
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario</title>
        <link rel="stylesheet" href="../css/index.css">
    </head>
    <body background="../imagens/absorvente-interno-externo.jpg"> 
        <form id="Formulario" action="MyServlet">
                <div id="interface">
                    <header id="cabecalho">
                        <h2 id="mensagem">Olá! Obrigado por fazer parte dessa pesquisa!</br>
                            Por favor, responda as questões de maneira séria!.
                        </h2>
                    </header>
                    <center>
                        <div id="campos">
                            <h4>Nome: </br><input type="text" name="nome" value="" size="50" id="nome"/></h4>
                            <h4>Idade: </br><input type="text" name="idade" value="" size="2" id="idade"/></h4>
                            <h4>Ciclo Menstrual: </br><select name="ciclo" id="ciclo">
                                    <option>.......</option>
                                    <option>Regular</option>
                                    <option>Inregular</option>
                                </select></h4>

                            <h4>Data da última menstruação: </br><input type="text" name="data" value="" id="data"/></h4>
                            </br>
                        </div>                      
                    </center>
                    
                    <div id="botoes">
                            <input type="submit" value="Enviar respostas" name="Enviar" id="butonEnviar"/>
                            <input type="submit" value="Cancelar" name="Cancelar" id="butonCancelar" />
                            
                            <div>
                                 <br/>
                                 <br/>
                                <footer id="rodape">Alef, Bianca, Matheus e Vinicius</footer>
                            </div>
                    </div>
                        
                </div>
        </form>
    </body>
</html>
