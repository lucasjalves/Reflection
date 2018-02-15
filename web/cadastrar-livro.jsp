<%@ page
        import="com.github.lucasjalves.livrosshop.core.util.*, java.lang.reflect.*, com.github.lucasjalves.livrosshop.domain.*"%>
<%@ page import="com.github.lucasjalves.livrosshop.domain.entities.Livro" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<form action="SalvarLivro" method="POST">
    <table>

        <%
            Field[] fields = Livro.class.getDeclaredFields();
            for(Field f: fields)
            {
                out.print(HtmlGeneratorUtil.generateFormField(f.getName(), "txt" + f.getName()));
            }
        %>
        <input type="submit" id="operacao" name="operacao" value="SALVAR" />

    </table>
</form>
</body>
</html>