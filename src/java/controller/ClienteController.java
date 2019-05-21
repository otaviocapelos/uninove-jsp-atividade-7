/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jpa.Cliente;
import jpa.ClienteDAO;

/**
 *
 * @author internet
 */
@WebServlet(name = "ClienteController", urlPatterns = {"/ClienteController"})
public class ClienteController extends HttpServlet {

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
            String flag = request.getParameter("flag");
            if (flag.equalsIgnoreCase("cadastrarEmprestimo")) {
                Cliente cliente = new Cliente();
                cliente.setNome(request.getParameter("nome"));
                cliente.setCpf(request.getParameter("cpf"));
                cliente.setSalario(Double.parseDouble(request.getParameter("salario")));
                Double valorEmprestimo = Double.parseDouble(request.getParameter("valorEmprestimo"));
                Integer parcela = Integer.parseInt(request.getParameter("parcela"));
                cliente.setStatus(valorEmprestimo, parcela);
                EntityManagerFactory emf
                        = Persistence.createEntityManagerFactory("MySQL");
                EntityManager em = emf.createEntityManager();
                ClienteDAO dao = new ClienteDAO(em);
                em.getTransaction().begin();
                dao.grava(cliente);
                em.getTransaction().commit();
                em.close();
                emf.close();
                String mensagem = cliente.getStatus();
                request.setAttribute("mensagem", mensagem);
                RequestDispatcher dispatcher = request.getRequestDispatcher("resposta.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception ex) {
            throw ex;
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
