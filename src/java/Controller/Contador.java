package Controller;
/*@autor Karioca*/
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*@autor Karioca*/
@WebServlet(name = "Contador", urlPatterns = {"/Contador"})
public class Contador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        int cont = 0;
        String users[] = new String[100] ;
        String user = request.getParameter("usuario");
        String list;
        String a;
                
        HttpSession sessao = request.getSession();
        sessao.setMaxInactiveInterval(10);
        
        if((Integer)sessao.getAttribute("contagem") != null){
            cont = (Integer)sessao.getAttribute("contagem");          
            a = request.getParameter("a");
            users[cont] = user;
            list = a +" "+ users[cont];
        }else{
           list = request.getParameter("usuario"); 
        }
        
        cont++;
        
        sessao.setAttribute("contagem", cont);
        request.setAttribute("acessos", list);

        request.getRequestDispatcher("index.jsp").forward(request, response);
   
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
/*@autor Karioca*/
}
