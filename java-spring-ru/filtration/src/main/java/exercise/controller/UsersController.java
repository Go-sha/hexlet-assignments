package exercise.controller;
import exercise.model.User;
import exercise.model.QUser;
import exercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

// Зависимости для самостоятельной работы
// import org.springframework.data.querydsl.binding.QuerydslPredicate;
// import com.querydsl.core.types.Predicate;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserRepository userRepository;

    // BEGIN
    @GetMapping("")
    public Iterable<User> getUser(@PathParam(value = "firstName") String firstName,
                                  @PathParam(value = "lastName") String lastName) {
        return userRepository.findAll(
                QUser.user.firstName.containsIgnoreCase(firstName != null ? firstName : "")
                        .and(
                                QUser.user.lastName.containsIgnoreCase(lastName != null ? lastName : "")
                        )
        );
    }
    // END
}

