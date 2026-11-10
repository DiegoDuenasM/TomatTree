import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductoServlet")
public class ProductoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Método POST para registrar o enviar datos desde formularios
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String precio = request.getParameter("precio");
        
        // Aquí puedes integrar tu ProductoDAO si deseas guardar en MySQL
        
        request.setAttribute("mensaje", "¡Producto '" + nombre + "' procesado correctamente en TomatTree!");
        request.getRequestDispatcher("resultado.jsp").forward(request, response);
    }

    // Método GET para consultas
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setAttribute("mensaje", "Consulta realizada vía GET con éxito.");
        request.getRequestDispatcher("resultado.jsp").forward(request, response);
    }
}