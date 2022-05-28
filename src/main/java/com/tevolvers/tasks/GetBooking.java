package com.tevolvers.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static com.tevolvers.utils.Constants.RESOURCE;
import static com.tevolvers.utils.Constants.idBooking;

public class GetBooking implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(RESOURCE+idBooking ).with(request -> request.accept("application/json"))
        );

    }
    public static GetBooking withGetBooking (int idBooking) {return Tasks.instrumented(GetBooking.class, idBooking);
    }
}
