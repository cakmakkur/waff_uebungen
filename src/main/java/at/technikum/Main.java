package at.technikum;

import at.technikum.InClassStuff.Apr3;


public class Main {
    public static void main(String[] args) {
        String input = "<h1><h1>This is a header</h1></h1><par>This is a par</par><div>This is a div</div><";
        Apr3 a = new Apr3(input);
        a.extractContent();


/*        Calendars c = new Calendars();
        c.run();*/
    }
}