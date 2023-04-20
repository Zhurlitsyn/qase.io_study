Feature: Project functionality qase.io CURD

  Scenario: Project should be created
    Given user "6131755@gmail.com" logs using password "testtest23"
    When user creates project with the following data: "Name", "CODE", "Description", "Public"
    And user goes to project details page using code "CODE"
    Then project page is opened with "Name", "CODE", "Description", "Public"