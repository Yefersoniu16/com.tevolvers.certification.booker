package com.tevolvers.stepdefinitions;

import com.tevolvers.models.User;
import com.tevolvers.tasks.CreateBooking;

import com.tevolvers.tasks.CreateToken;
import com.tevolvers.tasks.GetBooking;
import com.tevolvers.tasks.UpdateBooking;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;

import java.util.List;

import static com.tevolvers.utils.Constants.NOMBRE_USUARIO;
import static com.tevolvers.utils.Constants.URL_BASE;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class BookerStepdefinitions {

    @Before()
    public void setup(){
        setTheStage(new OnlineCast());
        theActorCalled(NOMBRE_USUARIO);

    }

    @Given("service opening Brooker")
    public void serviceOpeningBrooker() {
        theActorInTheSpotlight().whoCan(CallAnApi.at(URL_BASE));

    }

    @When("service execution Brooker")
    public void serviceExecutionBrooker(List<User> user) {

        theActorInTheSpotlight().attemptsTo(CreateBooking.withData(user.get(0)));

    }

    @Then("service verification Brooker with code (.*)")
    public void serviceVerificationBrooker(int code) {
        theActorInTheSpotlight().should(ResponseConsequence.seeThatResponse("code",
                response -> response.statusCode(code)));
    }

    @When("execution of get booking with id booking (.*)")
    public void executionOfGetBookingWithIdBooking(int idBooking){
        theActorInTheSpotlight().attemptsTo(GetBooking.withGetBooking(idBooking));

    }
    @When("executions of uddate booking with id booking")
    public void executionsOfUddateBookingWithIdBooking(List<User> user) {

        theActorInTheSpotlight().attemptsTo(CreateToken.createTokenBooking(),
                UpdateBooking.withUpdateBooking(user.get(0)));
    }
}
