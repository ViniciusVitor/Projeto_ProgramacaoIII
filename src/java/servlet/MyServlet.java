/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pessoa.Mulher;

/**
 *
 * @author vinicius
 */
@WebServlet(name = "MyServlet", urlPatterns = {"/MyServlet"})
public class MyServlet extends HttpServlet {

    private ArrayList<Mulher> mulheres = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Mulher m = new Mulher();

        String nome = request.getParameter("nome");
        String idade = request.getParameter("idade");
        String ciclo = request.getParameter("ciclo");
        String data = request.getParameter("data");

        m.setNome(nome);
        m.setIdade(idade);
        m.setCiclo(ciclo);
        m.setData(data);

        //Metodo tranformar data
        Integer ano = new Integer(data.substring(0, 4));
        Integer mes = new Integer(data.substring(5, 7));
        Integer dia = new Integer(data.substring(8, 10));

        Calendar calendario = Calendar.getInstance();
        calendario.set(ano, mes, dia);
        String dataFinal;
       
        
       
        
        if (m.getCiclo().equals("Regular")) {
            calendario.add(calendario.DATE, 28);
            int newYear = calendario.get(Calendar.YEAR);
            int newMonth = calendario.get(Calendar.MONTH);
            int newDay = calendario.get(Calendar.DAY_OF_MONTH);
            dataFinal = (newDay + "/" + newMonth + "/" + newYear); 
         
            

           

        }else{
            calendario.add(calendario.DATE, 26); 
             int newYear = calendario.get(Calendar.YEAR);
            int newMonth = calendario.get(Calendar.MONTH);
            int newDay = calendario.get(Calendar.DAY_OF_MONTH);
            dataFinal = ("Semana a partir do dia: "+newDay + "/" + newMonth + "/" + newYear); 
         
            
        }
       m.setDataFinal(dataFinal);
       
             
       
        
        mulheres.add(m);

        request.setAttribute("agenda", mulheres);

        String pagina = "/resposta.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
        dispatcher.forward(request, response);
    }

    public ArrayList<Mulher> getMulheres() {
        return mulheres;
    }

}
