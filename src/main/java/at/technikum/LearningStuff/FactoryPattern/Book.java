package at.technikum.LearningStuff.FactoryPattern;

public class Book {
    private final String name;
    private final int pageNumber;

    public Book() {
        name = "Generic Book";
        pageNumber = 0;
    }

    public Book(String name, int pageNumber) {
        this.name = name;
        this.pageNumber = pageNumber;
    }

    public String getName() {
        return name;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public String describe() {
        return "This is a generic book";
    }
}

class Novel extends Book {
    public Novel(String name, int pageNumber) {
        super(name, pageNumber);
    }

    @Override
    public String describe() {
        return "A novel is an extended work of narrative fiction usually written in prose and published as a book.";
    }

    public void specialMethod() {
        System.out.println("Special");
    }
}

class Biography extends Book {
    public Biography(String name, int pageNumber) {
        super(name, pageNumber);
    }

    @Override
    public String describe() {
        return "A biography is the life history of an individual, written by someone else.";
    }
}

