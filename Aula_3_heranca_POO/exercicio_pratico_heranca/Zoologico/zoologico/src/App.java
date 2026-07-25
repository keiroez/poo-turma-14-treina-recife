
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Mamifero cachorro = new Mamifero(
            "cachorro",
             "M",
              1,
               true
            );
        cachorro.comer();
        System.out.println("___________________________________________");
        
        Ave galinha = new Ave(
            "galinha", 
            "F",
             1,
            true);
        galinha.comer();
        galinha.voar();
        System.out.println("___________________________________________");

        Ave avestruz = new Ave(
            "avestruz",
            "M",
            5,
            false
            );
        avestruz.comer();
        avestruz.voar();

        Reptil jacare = new Reptil(
            "jacaré",
            "M",
            5, 
            true);

        jacare.comer();


        Animal animal = new Mamifero("", "", 0, true);
        Animal ave = new Ave("", "", 0, true);

        List<Animal> animais = new ArrayList<>();
        
        animais.add(ave);
        animais.add(animal);
        animais.add(jacare);
        animais.add(galinha);

    }
}
