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
