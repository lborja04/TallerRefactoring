public class RPMGame{

  private Player player1;
  private Player player2;
  private int victoriasRequeridas;
  private int numeroRondas;
  
  public RPMGame(Player player1, Player player2, int victoriasRequeridas){
    this.player1=player1;
    this.player2=player2;
    this.victoriasRequeridas=victoriasRequeridas;
    this.numeroRondas=0;
  }
  
  public static void main(String args[]){
    player1 = new Player();
    player2 = new Player();
    victoriasRequeridas = 1 + (int) (Math.random() * 3);

    RPMGame partida=new RPMGame(p1,p2,victoriasRequeridas);
    partida.start();
  }

  public void start(){
    boolean condicion1, condicion2;
    do{
      condicion1=player1.getVictorias() < victoriasReq;
      condicion2=player2.getVictorias() < victoriasReq;
      
      Ronda ronda=new Ronda(player1,player2);
      printGameDetails();
      ronda.start();
      
      numeroRondas++;
    }
    while(condicion1 || condicion2);
    printWinner();
  }

  public void printGameDetails(Round ronda){
    System.out.println("***"+"Round: "+numeroRondas+"***");
    System.out.println("***"+"Number of Draws:"+numeroEmpates+"***");
  }

  public void printWinner(){
    int player1Wins=player1.getWins();
    int player2Wins=player2.getWins();

    if(player1Wins>player2Wins)
      System.out.println("Player 1 Wins");
    else if(player2Wins>player1Wins)
      System.out.println("Player 2 Wins");
    else
      System.out.println("Game draw");
  }
}



public class Ronda{

  private Player player1;
  private Player player2;
  private Choice player1Choice;
  private Choice player2Choice;  

  public Ronda(Player player1, Player player2){
    this.player1=player1;
    this.player2=player2;
  }

  public void start(){
    player1Choice=player1.playerChoice();
    player2Choice=player2.playerChoice();

    printRoundDetails();
    int resultado=player1Choice.checkAgainst(player2Choice);
    calcularGanador(resultado);
  }

  public void calcularGanador(int resultado){
    int victoriasPlayer1=player1.getWins();
    int victoriasPlayer2=player2.getWins();
    
    switch(resultado){
      case 1:
        System.out.println("Player 1 wins");
        player1.setWins(victoriasPlayer1++);
      case 0:
        System.out.println("Draw");
      case -1:
        System.out.println("Player 2 wins");
        player2.setWins(victoriasPlayer2++);
    }
  }

  public void printRoundDetails(){
    int victoriasPlayer1=player1.getWins();
    int victoriasPlayer2=player2.getWins();
    
    System.out.println("Player 1:"+player1Choice);
    System.out.println("Player 1 Total Wins:"+player1Wins);
    System.out.println("Player 2:"+player2Choice);
    System.out.println("Player 2 Total Wins:"+player2Wins);
  }
}



public class Player{
  private int wins;
  
  public Choice playerChoice(){
    //lógica para elegir un Choice al azar
  }

  public void setWins(int wins){
    this.wins=wins;
  }

  public int getWins(){
    return this.wins;
  }
}



public abstract class Choice{
  private ArrayList<Choice> winAgainst;

  public Choice(ArrayList<Choice> winAgainst){
    this.winAgainst=winAgainst;
  }
  
  public abstract int checkAgainst(Choice choice);
}



public class Rock extends Choice{
  public Rock(ArrayList<Choice> winAgainst){
    super(ArrayList<Choice> winAgainst);
  }

  public int checkAgainst(Choice choice){
    //lógica para revisar que jugada gana, devuelve 1 si gana this, 0 si es igual, -1 si pierde el this
  }
}



public class Paper extends Choice{
  public Paper(ArrayList<Choice> winAgainst){
    super(ArrayList<Choice> winAgainst);
  }

  public int checkAgainst(Choice choice){
    //lógica para revisar que jugada gana, devuelve 1 si gana this, 0 si es igual, -1 si pierde el this
  }
}



public class Scissors extends Choice{
  public Scissors(ArrayList<Choice> winAgainst){
    super(ArrayList<Choice> winAgainst);
  }

  public int checkAgainst(Choice choice){
    //lógica para revisar que jugada gana, devuelve 1 si gana this, 0 si es igual, -1 si pierde el this
  }
}
