<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="estilo.css"/>
        <title>Exercício Avaliativo</title>
    </head>
    <body>
        <div class="corpo">
            <%
                int a = 0;
                if(request.getAttribute("acessos") != null)
                    a = (int)(request.getAttribute("acessos"));                        
            %>

            <div align="center"> <h1>Sessão de Usuários</h1></div><br>
            <form name="formulario" action="Contador" method="POST">
                <table align="center">
                    <div>
                        <tr>
                            <td>Usuário:</td>
                            <td><input type="text" name="usuario"/></td>
                        <tr>
                    </div>
                    <div>
                        <tr>
                            <td>Senha:</td>
                            <td><input type="text" name="senha"/></td>
                        <tr>
                    </div><br>
                </table>
                <table align="center">
                    <div>
                        <tr><td></td></tr>
                        <tr><td><b> ACESSOS = <%= a %> </b></td></tr>
                    </div><br>
                </table><br><br><br>
                <div align="center">
                    <input type="submit" name="ok" value="OK"/>
                </div>
            </form>
        </div>
    </body>
</html>
