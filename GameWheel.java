import java.util.*;

public class GameWheel
{

  private ArrayList<Slice> slices; // List of slices making up the wheel
  private int currentPos;   // Position of currently selected slice on wheel


  /* Returns string representation of GameWheel with each numbered slice
   * on a new line
   */
  public String toString()
  {
    //Implement the toString method here
    String gm = "";

    // Loop to print GameWheel
    for(int i = 0; i < slices.size(); i++)
    {
      gm += i + " - " + slices.get(i) + "\n";
    }

    return gm;
    
  }


  /* Randomizes the positions of the slices that are in the wheel, but without
   * changing the pattern of the colors
   */
  public void scramble()
  {
    // scramble black slices

      for(int i = 0; i < slices.size(); i++) // goes through every object in ArrayList
      {
        Slice temp = new Slice(slices.get(i).getColor(), slices.get(i).getPrizeAmount()); // creates temp Slice onject

        int rand = (int) (Math.random()*20); // random number 0-19

        if(i%5 == 0) // checks that index is a multiple of 5
        {
          if(rand%5 == 0) // checks that rand is a multiple of 5, sets object at i to rand and object at rand to temp if true
          {
            slices.set(i, slices.get(rand));
            slices.set(rand, temp);
          }
          else // if false, decrements i to go through a different number rand
          {
            i--;
          }
        }
        else if(i%2 == 0) // checks that index is even
        {
          if(rand%2 == 0 && rand%5 != 0) // checks that rand is even and not a multiple of 5
          {
            slices.set(i, slices.get(rand));
            slices.set(rand, temp);
          }
          else
          {
            i--;
          }
        }
        else if(i%2 == 1) // checks that i is odd
        {
          if(rand%2 == 1 && rand%5 != 0) // checks that rand is odd and not a multiple of 5
          {
            slices.set(i, slices.get(rand));
            slices.set(rand, temp);
          }
          else
          {
            i--;
          }
        }
      }
    
  }


  /* Sorts the positions of the slices that are in the wheel by prize amount,
   * but without changing the pattern of the colors.
   */
  public void sort()
  {
    //Implement the sort method here

    for(int i = 0; i < slices.size(); i += 5) // selection sort for multiples of 5
    {
      int min = i;
      for(int j = i + 5; j < slices.size(); j += 5)
      {
        if(slices.get(j).getPrizeAmount() < slices.get(min).getPrizeAmount())
        {
          min = j;
        }
      }
    
      Slice temp = new Slice(slices.get(i).getColor(), slices.get(i).getPrizeAmount());
      slices.set(i, slices.get(min));
      slices.set(min, temp);
    }

    for(int i = 0; i < slices.size(); i += 2) // selection sort for even indexes
    {
      if(i%5 != 0) // checks that index isn't a multiple of 5
      {
        int min = i;
        for (int j = i + 2; j < slices.size(); j += 2)
        {
          if(j != 0 && j != 10)
          {
            if(slices.get(j).getPrizeAmount() < slices.get(min).getPrizeAmount())
            {
              min = j;
            }
          }
        }
      
        Slice temp = new Slice(slices.get(i).getColor(), slices.get(i).getPrizeAmount());
        slices.set(i, slices.get(min));
        slices.set(min, temp);
      }
    }

    for(int i = 1; i < slices.size(); i += 2) // selection sort for odd indexes
    {
      if(i%5 != 0) // checks that i isn't an index of 5
      {
        int min = i;
        for (int j = i + 2; j < slices.size(); j += 2)
        {
          if(j != 5 && j != 15)
          {
            if(slices.get(j).getPrizeAmount() < slices.get(min).getPrizeAmount())
            {
              min = j;
            }
          }
        }
      
        Slice temp = new Slice(slices.get(i).getColor(), slices.get(i).getPrizeAmount());
        slices.set(i, slices.get(min));
        slices.set(min, temp);
      }
    }
      
  }

  /* COMPLETED METHODS - YOU DO NOT NEED TO CHANGE THESE */

  /* Creates a wheel with 20 preset slices
   */
  public GameWheel()
  {
    this(getStandardPrizes());
  }

  /* Creates a wheel with 20 slices, using values from array parameter
   */
  public GameWheel(int[] prizes)
  {
    currentPos = 0;
    slices = new ArrayList<Slice>();

    for(int i = 0; i < 20; i++)
    {
      int pa = 0;
      String col = "blue";

      if(i < prizes.length)
      {
        pa = prizes[i];
      }

      if (i%5 == 0)
      {
        col = "black";
      }
      else if (i%2 == 1)
      {
        col = "red";
      }
      
      slices.add(new Slice(col, pa));
    }
  }

  /* Spins the wheel by so that a different slice is selected. Returns that
   * slice (Note: the 10 slices following the current slice are more likely to
   * be returned than the other 10).
   */
  public Slice spinWheel()
  {
    //spin power between range of 1-50 (inclusive)
    int power = (int)(Math.random()*50 + 1);
    int newPos = (currentPos + power) % slices.size();
    currentPos = newPos;

    return slices.get(currentPos);
  }

  public Slice getSlice(int i)
  {
    int sliceNum = i;

    if(i < 0 || i > 19)
    {
      sliceNum = 0;
    }

    return slices.get(sliceNum);
  }

  // Makes an array with a standard list of prizes
  private static int[] getStandardPrizes()
  {
    int[] arr = new int[20];

    for (int i=0; i < 20; i++)
    {
      if (i%5 == 0)
      {
        arr[i] = i*1000;
      }
      else if (i%2 == 1)
      {
        arr[i] = i*100;
      }
      else
      {
        arr[i] = i*200;
      }
    }

    return arr;
  }

}