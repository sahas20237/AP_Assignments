/*  
How principles of OOPs helped me program this assignment efficiently:
1. I have majorly used the INHERITENCE AND POLYMORPHIS in this assignment.
2. INHERITENCE helped me make certain classes of matrices which can be derived from other types of matrices,
   and have the same methods and functions.
3. POLYMORPHISM helped me in method overloading.
4. I also used Parametrized and Non-parametrized Constructors using "super()" keyword.
5. The concept of OOPs made the code easier to read and store certain types of matrices more efficiently.
*/

import java.util.ArrayList;
import java.util.Scanner;

class Matrix{ // Parent Class of all, can be regarded as Rectangular matrix also
    private ArrayList<ArrayList<Double>> matrix;
    private int matrixID;
    private ArrayList<String> type;
    private int row;
    private int col;
    private double matrixMean; // this function was to be calculated for all, so I made it an instance variable
    
    public Matrix(){}

    public Matrix(ArrayList<ArrayList<Double>> matrix, int row, int col, ArrayList<String> type, int matrixID){
        this.matrix = matrix;
        this.matrixID = matrixID;
        this.type = type;
        this.row = row;
        this.col = col;
        this.matrixMean = matrixMean();
        System.out.println("MatrixID: " + matrixID + " Matrix: " + matrix + " Dimension: " + row + "x" + col + " Type: " + type);
    }

    public String toString(){
        return "MatrixID: " + matrixID + " Matrix: " + matrix + " Type: " + type;
    }

    private double matrixMean(){
        double sum = 0;
        for (int i=0; i<matrix.size(); i++){
            for (int j=0; j<matrix.get(0).size(); j++){
                sum += matrix.get(i).get(j);
            }
        }
        return sum/(matrix.size() * matrix.get(0).size());
    }

    public void setMatrix(ArrayList<ArrayList<Double>> newmatrix){this.matrix = newmatrix;}
    public void setMatrixType(ArrayList<String> newtype){this.type = newtype;}

    public ArrayList<ArrayList<Double>> getMatrix(int matrixID) {return matrix;}
    public ArrayList<String> getMatrixType(int matrixID) {return type;}
    public int getMatrixID() {return matrixID;}
    public int getMatrixRow() {return row;}
    public int getMatrixColoumn() {return col;}
    public double getMatrixMean() {return matrixMean;}
}

class RowMatrix extends Matrix{ // inherited from Matrix class
    ArrayList<Double> elements = new ArrayList<>(); // Optimized storage when Row matrix is directly created

    public RowMatrix(ArrayList<ArrayList<Double>> matrix, int row, int col, ArrayList<String> type, int matrixID){
        super(matrix, row, col, type, matrixID);
        for (int i=0; i<matrix.get(0).size(); i++){
            elements.add(matrix.get(0).get(i));
        }
    }

    public RowMatrix(){}

    public ArrayList<Double> getElements(){return elements;}
}

class ColoumnMatrix extends Matrix{
    ArrayList<Double> elements = new ArrayList<>(); // Optimized storage when Coloumn matrix is directly created

    public ColoumnMatrix(ArrayList<ArrayList<Double>> matrix, int row, int col, ArrayList<String> type, int matrixID){
        super(matrix, row, col, type, matrixID);
        for (int i=0; i<matrix.size(); i++){
            elements.add(matrix.get(i).get(0));
        }
    }

    public ColoumnMatrix(){}

    public ArrayList<Double> getElements(){return elements;}
}

class Ones extends Matrix{ // Ones matrix inherits all methods from matrix, yet it is created optimally
    public Ones(ArrayList<ArrayList<Double>> matrix, int row, int col, ArrayList<String> type, int matrixID){
        super(matrix, row, col, type, matrixID);
    }
}

class Null extends Matrix{ // Null matrix inherits all methods from matrix, yet it is created optimally
    public Null(ArrayList<ArrayList<Double>> matrix, int row, int col, ArrayList<String> type, int matrixID){
        super(matrix, row, col, type, matrixID);
    }
}

class SquareMatrix extends Matrix{ // Square matrix inherits from Rectangular matrix
    private int side;

    public SquareMatrix(ArrayList<ArrayList<Double>> matrix, int row, int col, ArrayList<String> type, int matrixID){
        super(matrix, row, col, type, matrixID);
        this.side = getMatrixRow();
    }

    public SquareMatrix(){}

    public int getSide(){return side;}
    // public double getDeterminant(){return determinant;}
}

class Symmetric extends SquareMatrix{ // Symmetric matrix inherits from Square matrix
    public Symmetric(ArrayList<ArrayList<Double>> matrix, int row, int col, ArrayList<String> type, int matrixID){
        super(matrix, row, col, type, matrixID);
    }
}

class Skew extends SquareMatrix{ // Skew Symmetric matrix inherits from Square matrix
    public Skew(ArrayList<ArrayList<Double>> matrix, int row, int col, ArrayList<String> type, int matrixID){
        super(matrix, row, col, type, matrixID);
    }
}

class UpperTriangular extends SquareMatrix{ // Upper T matrix inherits from Square matrix
    public UpperTriangular(ArrayList<ArrayList<Double>> matrix, int row, int col, ArrayList<String> type, int matrixID){
        super(matrix, row, col, type, matrixID);
    }
}

class LowerTriangular extends SquareMatrix{ // lower T matrix inherits from Square matrix
    public LowerTriangular(ArrayList<ArrayList<Double>> matrix, int row, int col, ArrayList<String> type, int matrixID){
        super(matrix, row, col, type, matrixID);
    }
}

class Singular extends SquareMatrix{
    private double determinant; // determinant is 0, hence no need to calculate

    public Singular(ArrayList<ArrayList<Double>> matrix, int row, int col, ArrayList<String> type, int matrixID){
        super(matrix, row, col, type, matrixID);
        this.determinant = 0.0;
    }

    public double getDeterminant(){return determinant;}
}

class Singleton extends SquareMatrix{
    private double element;     // singleton element stored optimally
    private double determinant; // determinant is thatelement, hence no need to calculate

    public Singleton(ArrayList<ArrayList<Double>> matrix, int row, int col, ArrayList<String> type, int matrixID){
        super(matrix, row, col, type, matrixID);
        this.element = matrix.get(0).get(0);
        this.determinant = element;
    }

    public Singleton(){}

    public double getElement(){return element;}
    public double getDeterminant(){return determinant;}
}

class Diagonal extends SquareMatrix{                        // Diagonal matrix inherits from Square matrix, yet performs some functions optimally
    private ArrayList<Double> elements = new ArrayList<>(); // elements can be acessed directly
    private double determinant;                             // Determinant calculated optimally

    public Diagonal(ArrayList<ArrayList<Double>> matrix, int row, int col, ArrayList<String> type, int matrixID){
        super(matrix, row, col, type, matrixID);
        for (int i=0; i<matrix.size(); i++){
            elements.add(matrix.get(i).get(i));
        }
        for (int i=0; i<elements.size(); i++){
            this.determinant *= elements.get(i);
        }
    }

    public ArrayList<Double> getElementsList(){return elements;}
    public double getDeterminant(){return determinant;}
}

class Scalar extends Diagonal{ // Scalar matrix inherits from Diagonal matrix
    private double thatelement; // that constant element can be acessed directly
    private double determinant; // Determinant calculated optimally

    public Scalar(ArrayList<ArrayList<Double>> matrix, int row, int col, ArrayList<String> type, int matrixID){
        super(matrix, row, col, type, matrixID);
        this.thatelement = matrix.get(0).get(0);
        this.determinant = Math.pow(thatelement, 3);
    }

    public double getScalarElement(){return thatelement;}
    public double getDeterminant(){return determinant;}
}

class Identity extends Scalar{  // Identity matrix inherits from Scalar matrix
    private double idenelement; // idenelement = 1.0
    private double determinant; // determinant = 1.0

    public Identity(ArrayList<ArrayList<Double>> matrix, int row, int col, ArrayList<String> type, int matrixID){
        super(matrix, row, col, type, matrixID);
        this.idenelement = 1.0;
        this.determinant = 1.0;
    }

    public double getIdentityElement(){return idenelement;}
    public double getDeterminant(){return determinant;}
}

class matrixMain{
    private static ArrayList<Matrix> mat = new ArrayList<>(); // different dynamic arrays for different objects
    private static ArrayList<RowMatrix> rowmat = new ArrayList<>();
    private static ArrayList<ColoumnMatrix> colmat = new ArrayList<>();
    private static ArrayList<Ones> onesmat = new ArrayList<>();
    private static ArrayList<Null> nullmat = new ArrayList<>();
    private static ArrayList<SquareMatrix> squaremat = new ArrayList<>();
    private static ArrayList<Symmetric> symmat = new ArrayList<>();
    private static ArrayList<Skew> skewmat = new ArrayList<>();
    private static ArrayList<UpperTriangular> upperTmat = new ArrayList<>();
    private static ArrayList<LowerTriangular> lowerTmat = new ArrayList<>();
    private static ArrayList<Singular> singularmat = new ArrayList<>();
    private static ArrayList<Singleton> singletonmat = new ArrayList<>();
    private static ArrayList<Diagonal> diagmat = new ArrayList<>();
    private static ArrayList<Scalar> scalmat = new ArrayList<>();
    private static ArrayList<Identity> idenmat = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number of Matrices: "); int num = sc.nextInt();

        for (int i=0; i<num; i++){
            ArrayList<Double> input = new ArrayList<>();
            System.out.print("Enter row: "); int row = sc.nextInt();
            System.out.print("Enter coloumn: "); int col = sc.nextInt();
            for (int j=0; j<row*col; j++){
                input.add(sc.nextDouble());
            }

            // combiantion of matrixGenerator(), typeGiver() and memoryOptimizer() is the basis of creating a new Matrix in my code
            ArrayList<ArrayList<Double>> output;
            output = generateMatrix(input, row, col);

            ArrayList<String> type;
            type = typeGiver(output, row, col);

            memoryOptimizer(type, output, row, col, mat.size());
        }

        while(true){
            System.out.println("-------------------------------------");
            System.out.println(
            "Tasks: " + "\n" + 
            "1. Take matrices as input" + "\n" +
            "2. Create matrices of requested matrix type" + "\n" +
            "3. Change the elements of a matrix, matrix type remain valid" + "\n" +
            "4. Display all types of a matrix" + "\n" +
            "5. Addition, Subtraction, Multiplication, Division" + "\n" +
            "6. Element wise operations" + "\n" +
            "7. Transpose Matrices" + "\n" +
            "8. Inverse Matrices" + "\n" +
            "9. Compute Means" + "\n" +
            "10. Compute Determinant" + "\n" +
            "11. Singleton matrices as Scalars" + "\n" +
            "12. Compute A + A'" + "\n" +
            "13. Compute Eigen Vectors and Values" + "\n" +
            "14. Solve Linear Equations" + "\n" +
            "15. Retrieve all the existing matrices" + "\n" + 
            "16. Exit");
            System.out.println("-------------------------------------");

            System.out.print("Enter task number: "); int task = sc.nextInt();

            if (task == 1){
                System.out.print("Enter row: "); int row = sc.nextInt();
                System.out.print("Enter coloumn: "); int col = sc.nextInt();
                ArrayList<Double> input = new ArrayList<>();
                for (int i=0; i<row*col; i++){
                    input.add(sc.nextDouble());
                }

                ArrayList<ArrayList<Double>> output;
                output = generateMatrix(input, row, col);

                ArrayList<String> type;
                type = typeGiver(output, row, col);

                memoryOptimizer(type, output, row, col, mat.size());
            }

            else if (task == 2){
                System.out.println(
                "1. Rectangular Matrix" + "\n" +
                "2. Row Matrix" + "\n" +
                "3. Column Matrix" + "\n" +
                "4. Square Matrix" + "\n" +
                "5. Symmetric Matrix" + "\n" +
                "6. Skew-symmetric Matrix"+ "\n" +
                "7. Upper-triangular Matrix" + "\n" +
                "8. Lower-triangular Matrix" + "\n" +
                "9. Singular Matrix" + "\n" +
                "10. Diagonal Matrix" + "\n" +
                "11. Scalar Matrix" + "\n" +
                "12. Identity Matrix" + "\n" +
                "13. Singleton Matrix" + "\n" +
                "14. Ones Matrix" + "\n" +
                "15. Null Matrix");

                System.out.print("Select type: "); int subtask = sc.nextInt();
                ArrayList<ArrayList<Double>> temp = new ArrayList<>();

                if (subtask == 1){
                    System.out.print("Enter row: "); int row = sc.nextInt();
                    System.out.print("Enter coloumn: "); int col = sc.nextInt();
                    ArrayList<Double> input = new ArrayList<>();
                    for (int i=0; i<row*col; i++){
                        input.add(sc.nextDouble());
                    }

                    temp = generateMatrix(input, row, col);
                }

                else if (subtask == 2){
                    int row = 1;
                    System.out.print("Enter coloumn: "); int col = sc.nextInt();
                    ArrayList<Double> input = new ArrayList<>();
                    for (int i=0; i<row*col; i++){
                        input.add(sc.nextDouble());
                    }

                    temp = generateMatrix(input, row, col);
                } 

                else if (subtask == 3){
                    int col = 1;
                    System.out.print("Enter row: "); int row = sc.nextInt();
                    ArrayList<Double> input = new ArrayList<>();
                    for (int i=0; i<row*col; i++){
                        input.add(sc.nextDouble());
                    }

                    temp = generateMatrix(input, row, col);
                }

                else if (subtask == 4 || subtask == 5 || subtask == 6 || subtask == 7 || subtask == 8 || subtask == 9){
                    System.out.print("Enter side: "); int side = sc.nextInt();
                    int row = side; int col = side;
                    ArrayList<Double> input = new ArrayList<>();
                    for (int i=0; i<row*col; i++){
                        input.add(sc.nextDouble());
                    }

                    temp = generateMatrix(input, row, col);
                }

                else if (subtask == 10){
                    System.out.print("Enter side: "); int side = sc.nextInt();
                    ArrayList<Double> elements = new ArrayList<>();
                    System.out.print("Enter elements with space: "); 
                    for (int i=0; i<side; i++){
                        elements.add(sc.nextDouble());
                    }

                    int counter = 0;
                    int row = side; int col = side;
                    ArrayList<Double> input = new ArrayList<>();

                    if (side == 1){
                        input.add(elements.get(0));
                    }
                    else if (side == 2){
                        for (int i=0; i<row*col; i++){
                            if (i == 0 || i == 3){
                                input.add(elements.get(counter++));
                            } else{
                                input.add(0.0);
                            }
                        }
                    } 
                    else if (side == 3){
                        for (int i=0; i<row*col; i++){
                            if (i == 0 || i == 4 || i == 8){
                                input.add(elements.get(counter++));
                            } else{
                                input.add(0.0);
                            }
                        }
                    }

                    temp = generateMatrix(input, row, col);
                }

                else if (subtask == 11){
                    System.out.print("Enter side: "); int side = sc.nextInt();
                    System.out.println("Enter that constant element: "); double thatelement = sc.nextDouble();

                    int row = side; int col = side;
                    ArrayList<Double> input = new ArrayList<>();

                    if (side == 1){
                        input.add(thatelement);
                    }
                    else if (side == 2){
                        for (int i=0; i<row*col; i++){
                            if (i == 0 || i == 3){
                                input.add(thatelement);
                            } else{
                                input.add(0.0);
                            }
                        }
                    } 
                    else if (side == 3){
                        for (int i=0; i<row*col; i++){
                            if (i == 0 || i == 4 || i == 8){
                                input.add(thatelement);
                            } else{
                                input.add(0.0);
                            }
                        }
                    }

                    temp = generateMatrix(input, row, col);
                }

                else if (subtask == 12){
                    System.out.print("Enter side: "); int side = sc.nextInt();
                    int row = side; int col = side;
                    ArrayList<Double> input = new ArrayList<>();
                    
                    if (side == 1){
                        input.add(1.0);
                    }
                    else if (side == 2){
                        for (int i=0; i<row*col; i++){
                            if (i == 0 || i == 3){
                                input.add(1.0);
                            } else{
                                input.add(0.0);
                            }
                        }
                    } 
                    else if (side == 3){
                        for (int i=0; i<row*col; i++){
                            if (i == 0 || i == 4 || i == 8){
                                input.add(1.0);
                            } else{
                                input.add(0.0);
                            }
                        }
                    }

                    temp = generateMatrix(input, row, col);
                }

                else if (subtask == 13){
                    System.out.print("Enter that element: ");
                    ArrayList<Double> input = new ArrayList<>();
                    for (int i=0; i<1; i++){
                        input.add(sc.nextDouble());
                    }

                    temp = generateMatrix(input, 1, 1);
                }

                else if (subtask == 14){
                    System.out.print("Enter row: "); int row = sc.nextInt();
                    System.out.print("Enter coloumn: "); int col = sc.nextInt();
                    ArrayList<Double> input = new ArrayList<>();
                    for (int i=0; i<row*col; i++){
                        input.add(1.0);
                    }

                    temp = generateMatrix(input, row, col);
                }

                else if (subtask == 15){
                    System.out.print("Enter row: "); int row = sc.nextInt();
                    System.out.print("Enter coloumn: "); int col = sc.nextInt();
                    ArrayList<Double> input = new ArrayList<>();
                    for (int i=0; i<row*col; i++){
                        input.add(0.0);
                    }

                    temp = generateMatrix(input, row, col);
                }

                ArrayList<String> type;
                type = typeGiver(temp, temp.size(), temp.get(0).size());
                memoryOptimizer(type, temp, temp.size(), temp.get(0).size(), mat.size());
            }

            else if (task == 3){
                System.out.print("Enter Matrix ID: "); int matID = sc.nextInt();
                Matrix A = new Matrix();
                int i;
                for (i=0; i<mat.size(); i++){
                    if (mat.get(i).getMatrixID() == matID){
                        A = mat.get(i);
                    }
                }

                System.out.println("Enter coordinate of that element: ");
                System.out.print("Enter row: "); int r = sc.nextInt();
                System.out.print("Enter coloumn: "); int c = sc.nextInt();

                String optimaltype = A.getMatrixType(A.getMatrixID()).get(A.getMatrixType(A.getMatrixID()).size()-1);
                boolean flag = false;

                if (optimaltype.equals("Identity") || optimaltype.equals("Ones") || optimaltype.equals("Null") || optimaltype.equals("Singular") || optimaltype.equals("Scalar")){
                    flag = false;
                }
                else if (optimaltype.equals("Skew Symmetric") || optimaltype.equals("Symmetric") || optimaltype.equals("Diagonal")){
                    if ((r == 0 && c == 0) || (r == 1 && c == 1) || (r == 2 && c == 2)){
                        System.out.print("Enter new element: "); double newele = sc.nextDouble();
                        flag = true;
                        changeElement(A, newele, r, c);
                    }
                }
                else if (optimaltype.equals("Lower Triangular")){
                    if (r >= c){
                        System.out.print("Enter new element: "); double newele = sc.nextDouble();
                        flag = true;
                        changeElement(A, newele, r, c);
                    }
                }
                else  if (optimaltype.equals("Upper Triangular")){
                    if (c >= r){
                        System.out.print("Enter new element: "); double newele = sc.nextDouble();
                        flag = true;
                        changeElement(A, newele, r, c);
                    }
                }
                else if (optimaltype.equals("Singleton") || optimaltype.equals("Square") || optimaltype.equals("Rectangular")){
                    System.out.print("Enter new element: "); double newele = sc.nextDouble();
                    flag = true;
                    changeElement(A, newele, r, c);
                }
                else if (optimaltype.equals("Row")){
                    if (r == 1){
                        System.out.print("Enter new element: "); double newele = sc.nextDouble();
                        flag = true;
                        changeElement(A, newele, r, c);
                    }
                }
                else if (optimaltype.equals("Coloumn")){
                    if (c == 1){
                        System.out.print("Enter new element: "); double newele = sc.nextDouble();
                        flag = true;
                        changeElement(A, newele, r, c);
                    }
                }

                if (flag == false){
                    System.out.println("Cannot change element of " + optimaltype + " Matrix");
                }
            }

            else if (task == 4){
                System.out.print("Enter Matrix ID: "); int matID = sc.nextInt();
                Matrix A = new Matrix();
                int i;
                for (i=0; i<mat.size(); i++){
                    if (mat.get(i).getMatrixID() == matID){
                        A = mat.get(i);
                    }
                }
                System.out.println("All types: " + A.getMatrixType(A.getMatrixID()));
            }

            else if (task == 5){
                System.out.println("Enter Matrix IDs: ");
                System.out.print("Matrix ID 1: "); int matID1 = sc.nextInt(); 
                System.out.print("Matrix ID 2: "); int matID2 = sc.nextInt();
                Matrix A = new Matrix();
                Matrix B = new Matrix();
                for (int i=0; i<mat.size(); i++){
                    if (mat.get(i).getMatrixID() == matID1){
                        A = mat.get(i);
                    }
                    if (mat.get(i).getMatrixID() == matID2){
                        B = mat.get(i);
                    }
                }

                System.out.println(
                "1. Add" + "\n" + 
                "2. Subtract" + "\n" + 
                "3. Multiply" + "\n" +
                "4. Divide");

                ArrayList<ArrayList<Double>> temp = new ArrayList<>();
                System.out.print("Enter subtask: "); int subtask = sc.nextInt();

                if (subtask == 1){
                    if (A.getMatrixRow() == B.getMatrixRow() && A.getMatrixColoumn() == B.getMatrixColoumn()){
                        temp = addMatrix(A, B);

                        ArrayList<String> type;
                        type = typeGiver(temp, temp.size(), temp.get(0).size());
                        memoryOptimizer(type, temp, temp.size(), temp.get(0).size(), mat.size());
                    }
                }
                
                else if (subtask == 2){
                    if (A.getMatrixRow() == B.getMatrixRow() && A.getMatrixColoumn() == B.getMatrixColoumn()){
                        temp = subMatrix(A, B);

                        ArrayList<String> type;
                        type = typeGiver(temp, temp.size(), temp.get(0).size());
                        memoryOptimizer(type, temp, temp.size(), temp.get(0).size(), mat.size());
                    }
                }

                else if (subtask == 3){
                    if (A.getMatrixColoumn() == B.getMatrixRow()){
                        temp = mulMatrix(A, B);

                        ArrayList<String> type;
                        type = typeGiver(temp, temp.size(), temp.get(0).size());
                        memoryOptimizer(type, temp, temp.size(), temp.get(0).size(), mat.size());
                    }
                }

                else if (subtask == 4){
                    if (A.getMatrixColoumn() == B.getMatrixRow()){
                        temp = divMatrix(A, B);

                        ArrayList<String> type;
                        type = typeGiver(temp, temp.size(), temp.get(0).size());
                        memoryOptimizer(type, temp, temp.size(), temp.get(0).size(), mat.size());
                    }
                }
            }

            else if (task == 6){
                System.out.println("Enter Matrix IDs: ");
                System.out.print("Matrix ID 1: "); int matID1 = sc.nextInt(); 
                System.out.print("Matrix ID 2: "); int matID2 = sc.nextInt();
                Matrix A = new Matrix();
                Matrix B = new Matrix();
                for (int i=0; i<mat.size(); i++){
                    if (mat.get(i).getMatrixID() == matID1){
                        A = mat.get(i);
                    }
                    if (mat.get(i).getMatrixID() == matID2){
                        B = mat.get(i);
                    }
                }

                System.out.println(
                "1. Element Wise Add" + "\n" + 
                "2. Element Wise Subtract" + "\n" + 
                "3. Element Wise Multiply" + "\n" + 
                "4. Element Wise Divide");

                ArrayList<ArrayList<Double>> temp = new ArrayList<>();
                System.out.print("Enter subtask: "); int subtask = sc.nextInt();

                if (subtask == 1){
                    if (A.getMatrixRow() == B.getMatrixRow() && A.getMatrixColoumn() == B.getMatrixColoumn()){
                        temp = addMatrix(A, B);
                        
                        ArrayList<String> type;
                        type = typeGiver(temp, temp.size(), temp.get(0).size());
                        memoryOptimizer(type, temp, temp.size(), temp.get(0).size(), mat.size());
                    }
                }
                
                else if (subtask == 2){
                    if (A.getMatrixRow() == B.getMatrixRow() && A.getMatrixColoumn() == B.getMatrixColoumn()){
                        temp = subMatrix(A, B);
                        
                        ArrayList<String> type;
                        type = typeGiver(temp, temp.size(), temp.get(0).size());
                        memoryOptimizer(type, temp, temp.size(), temp.get(0).size(), mat.size());
                    }
                }

                else if (subtask == 3){
                    if (A.getMatrixRow() == B.getMatrixRow() && A.getMatrixColoumn() == B.getMatrixColoumn()){
                        temp = EWMulMatrix(A, B);
                        
                        ArrayList<String> type;
                        type = typeGiver(temp, temp.size(), temp.get(0).size());
                        memoryOptimizer(type, temp, temp.size(), temp.get(0).size(), mat.size());
                    }
                }

                else if (subtask == 4){
                    if (A.getMatrixRow() == B.getMatrixRow() && A.getMatrixColoumn() == B.getMatrixColoumn()){
                        temp = EWDivMatrix(A, B);
                       
                        ArrayList<String> type;
                        type = typeGiver(temp, temp.size(), temp.get(0).size());
                        memoryOptimizer(type, temp, temp.size(), temp.get(0).size(), mat.size());
                    }
                }
            }

            else if (task == 7){
                System.out.print("Enter Matrix ID: "); int matID = sc.nextInt();
                Matrix A = new Matrix();
                for (int i=0; i<mat.size(); i++){
                    if (mat.get(i).getMatrixID() == matID){
                        A = mat.get(i);
                    }
                }

                ArrayList<ArrayList<Double>> temp = new ArrayList<>();
                temp = transposeMatrix(A);
                
                ArrayList<String> type;
                type = typeGiver(temp, temp.size(), temp.get(0).size());
                memoryOptimizer(type, temp, temp.size(), temp.get(0).size(), mat.size());
            }

            else if (task == 8){
                System.out.print("Enter Matrix ID: "); int matID = sc.nextInt();
                Matrix A = new Matrix();
                for (int i=0; i<mat.size(); i++){
                    if (mat.get(i).getMatrixID() == matID){
                        A = mat.get(i);
                    }
                }

                ArrayList<ArrayList<Double>> temp = new ArrayList<>();
                temp = inverseMatrix(A);

                
                ArrayList<String> type;
                type = typeGiver(temp, temp.size(), temp.get(0).size());
                memoryOptimizer(type, temp, temp.size(), temp.get(0).size(), mat.size());
            }

            else if (task == 9){
                System.out.print("Enter Matrix ID: "); int matID = sc.nextInt();
                Matrix A = new Matrix();
                for (int i=0; i<mat.size(); i++){
                    if (mat.get(i).getMatrixID() == matID){
                        A = mat.get(i);
                    }
                }

                System.out.println(
                "1. Row wise mean" + "\n" + 
                "2. Coloumn wise mean" + "\n" + 
                "3. Mean of all elements");

                System.out.print("Enter subtask: "); int subtask = sc.nextInt();

                if (subtask == 1){
                    System.out.print("Enter that row: "); int thatrow = sc.nextInt();
                    System.out.println();

                    double answer = computeMeans(A, true, thatrow-1);
                    System.out.println("Mean of row " + thatrow + " is: " + answer);
                }

                else if (subtask == 2){
                    System.out.print("Enter that coloumn: "); int thatcol = sc.nextInt();
                    System.out.println();

                    double answer = computeMeans(A, false, thatcol-1);
                    System.out.println("Mean of coloumn " + thatcol + " is: " + answer);
                }

                else if (subtask == 3){
                    System.out.println("Mean of all elements is: " + A.getMatrixMean());
                }
            }

            else if (task == 10){
                System.out.print("Enter Matrix ID: "); int matID = sc.nextInt();
                Matrix A = new Matrix();
                for (int i=0; i<mat.size(); i++){
                    if (mat.get(i).getMatrixID() == matID){
                        A = mat.get(i);
                    }
                }

                if (A.getMatrixRow() == A.getMatrixColoumn()){
                    double det = computeDeterminant(A);
                    System.out.println("Determinant: " + det);
                } else{
                    System.out.println("ERROR: Matrix not Square");
                }
            }

            else if (task == 11){   
                System.out.println("Enter Matrix IDs: ");
                System.out.print("Matrix ID 1 (to be scaled): "); int matID1 = sc.nextInt(); 
                System.out.print("Matrix ID 2 (to be used as scaling factor - singleton): "); int matID2 = sc.nextInt();
                Matrix A = new Matrix();
                Singleton B = new Singleton();
                for (int i=0; i<mat.size(); i++){
                    if (mat.get(i).getMatrixID() == matID1){
                        A = mat.get(i);
                    }
                }
                for (int i=0; i<singletonmat.size(); i++){
                    if (singletonmat.get(i).getMatrixID() == matID2){
                        B = singletonmat.get(i);
                    }
                }

                double scalingfactor = B.getElement();
                
                ArrayList<ArrayList<Double>> temp = new ArrayList<>();
                temp = A.getMatrix(A.getMatrixID());

                ArrayList<ArrayList<Double>> temp1 = new ArrayList<>();
                for (int i=0; i<A.getMatrixRow(); i++){
                    temp1.add(new ArrayList<>());
                }
                for (int i=0; i<A.getMatrixRow(); i++){
                    for (int j=0; j<A.getMatrixColoumn(); j++){
                        temp1.get(i).add(0.0);
                    }
                }

                for (int i=0; i<temp.size(); i++){
                    for (int j=0; j<temp.get(0).size(); j++){
                        double t1 = temp.get(i).get(j);
                        double t2 = t1 * scalingfactor;
                        temp1.get(i).set(j, t2);
                    }
                }

                ArrayList<String> type;
                type = typeGiver(temp1, temp1.size(), temp1.get(0).size());
                memoryOptimizer(type, temp1, temp1.size(), temp1.get(0).size(), mat.size());
            }

            else if (task == 12){
                System.out.print("Enter Matrix ID: "); int matID = sc.nextInt();
                Matrix A = new Matrix();
                for (int i=0; i<mat.size(); i++){
                    if (mat.get(i).getMatrixID() == matID){
                        A = mat.get(i);
                    }
                }

                if (A.getMatrixRow() == A.getMatrixColoumn()){
                    ArrayList<ArrayList<Double>> temp1 = new ArrayList<>();
                    for (int i=0; i<A.getMatrixColoumn(); i++){
                        temp1.add(new ArrayList<>());
                    }

                    temp1 = transposeMatrix(A);

                    ArrayList<String> type1;
                    type1 = typeGiver(temp1, temp1.size(), temp1.get(0).size());
                    memoryOptimizer(type1, temp1, temp1.size(), temp1.get(0).size(), mat.size());

                    Matrix B = new Matrix();
                    B = mat.get(mat.size()-1);

                    if (A.getMatrixRow() == B.getMatrixRow() && A.getMatrixColoumn() == B.getMatrixColoumn()){
                        ArrayList<ArrayList<Double>> temp = new ArrayList<>();
                        temp = addMatrix(A, B);

                        ArrayList<String> type;
                        type = typeGiver(temp, temp.size(), temp.get(0).size());
                        memoryOptimizer(type, temp, temp.size(), temp.get(0).size(), mat.size());
                    }
                }
            }

            else if (task == 13){
                System.out.print("Enter Matrix ID: "); int matID = sc.nextInt();
                Matrix A = new Matrix();
                for (int i=0; i<mat.size(); i++){
                    if (mat.get(i).getMatrixID() == matID){
                        A = mat.get(i);
                    }
                }

                ArrayList<ArrayList<Double>> temp = new ArrayList<>();
                temp = A.getMatrix(A.getMatrixID());
                double a = temp.get(0).get(0); double b = temp.get(0).get(1); double c = temp.get(1).get(0); double d = temp.get(1).get(1);

                double aa = 1.0; double bb = -(a+d); double cc = a*d - b*c;
                double D = (bb*bb) - 4*aa*cc;
                boolean flag = false;
                double ev1 = 0.0; double ev2 = 0.0;
                if (D >= 0){
                    flag = true;
                    ev1 = (-bb + Math.pow(D, 0.5)) / (2.0 * aa);
                    ev2 = (-bb - Math.pow(D, 0.5)) / (2.0 * aa);
                    System.out.println("EigenValue 1: " + ev1);
                    System.out.println("EigenValue 2: " + ev2);
                } else {
                    System.out.println("Complex Roots");
                }

                if (flag == true){
                    ArrayList<ArrayList<Double>> temp1 = new ArrayList<>();
                    temp1.add(new ArrayList<>()); temp1.add(new ArrayList<>());
                    temp1.get(0).add(a-ev1); temp1.get(0).add(b); temp1.get(1).add(c); temp1.get(1).add(d-ev1);
                    ArrayList<String> type;
                    type = typeGiver(temp1, temp1.size(), temp1.get(0).size());
                    memoryOptimizer(type, temp1, temp1.size(), temp1.get(0).size(), mat.size());

                    ArrayList<ArrayList<Double>> temp2 = new ArrayList<>();
                    temp2.add(new ArrayList<>()); temp2.add(new ArrayList<>());
                    temp2.get(0).add(a-ev2); temp2.get(0).add(b); temp2.get(1).add(c); temp2.get(1).add(d-ev2);
                    ArrayList<String> type2;
                    type2 = typeGiver(temp2, temp2.size(), temp2.get(0).size());
                    memoryOptimizer(type2, temp2, temp2.size(), temp2.get(0).size(), mat.size());
                }
            }

            else if (task == 14){
                System.out.println("Enter Matrix IDs: ");
                System.out.print("Matrix ID 1: "); int matID1 = sc.nextInt(); 
                System.out.print("Matrix ID 2: "); int matID2 = sc.nextInt();
                Matrix A = new Matrix();
                Matrix B = new Matrix();
                for (int i=0; i<mat.size(); i++){
                    if (mat.get(i).getMatrixID() == matID1){
                        A = mat.get(i);
                    }
                    if (mat.get(i).getMatrixID() == matID2){
                        B = mat.get(i);
                    }
                }

                if (A.getMatrixColoumn() == B.getMatrixRow()){
                    ArrayList<ArrayList<Double>> temp3 = new ArrayList<>();
                    temp3 = inverseMatrix(A);

                    ArrayList<String> type1;
                    type1 = typeGiver(temp3, temp3.size(), temp3.get(0).size());
                    memoryOptimizer(type1, temp3, temp3.size(), temp3.get(0).size(), mat.size());
        
                    Matrix C = new Matrix();
                    C = mat.get(mat.size()-1);
        
                    ArrayList<ArrayList<Double>> temp4 = new ArrayList<>();
                    temp4 = mulMatrix(C, B);

                    ArrayList<String> type;
                    type = typeGiver(temp4, temp4.size(), temp4.get(0).size());
                    memoryOptimizer(type, temp4, temp4.size(), temp4.get(0).size(), mat.size());
                }
            }

            else if (task == 15){
                for (Matrix i : mat){
                    System.out.println(i);
                }
            }

            else if (task == 16){
                break;
            }
        }
        sc.close();
    }

    // this function works as an automatic obect creater after getting which is the most optimal way to save a matrix in the hierarchy
    private static void memoryOptimizer(ArrayList<String> type, ArrayList<ArrayList<Double>> output, int row, int col, int ID){
        String best = type.get(type.size()-1);

        Matrix temp1 = new Matrix(output, row, col, type, ID);
        mat.add(temp1); // keeps record of all matrices

        if (best.equals("Singleton")){
            Singleton temp = new Singleton(output, row, col, type, ID);
            singletonmat.add(temp);
        }
        else if (best.equals("Ones")){
            Ones temp = new Ones(output, row, col, type, ID);
            onesmat.add(temp);
        }
        else if (best.equals("Null")){
            Null temp = new Null(output, row, col, type, ID);
            nullmat.add(temp);
        }
        else if (best.equals("Row")){
            RowMatrix temp = new RowMatrix(output, row, col, type, ID);
            rowmat.add(temp);
        } else if (best.equals("Coloumn")){
            ColoumnMatrix temp = new ColoumnMatrix(output, row, col, type, ID);
            colmat.add(temp);
        }
        else{
            if (best.equals("Square")){
                SquareMatrix temp = new SquareMatrix(output, row, col, type, ID);
                squaremat.add(temp);
            }
            
            if (best.equals("Symmetric")){
                Symmetric temp = new Symmetric(output, row, col, type, ID);
                symmat.add(temp);
            } else if (best.equals("Skew Symmetric")){
                Skew temp = new Skew(output, row, col, type, ID);
                skewmat.add(temp);
            }

            if (best.equals("Upper Triangular")){
                UpperTriangular temp = new UpperTriangular(output, row, col, type, ID);
                upperTmat.add(temp);
            } else if (best.equals("Lower Triangular")){
                LowerTriangular temp = new LowerTriangular(output, row, col, type, ID);
                lowerTmat.add(temp);
            }

            if (best.equals("Diagonal")){
                Diagonal temp = new Diagonal(output, row, col, type, ID);
                diagmat.add(temp);
            } else if (best.equals("Scalar")){
                Scalar temp = new Scalar(output, row, col, type, ID);
                scalmat.add(temp);
            } else if (best.equals("Identity")){
                Identity temp = new Identity(output, row, col, type, ID);
                idenmat.add(temp);
            }

            if (best.equals("Singular")){
                Singular temp = new Singular(output, row, col, type, ID);
                singularmat.add(temp);
            }
        }
    }

    // this function assigns the TYPE(s) to the matrix created
    private static ArrayList<String> typeGiver(ArrayList<ArrayList<Double>> A, int row, int col){ 
        ArrayList<String> type = new ArrayList<>();
        int side = 0;

        if (row == col){
            side = row;
        }

        if (isRectangular(A, row, col) == true){
            type.add("Rectangular");

            if (isColoumnMatrix(A, row, col) == true){
                type.add(("Coloumn"));
            } 
            else if (isRowMatrix(A, row, col) == true){
                type.add(("Row"));
            } 
            else if (isSquare(A, row, col) == true){
                type.add("Square");

                if (isSymmetric(A, side) == true){
                    type.add("Symmetric");
                } 
                else if (isSkewSymmetric(A, side) == true){
                    type.add("Skew Symmetric");
                }
                if (isUpperTriangular(A, side) == true){
                    type.add("Upper Triangular");
                } 
                else if (isLowerTriangular(A, side) == true){
                    type.add("Lower Triangular");
                }
                if (isDiagonal(A, side) == true){
                    type.add("Diagonal");

                    if (isScalar(A, side) == true){
                        type.add("Scalar");
                    }
                    if (isIdentity(A, side) == true){
                        type.add("Identity");
                    }
                }
                if (isSingular(A, side) == true){
                    type.add("Singular");
                }
                if (isSingleton(A, row, col) == true){
                    type.add("Singleton");
                }
            }
            if (isOnes(A, row, col) == true){
                type.add("Ones");
            }
            if (isNull(A, row, col) == true){
                type.add("Null");
            }
        }
        return type;
    }

    // certain boolean functions hepled typeGiver()
    private static boolean isRectangular(ArrayList<ArrayList<Double>> A, int row, int col){ // all matrices are rectangular?
        boolean flag = true;
        return flag;
    }

    private static boolean isRowMatrix(ArrayList<ArrayList<Double>> A, int row, int col){
        boolean flag = false;
        if (col != 0 &&  row == 1 && col != 1){
            flag = true;
        }
        return flag;
    }

    private static boolean isColoumnMatrix(ArrayList<ArrayList<Double>> A, int row, int col){
        boolean flag = false;
        if (row != 0 && col == 1 && row != 1){
            flag = true;
        }
        
        return flag;
    }

    private static boolean isSquare(ArrayList<ArrayList<Double>> A, int row, int col){
        boolean flag = true;
        if (row != col){
            flag = false;
        }
        return flag;
    }

    private static boolean isSymmetric(ArrayList<ArrayList<Double>> A, int side){
        ArrayList<Double> X = new ArrayList<>();
        ArrayList<Double> Y = new ArrayList<>();
        for (int i=0; i<side; i++){
            for (int j=0; j<side; j++){
                X.add(A.get(i).get(j));
                Y.add(A.get(j).get(i));
            }
        }
        // System.out.println(X);
        // System.out.println(Y);
        boolean flag = true;
        for (int i=0; i<side*side; i++){
            if (side == 1){
                continue;
            } else{
                if (X.get(i) != Y.get(i)){
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    private static boolean isSkewSymmetric(ArrayList<ArrayList<Double>> A, int side){
        ArrayList<Double> X = new ArrayList<>();
        ArrayList<Double> Y = new ArrayList<>();
        boolean flag = true;
        for (int i=0; i<side; i++){
            for (int j=0; j<side; j++){
                X.add(A.get(i).get(j));
                Y.add(A.get(j).get(i));
            }
        }
        // System.out.println(X);
        // System.out.println(Y);
        for (int i=0; i<side*side; i++){
            if (side == 3 && (i == 0 || i == 4 || i == 8)){
                continue;
            } 
            if (side == 2 && (i == 0 || i == 3)){
                continue;
            } 
            if (side == 1){ 
                continue;
            } else{
                if (X.get(i) != -Y.get(i)){
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    private static boolean isUpperTriangular(ArrayList<ArrayList<Double>> A, int side){
        boolean flag = true;
        for (int i=0; i<side; i++){
            for (int j=0; j<side; j++){
                if (j >= i){
                    if (A.get(i).get(j) == 0){
                        flag = false;
                        break;
                    }
                }
                if (i > j){
                    if (A.get(i).get(j) != 0){
                        flag = false;
                        break;
                    }
                }
            }
        }
        return flag;
    }

    private static boolean isLowerTriangular(ArrayList<ArrayList<Double>> A, int side){
        boolean flag = true;
        for (int i=0; i<side; i++){
            for (int j=0; j<side; j++){
                if (i >= j){
                    if (A.get(i).get(j) == 0){
                        flag = false;
                        break;
                    }
                }
                if (j > i){
                    if (A.get(i).get(j) != 0){
                        flag = false;
                        break;
                    }
                }
            }
        }
        return flag;
    }

    private static boolean isSingular(ArrayList<ArrayList<Double>> A, int side){
        boolean flag = true;
        if (side == 1){
            if (A.get(0).get(0) != 0){
                flag = false;
            }
        } else if (side == 2){
            double det = (A.get(0).get(0) * A.get(1).get(1)) - (A.get(0).get(1) * A.get(1).get(0));
            if (det != 0){
                flag = false;
            }
        } else if (side == 3){
            double det1 = A.get(0).get(0) * ((A.get(1).get(1) * A.get(2).get(2)) - (A.get(2).get(1) * A.get(1).get(2)));
            double det2 = A.get(0).get(1) * ((A.get(1).get(0) * A.get(2).get(2)) - (A.get(2).get(0) * A.get(1).get(2)));
            double det3 = A.get(0).get(2) * ((A.get(1).get(0) * A.get(2).get(1)) - (A.get(2).get(0) * A.get(1).get(1)));
            double det = det1 - det2 + det3;
            if (det != 0){
                flag = false;
            }
        }
        return flag;
    }

    private static boolean isDiagonal(ArrayList<ArrayList<Double>> A, int side){
        boolean flag = true;
        for (int i=0; i<side; i++){
            for (int j=0; j<side; j++){
                if (i == j){
                    if (A.get(i).get(j) == 0){
                        flag = false;
                        break;
                    }
                }
                if (i != j){
                    if (A.get(i).get(j) != 0){
                        flag = false;
                        break;
                    }
                }
            }
        }
        return flag;
    }

    private static boolean isScalar(ArrayList<ArrayList<Double>> A, int side){
        boolean flag = true;
        double init = A.get(0).get(0);
        for (int i=0; i<side; i++){
            for (int j=0; j<side; j++){
                if (i == j){
                    if (A.get(i).get(j) != init){
                        flag = false;
                        break;
                    }
                }
                if (i != j){
                    if (A.get(i).get(j) != 0){
                        flag = false;
                        break;
                    }
                }
            }
        }
        return flag;
    }

    private static boolean isIdentity(ArrayList<ArrayList<Double>> A, int side){
        boolean flag = true;
        double init = A.get(0).get(0);
        for (int i=0; i<side; i++){
            for (int j=0; j<side; j++){
                if (i == j){
                    if (A.get(i).get(j) != init){
                        flag = false;
                        break;
                    }
                }
                if (i != j){
                    if (A.get(i).get(j) != 0){
                        flag = false;
                        break;
                    }
                }
            }
        }
        boolean finalflag = false;
        if (init == 1 && flag == true){
            finalflag = true;
        }
        return finalflag;
    }

    private static boolean isSingleton(ArrayList<ArrayList<Double>> A, int row, int col){
        boolean flag = true;
        if (row != 1 && col != 1){
            flag = false;
        }
        return flag;
    }

    private static boolean isOnes(ArrayList<ArrayList<Double>> A, int row, int col){
        boolean flag = true;
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if (A.get(i).get(j) != 1){
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    private static boolean isNull(ArrayList<ArrayList<Double>> A, int row, int col){
        boolean flag = true;
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if (A.get(i).get(j) != 0){
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    // 1-D array to 2-D array (Matrix) maker
    private static ArrayList<ArrayList<Double>> generateMatrix(ArrayList<Double> input, int row, int col) {
        int counter = 0;
        ArrayList<ArrayList<Double>> A = new ArrayList<>(); // [[1, 2, 3], [4, 5, 6]] // [[1, 2], [3, 4], [5, 6]]
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

    private static ArrayList<ArrayList<Double>> addMatrix(Matrix A, Matrix B){
        ArrayList<ArrayList<Double>> answer = new ArrayList<>();
        ArrayList<ArrayList<Double>> temp1 = new ArrayList<>();
        ArrayList<ArrayList<Double>> temp2 = new ArrayList<>();
        temp1 = A.getMatrix(A.getMatrixID());
        temp2 = B.getMatrix(B.getMatrixID());

        String optimaltype1 = A.getMatrixType(A.getMatrixID()).get(A.getMatrixType(A.getMatrixID()).size()-1);
        String optimaltype2 = B.getMatrixType(B.getMatrixID()).get(B.getMatrixType(B.getMatrixID()).size()-1);

        if (optimaltype1.equals("Null")){
            return temp2;
        } 
        else if (optimaltype2.equals("Null")){
            return temp1;
        } 
        else{
            if (A.getMatrixRow() == B.getMatrixRow() && A.getMatrixColoumn() == B.getMatrixColoumn()){
                for (int i=0; i<A.getMatrixRow(); i++){
                    answer.add(new ArrayList<>());
                }
                for (int i=0; i<A.getMatrixRow(); i++){
                    for (int j=0; j<A.getMatrixColoumn(); j++){
                        answer.get(i).add(temp1.get(i).get(j) + temp2.get(i).get(j));
                    }
                }
            }
            return answer;
        }
    }

    private static ArrayList<ArrayList<Double>> subMatrix(Matrix A, Matrix B){
        ArrayList<ArrayList<Double>> temp1 = new ArrayList<>();
        ArrayList<ArrayList<Double>> temp2 = new ArrayList<>();
        ArrayList<ArrayList<Double>> answer = new ArrayList<>();
        temp1 = A.getMatrix(A.getMatrixID());
        temp2 = B.getMatrix(B.getMatrixID());

        String optimaltype1 = A.getMatrixType(A.getMatrixID()).get(A.getMatrixType(A.getMatrixID()).size()-1);
        String optimaltype2 = B.getMatrixType(B.getMatrixID()).get(B.getMatrixType(B.getMatrixID()).size()-1);

        if (optimaltype1.equals("Null")){
            return temp2;
        } 
        else if (optimaltype2.equals("Null")){
            return temp1;
        } 
        else{
            if (A.getMatrixRow() == B.getMatrixRow() && A.getMatrixColoumn() == B.getMatrixColoumn()){
                for (int i=0; i<A.getMatrixRow(); i++){
                    answer.add(new ArrayList<>());
                }
                for (int i=0; i<A.getMatrixRow(); i++){
                    for (int j=0; j<A.getMatrixColoumn(); j++){
                        answer.get(i).add(temp1.get(i).get(j) - temp2.get(i).get(j));
                    }
                }
            }
            return answer;
        }
    }

    private static ArrayList<ArrayList<Double>> mulMatrix(Matrix A, Matrix B){
        ArrayList<ArrayList<Double>> temp1 = new ArrayList<>();
        ArrayList<ArrayList<Double>> temp2 = new ArrayList<>();
        temp1 = A.getMatrix(A.getMatrixID());
        temp2 = B.getMatrix(B.getMatrixID());
        ArrayList<ArrayList<Double>> answer = new ArrayList<>();

        String optimaltype1 = A.getMatrixType(A.getMatrixID()).get(A.getMatrixType(A.getMatrixID()).size()-1);
        String optimaltype2 = B.getMatrixType(B.getMatrixID()).get(B.getMatrixType(B.getMatrixID()).size()-1);

        if (optimaltype1.equals("Ones")){
            return temp2;
        } 
        else if (optimaltype2.equals("Ones")){
            return temp1;
        }
        else{
            if (A.getMatrixColoumn() == B.getMatrixRow()){
                for (int i=0; i<A.getMatrixRow(); i++){
                    answer.add(new ArrayList<>());
                }
                for (int i=0; i<A.getMatrixRow(); i++){
                    for (int j=0; j<B.getMatrixColoumn(); j++){
                        answer.get(i).add(0.0);
                    }
                }
    
                for (int i=0; i<temp1.size(); i++){
                    for (int j=0; j<temp2.get(0).size(); j++){
                        for (int k=0; k<temp2.size(); k++){
                            double t1 = answer.get(i).get(j);
                            double t2 = t1 + temp1.get(i).get(k) * temp2.get(k).get(j);
                            answer.get(i).set(j, t2);
                        }
                    }
                }
            }
            return answer;
        }
    }

    private static ArrayList<ArrayList<Double>> divMatrix(Matrix A, Matrix B){
        ArrayList<ArrayList<Double>> temp4 = new ArrayList<>();

        if (A.getMatrixColoumn() == B.getMatrixRow()){
            ArrayList<ArrayList<Double>> temp3 = new ArrayList<>();
            temp3 = inverseMatrix(B);

            ArrayList<String> type1;
            type1 = typeGiver(temp3, temp3.size(), temp3.get(0).size());
            memoryOptimizer(type1, temp3, temp3.size(), temp3.get(0).size(), mat.size());

            Matrix C = new Matrix();
            C = mat.get(mat.size()-1);

            temp4 = mulMatrix(A, C);
        }
        return temp4;
    }

    private static ArrayList<ArrayList<Double>> EWMulMatrix(Matrix A, Matrix B){
        ArrayList<ArrayList<Double>> temp1 = new ArrayList<>();
        ArrayList<ArrayList<Double>> temp2 = new ArrayList<>();
        ArrayList<ArrayList<Double>> answer = new ArrayList<>();
        temp1 = A.getMatrix(A.getMatrixID());
        temp2 = B.getMatrix(B.getMatrixID());

        if (A.getMatrixRow() == B.getMatrixRow() && A.getMatrixColoumn() == B.getMatrixColoumn()){
            for (int i=0; i<A.getMatrixRow(); i++){
                answer.add(new ArrayList<>());
            }
            for (int i=0; i<A.getMatrixRow(); i++){
                for (int j=0; j<A.getMatrixColoumn(); j++){
                    answer.get(i).add(temp1.get(i).get(j) * temp2.get(i).get(j));
                }
            }
        }
        return answer;
    }

    private static ArrayList<ArrayList<Double>> EWDivMatrix(Matrix A, Matrix B){
        ArrayList<ArrayList<Double>> temp1 = new ArrayList<>();
        ArrayList<ArrayList<Double>> temp2 = new ArrayList<>();
        ArrayList<ArrayList<Double>> answer = new ArrayList<>();
        temp1 = A.getMatrix(A.getMatrixID());
        temp2 = B.getMatrix(B.getMatrixID());

        if (A.getMatrixRow() == B.getMatrixRow() && A.getMatrixColoumn() == B.getMatrixColoumn()){
            for (int i=0; i<A.getMatrixRow(); i++){
                answer.add(new ArrayList<>());
            }
            for (int i=0; i<A.getMatrixRow(); i++){
                for (int j=0; j<A.getMatrixColoumn(); j++){
                    double check = temp2.get(i).get(j);
                    if (check != 0){
                        answer.get(i).add(temp1.get(i).get(j) / temp2.get(i).get(j));
                    } else{
                        System.out.println("ERROR: Div by 0");
                        return null;
                    }
                }
            }
        }
        return answer;
    }
    
    private static ArrayList<ArrayList<Double>> transposeMatrix(Matrix A){
        ArrayList<ArrayList<Double>> temp1 = new ArrayList<>();
        temp1 = A.getMatrix(A.getMatrixID());

        ArrayList<Double> temp2 = new ArrayList<>();

        ArrayList<ArrayList<Double>> transposed = new ArrayList<>();
        for (int i=0; i<A.getMatrixColoumn(); i++){
            transposed.add(new ArrayList<>());
        }

        for (int i=0; i<temp1.get(0).size(); i++){
            for (int j=0; j<temp1.size(); j++){
                temp2.add(temp1.get(j).get(i));
            }
        }

        transposed = generateMatrix(temp2, A.getMatrixColoumn(), A.getMatrixRow());
        return transposed;
    }

    private static ArrayList<ArrayList<Double>> inverseMatrix(Matrix A){
        ArrayList<ArrayList<Double>> temp2 = new ArrayList<>();
        for (int i=0; i<A.getMatrixRow(); i++){
            temp2.add(new ArrayList<>());
        }
        if (A.getMatrixRow() == A.getMatrixColoumn()){
            ArrayList<ArrayList<Double>> temp1 = new ArrayList<>();
            temp1 = A.getMatrix(A.getMatrixID());

            if (A.getMatrixRow() == 1){
                double det = computeDeterminant(A);
                if (det != 0){
                    temp2.get(0).add(1/det);
                } else if (det == 0){
                    System.out.println("DET = 0, cannot divide by 0");
                }
            } else if (A.getMatrixRow() == 2){
                double det = computeDeterminant(A);
                if(det != 0){
                    double a = temp1.get(0).get(0); double b = temp1.get(0).get(1); double c = temp1.get(1).get(0); double d = temp1.get(1).get(1); 
                    temp2.get(0).add(d/det); temp2.get(0).add(-b/det); temp2.get(1).add(-c/det); temp2.get(1).add(a/det);
                } else if (det == 0){
                    System.out.println("DET = 0, cannot divide by 0");
                }
            } else if (A.getMatrixRow() == 3){
                double det = computeDeterminant(A);
                if (det != 0){
                    double d00 = +(1/det)*((temp1.get(2).get(2) * temp1.get(1).get(1)) - (temp1.get(2).get(1) * temp1.get(1).get(2)));
                    double d01 = -(1/det)*((temp1.get(2).get(2) * temp1.get(1).get(0)) - (temp1.get(2).get(0) * temp1.get(1).get(2)));
                    double d02 = +(1/det)*((temp1.get(2).get(1) * temp1.get(1).get(0)) - (temp1.get(2).get(0) * temp1.get(1).get(1)));
                    double d10 = -(1/det)*((temp1.get(2).get(2) * temp1.get(0).get(1)) - (temp1.get(2).get(1) * temp1.get(0).get(2)));
                    double d11 = +(1/det)*((temp1.get(2).get(2) * temp1.get(0).get(0)) - (temp1.get(2).get(0) * temp1.get(0).get(2)));
                    double d12 = -(1/det)*((temp1.get(2).get(1) * temp1.get(0).get(0)) - (temp1.get(2).get(0) * temp1.get(0).get(1)));
                    double d20 = +(1/det)*((temp1.get(1).get(2) * temp1.get(0).get(1)) - (temp1.get(1).get(1) * temp1.get(0).get(2)));
                    double d21 = -(1/det)*((temp1.get(1).get(2) * temp1.get(0).get(0)) - (temp1.get(1).get(0) * temp1.get(0).get(2)));
                    double d22 = +(1/det)*((temp1.get(1).get(1) * temp1.get(0).get(0)) - (temp1.get(1).get(0) * temp1.get(0).get(1)));

                    temp2.get(0).add(d00); temp2.get(0).add(d01); temp2.get(0).add(d02); 
                    temp2.get(1).add(d10); temp2.get(1).add(d11); temp2.get(1).add(d12); 
                    temp2.get(2).add(d20); temp2.get(2).add(d21); temp2.get(2).add(d22);
                }
            }
        }
        return temp2;
    }

    private static double computeMeans(Matrix A, boolean whichdim, int whichcolrow){ // boolean true = row, false = col
        ArrayList<ArrayList<Double>> temp1 = new ArrayList<>();
        temp1 = A.getMatrix(A.getMatrixID());
        double sum = 0.0;
        double answer = 0.0;

        if (whichdim == true){
            for (int i=0; i<A.getMatrixColoumn(); i++){
                sum += temp1.get(whichcolrow).get(i);
            }
            answer = sum/A.getMatrixColoumn();
        }

        else if (whichdim == false){
            for (int i=0; i<A.getMatrixRow(); i++){
                sum += temp1.get(i).get(whichcolrow);
            }
            answer = sum/A.getMatrixRow();
        }
        return answer;
    }

    private static double computeDeterminant(Matrix A){
        double det = -1.0;
        if (A.getMatrixRow() == A.getMatrixColoumn()){
            ArrayList<ArrayList<Double>> temp1 = new ArrayList<>();
            temp1 = A.getMatrix(A.getMatrixID());

            if (A.getMatrixRow() == 1){
                det = temp1.get(0).get(0);
            } else if (A.getMatrixRow() == 2){
                det = (temp1.get(0).get(0) * temp1.get(1).get(1)) - (temp1.get(0).get(1) * temp1.get(1).get(0));
            } else if (A.getMatrixRow() == 3){
                double det1 = temp1.get(0).get(0) * ((temp1.get(1).get(1) * temp1.get(2).get(2)) - (temp1.get(2).get(1) * temp1.get(1).get(2)));
                double det2 = temp1.get(0).get(1) * ((temp1.get(1).get(0) * temp1.get(2).get(2)) - (temp1.get(2).get(0) * temp1.get(1).get(2)));
                double det3 = temp1.get(0).get(2) * ((temp1.get(1).get(0) * temp1.get(2).get(1)) - (temp1.get(2).get(0) * temp1.get(1).get(1)));
                det = det1 - det2 + det3;
            }
        }
        return det;
    }

    private static void changeElement(Matrix A, double newele, int r, int c){
        ArrayList<ArrayList<Double>> temp = new ArrayList<>();
        temp = A.getMatrix(A.getMatrixID());

        if (r <= A.getMatrixRow() && c <= A.getMatrixColoumn()){
            for (int i=0; i<temp.size(); i++){
                for (int j=0; j<temp.get(0).size(); j++){
                    if (i == r-1 && j == c-1){
                        temp.get(i).set(j, newele);
                    }
                }
            }
        }

        ArrayList<String> newtype = new ArrayList<>();
        newtype = typeGiver(temp, r, c);

        A.setMatrix(temp);
        A.setMatrixType(newtype);
    }
}
