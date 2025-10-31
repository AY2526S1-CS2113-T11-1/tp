## **Overview**

Our product, **Quizmos**, is a flashcard-based quiz application that helps students study effectively through active recall. Users can create, edit, delete, and quiz themselves on flashcards through a simple and intuitive command-line interface.  
*(Shared 1–2 sentences for all team members)*

In addition to the core quiz functionality, I implemented the **Starring Flashcards feature** and the **Storage component**, and contributed extensively to the **JUnit test suite**. These contributions improved both the reliability and long-term usability of Quizmos.

---

## **Summary of Contributions**

### **Code Contributed**
- [Link to my code on the tP Code Dashboard](<https://nus-cs2113-ay2526s1.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2025-09-19T00%3A00%3A00&filteredFileName=&tabOpen=true&tabType=authorship&tabAuthor=ashutoshalung&tabRepo=AY2526S1-CS2113-T11-1%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false>)

---

### **Enhancements Implemented**

#### 🔹 Starring Flashcards Feature
- Implemented the ability for users to **mark and unmark flashcards as starred** to highlight important ones for focused revision.
- Added support for commands such as `star`, `unstar`, and `list starred`.
- Integrated starred status persistence through the Storage component.
- Updated UI messages to display clear feedback when a flashcard is starred or unstarred.
- Added **JUnit tests** to verify correct command parsing, execution, and storage behavior.

#### 🔹 Storage Component
- Designed and implemented the **Storage** system responsible for saving and loading flashcards from a local text file.
- Added support for reading and writing the **starred status** of each flashcard.
- Implemented robust **error handling** for missing or corrupted files, with automatic file creation and recovery logic.
- Refactored serialization and deserialization logic for clarity and adherence to SRP (Single Responsibility Principle).
- Wrote comprehensive **JUnit tests** for Storage, covering boundary cases (e.g., empty files, malformed lines, missing attributes).

#### 🔹 JUnit Test Suite
- Significantly expanded test coverage across multiple components, including:
    - `Storage` – verifying correct persistence and loading of flashcards.
    - `Parser` – validating correct command parsing and error messages.
    - `Command` – ensuring consistent behavior for `star`, `unstar`, and `list starred`.
- Created structured test data and setup/teardown logic for isolated test execution.
- Improved reliability of the CI pipeline by ensuring all new test cases passed consistently.

---

### **Contributions to the User Guide (UG)**
- Authored the **“Starring Flashcards”** section with examples for `star`, `unstar`, and `list starred` commands.
- Added documentation on **data persistence**, explaining how and where flashcards are stored.
- Updated the **Command Summary Table** with all new commands and parameters.
- Edited multiple sections for consistency and formatting improvements.

---

### **Contributions to the Developer Guide (DG)**
- Authored the **“Storage Component”** section describing its structure, read/write logic, and integration with the rest of the app.
- Wrote the **“Starring Feature Implementation”** section detailing the command flow and persistence design.
- Added UML diagrams:
    - **Sequence Diagram** for `StarCommand` execution.
    - **Class Diagram** update showing the new `isStarred` attribute in `Flashcard`.
    - **Activity Diagram** for flashcard saving/loading on startup and shutdown.
- Wrote **Design Considerations** discussing text-based vs JSON-based storage alternatives.

---

### **Contributions to Team-Based Tasks**
- Helped maintain the **GitHub issue tracker** by creating, tagging, and closing issues.
- Assisted with **CI setup and testing pipeline** to include new test cases.
- Supported teammates in resolving file I/O and parser-related bugs.
- Participated in team discussions on architecture and milestone planning.

---

### **Review / Mentoring Contributions**
- Reviewed teammates’ pull requests focusing on code quality, test structure, and logic correctness.
    - [Example PR Review #1](<insert link>)
    - [Example PR Review #2](<insert link>)
- Provided debugging help for teammates struggling with file parsing or JUnit test setup.
- Shared tips on improving test readability and using parameterized tests effectively.

---

### **Contributions Beyond the Project Team**
- Reported bugs in other teams’ Quiz applications related to incorrect file persistence.
- Answered forum queries on **PlantUML**, **JUnit testing**, and **GitHub Actions** CI setup.
- Shared example snippets demonstrating safe file handling and error recovery techniques.

---

### **Evidence of Technical Leadership**
- Took ownership of the **Storage subsystem** design and ensured seamless integration across components.
- Designed the **persistence architecture** to handle the starred attribute efficiently.
- Led test design discussions to ensure consistent and maintainable unit tests.
- Guided teammates on debugging strategies and best practices for TDD (Test-Driven Development).
