package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
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
        List<String> companiesToPrint = new ArrayList<>();
        PrintWriter out = response.getWriter();
        if (search != null && !search.equals("")) {
            companiesToPrint = companies.stream()
                    .filter(c -> c.contains(search))
                    .collect(Collectors.toList());
        } else {
            companiesToPrint.addAll(companies);
        }

        if (companiesToPrint.isEmpty()) {
            out.println("Companies not found");
        } else {
            for (String e : companiesToPrint) {
                out.println(e);
            }
        }
        // END
    }
}
