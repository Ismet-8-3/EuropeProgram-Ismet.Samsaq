@RegressionTest
Feature: Admin user can manage product
        As an admin, the user should be able to add,edit and delete products
       @AddProduct   @SmokeTest
  Scenario: admin user can add a new product
    Given user is already on the dashboard
    When user save the product with details
    Then product is added succesfully
    And user should log out
    @EdiProduct
    Scenario: admin user can edit product info
      Given user is already on the dashboard
      When user edit the existing product information
      Then product information should be updated successfully
      @DeleteProduct
      Scenario: admin user can delete product
        Given user is already on the dashboard
        When user delete the product
        Then product should removed from the product list