package exercise.controllers;

import io.javalin.http.Handler;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import io.javalin.core.validation.Validator;
import io.javalin.core.validation.ValidationError;
import io.javalin.core.validation.JavalinValidation;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.lang3.StringUtils;

import exercise.domain.User;
import exercise.domain.query.QUser;

public final class UserController {

    public static Handler listUsers = ctx -> {

        List<User> users = new QUser()
            .orderBy()
                .id.asc()
            .findList();

        ctx.attribute("users", users);
        ctx.render("users/index.html");
    };

    public static Handler showUser = ctx -> {
        long id = ctx.pathParamAsClass("id", Long.class).getOrDefault(null);

        User user = new QUser()
            .id.equalTo(id)
            .findOne();

        ctx.attribute("user", user);
        ctx.render("users/show.html");
    };

    public static Handler newUser = ctx -> {

        ctx.attribute("errors", Map.of());
        ctx.attribute("user", Map.of());
        ctx.render("users/new.html");
    };

    public static Handler createUser = ctx -> {
        // BEGIN
        String firstName = ctx.formParam("firstName");
        String lastName = ctx.formParam("lastName");
        String email = ctx.formParam("email");
        String password = ctx.formParam("password");

        Validator<String> firstNameValidator = ctx.formParamAsClass("firstName", String.class)
                .check(Objects::nonNull, "FirstName cannot be null")
                .check(value -> !value.isEmpty(), "FirstName cannot be empty");
        Validator<String> lastNameValidator = ctx.formParamAsClass("lastName", String.class)
                .check(Objects::nonNull, "LastName cannot be null")
                .check(value -> !value.isEmpty(), "LastName cannot be empty");
        Validator<String> emailValidator = ctx.formParamAsClass("email", String.class)
                .check(Objects::nonNull, "Email cannot be null")
                .check(value -> !value.isEmpty(), "Email cannot be empty")
                .check(value -> EmailValidator.getInstance().isValid(value), "Email must be valid");
        Validator<String> passwordValidator = ctx.formParamAsClass("password", String.class)
                .check(Objects::nonNull, "Password cannot be null")
                .check(value -> !value.isEmpty(), "Password cannot be empty")
                .check(StringUtils::isNumeric, "Only numeric values are allowed in password")
                .check(value -> value.length() >= 4, "Password must be longer than 3 symbols");

        Map<String, List<ValidationError<? extends Object>>> errors = JavalinValidation.collectErrors(
                firstNameValidator,
                lastNameValidator,
                emailValidator,
                passwordValidator
        );

        if (!errors.isEmpty()) {
            ctx.status(422);
            ctx.attribute("errors", errors);
            User invalidUser = new User(firstName, lastName, email, password);
            ctx.attribute("user", invalidUser);
            ctx.render("users/new.html");
            return;
        }

        User user = new User(firstName, lastName, email, password);

        user.save();
        ctx.sessionAttribute("flash", "???????????????????????? ?????????????? ????????????????");
        ctx.redirect("/users");
        // END
    };
}
