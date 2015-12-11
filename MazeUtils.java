import java.util.Scanner;

public class MazeUtils {
  //Main class. Will call upon other functions.
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int x=7;
    int y=1;
    int mazeChoice;
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
    System.out.println("==========================");
    System.out.println("= Welcome to Maze Mania! =");
    System.out.println("==========================");
    do {
      quitSolvedOrQ = false;
      mazeChoice = displayMazeMenu(input);

      if(mazeChoice != -1) {
        //Gets directions to move in maze and implements them
        do {
          displayMaze(maze,x,y,mazeChoice);
          System.out.println("Enter a command: (l)eft, (r)ight, (u)p, (d)own, (q)uit");
          String commands = input.next();

          for(int i= 0; i<commands.length(); i++) {
            System.out.println();
            // Left
            if(commands.charAt(i) == 'l')
            {
              if(y-1 >= 0 && maze[mazeChoice][x][y-1] != 1)
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
              if(y+1 < 8 && maze[mazeChoice][x][y+1] != 1)
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
              if(maze[mazeChoice][x-1][y] != 1)
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
              if(maze[mazeChoice][x+1][y] != 1)
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
              break;
            }
            //Solved the maze
            if(maze[mazeChoice][x][y] == 3)
            {
              System.out.println("Congralations, you solved the maze! Which one do you want to try next?");
              // reset player starting position
              // need to tie this to different spot for different mazes eventually
              x=7;
              y=1;
              quitSolvedOrQ = true;
              break;
            }
          }
        } while(quitSolvedOrQ == false);
      }
    } while(true);
  }

  public static int displayMazeMenu(Scanner input){
    System.out.println("To play a maze, enter a number: 1, 2, or 3.");
    System.out.println("Maze number correlates to it's level of difficulty, so choose accordingly.");
    System.out.println("Enter 'q' to quit.");
    // must be string so user can quit from main menu
    String userChoice = input.next();

    if(userChoice.equals("1") || userChoice.equals("2") || userChoice.equals("3") || userChoice.equals("q"))
    {
      if(userChoice.equals("q"))
      {
        System.exit(0);
      }
      else
      {
        // convert user choice from string to int for use in getting maze from array
        int mazeChoice = Integer.parseInt(userChoice);
        // arrays are zero based, so minus 1 to select the right maze
        mazeChoice -= 1;
        return mazeChoice;
      }
    }
    else
    {
      System.out.println("Please enter a maze choice: 1, 2, or 3, or enter 'q' to quit.");
      return -1;
    }
    return -1;
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
