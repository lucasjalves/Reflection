package com.github.lucasjalves.livrosshop.web.servlet;

import com.github.lucasjalves.livrosshop.core.aplicacao.Resultado;
import com.github.lucasjalves.livrosshop.domain.entities.AbstractEntidade;
import com.github.lucasjalves.livrosshop.web.command.Command;
import com.github.lucasjalves.livrosshop.web.command.impl.AtualizarCommand;
import com.github.lucasjalves.livrosshop.web.command.impl.ConsultarCommand;
import com.github.lucasjalves.livrosshop.web.command.impl.DeletarCommand;
import com.github.lucasjalves.livrosshop.web.command.impl.SalvarCommand;
import com.github.lucasjalves.livrosshop.web.viewhelper.ViewHelper;
import com.github.lucasjalves.livrosshop.web.viewhelper.impl.LivroViewHelper;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@WebServlet(value="/SalvarLivro", name="Servlet")
public class Servlet<T> extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static Map<String, Command> commands;
    private static Map<String, ViewHelper> vhs;
    static
    {
        commands = new HashMap<>();
        commands.put("SALVAR", new SalvarCommand());
        commands.put("CONSULTAR", new ConsultarCommand());
        commands.put("DELETAR", new DeletarCommand());
        commands.put("ATUALIZAR", new AtualizarCommand());

        vhs = new HashMap<>();
        vhs.put("/SalvarLivro", new LivroViewHelper());
    }

    public void service(HttpServletRequest request, HttpServletResponse response)
    {
        processRequest(request, response);
    }

    private void  processRequest(HttpServletRequest request, HttpServletResponse response)
    {

        ViewHelper vh = vhs.get(request.getRequestURI());
        T entidade = (T) vh.getEntidades(request);

        Command command = commands.get(request.getParameter("operacao"));
        Resultado resultado = command.executar(entidade);
        vh.setView(resultado, request, response);

    }
}
