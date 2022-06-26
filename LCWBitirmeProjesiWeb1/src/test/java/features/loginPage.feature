@LoginPage
Feature: Login Page

  @SuccessLogin
  Scenario Outline: Login
    Given user is on home page
    When click login button "<button>"
    Then should see login page
    When type Email "<email>", Password "<password>"
    And click button
    Then should see "Hesabım"
    Examples:
      | button    | email                 | password  |
      | Giriş Yap | gizemtrkgl@icloud.com | gizem2406 |

  @InvalidLogin
  Scenario Outline: False Password and Mail
    Given user is on home page
    When click login button "<button>"
    Then should see login page
    When type Email "<email>", Password "<password>"
    And click button
    Then user should see error message "<message>"
    Examples:
      | button    | email         | password | message                                        |
      | Giriş Yap | mail@mail.com | pass     | Lütfen e-posta ya da şifrenizi kontrol ediniz. |







