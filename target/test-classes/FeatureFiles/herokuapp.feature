#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Title of your feature
  I want to use this template for my feature file


  Scenario: Launch herokuapp
   Given Launch herokuapp with url "http://admin:admin@the-internet.herokuapp.com/basic_auth"
   #When Take Screenshot
   
   
   Scenario: Find Broken images herokuapp
   Given Launch herokuapp "http://the-internet.herokuapp.com/"
   Then click on link from main page "Broken Images"
   Then Find Broken images in the page
   #When Take Screenshot
   


    