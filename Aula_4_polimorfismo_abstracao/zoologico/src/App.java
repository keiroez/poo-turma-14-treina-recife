import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Animal cachorro = new Cachorro(
            "cachorro",
             "M",
              1,
               true
            );

        System.out.println("___________________________________________");
        
        Animal galinha = new Galinha(
            "galinha", 
            "F",
             1,
            true);
        System.out.println("___________________________________________");

        Animal cobra = new Cobra("Naja", "M", 10, false);

       List<Animal> animais = new ArrayList<>();
       
       animais.add(galinha);
       animais.add(cachorro);
       animais.add(cobra);

       for(Animal animal: animais){
            animal.emitirSom();

            // if(animal instanceof Galinha){
            //     System.out.println("Có Có");
            // }

            // if(animal instanceof Cachorro){
            //      System.out.println("Au Au");
            // }

       }

    //    Animal animal = new Animal("animal", "animal", 0);

    }
}
