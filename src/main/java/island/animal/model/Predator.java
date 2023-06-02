package island.animal.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Predator extends Animal{
//    Animals animals;
//    Island island;
    String type = "Predator";
    public Predator(Animals animals, Island island) {
        super(animals, island);
//        this.animals = animals;
//        this.island = island;
    }

    @Override
    public void eat() {
        List<Animal> list =  new ArrayList<>(island.arrayCells[getPosition()].getAnimals());
        for (Animal animal : list) {
            if (animals.canEat.containsKey(animal.getAnimals())) {
                int potentialProbability = animals.canEat.get(animal.getAnimals());
                int probability = RandomValue.getIntRandom(101);
                double potentialFoodWeight = this.getMaxAnimalWeight() - this.getWeight();
                if (probability > potentialProbability && this.getWeight() < this.getMaxAnimalWeight()) {
                    double foodWeight = animal.getWeight() <= potentialFoodWeight ? animal.getWeight() : potentialFoodWeight;
                    this.setWeight(this.getWeight() + foodWeight);
//                    System.out.println(animal.getClass().getSimpleName() + " is eaten..."); //!!!!!!!!!!!!!!!!!
                    Logger.printLog(this.getClass().getSimpleName() + " (" + this.getUuid() + ") ate a " + animal.getClass().getSimpleName().toLowerCase() + ".");
                    Logger.printLog(animal.getClass().getSimpleName() + " (" + animal.getUuid() + ")" + " is eaten...");
                    animal.die();
                } else {
                    this.setWeight(this.getWeight() - 1);
                    if (this.getWeight() <= this.getNormalWeight() * 0.4) {
                        Logger.printLog(this.getClass().getSimpleName() + " (" + this.getUuid() + ") died of starvation.");
                        die();
                    }
                }
            }
        }

    }
}
