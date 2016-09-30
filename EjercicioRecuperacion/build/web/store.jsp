<%-- 

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Procesos</title>
    </head>
    <body>
        <form action="StoreController" method="post">
            <fieldset> 
                <legend> Detalle de Proceso </legend>
                <div>
                    <label for="idPid">ID de Proceso </label>
                    <input type="number" name="idPid" placeholder="Ingresa el ID" value="${store.idPid}" readonly="readonly">
                </div>
                <div>
                    <label for="state">State: </label>
                    <input type="text" name="state" placeholder="Indica tu State" value="${store.state}">
                </div>
                <div>
                    <label for="type">Type: </label>
                    <input type="text" name="type" placeholder="Ingresa tu Type" value="${store.type}">
                </div>
                <div>
                    <label for="version">Version: </label>
                    <input type="number" name="version" placeholder="Inserta la version" value="${store.version}">
                </div>
                <div>
                    <label for="du">DU: </label>
                    <input type="text" name="du" placeholder="Inserta el DU" value="${store.du}">
                </div>
                <div>
                    <input type="submit" value="Guardar">
                </div>
            </fieldset>
        </form>
    </body>
</html>
