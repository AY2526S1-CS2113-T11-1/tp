# Raahim Mukhtar - Project Portfolio Page

---

## Overview

My contributions centered on building the core flashcard management system. I implemented the `Flashcard` and `FlashcardList` classes, which form the foundation of the application’s data model, and developed the `AddFlashcardCommand`, `DeleteFlashcardCommand`, and `SearchFlashcardCommand` features to allow users to manage their flashcards seamlessly. Additionally, I integrated these features with the `Storage` and `Ui` components to ensure reliable saving and display of flashcards. I also created comprehensive tests, including JUnit tests and UI-based validation, to verify functionality and ensure robust error handling across all flashcard-related commands.

--- 

## Summary of Contributions

### **Code Contributed**
- [View my code on tP Code Dashboard](https://nus-cs2113-ay2526s1.github.io/tp-dashboard/?search=mukhtarcal&breakdown=true&sort=groupTitle%20dsc&sortWithin=title&since=2025-09-19T00%3A00%3A00&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other&filteredFileName=) 

---

## **Enhancements Implemented**

#### **1. Add Flashcard Feature**
- Implemented the core logic for adding new flashcards through the `AddFlashcardCommand` class.
- Integrated input parsing with validation checks (ensuring both question and answer fields are present and properly ordered).
- Updated the `Storage` class to persist added flashcards to the save file.
- Added corresponding JUnit and text-based UI tests to ensure full feature coverage.

#### **2. Delete Flashcard Feature**
- Developed the `RemoveFlashcardCommand` to allow users to delete flashcards by index.
- Implemented defensive error handling for invalid inputs (e.g., out-of-range indices, non-integer inputs).
- Enhanced the UI feedback to clearly display which flashcard was removed.
- Wrote multiple JUnit tests and text-based UI tests verifying expected behavior and edge cases.

#### **3. Search Flashcard Feature**
- Designed and implemented the `SearchCommand`, which filters flashcards based on a user-provided keyword.
- Built logic for case-insensitive matching and formatted UI output to show matched results clearly.
- Wrote comprehensive tests to ensure correctness and reliability of search results.

#### **4. Core Flashcard System**
- Implemented the foundational `Flashcard` and `FlashcardList` classes.
- Designed `FlashcardList` to support operations such as adding, deleting, and searching efficiently.
- Ensured clean integration between `FlashcardList`, commands, and persistent storage.
- Collaborated with teammates to align data structures with other system components.

---

## **Contributions to the User Guide (UG)**
- Created the template and draft one of the UG
- Added and edited sections explaining:
    - `add q/<QUESTION> a/<ANSWER>` command
    - `delete <INDEX>` command
    - `search <KEYWORD>` command
- Wrote usage examples and error message explanations for each feature.
- Improved command descriptions for clarity and consistency in formatting.

---

## **Contributions to the Developer Guide (DG)**
- Authored the design and implementation sections for:
    - `AddFlashcardCommand`
    - `RemoveFlashcardCommand`
    - `SearchCommand`
    - `Flashcard` and `FlashcardList` class diagrams
- Added UML diagrams (Class and Sequence diagrams) illustrating interactions between command classes and all other parts of the system.

---

## **Contributions to Team-Based Tasks**
- Regularly reviewed pull requests from team members for consistency, readability, and adherence to project standards.
- Assisted in resolving merge conflicts involving command parsing and shared data structures.
- Contributed to team discussions on command structure and error-handling design.

---

## **Review and Mentoring Contributions**
- Reviewed teammates’ PRs related to `ReviewCommand`, `Storage`, and more.
- Provided testing feedback and helped identify input edge cases.
- Helped debug file I/O issues during integration testing.

---