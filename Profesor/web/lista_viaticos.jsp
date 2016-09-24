<%-- 
    Document   : lista_viaticos
    Created on : 23/09/2016, 03:50:30 PM
    Author     : Jazmin Salmeron
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Viaticos</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>  ID Viaticos</tr>
                <tr>-  Monto Solicitado</tr>
                <tr>-  Monto Otorgado</tr>
                <tr>  Monto Comprobado</tr>
                <tr>-  Comprobacion Valida</tr>
                
            </thead>
            <tbody>
                <c:forEach items="${viaticos}" var="viatico">
                    <tr>
                        <td>${viatico.idViaticos}</td>
                        <td>${viatico.montoSolicitado}</td>
                        <td>${viatico.montoOtorgado}</td>
                        <td>${viatico.montoComprobado}</td>
                        <td>${viatico.comprobacionValida}</td>
                        
                        <td> 
                            <a href="ViaticosController?action=cambiar&idViaticos=${viatico.idViatico}">Cambiar</a> 
                        </td>
                        <td> 
                            <a href="ViaticosController?action=borrar&idViaticos=${viatico.idViatico}">Borrar</a> 
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>
            <a href="ViaticosController?action=agregar">AgregarViaticos</a>
        </p>
    </body>
</html>

