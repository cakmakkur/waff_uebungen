package at.technikum.LearningStuff.FactoryPattern;

public class BookFactory {
    public enum BookTypes {
        NOVEL, BIOGRAPHY
    }

    public static Book publishBook(BookTypes type, String name, int pageNumber) {
        return switch (type) {
            case NOVEL -> new Novel(name, pageNumber);
            case BIOGRAPHY -> new Biography(name, pageNumber);
            case null -> new Book();
        };
    }
}

