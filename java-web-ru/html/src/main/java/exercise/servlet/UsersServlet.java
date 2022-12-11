package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.print.DocFlavor;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;

import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import exercise.User;
import org.apache.commons.lang3.ArrayUtils;
public class UsersServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        String pathInfo = request.getPathInfo();

        if (pathInfo == null) {
            showUsers(request, response);
            return;
        }

        String[] pathParts = pathInfo.split("/");
        String id = ArrayUtils.get(pathParts, 1, "");

        showUser(request, response, id);
    }

    private List getUsers() throws JsonProcessingException, IOException {
        // BEGIN
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonUsersArray = null;
        jsonUsersArray = Files.readString(Paths.get("src/main/resources/users.json"));
        List<User> users = objectMapper.readValue(jsonUsersArray, new TypeReference<List<User>>(){});

        return users;
        // END
    }

    private void showUsers(HttpServletRequest request,
                          HttpServletResponse response)
                throws IOException {

        // BEGIN
        StringBuilder result = new StringBuilder();
        List<User> users = getUsers();

        result.append("<table>\n");
        result.append("    <tr>\n");
        users.stream()
                .forEach(u -> {
                    String toAppend =
                            "       <td>" + u.getId() + "</td>\n" +
                            "       <td>" +
                            "           <a href=\"/users/" + u.getId() + "\">" + u.getFullName() + "</a>" +
                            "       </td>";
                    result.append(toAppend);
                });
        result.append("    </tr>");
        result.append("</table>");

        PrintWriter out = response.getWriter();
        out.println(result.toString());
        // END
    }

    private void showUser(HttpServletRequest request,
                         HttpServletResponse response,
                         String id)
                 throws IOException {

        // BEGIN
        List<User> users = getUsers();
        PrintWriter out = response.getWriter();

        User user = users.stream()
                .filter(u -> id.equals(u.getId()))
                .findAny()
                .orElse(null);

        System.out.println(user);

        if (user != null) {
            out.printf("""
                    <table>
                        <tr>
                            <td>Firstname</td>
                            <td>%s</td>
                        </tr>
                        <tr>
                            <td>LastName</td>
                            <td>%s</td>
                        </tr>
                        <tr>
                            <td>Email</td>
                            <td>%s</td>
                        </tr>
                    </table>
                    """, user.getFirstName(), user.getLastName(), user.getEmail());
        } else {
            response.sendError(404);
        }
        // END
    }
}
