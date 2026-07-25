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

    }
}
