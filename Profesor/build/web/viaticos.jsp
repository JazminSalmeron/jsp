<%-- 
    Document   : viaticos
    Created on : 23/09/2016, 03:51:55 PM
    Author     : Jazmin Salmeron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Viaticos</title>
    </head>
    <body>
        <form action="ViaticosController" method="post">
            <fieldset> 
                <legend> Registro de Viaticos </legend>
                <div>
                    <label for="idViatico">ID Viatico: </label>
                    <input type="number" name="idViaticos" placeholder="ID Viatico" value="${viatico.idViatico}" readonly="readonly">
                </div>
                <div>
                    <label for="montoSolicitado">Monto Solicitado: </label>
                    <input type="number" name="montoSolicitado" placeholder="Monto Solicitado" value="${viatico.montoSolicitado}">
                </div>
                <div>
                    <label for="montoOtorgado">Monto Otorgado: </label>
                    <input type="number" name="montoOtorgado" placeholder="Monto Otorgado" value="${viatico.montoOtorgado}">
                </div>
                <div>
                    <label for="montoComprobado">Monto Comprobado: </label>
                    <input type="number" name="montoComprobado" placeholder="Monto Comprobado" value="${viatico.montoComprobado}">
                </div>
                <div>
                    <label for="comprobacionValida">Comprobacion Valida: </label>
                    <input type="text" name="comprobacionValida" placeholder="Comprobacion Valida" value="${viatico.comprobacionValida}">
                </div>
               
                <div>
                    <input type="submit" values="Guardar">
                </div>
            </fieldset>
        </form>
    </body>
</html>
