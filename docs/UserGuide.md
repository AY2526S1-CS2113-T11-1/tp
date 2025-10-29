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

### Receive help by being shown possible commands

```bash
help
```

### View all flashcards

```bash
list
```

### Add a flashcard with a question and answer

```bash
add q/QUESTION a/ANSWER
```

### Delete a flashcard

```bash
delete 3
```

### Reviewing flashcards 

To begin the review:
```bash
review m/[TF | FLIP | MCQ]
```

### Star/flag an important flashcard

```bash
star 2
```
Stars the flashcard at index 2 if it is unstarred.

Example output:

This flashcard is starred!

#### Simple flip mode
After each question showed, can select whether to show the answer (y/n), or quit the session
```bash
[Y | N | QUIT]
```
#### True/false mode
After each question showed, type your answer (t/f) or quit the session
```bash
[T | F | QUIT]
```
#### MCQ mode
This mode requires flashcard list has no less than 4 flashcards

After each question showed, type your answer (1/2/3/4) or quit the session
```bash
[1 | 2 | 3 | 4 | QUIT]
```

---

## FAQ {not yet completed}

**Q**: {question} 

**A**: {your answer here}

---

## Command Summary

* Receive help `help`
* Add flashcard `add q/QUESTION a/ANSWER`
* Remove flashcard `delete #`
* List flashcards `list`
