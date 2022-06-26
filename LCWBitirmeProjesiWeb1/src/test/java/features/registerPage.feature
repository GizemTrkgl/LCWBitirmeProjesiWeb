@RegisterPage
Feature: Register Page

  @SuccessRegister
  Scenario Outline: Success Registration
    Given user is on home page
    When mouse over "<text>" and click "<button>"
    Then should see registration page
    When type Email "<email>", Password "<password>", phone number "<phoneNumber>"
    And click approve checkbox
    And click sign up button
    Then should see phone code box
    Then should see "<success>" success registration title
    Examples:
      | text      | button | email                | password | phoneNumber | success                   |
      | Giriş Yap | Üye Ol | xxxxxxxxxx@gmail.com | 123456g. | 372723346   | Üye kaydınız yapılmıştır. |

  @InvalidRegister
  Scenario Outline: False mail
    Given user is on home page
    When mouse over "<text>" and click "<button>"
    Then should see registration page
    When type Email "<email>", Password "<password>", phone number "<phoneNumber>"
    And click approve checkbox
    And click sign up button
    Then should see "<error>" error message
    Examples:
      | text      | button | email    | password | phoneNumber | error                                      |
      | Giriş Yap | Üye Ol | xx@gmail | 123456g. | 372723346   | Lütfen geçerli bir e-posta adresi giriniz. |











