import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@WebServlet(urlPatterns={"/patients"},loadOnStartup = 1)
public class Serv extends HttpServlet {
    private static final Logger log= Logger.getLogger(Serv.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().write("Hello, world!");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            String reqBody=req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
            resp.setContentType("text/html");
            resp.getWriter().write("Thank you client!\n");
            log.info(reqBody);
            Gson gson = new Gson();
            Patient p=gson.fromJson(reqBody,Patient.class);
            log.info(reqBody);
            resp.getWriter().write(p.getName());
            resp.getWriter().write("\n");
            resp.getWriter().write(p.getPhoneNumber());
    }
}
