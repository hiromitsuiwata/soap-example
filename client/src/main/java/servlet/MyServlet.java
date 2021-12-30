package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.Main;

@WebServlet("/myservlet")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html; charset=utf-8");
        try (PrintWriter out = res.getWriter()) {
            out.println("<html><body>");
            out.println("サーブレット: Hello Servlet World!<br>");
            out.println(getServletContext().getServerInfo() + "<br>");
            Main m = new Main();
            out.println(m.call());
            out.println("</body></html>");
        }
    }
}
