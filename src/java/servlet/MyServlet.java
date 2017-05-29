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

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            
             Mulher m = new Mulher();
            
            String nome = request.getParameter("nome");
            String idade = request.getParameter("idade");
            String ciclo = request.getParameter("ciclo");
            String data = request.getParameter("data");
            
            ArrayList<Mulher> lista =  new ArrayList();
           
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
            
            if(m.getCiclo().equals("Regular")){
                calendario.add(calendario.DATE, 28);
            }else{
                calendario.add(calendario.DATE, 30);
            }
            
            
            int newYear = calendario.get(Calendar.YEAR);
            int newMonth = calendario.get(Calendar.MONTH);
            int newDay = calendario.get(Calendar.DAY_OF_MONTH);
            
            String dataFinal = (newDay+"/"+newMonth+"/"+newYear);
            
            m.setDataFinal(dataFinal);
            lista.add(m);
              
            request.setAttribute("agenda", lista);
           
            String pagina = "/resposta.jsp";
           
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);

            
            
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
