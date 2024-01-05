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
  
}
