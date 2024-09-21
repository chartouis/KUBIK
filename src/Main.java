import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static String[][][] KUBIK = {
            {{"ORA", "ORA", "ORA"}, {"ORA", "ORA", "ORA"}, {"ORA", "ORA", "ORA"}},
            {{"YEL", "YEL", "YEL"}, {"YEL", "YEL", "YEL"}, {"YEL", "YEL", "YEL"}},
            {{"GRE", "GRE", "GRE"}, {"GRE", "GRE", "GRE"}, {"GRE", "GRE", "GRE"}},
            {{"RED", "RED", "RED"}, {"RED", "RED", "RED"}, {"RED", "RED", "RED"}},
            {{"WHI", "WHI", "WHI"}, {"WHI", "WHI", "WHI"}, {"WHI", "WHI", "WHI"}},
            {{"BLU", "BLU", "BLU"}, {"BLU", "BLU", "BLU"}, {"BLU", "BLU", "BLU"}},
    };
    static String[][][] KUBIKGREENFACE = {
            {{"ORA", "ORA", "ORA"}, {"ORA", "ORA", "ORA"}, {"ORA", "ORA", "ORA"}},
            {{"YEL", "YEL", "YEL"}, {"YEL", "YEL", "YEL"}, {"YEL", "YEL", "YEL"}},
            {{"RED", "RED", "RED"}, {"RED", "RED", "RED"}, {"RED", "RED", "RED"}},
            {{"BLU", "BLU", "BLU"}, {"BLU", "BLU", "BLU"}, {"BLU", "BLU", "BLU"}},
            {{"WHI", "WHI", "WHI"}, {"WHI", "WHI", "WHI"}, {"WHI", "WHI", "WHI"}},
            {{"GRE", "GRE", "GRE"}, {"GRE", "GRE", "GRE"}, {"GRE", "GRE", "GRE"}},
    };


    public static void main(String[] args) throws InterruptedException {

        Scanner scan = new Scanner(System.in);
        boolean stopper = true;
        while(stopper){
            String TEXT = scan.nextLine();
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
                    case ("STOP"):scan.close();stopper = false; break;
                    case ("RESET"):
                        curentCube = new String[][][]{
                                {{"ORA", "ORA", "ORA"}, {"ORA", "ORA", "ORA"}, {"ORA", "ORA", "ORA"}},
                                {{"YEL", "YEL", "YEL"}, {"YEL", "YEL", "YEL"}, {"YEL", "YEL", "YEL"}},
                                {{"RED", "RED", "RED"}, {"RED", "RED", "RED"}, {"RED", "RED", "RED"}},
                                {{"BLU", "BLU", "BLU"}, {"BLU", "BLU", "BLU"}, {"BLU", "BLU", "BLU"}},
                                {{"WHI", "WHI", "WHI"}, {"WHI", "WHI", "WHI"}, {"WHI", "WHI", "WHI"}},
                                {{"GRE", "GRE", "GRE"}, {"GRE", "GRE", "GRE"}, {"GRE", "GRE", "GRE"}},};
                        break;
                }
                drawCube(curentCube);
            }
        }
    }


    public static void rotate2(String[][][] cube) {
        String[] temp = new String[3];
        for (int i = 0; i < 3; i++) {
            temp[i]=cube[5][i][2];
            cube[5][i][2] = cube[1][i][2];
            cube[1][i][2] = cube[3][i][2];
            cube[3][i][2] = cube[4][i][2];
            cube[4][i][2] = temp[i] ;
        }

        rotateFaceClockwise(cube[2]);
    }
    public static void rotate0(String[][][] cube) {
        String[] temp = new String[3];
        for (int i = 0; i < 3; i++) {
            temp[i]=cube[5][i][0];
            cube[5][i][0] = cube[4][i][0];
            cube[4][i][0] = cube[3][i][0];
            cube[3][i][0] = cube[1][i][0];
            cube[1][i][0] = temp[i] ;
        }

        rotateFaceClockwise(cube[0]);
    }
    public static void rotate5(String[][][] cube) {
        String[] temp = new String[3];
        for (int i = 0; i < 3; i++) {
            temp[i]=cube[4][2][i];
            cube[4][2][i] = cube[0][i][2];
            cube[0][i][2] = cube[1][0][i];
            cube[1][0][i] = cube[2][i][0];
            cube[2][i][0] = temp[i] ;
        }

        rotateFaceClockwise(cube[5]);
    }
    public static void rotate4(String[][][] cube) {
        String[] temp = new String[3];
        for (int i = 0; i < 3; i++) {
            temp[i]=cube[5][0][i];
            cube[5][0][i] = cube[2][0][i];
            cube[2][0][i] = cube[3][2][i];
            cube[3][2][i] = cube[0][0][i];
            cube[0][0][i] = temp[i] ;
        }

        rotateFaceClockwise(cube[4]);
    }
    public static void rotate1(String[][][] cube) {
        String[] temp = new String[3];
        for (int i = 0; i < 3; i++) {
            temp[i]=cube[5][2][i];
            cube[5][2][i] = cube[0][2][i];
            cube[0][2][i] = cube[3][0][i];
            cube[3][0][i] = cube[2][2][i];
            cube[2][2][i] = temp[i] ;
        }

        rotateFaceClockwise(cube[1]);
    }
    public static void rotate3(String[][][] cube) {
        String[] temp = new String[3];
        for (int i = 0; i < 3; i++) {
            temp[i]=cube[1][2][i];
            cube[1][2][i] = cube[0][i][0];
            cube[0][i][0] = cube[4][0][i];
            cube[4][0][i] = cube[2][i][2];
            cube[2][i][2] = temp[i] ;
        }

        rotateFaceClockwise(cube[3]);
        rotateFaceClockwise(cube[3]);
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
    public static void drawCube(String[][][] cube, int type) {
        System.out.println("\nCube Unfolded View:");

        // Верхняя грань (WHI)
        System.out.println("       " + cubeFaceToString(cube[4]));

        // Левая грань (ORA), передняя грань (GRE), правая грань (RED), задняя грань (BLU)
        for (int i = 0; i < 3; i++) {
            System.out.print(cubeRowToString(cube[0], i) + " ");
            System.out.print(cubeRowToString(cube[2], i) + " ");
            System.out.print(cubeRowToString(cube[3], i) + " ");
            System.out.print(cubeRowToString(cube[5], i));
            System.out.println();
        }

        // Нижняя грань (YEL)
        System.out.println("       " + cubeFaceToString(cube[1]));
    }

    // Преобразует одну грань куба в строку для вывода
    public static String cubeFaceToString(String[][] face) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(" ");
            for (int j = 0; j < 3; j++) {
                sb.append(face[i][j] + " ");
            }
            sb.append("\n       ");
        }
        return sb.toString();
    }

    // Преобразует одну строку одной грани куба в строку для вывода
    public static String cubeRowToString(String[][] face, int row) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < 3; j++) {
            sb.append(face[row][j] + " ");
        }
        return sb.toString();
    }
    public static void drawCube(String[][][] cube){
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
}



