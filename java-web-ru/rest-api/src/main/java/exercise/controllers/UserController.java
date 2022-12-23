package exercise.controllers;

import io.javalin.http.Context;
import io.javalin.apibuilder.CrudHandler;
import io.ebean.DB;
import java.util.List;

import exercise.domain.User;
import exercise.domain.query.QUser;

import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.lang3.StringUtils;

public class UserController implements CrudHandler {

    public void getAll(Context ctx) {
        // BEGIN
        List<User> userList = new QUser()
                .orderBy().id.asc()
                .findList();

        String json = DB.json().toJson(userList);
        ctx.json(json);
        // END
    };

    public void getOne(Context ctx, String id) {

        // BEGIN
        long normalizedId = id == null ? 1 : Long.parseLong(id);
        User user = new QUser()
                .where().id.equalTo(normalizedId)
                .findOne();

        String json = DB.json().toJson(user);
        ctx.json(json);
        // END
    };

    public void create(Context ctx) {

        // BEGIN
        String jsonBody = ctx.body();
        User user = DB.json().toBean(User.class, jsonBody);
        user.save();
        // END
    };

    public void update(Context ctx, String id) {
        // BEGIN
        long normalizedId = Long.parseLong(id);
        String jsonBody = ctx.body();
        User newUser = DB.json().toBean(User.class, jsonBody);

        newUser.setId(id);
        newUser.update();
        // END
    };

    public void delete(Context ctx, String id) {
        // BEGIN
        long normalizedId = Long.parseLong(id);

        User user = new QUser()
                .where().id.equalTo(normalizedId)
                .findOne();
        user.delete();
        // END
    };
}
