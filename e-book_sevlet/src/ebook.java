import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ebook")
public class ebook extends HttpServlet {
    private String message;

    @Override
    public void init() throws ServletException {
        message = "Hello world, this message is from servlet!";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("jsps/books.jsp");
    }


    @Override
    public void destroy() {
        super.destroy();
    }
}