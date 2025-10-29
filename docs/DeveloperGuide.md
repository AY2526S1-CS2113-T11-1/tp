# Developer Guide

## Acknowledgements

{list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the original source as well}

## Design & implementation

### Overall design
- class `QuizMos`: run the program loop, implement `FlashcardList` and `Storage`
- class `Ui`: define printing formats (announcements, errors,...)
- class `Storage`: store and load flashcards
- class `Parser`: parse raw user's command to suitable `Command` object
- package `common`: include `Messages` class (for general messages) and other classes store messages for features
- package `command`: include different classes for each command to execute

### Feature: review
- If `Parser` detects `review` command, it creates a `ReviewCommand` instance
- The `ReviewCommand` instance gets the raw command to define its review mode (an `IReviewMode` instance)
- The `ReviewCommand` instance run the review loop:
  - display question (`displayQuestion`)
  - prompt user's answer (`getPrompt()`)
  - check that answer (`checkAnswer()`)
- Each IReviewMode instance override the 3 functions to fit its function

## Product scope

### Target user profile

- Busy students
- Students that want to study their materials buy active recall

### Value proposition

{Describe the value proposition: what problem does it solve?}

## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see usage instructions|refer to them when I forget how to use the application|
|v2.0|user|find a to-do item by name|locate a to-do without having to go through the entire list|

## Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* *glossary item* - Definition

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
