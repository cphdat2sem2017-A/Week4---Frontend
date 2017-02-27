package control;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thomas Hartmann - tha@cphbusiness.dk created on Feb 21, 2017
 */
@WebServlet(name="UserControl", urlPatterns={"/UserControl"})
public class UserControl extends HttpServlet {
   private static final List<User> users = new ArrayList(){{
        add(new User(1, "Hans", "H123", 12));
        add(new User(2, "Grethe", "G123", 23));
        add(new User(3, "Hassan", "H123", 34));
        add(new User(4, "Gyda", "G123", 45));
        add(new User(5, "Halfdan", "H123", 54));
        add(new User(6, "Gerda", "G123", 56));
        add(new User(7, "Hubert", "H123", 67));
        add(new User(8, "Gunna", "G123", 76));
        add(new User(9, "Peter", "H123", 78));
        add(new User(10, "Hanne", "G123", 88));
   }};
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //Gson gson = new Gson();
        response.setContentType("text/html;charset=UTF-8");
        request.getSession().setAttribute("userlist", users);
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Type listOfUserObjects = new TypeToken<List<User>>(){}.getType();
        String str = gson.toJson(users, listOfUserObjects);
        request.getSession().setAttribute("gsonstring", str );
        
        request.getRequestDispatcher("showusers.jsp").forward(request, response);
        
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
