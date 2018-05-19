import java.io.*;
import java.util.*;

public class USACO{

  //BRONZE
  public static int bronze(String filename)throws FileNotFoundException{
    int total = 0;

    Scanner lake = new Scanner(new File(filename));
    int nRow = lake.nextInt();
    int nCol = lake.nextInt();
    int e = lake.nextInt();
    int n = lake.nextInt();
    int[][] field = new int[nRow][nCol];

    for (int row = 0; row < nRow; row++){
      for(int col = 0; col < nCol; col++){
        field[row][col] = lake.nextInt();
      }
    }

    int[] orders = new int[3];
    int count = 0;
    while (count < n){

      int max = 0;
      int current = 0;

      for (int x = 0; x < 3; x++) {
        orders[x] = lake.nextInt();
      }
      for (int x = orders[0] - 1; x < orders[0] + 2; x++){
        for (int y = orders[1] - 1; y < orders[1] + 2; y++) {
          if (field[x][y] > max) {
            max = field[x][y];
          }
        }
      }
      for (int x = orders[0] - 1; x < orders[0] + 2; x++){
        for (int y = orders[1] - 1; y < orders[1] + 2; y++) {
          if (field[x][y] == max) {
            field[x][y] = field[x][y] - orders[2];
            current = field[x][y];
          }
        }
      }
      for (int x = orders[0] - 1; x < orders[0] + 2; x++){
        for (int y = orders[1] - 1; y < orders[1] + 2; y++) {
          if (field[x][y] > current) {
            field[x][y] = current;
          }
        }
      }
      count++;
    }

    for (int x = 0; x < nRow; x++) {
      for (int y = 0; y < nCol; y++) {
        if (e - field[x][y] > 0) {
          total = total + (e - field[x][y]);
        }
      }
    }

    return total*72*72;
  }

  //SILVER////////////////////////////////////////////////////////
  public static int silver(String filename) throws FileNotFoundException{

    Scanner travel = new Scanner(new File(filename));

    int row = travel.nextInt();
    int col = travel.nextInt();
    int steps = travel.nextInt();

    travel.nextLine();

    char[][] map = new char[row][col];
    for (int x = 0; x < row; x++) {
      String line = travel.nextLine();
      for (int y = 0; y < col; y++){
        map[x][y] = line.charAt(y);
      }
    }

    int sRow = travel.nextInt();
    int sCol = travel.nextInt();
    int eRow = travel.nextInt();
    int eCol = travel.nextInt();

    int[][] fullPath = new int[row][col];
    fullPath[sRow - 1][sCol - 1] = 1;

    int Count = 0;
    while (Count < steps){
      int[][] currentPath = new int[row][col];
      for (int x = 0; x < row; x++){
        for (int y = 0; y < col; y++){
          if (map[x][y] != '*'){
            if ((x+1) < row){
              currentPath[x][y] = currentPath[x][y] + fullPath[x+1][y];
            }
            if ((x-1) >= 0){
              currentPath[x][y] = currentPath[x][y] + fullPath[x-1][y];
            }
            if ((y+1) < col){
              currentPath[x][y] = currentPath[x][y] + fullPath[x][y+1];
            }
            if ((y-1) >= 0){
              currentPath[x][y] = currentPath[x][y] + fullPath[x][y-1];
            }
          }
        }
      }
      for (int x = 0; x < row; x++){
        for (int y = 0; y < col; y++){
          fullPath[x][y] = currentPath[x][y];
        }
      }
      Count++;
    }
    return fullPath[erow - 1][eCol - 1];
  }
}
