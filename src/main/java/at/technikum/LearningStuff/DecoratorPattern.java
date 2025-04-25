package at.technikum.LearningStuff;

interface CoffeeInterface {
    int getCost();

    String getIngredients();
}

class StandardCoffee implements CoffeeInterface {
    private int cost = 5;
    private String ingredients = "Coffee";


    @Override
    public int getCost() {
        return this.cost;
    }

    @Override
    public String getIngredients() {
        return this.ingredients;
    }
}


abstract class CoffeeDecorator implements CoffeeInterface {
    CoffeeInterface decoratedCoffee;

    public CoffeeDecorator(CoffeeInterface coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    public int getCost() {
        return this.decoratedCoffee.getCost();
    }

    @Override
    public String getIngredients() {
        return this.decoratedCoffee.getIngredients();
    }
}

class MilkCoffee extends CoffeeDecorator {

    public MilkCoffee(CoffeeInterface coffee) {
        super(coffee);
    }

    @Override
    public int getCost() {
        return this.decoratedCoffee.getCost() + 2;
    }

    @Override
    public String getIngredients() {
        return this.decoratedCoffee.getIngredients() + " " + "Milk";
    }

}

public class DecoratorPattern {
    CoffeeInterface coffee = new StandardCoffee();

    CoffeeDecorator milkCoffee = new MilkCoffee(coffee);

    public void run() {
        System.out.println("Standard coffee");
        System.out.println(coffee.getCost());
        System.out.println(coffee.getIngredients());
        System.out.println("Milk Coffee");
        System.out.println(milkCoffee.getCost());
        System.out.println(milkCoffee.getIngredients());
    }
}
