public class Scissors extends Choice{
  
  public Scissors(ArrayList<Choice> winAgainst){
    super(ArrayList<Choice> winAgainst);
  }

  public int checkAgainst(Choice choice){
    //lógica para revisar que jugada gana, devuelve 1 si gana this, 0 si es igual, -1 si pierde el this
  }
  
}
