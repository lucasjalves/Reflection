<%@ page
        import="com.github.lucasjalves.livrosshop.core.util.*, java.lang.reflect.*, com.github.lucasjalves.livrosshop.domain.*"%>
<%@ page import="com.github.lucasjalves.livrosshop.domain.entities.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<form action="SalvarLivro" method="POST">
    <table class="table" style="width: 200px;">
        <%
            Field[] atributos = Livro.class.getDeclaredFields();
            for(Field atributo: atributos)
            {
                out.print(HtmlGeneratorUtil.generateFormField(atributo.getName(), "txt" + atributo.getName()));
            }
        %>
        <tr><td></td>
            <td><input type="submit" id="operacao" name="operacao" value="SALVAR"  /></td>
        </tr>

    </table>
</form>
</body>
</html>