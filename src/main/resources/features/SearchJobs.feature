Feature: NHS Job Search Functionality

  As a jobseeker on the NHS Jobs website
  I want to search for jobs based on my preferences
  So that I can get relevant and most recently posted job results

  Scenario: Search for jobs with preferences and sort by newest date posted
    Given I am on the NHS Jobs Search page
    When I enter valid preferences in the search form
    And I click the search button
    Then I should see a list of jobs matching my preferences
    And the results should be sorted by newest date posted