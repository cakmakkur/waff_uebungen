package at.technikum.LearningStuff;

public class Singleton {
    private static volatile Singleton instance;
    // volatile ensures atomic visibility
    private String data;

    private Singleton(String data) {
        this.data = data;
    }

    public static Singleton getInstance(String data) {
        // instead of ---if (instance == null)--- and at the end ---return instance---
        // which retrieves instance twice from memory, we can turn it into a local variable for both if-check and return
        // this can increase performance greatly

        // reason of this outer if-check is to prevent it go into synchronised block and reduce performance if there is already an instance to return

        Singleton result = instance;

        if (result == null) {
            // synchronised block ensures only one write operation at a time
            synchronized (Singleton.class) {
                if (result == null) {
                    result = new Singleton(data);
                }
            }
        }
        return result;
    }
}
