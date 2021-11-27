import java.util.ArrayList;
import java.util.Scanner;

class imageMatrix{
    private int matrixID;
    private String type;
    private int row;
    private int col;

    public imageMatrix(int matrixID, String type, int row, int col){
        this.matrixID = matrixID;
        this.type = type;
        this.row = row;
        this.col = col;
        System.out.println("Matrix ID: "+ matrixID + " Matrix Type: " + type + " Dimension: " + row + "x" + col);
    }

    public imageMatrix(){}

    public String toString(){
        return "Matrix ID: " + matrixID + " Matrix Type: " + type + " Dimension: " + row + "x" + col;
    }

    public int getMatrixID(){return matrixID;}
    public String getType(){return type;}
    public int getMatrixRow(){return row;}
    public int getMatrixColoumn(){return col;}
}

class colouredImageMatrix extends imageMatrix{
    private ArrayList<ArrayList<Integer>> matrix_RED;
    private ArrayList<ArrayList<Integer>> matrix_GREEN;
    private ArrayList<ArrayList<Integer>> matrix_BLUE;

    public colouredImageMatrix(ArrayList<ArrayList<Integer>> matrix_RED, ArrayList<ArrayList<Integer>> matrix_GREEN, 
    ArrayList<ArrayList<Integer>> matrix_BLUE, int matrixID, String type, int row, int col){
        super(matrixID, type, row, col);
        this.matrix_RED = matrix_RED;
        this.matrix_GREEN = matrix_GREEN;
        this.matrix_BLUE = matrix_BLUE;
    }

    public colouredImageMatrix(){}

    public void setMatrix_RED(ArrayList<ArrayList<Integer>> newmatrix){this.matrix_RED = newmatrix;}
    public void setMatrix_GREEN(ArrayList<ArrayList<Integer>> newmatrix){this.matrix_GREEN = newmatrix;}
    public void setMatrix_BLUE(ArrayList<ArrayList<Integer>> newmatrix){this.matrix_BLUE = newmatrix;}

    public ArrayList<ArrayList<Integer>> getMatrix_RED(){return matrix_RED;}
    public ArrayList<ArrayList<Integer>> getMatrix_GREEN(){return matrix_GREEN;}
    public ArrayList<ArrayList<Integer>> getMatrix_BLUE(){return matrix_BLUE;}
}

class grayscaleImageMatrix extends imageMatrix{
    private ArrayList<ArrayList<Integer>> matrix;

    public grayscaleImageMatrix(ArrayList<ArrayList<Integer>> matrix, int matrixID, String type, int row, int col){
        super(matrixID, type, row, col);
        this.matrix = matrix;
    }

    public grayscaleImageMatrix() {
    }

    public void setMatrix(ArrayList<ArrayList<Integer>> newmatrix){this.matrix = newmatrix;}

    public ArrayList<ArrayList<Integer>> getMatrix(){return matrix;}
}

class imageMain{
    private static ArrayList<imageMatrix> mat = new ArrayList<>();
    private static ArrayList<colouredImageMatrix> colmat = new ArrayList<>();
    private static ArrayList<grayscaleImageMatrix> graymat = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("-------------------------------------");
            System.out.println(
            "Tasks: " + "\n" + 
            "1. Take Pixels as input" + "\n" +
            "2. Change the Pixels" + "\n" +
            "3. Display Image" + "\n" + 
            "4. Generate Negative of Image" + "\n" +
            "5. Exit");
            System.out.println("-------------------------------------");

            System.out.print("Enter task number: "); int task = sc.nextInt();

            if (task == 1){
                System.out.print("Enter row: "); int row = sc.nextInt();
                System.out.print("Enter coloumn: "); int col = sc.nextInt();
                System.out.print("Enter type (1. coloured, 2. grayscale): "); int typeint = sc.nextInt();
                String type = (typeint == 1) ? "coloured" : "grayscale";

                if (type.equals("grayscale")){
                    ArrayList<Integer> input = new ArrayList<>();
                    for (int i=0; i<row*col; i++){
                        input.add(sc.nextInt());
                    }

                    ArrayList<ArrayList<Integer>> output;
                    output = generateMatrix(input, row, col);

                    grayscaleImageMatrix temp = new grayscaleImageMatrix(output, mat.size()+1, type, row, col);
                    graymat.add(temp);
                    mat.add(temp);
                }

                else if (type.equals("coloured")){
                    System.out.println("Enter elements for RED: ");
                    ArrayList<Integer> input1 = new ArrayList<>();
                    for (int i=0; i<row*col; i++){
                        input1.add(sc.nextInt());
                    }
                    ArrayList<ArrayList<Integer>> output1;
                    output1 = generateMatrix(input1, row, col);

                    System.out.println("Enter elements for GREEN: ");
                    ArrayList<Integer> input2 = new ArrayList<>();
                    for (int i=0; i<row*col; i++){
                        input2.add(sc.nextInt());
                    }
                    ArrayList<ArrayList<Integer>> output2;
                    output2 = generateMatrix(input2, row, col);

                    System.out.println("Enter elements for BLUE: ");
                    ArrayList<Integer> input3 = new ArrayList<>();
                    for (int i=0; i<row*col; i++){
                        input3.add(sc.nextInt());
                    }
                    ArrayList<ArrayList<Integer>> output3;
                    output3 = generateMatrix(input3, row, col);

                    colouredImageMatrix temp = new colouredImageMatrix(output1, output2, output3, mat.size()+1, type, row, col);
                    colmat.add(temp);
                    mat.add(temp);
                }
            }

            else if (task == 2){
                System.out.print("Enter Matrix ID: "); int matID = sc.nextInt();

                String type = "";
                for (int i=0; i<mat.size(); i++){
                    if (mat.get(i).getMatrixID() == matID){
                        type = mat.get(i).getType();
                    }
                }

                if (type.equals("coloured")){
                    colouredImageMatrix B = new colouredImageMatrix();
                    for (int i=0; i<colmat.size(); i++){
                        if (colmat.get(i).getMatrixID() == matID){
                            B = colmat.get(i);
                        }
                    }

                    String RGB = "";
                    System.out.println("Enter R or G or B"); RGB = sc.nextLine();

                    System.out.println("Enter coordinate of that element: ");
                    System.out.print("Enter row: "); int r = sc.nextInt();
                    System.out.print("Enter coloumn: "); int c = sc.nextInt();
                    System.out.print("Enter new element: "); int newele = sc.nextInt();

                    changeElement1(B, newele, r, c, type, RGB);
                }
                
                else if (type.equals("grayscale")){
                    grayscaleImageMatrix B = new grayscaleImageMatrix();
                    for (int i=0; i<graymat.size(); i++){
                        if (graymat.get(i).getMatrixID() == matID){
                            B = graymat.get(i);
                        }
                    }

                    System.out.println("Enter coordinate of that element: ");
                    System.out.print("Enter row: "); int r = sc.nextInt();
                    System.out.print("Enter coloumn: "); int c = sc.nextInt();
                    System.out.print("Enter new element: "); int newele = sc.nextInt();
                    changeElement2(B, newele, r, c);
                }
            }

            else if (task == 3){
                System.out.print("Enter Matrix ID: "); int thatID = sc.nextInt();
                for (int i=0; i<mat.size(); i++){
                    if (mat.get(i).getMatrixID() == thatID){
                        if (mat.get(i).getType().equals("coloured")){
                            for (int j=0; j<colmat.size(); j++){
                                if (colmat.get(j).getMatrixID() == thatID){
                                    System.out.println(colmat.get(j).getMatrix_RED());
                                    System.out.println(colmat.get(j).getMatrix_GREEN());
                                    System.out.println(colmat.get(j).getMatrix_BLUE());
                                }
                            }
                        }

                        else if (mat.get(i).getType().equals("grayscale")){
                            for (int j=0; j<graymat.size(); j++){
                                if (graymat.get(j).getMatrixID() == thatID){
                                    System.out.println(graymat.get(j).getMatrix());
                                }
                            }
                        }
                    }
                }
            }

            else if (task == 4){
                System.out.print("Enter Matrix ID: "); int thatID = sc.nextInt();
                String type = "";
                for (int i=0; i<mat.size(); i++){
                    if (mat.get(i).getMatrixID() == thatID){
                        type = mat.get(i).getType();
                    }
                }
                
                if (type.equals("coloured")){
                    colouredImageMatrix B = new colouredImageMatrix();
                    for (int i=0; i<colmat.size(); i++){
                        if (colmat.get(i).getMatrixID() == thatID){
                            B = colmat.get(i);
                        }
                    }
                    negativeImage2(B);
                } else{
                    grayscaleImageMatrix B = new grayscaleImageMatrix();
                    for (int i=0; i<graymat.size(); i++){
                        if (graymat.get(i).getMatrixID() == thatID){
                            B = graymat.get(i);
                        }
                    }
                    negativeImage1(B);
                } 
            }

            else if (task == 5){
                break;
            }
        }

        sc.close();
    }

    private static ArrayList<ArrayList<Integer>> generateMatrix(ArrayList<Integer> input, int row, int col) {
        int counter = 0;
        ArrayList<ArrayList<Integer>> A = new ArrayList<>(); // [[1, 2, 3], [4, 5, 6]] // [[1, 2], [3, 4], [5, 6]]
        for (int i=0; i<row; i++){
            A.add(new ArrayList<>());
        }
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                A.get(i).add(input.get(counter++));
            }
        }
        return A;
    }

    private static void changeElement1(colouredImageMatrix A, int newele, int r, int c, String type, String RGB){
        ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
        if (RGB.equals("R")){
            temp = A.getMatrix_RED();
        } else if (RGB.equals("G")){
            temp = A.getMatrix_GREEN();
        } else if(RGB.equals("B")){
            temp = A.getMatrix_BLUE();
        }

        if (r <= A.getMatrixRow() && c <= A.getMatrixColoumn()){
            for (int i=0; i<temp.size(); i++){
                for (int j=0; j<temp.get(0).size(); j++){
                    if (i == r-1 && j == c-1){
                        temp.get(i).set(j, newele);
                    }
                }
            }
        }

        if (RGB.equals("R")){
            A.setMatrix_RED(temp);
        } else if (RGB.equals("G")){
            A.setMatrix_GREEN(temp);
        } else if(RGB.equals("B")){
            A.setMatrix_BLUE(temp);
        }
    }

    private static void changeElement2(grayscaleImageMatrix A, int newele, int r, int c){
        ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
        temp = A.getMatrix();

        if (r <= A.getMatrixRow() && c <= A.getMatrixColoumn()){
            for (int i=0; i<temp.size(); i++){
                for (int j=0; j<temp.get(0).size(); j++){
                    if (i == r-1 && j == c-1){
                        temp.get(i).set(j, newele);
                    }
                }
            }
        }

        A.setMatrix(temp);
    }

    private static void negativeImage1(grayscaleImageMatrix A){
        ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
        temp = A.getMatrix();

        for(int i=0; i<A.getMatrixRow(); i++){
            for (int j=0; j<A.getMatrixColoumn(); j++){
                int before = temp.get(i).get(j);
                temp.get(i).set(j, before - 255);
            }
        }

        A.setMatrix(temp);
    }

    private static void negativeImage2(colouredImageMatrix A){
        ArrayList<ArrayList<Integer>> temp1 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> temp2 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> temp3 = new ArrayList<>();
        temp1 = A.getMatrix_RED();
        temp2 = A.getMatrix_GREEN();
        temp3 = A.getMatrix_BLUE();

        for(int i=0; i<A.getMatrixRow(); i++){
            for (int j=0; j<A.getMatrixColoumn(); j++){
                int before1 = temp1.get(i).get(j);
                int before2 = temp2.get(i).get(j);
                int before3 = temp3.get(i).get(j);

                temp1.get(i).set(j, before1 - 255);
                temp2.get(i).set(j, before2 - 255);
                temp3.get(i).set(j, before3 - 255);
            }
        }

        A.setMatrix_RED(temp1);
        A.setMatrix_GREEN(temp2);
        A.setMatrix_BLUE(temp3);
    }
}
