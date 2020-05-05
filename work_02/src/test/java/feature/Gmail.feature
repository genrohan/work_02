Feature: finding a mail in Gmail and storing the body message

Scenario: User want to save a mail message
Given User is on Gmail login page
When User gets logged in to Gmail
When User opens a spefic mail
Then Save the body message in a notepad file.