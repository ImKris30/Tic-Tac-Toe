package tictactoe;
import java.util.Scanner;

public class Main {
     static int count = 1;
    Scanner sc = new Scanner(System.in);
    public static void main (String[] args) {
       char[][] ch = new char[3][3];
       for (int i = 0; i < 3; i++) {
           for (int j = 0; j < 3; j++) {
               ch[i][j] = ' ';
           }
       }
        print(ch); 
        checkCoordinates(ch);
        
    }
    public static void print(char[][] ch) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                
                    System.out.print(ch[i][j] + " ");
                
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }     
    public static void checkCoordinates(char[][] ch) {
        Scanner sc = new Scanner(System.in);
        boolean True = true;
        while(True) {
            System.out.print("Enter the coordinates: ");
            
            String a = sc.next();
            String b = sc.next();
            
            int sizeA = a.length();
            int sizeB = b.length();
            if (sizeA != 1 || sizeB != 1) {
                System.out.println("You should enter numbers!");
                continue;
            } else if (!((a.charAt(0) == '1' || a.charAt(0) == '2' || a.charAt(0) == '3') &&
                    (b.charAt(0) == '1' || b.charAt(0) == '2' || b.charAt(0) == '3'))) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }else if ((a.charAt(0) == '1' || a.charAt(0) == '2' || a.charAt(0) == '3') &&
                    (b.charAt(0) == '1' || b.charAt(0) == '2' || b.charAt(0) == '3')){
                True = adjustCoordinate(a,b,ch);
                boolean check =  stepCheck(ch);
                if (check == true) {
                    True = false;
                } else if (check == false) {
                    True = true;
                }
            }
        }
        whoWins(ch);
    }
    public static boolean stepCheck(char[][] ch){
        boolean x = false;
        boolean o = false;
        //check rows
        for (int i = 0; i < 3; i++) {
            if (ch[i][0] == ch[i][1] && ch[i][1] == ch[i][2]) {
                switch (ch[i][0]) {
                    case 'X' :
                        x = true;
                        return x;
                    case 'O' :
                        o = true;
                        return o;
                    default:
                        break;
                }
            }
        }
        // check columns
        for (int i = 0; i < 3; i++) {
            if (ch[0][i] == ch[1][i] && ch[1][i] == ch[2][i]) {
                switch (ch[0][i]) {
                    case 'X' :
                        x = true;
                        return x;
                    case 'O' :
                        o = true;
                        return o;
                    default:
                        break;
                }
            }
        }
        //check diagonal
        if ((ch[0][0] == ch[1][1] && ch[1][1] == ch[2][2]) || (ch[0][2] == ch[1][1]
                && ch[1][1] == ch[2][0])) {
            switch (ch[1][1]) {
                case 'X' :
                    x = true;
                    return x;
                case 'O' :
                    o = true;
                    return o;
                default:
                    break;
            }
        }
        int thor = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (ch[i][j] != ' ') {
                    thor++;
                }
            }
        }
        if (thor == 9) {
            System.out.println("Draw");
            return true;
        }
        return false;
    }
    public static boolean adjustCoordinate(String a, String b, char[][] ch) {
        boolean result = false;
        int c1 = Integer.parseInt(a);
        int c2 = Integer.parseInt(b);
       if (c1 == 1 && c2 == 3) {
            c1 = 0; c2 = 0;
        } else if (c1 == 1 && c2 == 3) {
            c1 = 0; c2 = 0;
        } else if (c1 == 2 && c2 == 3) {
            c1 = 0; c2 = 1;
        } else if (c1 == 3 && c2 == 3) {
            c1 = 0; c2 = 2;
        } else if (c1 == 1 && c2 == 2) {
            c1 = 1; c2 = 0;
        } else if (c1 == 2 && c2 == 2) {
            c1 = 1; c2 = 1;
        } else if (c1 == 3 && c2 == 2) {
            c1 = 1; c2 = 2;
        } else if (c1 == 1 && c2 == 1) {
            c1 = 2; c2 = 0;
        } else if (c1 == 2 && c2 == 1) {
            c1 = 2; c2 = 1;
        } else if (c1 == 3 && c2 == 1) {
            c1 = 2; c2 = 2;
        }
        if (ch[c1][c2] == 'X' || ch[c1][c2] == 'O'){
            System.out.println("This cell is occupied! Choose another one!");
            result = true;
            return result;
        }
        
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                if (c1 == i && c2 == j) {
                    if (count % 2 != 0) {
                        count = count + 1;
                        
                    ch[i][j] = 'X';
                    
                    } else if (count % 2 == 0) {
                         
                         count = count + 1;
                        ch[i][j] = 'O';
                        
                    }
                    
                    break;
               }
            }
        }
        print(ch);
        return result;
       }
    public static void whoWins(char[][] ch) {
        
        if (!checkImpossible(ch)) {
            System.out.println("Impossible");
            return;
        }

        String input = checkWin(ch);
        switch(input) {
            case "X":
                System.out.println("X wins");
                break;

            case "O":
                System.out.println("O wins");
                break;

            case "tie" :
                break;
                
                

            case "impossible" :
                System.out.println("Impossible");
                break;

            case "not" :
                System.out.println("Game not finished");
                break;
        } 

    }
    public static String checkWin(char[][] ch) {
        boolean x = false;
        boolean o = false;
        //check rows
        for (int i = 0; i < 3; i++) {
            if (ch[i][0] == ch[i][1] && ch[i][1] == ch[i][2]) {
                switch (ch[i][0]) {
                    case 'X' :
                        x = true;
                        break;
                    case 'O' :
                        o = true;
                        break;
                    default:
                        break;
                }
            }
        }
        // check columns
        for (int i = 0; i < 3; i++) {
            if (ch[0][i] == ch[1][i] && ch[1][i] == ch[2][i]) {
                switch (ch[0][i]) {
                    case 'X' :
                        x = true;
                        break;
                    case 'O' :
                        o = true;
                        break;
                    default:
                        break;
                }
            }
        }
        //check diagonal
        if ((ch[0][0] == ch[1][1] && ch[1][1] == ch[2][2]) || (ch[0][2] == ch[1][1]
                && ch[1][1] == ch[2][0])) {
            switch (ch[1][1]) {
                case 'X' :
                    x = true;
                    break;
                case 'O' :
                    o = true;
                    break;
                default:
                    break;
            }
        }
        if (x && o) {
            return "impossible";
        } else if(x) {
            return "X";
        } else if (o) {
            return "O";
        } else if(getDashCount(ch) > 0) {
            return "not";
        } else {
            return "tie";
        }
    }
    public static int getDashCount(char[][] arr) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == '_') {
                    count++;
                }
            }
        }
        return count;
    }
    public static boolean checkImpossible(char[][] ch) {
        int countX = 0;
        int countO = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
            if (ch[i][j] == 'X') {
                countX++;
            } else if (ch[i][j] == 'O') {
                countO++;
            }
          }
        }
        if (countO > countX + 1 || countX > countO + 1) {
            return false;
        }
        return true;
    }
}
