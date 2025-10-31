# Quizmos User Guide

```
 ___        _     __  __
/ _ \ _   _(_)___|  \/  | ___  ___
| | | | | | | |_  / |\/| |/ _ \/ __|
| |_| | |_| | |/ /| |  | | (_) \__ \
\__\_\\__,_|_/___|_|  |_|\___/|___/
```

---

## Introduction

**QuizMos** is a simple **command-line flashcard manager** that helps you create, review, and organize flashcards for effective studying and memorization.

It allows you to add, list, and remove flashcards—each containing a question and an answer—all directly from your terminal.

QuizMos automatically saves your flashcards to a file, ensuring your collection is preserved and ready every time you run the program.

---

## Quick Start {not yet completed}

{Give steps to get started quickly}

1. {step 1}
2. {step 2}

---

## Features 

- Quizmos supports creating basic flashcards with text based questions and answers.
- **Marking flashcards as important/starred** for easy review.
---

## Usage

For now, Quizmos only supports creating basic flashcards with text based questions and answers.

Notes about the command format:
- Words in `UPPERCASE` are the parameters to be supplied by the user.
- Items in square brackets are optional
- Parameters MUST be in order
- Extraneous parameters for commands that do not take in parameters (`help`, `list`, `exit`...) will be ignored.
- If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.

### View help: `help`
Shows a list of command

Format: `help`

### List all flashcards: `list`
Shows a list of flashcards

Format: `list`

### Add a flashcard: `add`
Add flashcard with a question and answer

Format: `add q/QUESTION a/ANSWER`

### Delete a flashcard: `delete`

Delete a flashcard with its index, can check by `list` command

Format: `delete INDEX`

### Search for flashcards: `search`
Search flashcards by keyword or keyphrase

Format: `search KEYPHRASE`

### Review: `review`

To begin the review:

Format: `review m/[FLIP | TF | MCQ]`
- the mode is case-insensitive
- `FLIP`: Simple flip mode
- `TF`: True/False mode
- `MCQ`: Multi-choices question mode

Example:
- `review m/FLIP`
- `review m/tf`
- `review m/mCq`

#### Simple flip mode
After each question showed, can select whether to show the answer (y/n), or quit the session

Format: `[Y | N | QUIT]`
#### True/false mode
After each question showed, type your answer (t/f) or quit the session

Format: `[T | F | QUIT]`
- `T` True
- `F` False
#### MCQ mode
This mode requires flashcard list has no less than 4 flashcards

After each question showed, type your answer (1/2/3/4) or quit the session

Format: `[1 | 2 | 3 | 4 | QUIT]`
- `1` Answer 1
- `2` Answer 2
- `3` Answer 3
- `4` Answer 4

### Star/flag flashcard: `star`
Star/flag a flashcard by its index
The starred flashcard is depicted in the stored file. 

Format: `star INDEX`



Example:
- `star 2`
- Output: `This flashcard is starred!`

### Exit the program: `exit`
Exit the program

Format: `exit`

---

## FAQ {not yet completed}

**Q**: {question} 

**A**: {your answer here}

---

## Command Summary

| Action | Format, Examples                | 
|--------|---------------------------------|
| Add    | `add q/QUESTION a/ANSWER`       |
| Delete | `delete INDEX`                  |
| Search | `search KEYPHRASE`              |
| Review | `review m/[FLIP  \| TF \| MCQ]` |
| Star   | `star INDEX`                    |
| List   | `list`                          |
| Exit   | `exit`                          |
| Help   | `help`                          |
