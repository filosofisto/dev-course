package com.cursojava;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;
import static java.lang.System.currentTimeMillis;

public class StatFilter implements Filter {

    private static final Logger log = Logger.getLogger(StatFilter.class.getName());

    private Stat stat;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("Inicializando filtro de estatisticas");
        stat = new Stat();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        long t1 = currentTimeMillis();

        log.info("IP: " + request.getRemoteHost());
        if (!"127.0.0.1".equals(request.getRemoteHost())) {
            chain.doFilter(request, response);
        } else {
            res.setStatus(403);
            return;
        }

        long t2 = currentTimeMillis();

        long tempo = t2-t1;
        stat.add(tempo);


        log.info("Requisicao: " + req.getRequestURI() + " tempo: " + tempo + " ms");
        log.info("Tempo medio: " + stat.media() + " ms");
    }

    @Override
    public void destroy() {
        log.info("Inicializando filtro de estatisticas");
    }
}
