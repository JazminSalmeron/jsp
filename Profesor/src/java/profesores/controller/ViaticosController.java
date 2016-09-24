/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profesores.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import profesores.dao.ViaticosDAO;
import profesores.dao.ViaticosDAOI;
import profesores.model.Viaticos;

/**
 *
 * @author Jazmin Salmeron
 */

public class ViaticosController extends HttpServlet{
    private final String LISTA_VIATICOS = "/lista_viaticos.jsp";
    private final String AGREGAR_CAMBIAR = "/viaticos.jsp";
    private ViaticosDAO dao;

    public ViaticosController() {
        dao = new ViaticosDAOI();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String forward = "";

        
        if (action.equalsIgnoreCase("borrar")) {
            forward = LISTA_VIATICOS;
            int idViaticos = Integer.parseInt(request.getParameter("idViaticos"));
            dao.borrarViaticos(idViaticos);
            request.setAttribute("viaticos", dao.desplegarViaticos());
        } else if (action.equalsIgnoreCase("cambiar")) {
            forward = AGREGAR_CAMBIAR;
            int idViaticos = Integer.parseInt(request.getParameter("idViaticos"));
            Viaticos viatico = dao.elegirViaticos(idViaticos);
            request.setAttribute("viatico", viatico);
      
            
        } else if (action.equalsIgnoreCase("agregar")) {
            forward = AGREGAR_CAMBIAR;
        } else {
            forward = LISTA_VIATICOS;
            request.setAttribute("viaticos", dao.desplegarViaticos());
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);

        view.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Viaticos viatico = new Viaticos();
       
        viatico.setMontoSolicitado(Integer.parseInt(request.getParameter("montoSolicitado")));
        viatico.setMontoOtorgado(Integer.parseInt(request.getParameter("montoOtorgado")));
        viatico.setMontoComprobado(Integer.parseInt(request.getParameter("montoComprobado")));
        viatico.setComprobacionValida(request.getParameter("comprobacionValida "));

        String idViaticos = request.getParameter("idViaticos");

        if (idViaticos == null || idViaticos.isEmpty()) {
            dao.agregarViaticos(viatico);
        } else {
            viatico.setIdViaticos(Integer.parseInt(idViaticos));
            dao.cambiarViaticos(viatico);
        }

        RequestDispatcher view = request.getRequestDispatcher(LISTA_VIATICOS);
        request.setAttribute("viaticos", dao.desplegarViaticos());
        view.forward(request, response);

    }
    
}
