package at.technikum.LearningStuff;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MementoPatternTests {
    @Test
    void shouldSetTextInTextArea() {
        Editor editor = new Editor();
        String str = "-test string-";
        editor.write(str);
        assertEquals(editor.read(), str);
    }

    @Test
    void shouldIncreaseHistorySizeOnWrite() throws Exception {
        Editor editor = new Editor();

        // Before writing
        Field historyField = Editor.class.getDeclaredField("history");
        historyField.setAccessible(true);
        Deque<?> history = (Deque<?>) historyField.get(editor);
        int sizeBefore = history.size();

        // After writing
        editor.write("Test Entry");
        int sizeAfter = history.size();

        assertEquals(sizeBefore + 1, sizeAfter, "History size should increase by 1 after writing.");
    }
}
