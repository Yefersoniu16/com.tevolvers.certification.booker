package com.tevolvers.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static com.tevolvers.utils.Constants.*;

public class CreateToken implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Post.to(TOKEN).with(requet -> requet.contentType("application/json").body(
                "{\n" +
                "  \"username\": \"" + USER + "\",\n" +
                "  \"password\": \"" + PASSWORD + "\""+
                        "}"
        )));
        actor.remember("TOKEN",SerenityRest.lastResponse().body().jsonPath().getString("token"));

    }
    public static CreateToken createTokenBooking(){return Tasks.instrumented(CreateToken.class);
    }
}
