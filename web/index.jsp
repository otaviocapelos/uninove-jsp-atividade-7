<%-- 
    Document   : index
    Created on : 16/05/2019, 20:40:09
    Author     : internet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulário de Emprestimo</title>
    </head>
    <body>
        <h1>Formulário de Emprestimo</h1>
        <form action="ClienteController" method="post">
            <input type="hidden" name="flag" value="cadastrarEmprestimo" />
            <p>Nome: <input type="text" name="nome" size="30" />
            <p>CPF: <input type="text" name="cpf" size="30" />
            <p>Salario: <input type="text" name="salario" size="30" />
            <p>Valor do Emprestimo: <input type="text" name="valorEmprestimo" size="30" />
            <p>Nº Parcelas: <input type="text" name="parcela" size="30" />
            <p> <input type="submit" value="Cadastrar" /> <input type="reset" value="Limpar" />
        </form>
    </body>
</html>
