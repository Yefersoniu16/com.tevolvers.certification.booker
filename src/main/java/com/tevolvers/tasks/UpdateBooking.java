package com.tevolvers.tasks;

import com.tevolvers.models.User;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static com.tevolvers.utils.Constants.RESOURCE;

public class UpdateBooking implements Task {
    private User user;

    public UpdateBooking(User user) {
        this.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
actor.attemptsTo(Put.to(RESOURCE+user.getId()).with(request ->
        request.contentType("application/json")
                .accept("application/json")
                .header("Cookie","token="+ actor.recall("TOKEN"))
        .body(
        "{\n" +
                "  \"firstname\": \"" + user.getFirstName() + "\",\n" +
                "  \"lastname\": \"" + user.getLastName() + "\",\n" +
                "  \"totalprice\": \"" + user.getTotalPrice() + "\",\n" +
                "  \"depositpaid\": \"" + user.isDepositPaid() + "\",\n" +
                "  \"bookingdates\": " + "{\n" +
                "  \"checkin\": \"" + user.getCheckIn() + "\",\n" +
                "  \"checkout\": \"" + user.getCheckOut() + "\"\n" +
                "}" +",\n"+
                "  \"depositpaid\": \"" +user.getAdditionalNeeds()  + "\"\n" +

                "}"
) ));

    }
    public static UpdateBooking withUpdateBooking (User user) {return Tasks.instrumented(UpdateBooking.class, user);
    }

}
