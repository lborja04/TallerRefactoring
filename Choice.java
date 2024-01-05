public abstract class Choice{
  private ArrayList<Choice> winAgainst;

  public Choice(ArrayList<Choice> winAgainst){
    this.winAgainst=winAgainst;
  }
  
  public abstract int checkAgainst(Choice choice);
  
}
