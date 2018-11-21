public class playerDevine {
    
    String name;
    int nbAlea;
    int essai;
    
    
    public playerDevine(String name){
        this.name = name;
        nbAlea = (int)(Math.random() * (100 + 1));
        System.out.print("Nom: "+ this.name);
        System.out.print("Nombre Aleatoire: " + this.nbAlea);
        this.essai = 0;
    }
    
}
