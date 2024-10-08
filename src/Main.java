import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static String[][][] KUBIKGREENFACE = {
            {{"ORA", "ORA", "ORA"}, {"ORA", "ORA", "ORA"}, {"ORA", "ORA", "ORA"}},
            {{"YEL", "YEL", "YEL"}, {"YEL", "YEL", "YEL"}, {"YEL", "YEL", "YEL"}},
            {{"RED", "RED", "RED"}, {"RED", "RED", "RED"}, {"RED", "RED", "RED"}},
            {{"BLU", "BLU", "BLU"}, {"BLU", "BLU", "BLU"}, {"BLU", "BLU", "BLU"}},
            {{"WHI", "WHI", "WHI"}, {"WHI", "WHI", "WHI"}, {"WHI", "WHI", "WHI"}},
            {{"GRE", "GRE", "GRE"}, {"GRE", "GRE", "GRE"}, {"GRE", "GRE", "GRE"}},
    };
    static String TEMP;
    static boolean solvbool = true;
    static boolean doReset = false;
    static ArrayList<String> solveTEMP = new ArrayList<>();

    public static void main(String[] args){
        boolean Autodraw = false;
        String TEXT = "";
        Scanner scan = new Scanner(System.in);
        boolean stopper = true;
        help();
        while(stopper){


            if (doReset){TEXT = solve();doReset = false;}
            else {TEXT= scan.nextLine();}
            String[] commands = TEXT.split(" ");
            String[][][] curentCube = KUBIKGREENFACE;
            for (String command : commands){
                switch (command){
                    case ("L"):rotate0(curentCube);break;
                    case ("D"):rotate1(curentCube);break;
                    case ("R"):rotate2(curentCube);break;
                    case ("B"):rotate3(curentCube);break;
                    case ("U"):rotate4(curentCube);break;
                    case ("F"):rotate5(curentCube);break;
                    case ("L'"):rotate0(curentCube);rotate0(curentCube);rotate0(curentCube);break;
                    case ("D'"):rotate1(curentCube);rotate1(curentCube);rotate1(curentCube);break;
                    case ("R'"):rotate2(curentCube);rotate2(curentCube);rotate2(curentCube);break;
                    case ("B'"):rotate3(curentCube);rotate3(curentCube);rotate3(curentCube);break;
                    case ("U'"):rotate4(curentCube);rotate4(curentCube);rotate4(curentCube);break;
                    case ("F'"):rotate5(curentCube);rotate5(curentCube);rotate5(curentCube);break;
                    case ("L2"):rotate0(curentCube);rotate0(curentCube);break;
                    case ("D2"):rotate1(curentCube);rotate1(curentCube);break;
                    case ("R2"):rotate2(curentCube);rotate2(curentCube);break;
                    case ("B2"):rotate3(curentCube);rotate3(curentCube);break;
                    case ("U2"):rotate4(curentCube);rotate4(curentCube);break;
                    case ("F2"):rotate5(curentCube);rotate5(curentCube);break;
                    case ("AUTO"):
                                   Autodraw= !Autodraw;
                                   System.out.println("Auto draw is "+Autodraw);break;
                    case ("HELP"):break;
                    case ("DRAW"):drawCube(curentCube);break;
                    case ("STOP"):scan.close();stopper = false;
                    case ("RESET"):
                        doReset=true;
                        solvbool = false;
                        break;
                    case ("RCHECK"): solvbool = true;
                }
                if (solvbool) {solveTEMP.add(command);}
                if (Autodraw){drawCube(curentCube);}

            }
        }
    }


    public static void rotate2(String[][][] cube) {
        String[] temp = new String[3];
        for (int i = 0; i < 3; i++) {
            temp[i]=cube[5][2-i][2];
            cube[5][2-i][2] = cube[1][2-i][2];
            cube[1][2-i][2] = cube[3][i][0];
            cube[3][i][0] = cube[4][2-i][2];
            cube[4][2-i][2] = temp[i] ;
        }

        rotateFaceClockwise(cube[2]);
    }
    public static void rotate0(String[][][] cube) {
        String[] temp = new String[3];
        for (int i = 0; i < 3; i++) {
            temp[i]=cube[5][i][0];
            cube[5][i][0] = cube[4][2-i][0];
            cube[4][2-i][0] = cube[3][2-i][2];
            cube[3][2-i][2] = cube[1][i][0];
            cube[1][i][0] = temp[i] ;
        }

        rotateFaceClockwise(cube[0]);
    }
    public static void rotate5(String[][][] cube) {
        String[] temp = new String[3];
        for (int i = 0; i < 3; i++) {
            temp[i]=cube[4][2][2-i];
            cube[4][2][2-i] = cube[0][i][2];
            cube[0][i][2] = cube[1][0][i];
            cube[1][0][i] = cube[2][2-i][0];
            cube[2][2-i][0] = temp[i] ;
        }

        rotateFaceClockwise(cube[5]);
    }
    public static void rotate4(String[][][] cube) {
        String[] temp = new String[3];
        for (int i = 0; i < 3; i++) {
            temp[i]=cube[5][0][i];
            cube[5][0][i] = cube[2][0][i];
            cube[2][0][i] = cube[3][0][i];
            cube[3][0][i] = cube[0][0][i];
            cube[0][0][i] = temp[i] ;
        }

        rotateFaceClockwise(cube[4]);
    }
    public static void rotate1(String[][][] cube) {
        String[] temp = new String[3];
        for (int i = 0; i < 3; i++) {
            temp[i]=cube[5][2][i];
            cube[5][2][i] = cube[0][2][i];
            cube[0][2][i] = cube[3][2][i];
            cube[3][2][i] = cube[2][2][i];
            cube[2][2][i] = temp[i] ;
        }

        rotateFaceClockwise(cube[1]);
    }
    public static void rotate3(String[][][] cube) {
        String[] temp = new String[3];
        for (int i = 0; i < 3; i++) {
            temp[i]=cube[1][2][i];
            cube[1][2][i] = cube[0][i][0];
            cube[0][i][0] = cube[4][0][2-i];
            cube[4][0][2-i] = cube[2][2-i][2];
            cube[2][2-i][2] = temp[i] ;
        }

        rotateFaceClockwise(cube[3]);
    }

    // Вращает любую сторону на 90 градусов по часовой стрелке
    public static void rotateFaceClockwise(String[][] face) {
        String[][] temp = new String[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp[i][j] = face[i][j];
            }
        }
        // Поворачиваем по часовой
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                face[i][j] = temp[2-j][i];
            }
        }
    }
    public static void drawCube(String[][][] cube) {
        System.out.println("\n---------------------------------------");
        for (int i = 0; i <3; i++){drawLine(cube[3][i],"             ",true);}
        System.out.println();
        for (int i = 0; i <3; i++){drawLine(cube[4][i],"             ",true);}
        System.out.println();
        System.out.println();
        for (int j = 0; j < 3; j++){
            if (j>0){System.out.println();}
            drawLine(cube[0][j],"",false);
            System.out.print(" ");
            drawLine(cube[5][j],"",false);
            System.out.print(" ");
            drawLine(cube[2][j],"",false);
        }
        System.out.println();
        for (int j = 0; j < 3; j++){drawLine(cube[1][j],"             ",true);}
        System.out.println();

    }
    static void drawLine(String[] side, String space,boolean doNext){
        if (doNext){System.out.println();}
        System.out.print(space);
        for (int i = 0; i<3;i++){
                System.out.print(" "+side[i]);
        }
    }
    public static void drawCubeDEBUG(String[][][] cube){
        System.out.println("\n----------------------------------------------------------------------------");
        for (int i = 0; i<3 ;i++){
            System.out.println();
            for(int j = 0; j<3;j++){
                System.out.print(" ");
                for(int l = 0; l<3;l++){
                    System.out.print(" "+cube[j][i][l]+j+i+l);
                }
            }
        }
        for (int i = 0; i<6 ;i++){
            if (i<6 && i>2){
                System.out.println();
                for(int j = 0; j<3;j++){
                    System.out.println();
                    System.out.print("                       ");
                    for(int l = 0; l<3;l++){
                        System.out.print(" "+cube[i][j][l]+i+j+l);
                    }
                }
            }
        }
    }
    public static String solve(){
        TEMP = "";
        List<String> solv = solveTEMP.reversed();
        for (String instr : solv){
            if (instr.length() < 3){
            if (instr.contains("R") || instr.contains("F") || instr.contains("U") ||
                instr.contains("B") || instr.contains("D") || instr.contains("L") ) {
                if (instr.contains("'")) {
                    TEMP += instr.charAt(0)+" ";
                } else if (instr.contains("2")) {
                    TEMP += instr+" ";
                } else {
                    TEMP += instr + "' ";
                }

            }}
        }

        solveTEMP.clear();
        solv.clear();
        System.out.println(TEMP);
        TEMP += "RCHECK";
        return TEMP;
    }
    public static void help(){
        System.out.println("""
                F: Rotate GREEN  | ' :     Rotate Counter-Clockwise           | DRAW : Draw the cube\s
                R: Rotate RED    | 2 :     Rotate Two Times\s
                U: Rotate WHITE  | RESET : Solves the cube'\s
                B: Rotate BLUE   | STOP  : Stops the program\s
                L: Rotate ORANGE | HELP  : Shows this\s
                D: Rotate YELLOW | AUTO  : Enable/disable Auto draw""");
    }
}