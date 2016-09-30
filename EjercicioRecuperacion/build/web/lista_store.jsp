<%-- 

--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>STORE PROCESS</title>
    </head>
    <body>
        <table>
            <thead>
                <th>  PID</th>
                <th>  State</th>
                <th>  Type</th>
                <th>  Version</th>
                <th>  DU </th>
            </thead>
            <tbody>
                <c:forEach items="${stores}" var="store">
                    <tr>
                        <td>${store.idPid}</td>
                        <td>${store.state}</td>
                        <td>${store.type}</td>
                        <td>${store.version}</td>
                        <td>${store.du}</td>
                        <td> 
                            <a href="StoreController?action=cambiar&id_pid=${store.idPid}">Cambiar</a> 
                        </td>
                        <td> 
                            <a href="StoreController?action=borrar&id_pid=${store.idPid}">Borrar</a> 
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>
            <a href="StoreController?action=agregar">Agregar Store Process</a>
        </p>
    </body>
</html>
