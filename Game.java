import java.util.*;

public class Game
{

  public static void play(GameWheel g)
  {

    // create ArrayList that pulls Slice objects from GameWheel g
    ArrayList<Slice> spins = new ArrayList<Slice>();
    spins.add(g.spinWheel());
    spins.add(g.spinWheel());
    spins.add(g.spinWheel());

    // add up PrizeAmount of all 3 spins
    int totalPrize = spins.get(0).getPrizeAmount() + spins.get(1).getPrizeAmount() + spins.get(2).getPrizeAmount();

    // Get colors of all 3 spins
    String color1 = spins.get(0).getColor();
    String color2 = spins.get(1).getColor();
    String color3 = spins.get(2).getColor();

    // Check if colors are the same to double prize
    if(color1.equals(color2) && color2.equals(color3))
    {
      totalPrize *= 2;
    }

    // Print total prize and spins
    System.out.println("\nTotal prize money: $" + totalPrize);
    System.out.println();
    System.out.println("Spin 1 - " + spins.get(0));
    System.out.println("Spin 2 - " + spins.get(1));
    System.out.println("Spin 3 - " + spins.get(2));

    // Check if colors are the same again to print that prize was doubled
    if(color1.equals(color2) && color2.equals(color3))
    {
      System.out.println("Three " + color1 + "s = double your money!");
    }
    
  }
  
}