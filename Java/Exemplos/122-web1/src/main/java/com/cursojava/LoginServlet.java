package com.cursojava;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

/*@WebServlet(name = "Login", urlPatterns = "login")*/
public class LoginServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(LoginServlet.class.getName());

    public void init() throws ServletException {
        log.info("Inicializando servlet Login");
    }

    /*
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    }*/

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        log.info("Tentativa de autenticacao usuario " + email);
        if (senha != null) {
            log.info("Senha informada");
        }

        /*RequestDispatcher dispatcher = req.getRequestDispatcher("/index.html");
        dispatcher.forward(req, resp);*/

        /*PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<h1>Congratulations " + email + ", welcome</h1>");
        writer.println("</body>");
        writer.println("</html>");*/

        String pathPDF = getServletContext().getRealPath("/WEB-INF/pdf/comprovante.pdf");
        Path path = Paths.get(pathPDF);
        byte[] bytes = Files.readAllBytes(path);

        resp.setContentType("application/pdf");
        resp.setHeader("Content-disposition", "attachment; filename=\"comprovante.pdf\"");

        OutputStream out = resp.getOutputStream();
        out.write(bytes);
        out.close();


        //if ("filosofisto@hotmail.com".equals(email))
    }

    public void destroy() {
        log.info("Destruindo servlet login");
    }
}
