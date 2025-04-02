package at.technikum.LearningStuff;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Editor {
    private final Deque<TextArea.Memento> history = new ArrayDeque<>();
    private final TextArea ta = new TextArea();

    public Editor() {
        history.push(ta.takeSnapshot());
    }

    public void write(String s) {
        ta.setText(s);
        history.push(ta.takeSnapshot());
    }

    public String read() {
        return ta.getText();
    }

    public void print() {
        System.out.println(read());
    }

    public void undo() {
        if (history.size() > 1) {
            history.pop();
            ta.restore(history.peek());
        }
    }
}

class TextArea {
    private String text = "";

    public void appendText(String s) {
        StringBuilder sb = new StringBuilder().append(text);
        if (!text.isEmpty()) {
            sb.append(" ");
        }
        sb.append(s);
        text = sb.toString();
    }

    public void setText(String s) {
        text = s;
    }

    public Memento takeSnapshot() {
        return new Memento(text);
    }

    public String getText() {
        return text;
    }

    public void restore(Memento m) {
        text = m.getSavedText();
    }

    public static class Memento {
        private final String text;

        private Memento(String t) {
            text = t;
        }

        private String getSavedText() {
            return text;
        }
    }
}


public class MementoPattern {
    public static void run() {
/*        Editor editor = new Editor();
        editor.write("1 - Hello");
        editor.write("2 - World");
        editor.write("3 - Java");
        System.out.println("Last entry: ");
        System.out.println(editor.read());
        System.out.println();
        editor.undo();
        System.out.println("After one undo:");
        System.out.println(editor.read());
        editor.undo();
        System.out.println("After second undo:");
        System.out.println(editor.read());*/
        Scanner sc = new Scanner(System.in);
        Editor editor = new Editor();
        System.out.println("Enter your text: (type \"*undo*\" to undo)");
        while (sc.hasNext()) {
            String input = sc.nextLine();
            if (input.equals("*undo*")) {
                editor.undo();
            } else {
                editor.write(input);
            }
            editor.print();
        }

    }
}
