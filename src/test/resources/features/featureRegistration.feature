Feature: User Registration
  As a user
  I want to be able to register for an account
  So that I can access the platform

  Scenario Succssesful registration
    Given I am on the registration page
    When I have entered date of birth "14/05/1999"
    And I have entered first name "Amila"
    And I have entered last name "Sa"
    And I have entered my email "amila2@outlook.com"
    And I have repeated my email "amila2@outlook.com"
    And I have entered my pasword "amila123"
    And I have repeated my pasword "amila123"
    And I have accepted the terms and conditions
    And I have klicked over "18"
    And I have klicked code of ethics
    When Press submmit button
    Then Verify the "THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND" on the webside

  Scenario Unsuccssesful registration-Missing lastname
    Given I am on the registration page
    When I have entered date of birth "14/05/1999"
    And I have entered first name "Amila"
    And I have entered last name ""
    And I have entered my email "amila2@outlook.com"
    And I have repeated my email "amila2@outlook.com"
    And I have entered my pasword "amila123"
    And I have repeated my pasword "amila123"
    And I have accepted the terms and conditions
    And I have klicked over "18"
    And I have klicked code of ethics
    When Press submmit button
    Then Verify the "Last Name is required" on the webside

  Scenario Unsuccssesful registration - Pasword missmatch
    Given I am on the registration page
    When I have entered date of birth "14/05/1999"
    And I have entered first name "Amila"
    And I have entered last name "Sa"
    And I have entered my email "amila2@outlook.com"
    And I have repeated my email "amila2@outlook.com"
    And I have entered my pasword "amila123"
    And I have repeated my pasword "amila12"
    And I have accepted the terms and conditions
    And I have klicked over "18"
    And I have klicked code of ethics
    When Press submmit button
    Then Verify the "Incorrect Password" on the webside

  Scenario Unsuccssesful registration - Terms and conditions not accepted
    Given I am on the registration page
    When I have entered date of birth "14/05/1999"
    And I have entered first name "Amila"
    And I have entered last name "Sa"
    And I have entered my email "amila2@outlook.com"
    And I have repeated my email "amila2@outlook.com"
    And I have entered my pasword "amila123"
    And I have repeated my pasword "amila123"
    And I have klicked over "18"
    And I have klicked code of ethics
    When Press submmit button
    Then Verify the "You must confirm that you have read and accepted our Terms and Conditions" on the webside



