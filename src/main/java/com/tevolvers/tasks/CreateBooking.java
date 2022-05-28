package com.tevolvers.tasks;

import com.tevolvers.models.User;
import io.restassured.RestAssured;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static com.tevolvers.utils.Constants.RESOURCE;


public class CreateBooking implements Task {
    private User user;

    public CreateBooking(User user) {
        this.user = user;
    }

    public static CreateBooking withData(User user) {
        return Tasks.instrumented(CreateBooking.class, user);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Post.to(RESOURCE).with(request -> request
                .contentType("application/json")
                .accept("application/json").body(
                        "{\n" +
                                "  \"firstname\": \"" + user.getFirstName() + "\",\n" +
                                "  \"lastname\": \"" + user.getLastName() + "\",\n" +
                                "  \"totalprice\": \"" + user.getTotalPrice() + "\",\n" +
                                "  \"depositpaid\": \"" + user.isDepositPaid() + "\",\n" +
                                "  \"bookingdates\": " + "{\n" +
                                "  \"checkin\": \"" + user.getCheckIn() + "\",\n" +
                                "  \"checkout\": \"" + user.getCheckOut() + "\"\n" +
                                "}" + ",\n" +
                                "  \"depositpaid\": \"" + user.getAdditionalNeeds() + "\"\n" +

                                "}"
                ))
        );


    }
}
