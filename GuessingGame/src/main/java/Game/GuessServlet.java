package Game;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/guess")
public class GuessServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final int MAX_ATTEMPTS = 5;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int randomNumber;

        if (session.getAttribute("randomNumber") == null) {
            Random rand = new Random();
            randomNumber = rand.nextInt(100) + 1; // generates number between 1 and 100
            session.setAttribute("randomNumber", randomNumber);
            session.setAttribute("attempts", MAX_ATTEMPTS);
        } else {
            randomNumber = (int) session.getAttribute("randomNumber");
        }

        int attempts = (int) session.getAttribute("attempts");
        int guess = Integer.parseInt(request.getParameter("guess"));

        String message;
        if (guess == randomNumber) {
            message = "Congratulations! You guessed the number!";
        } else {
            attempts--;
            session.setAttribute("attempts", attempts);
            if (attempts == 0) {
                message = "Sorry, you've run out of attempts. The number was " + randomNumber + ".";
                session.removeAttribute("randomNumber");
                saveScore(request.getParameter("username"), 0); // Save score to database
            } else {
                message = guess < randomNumber ? "Too low! Try again." : "Too high! Try again.";
            }
        }

        request.setAttribute("message", message);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void saveScore(String username, int score) {
        try {
            // Loading the Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establishing connection to Oracle database
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "CodeDeveloper007",
                    "Manu123");

            // Prepare SQL statement
            PreparedStatement stmt = con.prepareStatement("INSERT INTO scores (username, score) VALUES (?, ?)");
            stmt.setString(1, username);
            stmt.setInt(2, score);

            // Execute SQL statement
            stmt.executeUpdate();

            // Close connection
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
