package at.technikum.LearningStuff;

// Builder pattern example

public class BuilderPatternBurgerMaker {
    private String patty;
    private int portion;
    private String sauce;
    private boolean onions;
    private boolean lettuce;

    private BuilderPatternBurgerMaker(BurgerBuilder bb) {
        this.patty = bb.patty;
        this.portion = bb.portion;
        this.sauce = bb.sauce;
        this.onions = bb.onions;
        this.lettuce = bb.lettuce;
    }

    public void serveBurger() {
        System.out.println("Burger served: ");
        System.out.println("Patty: " + patty + ", Portion: " + portion + ", Sauce: " + sauce + ", Onions: " + onions + ", Lettuce: " + lettuce);
    }

    public static class BurgerBuilder {
        private final String patty;
        private final int portion;
        private String sauce;
        private boolean onions = false;
        private boolean lettuce = false;

        public BurgerBuilder(String patty, int portion) {
            this.patty = patty;
            this.portion = portion;
        }

        public BurgerBuilder sauce(String s) {
            this.sauce = s;
            return this;
        }

        public BurgerBuilder onions(boolean b) {
            this.onions = b;
            return this;
        }

        public BurgerBuilder lettuce(boolean b) {
            this.lettuce = b;
            return this;
        }

        public BuilderPatternBurgerMaker cook() {
            return new BuilderPatternBurgerMaker(this);
        }
    }

}

// main method
/*
Burger burger = new Burger.BurgerBuilder("normal patty", 2)
                .lettuce(true)
                .cook();

        Burger burger2 = new Burger.BurgerBuilder("sesame patty", 5)
                .onions(true)
                .lettuce(true)
                .cook();

        burger.serveBurger();
        burger2.serveBurger();
* */