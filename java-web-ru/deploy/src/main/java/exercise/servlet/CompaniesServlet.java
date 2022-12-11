package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.stream.Collectors;
import static exercise.Data.getCompanies;

public class CompaniesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        // BEGIN
        String search = request.getParameter("search");
        List<String> companies = getCompanies();
        PrintWriter out = response.getWriter();
        for (String e : companies) {
            if (search != null && !search.equals("") && !search.equals("\"\"")) {
                if (e.contains(search)) {
                    out.println(e);
                }
            } else {
                out.println(e);
            }
        }
        // END
    }
}
