@HomePage
Feature: Home Page

  @AddProduct @Cart
  Scenario Outline: Login and add product to cart
    Given user is on home page
    When click login button "<button>"
    Then should see login page
    When type Email "<email>", Password "<password>"
    And click button
    Then should see "Hesabım"
    When mouse over "<list>" Kadın,"<menu>" Giyim and click Bluz "<button1>"
    Then should see product page
    When enter size "M" to search box and click size
    And enter color "<color>" to search box and click color text
    Then should see filter text
    When select product
    And select size "<size>"
    And click add to cart button "SEPETE EKLE"
    And click my cart button
    Then should see cart page
    When check product size "Beden: M"
    And check product name "Bluz"
    And check product counter "Sepetim (1 Ürün)"
    And click payment button "ÖDEME ADIMINA GEÇ"
    Then should see text "1. Teslimat yönteminizi seçiniz."
    Examples:
      | button    | email                 | password   | list  | menu  | button1 | color  | size |
      | Giriş Yap | gizemtrkgl@icloud.com | gizem2406  | KADIN | GİYİM | Bluz    | Siyah  | M    |







