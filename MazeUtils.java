import java.util.Scanner;

public class MazeUtils {
  //Main class. Will call upon other functions.
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int x=7;
    int y=1;
    int userChoice;

    //Makes the Menu close after entering a number. Opens again after the user solves the maze
    boolean quitMenu = false;

    //Makes the Maze and the menu to stop appearing. (Stops Program)
    boolean quitSolvedOrQ = false;

    //3D Array with three separate mazes
    int maze[][][] = {
      {
        {0,1,1,1,1,1,1,1},
        {1,1,3,1,1,1,1,1},
        {1,1,0,0,0,0,1,1},
        {0,0,0,1,1,1,1,1},
        {1,1,0,0,0,1,1,1},
        {0,0,0,1,1,1,1,1},
        {1,1,0,1,1,1,1,1},
        {0,0,0,1,1,1,1,1}
      },
      {
        {1,1,3,1,1,1,1,1},
        {1,1,0,0,0,0,1,1},
        {1,1,0,0,0,0,1,1},
        {0,0,0,1,1,1,1,1},
        {1,1,0,0,0,1,1,1},
        {0,0,0,1,1,1,1,1},
        {1,1,0,1,1,1,1,1},
        {0,0,0,1,1,1,1,1}
      },
      {
        {2,1,3,1,1,1,1,1},
        {1,1,0,0,0,0,1,1},
        {1,1,0,0,0,0,1,1},
        {0,0,0,1,1,1,1,1},
        {1,1,0,0,0,1,1,1},
        {0,0,0,1,1,1,1,1},
        {1,1,0,1,1,1,1,1},
        {0,0,0,1,1,1,1,1}
      }
    };

    //Menu
    do {
      System.out.println("Welcome to Maze Mania! To play a maze, enter a number: 1, 2, or 3.");
      System.out.println("Maze number correlates to it's level of difficulty, so choose accordingly.");

      userChoice = input.nextInt();

      if (userChoice < 1 || userChoice > 3 )
      {
        System.out.println("Please enter a 1, 2, or 3");
      }
      else
      {
        // arrays are zero based, so minus 1 to select the right maze
        userChoice--;
        quitMenu = true;
      }
    } while(quitMenu == false);

    //Gets directions to move in maze and implements them
    do {
      displayMaze(maze,x,y,userChoice);
      System.out.println("Enter a command: (l)eft, (r)ight, (u)p, (d)own, (q)uit");
      String commands = input.next();

      for(int i= 0; i<commands.length(); i++) {
        System.out.println();
        // Left
        if(commands.charAt(i) == 'l')
        {
          if(y-1 >= 0 && maze[userChoice][x][y-1] != 1)
          {
            y -= 1;
          }
          else
          {
            System.out.println("You ran into a wall! Please enter a vaild command");
          }
        }
        //Right
        if(commands.charAt(i) == 'r')
        {
          if(y+1 < 8 && maze[userChoice][x][y+1] != 1)
          {
            y += 1;
          }
          else
          {
            System.out.println("You ran into a wall! Please enter a vaild command");
          }
        }
        //Up
        if(x-1 >= 0 && commands.charAt(i) == 'u')
        {
          if(maze[userChoice][x-1][y] != 1)
          {
            x -= 1;
          }
          else
          {
            System.out.println("You ran into a wall! Please enter a vaild command");
          }
        }
        //Down
        if(x+1 < 8 && commands.charAt(i) == 'd')
        {
          if(maze[userChoice][x+1][y] != 1)
          {
            x += 1;
          }
          else
          {
            System.out.println("You ran into a wall! Please enter a vaild command");
          }
        }
        //Quit
        if(commands.charAt(i) == 'q')
        {
          quitSolvedOrQ = true;
          quitMenu = false;
          break;
        }
        //Solved the maze
        if(maze[userChoice][x][y] == 3)
        {
          System.out.println("Congralations, you solved the maze! Which one do you want to try next?");
          userChoice = input.nextInt();
          quitSolvedOrQ = true;
          quitMenu = false;
          break;
        }
      }
    } while(quitSolvedOrQ == false);
  }

  // Displays the maze correctly
  public static void displayMaze(int[][][] maze, int x, int y, int userChoice){
    int rows = 8;
    int columns = 8;

    for(int i = 0; i<rows; i++)
    {
      for(int b = 0; b<columns; b++)
      {
        if (x == i && y == b)
        {
          System.out.print("o");
        }
        else if (maze[userChoice][i][b] == 1)
        {
          System.out.print("X");
        }
        else if (maze[userChoice][i][b] == 0)
        {
          System.out.print(" ");
        }
        else if (maze[userChoice][i][b] == 3) {
          System.out.print("F");
        }
      }
      System.out.println();
    }
  }
}
