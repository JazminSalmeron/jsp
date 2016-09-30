/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.StoreDAOImp;
import model.Store;
import dao.StoreDAO;

public class StoreController extends HttpServlet {

    private final String LISTAR_STORE = "/lista_store.jsp";
    private final String AGREGAR_CAMBIAR = "store.jsp";
    private StoreDAO dao;

    public StoreController() {
        dao = new StoreDAOImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String forward = "";

        response.getWriter().println(action);  
        if (action.equalsIgnoreCase("borrar")) {
            forward = LISTAR_STORE;
            int idPid = Integer.parseInt(request.getParameter("id_pid"));
            dao.borrarStore(idPid);
            request.setAttribute("stores", dao.desplegarStore());
        } else if (action.equalsIgnoreCase("cambiar")) {
            forward = AGREGAR_CAMBIAR;
            int idPid = Integer.parseInt(request.getParameter("id_pid"));
            
            Store store = dao.elegirStore(idPid);
            System.out.println(store);
            request.setAttribute("store", store);
        } else if (action.equalsIgnoreCase("agregar")) {
            forward = AGREGAR_CAMBIAR;
        } else {
            forward = LISTAR_STORE;
            request.setAttribute("stores", dao.desplegarStore());
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);

        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Store store = new Store();
        store.setState(request.getParameter("state"));
        store.setType(request.getParameter("type"));
        store.setVersion(Integer.parseInt(request.getParameter("version")));
        store.setDu(request.getParameter("du"));

        String idPid = request.getParameter("idPid");

        if (idPid == null || idPid.isEmpty()) {
            dao.insertarStore(store);
        } else {
            store.setIdPid(Integer.parseInt(idPid));
            dao.cambiarStore(store);
        }

        RequestDispatcher view = request.getRequestDispatcher(LISTAR_STORE);
        request.setAttribute("stores", dao.desplegarStore());
        view.forward(request, response);

    }
}
