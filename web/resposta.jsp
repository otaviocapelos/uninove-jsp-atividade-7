<%-- 
    Document   : resposta
    Created on : 16/05/2019, 21:33:43
    Author     : internet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body
        <div id ="conteudo">
            <%
                String Mensagem = (String) request.getAttribute("mensagem");
            %>
            <p>
                <%=Mensagem%>
            </p>
            <br>
            <a href="index.jsp">Voltar</a>
        </div>
    </body>
</html>
