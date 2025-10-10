package quizmos.storage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import quizmos.flashcard.Flashcard;
import quizmos.flashcardlist.FlashcardList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StorageTest {

    private Path tempDir;
    private Path tempFile;
    private Storage storage;

    @BeforeEach
    void setUp() throws IOException {
        tempDir = Files.createTempDirectory("storageTest");
        tempFile = tempDir.resolve("flashcards.txt");
        storage = new Storage(tempFile.toString());
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.walk(tempDir)
                .sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(File::delete);
    }

    @Test
    void constructor_createsFileAndParentDirsIfMissing() {
        Path nestedDir = tempDir.resolve("nested/folder");
        Path nestedFile = nestedDir.resolve("cards.txt");
        assertFalse(Files.exists(nestedFile));

        new Storage(nestedFile.toString());

        assertTrue(Files.exists(nestedDir), "Parent directory should be created");
        assertTrue(Files.exists(nestedFile), "File should be created");
    }

    @Test
    void load_returnsEmptyListWhenFileEmpty() throws Exception {
        Files.createFile(tempFile);
        ArrayList<Flashcard> flashcards= storage.load();
        assertTrue(flashcards.isEmpty(), "Empty file should return empty list");
    }

    @Test
    void load_ignoresInvalidAndEmptyLines() throws Exception {
        List<String> lines = Arrays.asList(
                "Question 1 | Answer 1",
                "",
                "Invalid line without pipe",
                "Question 2 | Answer 2"
        );
        Files.write(tempFile, lines);

        List<Flashcard> loaded = storage.load();

        assertEquals(2, loaded.size());
        assertEquals("Question 1", loaded.get(0).getQuestion());
        assertEquals("Answer 1", loaded.get(0).getAnswer());
        assertEquals("Question 2", loaded.get(1).getQuestion());
        assertEquals("Answer 2", loaded.get(1).getAnswer());
    }

    @Test
    void load_trimsSpacesAroundQuestionAndAnswer() throws Exception {
        Files.write(tempFile, Arrays.asList("   What is AI   |   Artificial Intelligence   "));

        List<Flashcard> loaded = storage.load();

        assertEquals(1, loaded.size());
        assertEquals("What is AI", loaded.get(0).getQuestion());
        assertEquals("Artificial Intelligence", loaded.get(0).getAnswer());
    }

    @Test
    void writeToFile_writesFlashcardsCorrectly() throws Exception {
        FlashcardList list = new FlashcardList();
        list.addFlashcard(new Flashcard("Q1", "A1"));
        list.addFlashcard(new Flashcard("Q2", "A2"));

        storage.writeToFile(list);

        List<String> lines = Files.readAllLines(tempFile);
        assertEquals(2, lines.size());
        assertEquals("Q1 | A1", lines.get(0));
        assertEquals("Q2 | A2", lines.get(1));
    }

    @Test
    void writeToFile_overwritesPreviousContent() throws Exception {
        Files.write(tempFile, Arrays.asList("Old data line"));
        FlashcardList list = new FlashcardList();
        list.addFlashcard(new Flashcard("NewQ", "NewA"));

        storage.writeToFile(list);

        List<String> lines = Files.readAllLines(tempFile);
        assertEquals(1, lines.size());
        assertEquals("NewQ | NewA", lines.get(0));
    }

    @Test
    void load_throwsFileNotFoundIfDeleted() throws Exception {
        Files.delete(tempFile);
        assertThrows(FileNotFoundException.class, () -> storage.load());
    }
}
