@stories
Feature: I, as a test automator, want to verify the
  reservations through apis

  Background:

    Given service opening Brooker

  @CreateBooking
  Scenario: test create booking
    When service execution Brooker
      | firstName | lastName | totalPrice | depositPaid | checkIn    | checkOut   | additionalNeeds |
      | Tom       | Cruce    | 111        | true        | 2018-01-01 | 2019-01-01 | Breakfast       |
    Then service verification Brooker with code 200

  @GetBooking
  Scenario: Consult get booking for id
    When execution of get booking with id booking 2598
    Then service verification Brooker with code 200


  @UpdateBooking
  Scenario: Perform update booking for id
    When executions of uddate booking with id booking
      | id  | firstName | lastName | totalPrice | depositPaid | checkIn    | checkOut   | additionalNeeds |
      | 693 | Cart      | vans     | 11176      | true        | 2018-01-01 | 2019-01-01 | Breakfast       |
    Then service verification Brooker with code 200

