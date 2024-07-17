package controlador;

import Util.ConexionJDBC;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class login extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("clave");

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexionJDBC.getConexion();
            String sql = "SELECT * FROM Usuario WHERE NombreUsuario = ? AND Contrasena = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, clave);
            rs = stmt.executeQuery();

            if (rs.next()) {
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuario);
                session.setAttribute("isAdmin", rs.getBoolean("IsAdmin"));
                session.setAttribute("idCliente", rs.getInt("IdCliente"));

                response.sendRedirect("dashboard.jsp");
            } else {
                request.setAttribute("errorMessage", "Usuario o contraseña incorrecta");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Database connection error");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } finally {
            if (rs != null) {
                ConexionJDBC.close(rs);
            }
            if (stmt != null) {
                ConexionJDBC.close(stmt);
            }
            if (conn != null) {
                ConexionJDBC.close(conn);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
