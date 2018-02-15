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


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static Map<String, Command> commands;
    private static Map<String, ViewHelper> vhs;
    public Servlet()
    {
        commands = new HashMap<>();
        commands.put("SALVAR", new SalvarCommand());
        commands.put("CONSULTAR", new ConsultarCommand());
        commands.put("DELETAR", new DeletarCommand());
        commands.put("ATUALIZAR", new AtualizarCommand());

        vhs = new HashMap<>();
        vhs.put("/SalvarLivro", new LivroViewHelper());
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
    {
        System.out.println("processando requisição...");
        String uri = request.getRequestURI();
        String operacao = request.getParameter("operacao");


        ViewHelper vh = vhs.get(uri);

        AbstractEntidade entidade =  vh.getEntidades(request);

        System.out.println("indo para..." + commands.get(operacao).getClass().getSimpleName());
        Command command = commands.get(operacao);
        Resultado resultado = command.executar(entidade);


        vh.setView(resultado, request, response);
    }
}
