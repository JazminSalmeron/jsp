<%-- 
    Document   : lista_profesores
    Created on : 21/09/2016, 10:34:46 AM
    Author     : Felipe
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Profesores</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>  ID Profesor</tr>
                <tr>-  Nombre</tr>
                <tr>-  Experiencia</tr>
                <tr>-  Carrera</tr>
            </thead>
            <tbody>
                <c:forEach items="${profesores}" var="profesor">
                    <tr>
                        <td>${profesor.idProfesor}</td>
                        <td>${profesor.nombre}</td>
                        <td>${profesor.experiencia}</td>
                        <td>${profesor.carrera}</td>
                        <td> 
                            <a href="ProfesorController?action=cambiar&idProfesor=${profesor.idProfesor}">Cambiar</a> 
                        </td>
                        <td> 
                            <a href="ProfesorController?action=borrar&idProfesor=${profesor.idProfesor}">Borrar</a> 
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>
            <a href="ProfesorController?action=agregar">AgregarProfesor</a>
        </p>
    </body>
</html>
