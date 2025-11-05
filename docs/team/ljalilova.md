# Leyli Jalilova - Project Portfolio Page

---

## **Overview**

My contributions focused on designing and implementing core editing and review capabilities in the QuizMos system — enabling users to refine flashcards and revisit learned content through structured flows.

I developed the foundational Edit Flashcard feature, which empowers users to update flashcard content interactively and reliably. I also implemented the base Review feature, which introduced sequential flashcard traversal — laying the groundwork for future enhancements like review modes.

These features strengthened QuizMos’ usability, maintainability, and learning effectiveness, bridging the gap between static content and dynamic user engagement.

Beyond implementation, I ensured architectural clarity and audit compliance and contributed to the Developer Guide and User Guide with clear, example-driven documentation.

---

## **Summary of Contributions**

### **Code Contributed**

* [View my code on tP Code Dashboard](https://nus-cs2113-ay2526s1.github.io/tp-dashboard/?search=ljalilova&breakdown=true&sort=groupTitle%20dsc&sortWithin=title&since=2025-09-19T00%3A00%3A00&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other&filteredFileName=)


---

## **Enhancements Implemented**

### **1. Edit Flashcard Feature (`edit INDEX`)**

* Engineered the `EditFlashcardCommand` to allow users to update flashcard content interactively.
* Validated user input and index bounds with custom exceptions and assertions.
* Integrated with the Ui component to prompt for new question and answer values.
* Compared new input against existing flashcard data to detect meaningful changes.
* Persisted updates via the Storage component using consistent serialization logic.
* Provided clear feedback through Ui.respond() for both successful edits and no-change scenarios.


**Impact:**
Enabled users to refine and personalize their flashcards, improving content accuracy and long-term retention. This feature added depth to the flashcard lifecycle and enhanced QuizMos’ flexibility.

---

### 2. Base Review Feature (`review`)

* Implemented the initial ReviewCommand subsystem, allowing users to enter the review mode and cycle through flashcards in order.
* Designed a simple, intuitive flow for displaying questions and awaiting user input before revealing answers.
* Ensured compatibility with Ui and FlashcardList components for seamless interaction.
* Created a foundation for future enhancements like review modes.


**Impact:**
Introduced active recall mechanics into QuizMos, transforming it from a passive flashcard viewer into an interactive learning tool. This laid the groundwork for future review features that support deeper learning.

---

## **Contributions to the Developer Guide (DG)**

* Authored **sequence diagrams** for:
  * EditFlashcardCommand
* Documented feature responsibilities, command formats, and edge case handling.
* Wrote clear, example-driven sections for manual testing and feature behavior.
* Ensured consistency in diagram style, terminology, and layout.


**Impact:**  
Made the DG a developer-friendly reference that accurately reflects system behavior and supports onboarding and future development.

---

## **Contributions to the User Guide (UG)**

* Documented the `edit INDEX` command with:
  * Usage examples
  * Expected prompts and outputs
  * Error handling for invalid input and no changes

**Impact:**  
Improved the UG’s clarity and completeness, helping users understand and utilize new features effectively.

---

## **Team and Leadership Contributions**

* Collaborated with teammates to ensure consistent command structure and UI messaging.
* Supported enhancements to the review feature by sharing design rationale and edge case handling.
* Helped standardize documentation and diagram formats across the team.
* Aided in the brainstorming for new ideas in team meetings.


---

## **Overall Impact**

I contributed key features that enhanced QuizMos’ interactivity, reliability, and learning value — from editing flashcards to initiating review flows.

By implementing the EditFlashcardCommand, designing the base ReviewCommand, and ensuring audit-compliant, maintainable code, I helped evolve QuizMos into a more dynamic and user-centered learning platform.

My documentation, diagrams, and architectural contributions strengthened the system’s clarity and scalability — positioning QuizMos for continued growth and innovation.

---
