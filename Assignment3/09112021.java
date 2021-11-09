import java.util.ArrayList;
import java.util.Scanner;

class Matrix{
    private ArrayList<ArrayList<Double>> matrix;
    private int matrixID;
    protected ArrayList<String> type;
    private int row;
    private int col;
    private int matrixMean;
    
    public Matrix(){}

    public Matrix(ArrayList<ArrayList<Double>> matrix, int row, int col, ArrayList<String> type, int matrixID){
        this.matrix = matrix;
        this.matrixID = matrixID;
        this.type = type;
        this.row = row;
        this.col = col;
        this.matrixMean = matrixMean();
        System.out.println("MatrixID: " + matrixID + " Matrix: " + matrix + " Type: " + type);
    }

    public String toString(){
        return "MatrixID: " + matrixID + " Matrix: " + matrix + " Type: " + type;
    }

    private int matrixMean(){
        int sum = 0;
        for (int i=0; i<matrix.size(); i++){
            for (int j=0; j<matrix.get(0).size(); j++){
                sum += matrix.get(i).get(j);
            }
        }
        return sum/(matrix.size() * matrix.get(0).size());
    }

    public ArrayList<ArrayList<Double>> getMatrix(int matrixID) {return matrix;}
    public ArrayList<String> getMatrixType(int matrixID) {return type;}
    public int getMatrixID() {return matrixID;}
    public int getMatrixRow() {return row;}
    public int getMatrixColoumn() {return col;}
    public int getMatrixMean() {return matrixMean;}
}

class RowMatrix extends Matrix{
    // public RowMatrix(){
    // }

    public RowMatrix(ArrayList<ArrayList<Double>> matrix, int row, int col, ArrayList<String> type, int matrixID){
        super(matrix, row, col, type, matrixID);
    }
}

class ColoumnMatrix extends Matrix{
    // public ColoumnMatrix(){
    // }

    public ColoumnMatrix(ArrayList<ArrayList<Double>> matrix, int row, int col, ArrayList<String> type, int matrixID){
        super(matrix, row, col, type, matrixID);
    }
}

class Ones extends Matrix{
    // public Ones(){
    // }

    public Ones(ArrayList<ArrayList<Double>> matrix, int row, int col, ArrayList<String> type, int matrixID){
        super(matrix, row, col, type, matrixID);
    }
}

class Null extends Matrix{
    // public Null(){
    // }

    public Null(ArrayList<ArrayList<Double>> matrix, int row, int col, ArrayList<String> type, int matrixID){
        super(matrix, row, col, type, matrixID);
    }
}

class SquareMatrix extends Matrix{
    private int side;
    private double determinant;

    private double findDeterminant(SquareMatrix A){
        double det = -1.0;
        ArrayList<ArrayList<Double>> temp1 = new ArrayList<>();
        temp1 = A.getMatrix(A.getMatrixID());

        if (side == 1){
            det = temp1.get(0).get(0);
        } else if (side == 2){
            det = (temp1.get(0).get(0) + temp1.get(1).get(1)) - (temp1.get(0).get(1) + temp1.get(1).get(0));
        } else if (side == 3){
            double det1 = temp1.get(0).get(0) * ((temp1.get(1).get(1) + temp1.get(2).get(2)) - (temp1.get(2).get(1) + temp1.get(1).get(2)));
            double det2 = temp1.get(0).get(1) * ((temp1.get(1).get(0) + temp1.get(2).get(2)) - (temp1.get(2).get(0) + temp1.get(1).get(2)));
            double det3 = temp1.get(0).get(2) * ((temp1.get(1).get(0) + temp1.get(2).get(1)) - (temp1.get(2).get(0) + temp1.get(1).get(1)));
            det = det1 - det2 + det3;
        }
        return det;
    }

    public SquareMatrix(ArrayList<ArrayList<Double>> matrix, int row, int col, ArrayList<String> type, int matrixID){
        super(matrix, row, col, type, matrixID);
        this.side = getMatrixRow();
    }

    public int getSide(){return side;}
    public double getDeterminant(){return determinant;}
}

class Symmetric extends SquareMatrix{
    public Symmetric(ArrayList<ArrayList<Double>> matrix, int row, int col, ArrayList<String> type, int matrixID){
        super(matrix, row, col, type, matrixID);
    }
}

class Skew extends SquareMatrix{

    public Skew(ArrayList<ArrayList<Double>> matrix, int row, int col, ArrayList<String> type, int matrixID){
        super(matrix, row, col, type, matrixID);
    }
}

class UpperTriangular extends SquareMatrix{
    ArrayList<Double> elements = new ArrayList<>();

    public UpperTriangular(ArrayList<ArrayList<Double>> matrix, int row, int col, ArrayList<String> type, int matrixID){
        super(matrix, row, col, type, matrixID);
    }
}

class LowerTriangular extends SquareMatrix{
    ArrayList<Double> elements = new ArrayList<>();

    public LowerTriangular(ArrayList<ArrayList<Double>> matrix, int row, int col, ArrayList<String> type, int matrixID){
        super(matrix, row, col, type, matrixID);
    }
}

class Singular extends SquareMatrix{

    public Singular(ArrayList<ArrayList<Double>> matrix, int row, int col, ArrayList<String> type, int matrixID){
        super(matrix, row, col, type, matrixID);
    }
}

class Singleton extends SquareMatrix{
    private double element;

    public Singleton(ArrayList<ArrayList<Double>> matrix, int row, int col, ArrayList<String> type, int matrixID){
        super(matrix, row, col, type, matrixID);
        this.element = matrix.get(0).get(0);
    }

    public double getElement(){return element;}
}

class Diagonal extends SquareMatrix{
    private ArrayList<Double> elements = new ArrayList<>();
    private ArrayList<ArrayList<Double>> temp = new ArrayList<>();

    public Diagonal(ArrayList<ArrayList<Double>> matrix, int row, int col, ArrayList<String> type, int matrixID){
        super(matrix, row, col, type, matrixID);
        for (int i=0; i<matrix.size(); i++){
            elements.add(temp.get(i).get(i));
        }
    }
}

class Scalar extends Diagonal{
    private double thatelement;

    public Scalar(ArrayList<ArrayList<Double>> matrix, int row, int col, ArrayList<String> type, int matrixID){
        super(matrix, row, col, type, matrixID);
        this.thatelement = matrix.get(0).get(0);
    }

    public double getScalarElement(){return thatelement;}
}

class Identity extends Scalar{
    private double idenelement;

    public Identity(ArrayList<ArrayList<Double>> matrix, int row, int col, ArrayList<String> type, int matrixID){
        super(matrix, row, col, type, matrixID);
        this.idenelement = 1;
    }

    public double getIdentityElement(){return idenelement;}
}

class matrixMain{
    private static ArrayList<Matrix> mat = new ArrayList<>();
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
            int row = sc.nextInt();
            int col = sc.nextInt();
            for (int j=0; j<row*col; j++){
                input.add(sc.nextDouble());
            }

            ArrayList<ArrayList<Double>> output;
            output = generateMatrix(input, row, col);

            ArrayList<String> type;
            type = typeGiver(output, row, col);

            memoryOptimizer(type, output, row, col, mat.size());
        }

        while(true){
            System.out.println();
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
                "3. Multiply");

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

                // else if (subtask == 3){
                //     if (A.getMatrixColoumn() == B.getMatrixRow()){
                //         temp = mulMatrix(A, B);
                //         ArrayList<String> type;
                //         type = typeGiver(temp, temp.size(), temp.get(0).size());
                //         Matrix temp2 = new Matrix(temp, temp.size(), temp.get(0).size(), type, mat.size());
                //         mat.add(temp2);
                //     }
                // }
            }

            else if (task == 6){
                System.out.println("Enter Matrix IDs: ");
                System.out.print("Matrix ID 1: "); int matID1 = sc.nextInt(); 
                System.out.print("Matrix ID 2: "); int matID2 = sc.nextInt();
                Matrix A = new Matrix();
                Matrix B = new Matrix();
                for (int i=0; i<num; i++){
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
                for (int i=0; i<num; i++){
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
                for (int i=0; i<num; i++){
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
                for (int i=0; i<num; i++){
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
                    System.out.println("Mean of " + thatrow + " is: " + answer);
                }

                else if (subtask == 2){
                    System.out.print("Enter that coloumn: "); int thatcol = sc.nextInt();
                    System.out.println();

                    double answer = computeMeans(A, false, thatcol-1);
                    System.out.println("Mean of " + thatcol + " is: " + answer);
                }

                else if (subtask == 3){
                    System.out.println("Mean of all elements is: " + A.getMatrixMean());
                }
            }

            else if (task == 10){
                System.out.print("Enter Matrix ID: "); int matID = sc.nextInt();
                Matrix A = new Matrix();
                for (int i=0; i<num; i++){
                    if (mat.get(i).getMatrixID() == matID){
                        A = mat.get(i);
                    }
                }

                if (A.getMatrixRow() == A.getMatrixColoumn()){
                    double det = computeDeterminant(A);
                    System.out.println(det);
                } else{
                    System.out.println("ERROR: Matrix not Square");
                }
            }

            else if (task == 11){   
                System.out.println("Enter Matrix IDs: ");
                System.out.print("Matrix ID 1 (to be scaled): "); int matID1 = sc.nextInt(); 
                System.out.print("Matrix ID 2 (to be used as scaling factor - singleton): "); int matID2 = sc.nextInt();
                Matrix A = new Matrix();
                Matrix B = new Matrix();
                for (int i=0; i<num; i++){
                    if (mat.get(i).getMatrixID() == matID1){
                        A = mat.get(i);
                    }
                    if (mat.get(i).getMatrixID() == matID2){
                        B = mat.get(i);
                    }
                }

                ArrayList<String> thattype = new ArrayList<>();
                thattype = A.getMatrixType(A.getMatrixID());

                for (int i=0; i<thattype.size(); i++){
                    if (thattype.get(i).equals("Singleton")){
                        EWMulMatrix(A, B);
                    }
                }
            }

            else if (task == 15){
                for (Matrix i : mat) {
                    System.out.println(i);
                }
            }

            else if (task == 16){
                break;
            }
        }
        sc.close();
    }

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
                    answer.get(i).add(temp1.get(i).get(j) + temp2.get(i).get(j));
                }
            }
        }
        return answer;
    }

    private static ArrayList<ArrayList<Double>> subMatrix(Matrix A, Matrix B){
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
                    answer.get(i).add(temp1.get(i).get(j) - temp2.get(i).get(j));
                }
            }
        }
        return answer;
    }

    // private static ArrayList<ArrayList<Double>> mulMatrix(Matrix A, Matrix B){
    //     ArrayList<ArrayList<Double>> temp1 = new ArrayList<>();
    //     ArrayList<ArrayList<Double>> temp2 = new ArrayList<>();
    //     temp1 = A.getMatrix(A.getMatrixID());
    //     temp2 = B.getMatrix(B.getMatrixID());
    //     ArrayList<ArrayList<Double>> answer = new ArrayList<>();

    //     if (A.getMatrixColoumn() == B.getMatrixRow()){
    //         for (int i=0; i<B.getMatrixColoumn(); i++){
    //             answer.add(new ArrayList<>());
    //         }

    //         ArrayList<ArrayList<Double>> temp3 = new ArrayList<>();
    //         temp3 = transposeMatrix(B);

    //         // start here for loops
    //     }
    //     return temp1; // remove this
    // }

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
                    answer.get(i).add(temp1.get(i).get(j) / temp2.get(i).get(j));
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
                }
            } else if (A.getMatrixRow() == 2){
                double det = computeDeterminant(A);
                if(det != 0){
                    double a = temp1.get(0).get(0); double b = temp1.get(0).get(1); double c = temp1.get(1).get(0); double d = temp1.get(1).get(1); 
                    temp2.get(0).add(d/det); temp2.get(0).add(-b/det); temp2.get(1).add(-c/det); temp2.get(1).add(a/det);
                }
            } else if (A.getMatrixRow() == 3){
                double det = computeDeterminant(A);
                if (det != 0){
                    double d00 = +(1/det)*((temp1.get(2).get(2) + temp1.get(1).get(1)) - (temp1.get(2).get(1) + temp1.get(1).get(2)));
                    double d01 = -(1/det)*((temp1.get(2).get(2) + temp1.get(1).get(0)) - (temp1.get(2).get(0) + temp1.get(1).get(2)));
                    double d02 = +(1/det)*((temp1.get(2).get(1) + temp1.get(1).get(0)) - (temp1.get(2).get(0) + temp1.get(1).get(1)));
                    double d10 = -(1/det)*((temp1.get(2).get(2) + temp1.get(0).get(1)) - (temp1.get(2).get(1) + temp1.get(0).get(2)));
                    double d11 = +(1/det)*((temp1.get(2).get(2) + temp1.get(0).get(0)) - (temp1.get(2).get(0) + temp1.get(0).get(2)));
                    double d12 = -(1/det)*((temp1.get(2).get(1) + temp1.get(0).get(0)) - (temp1.get(2).get(0) + temp1.get(0).get(1)));
                    double d20 = +(1/det)*((temp1.get(1).get(2) + temp1.get(0).get(1)) - (temp1.get(1).get(1) + temp1.get(0).get(2)));
                    double d21 = -(1/det)*((temp1.get(1).get(2) + temp1.get(0).get(0)) - (temp1.get(1).get(0) + temp1.get(0).get(2)));
                    double d22 = +(1/det)*((temp1.get(1).get(1) + temp1.get(0).get(0)) - (temp1.get(1).get(0) + temp1.get(0).get(1)));

                    temp2.get(0).add(d00); temp2.get(0).add(d01); temp2.get(0).add(d02); 
                    temp2.get(1).add(d10); temp2.get(1).add(d11); temp2.get(1).add(d12); 
                    temp2.get(2).add(d20); temp2.get(2).add(d21); temp2.get(2).add(d22);
                }
            }
        }
        return temp2;
    }

    private static int computeMeans(Matrix A, boolean whichdim, int whichcolrow){ // boolean true = row, false = col
        ArrayList<ArrayList<Double>> temp1 = new ArrayList<>();
        temp1 = A.getMatrix(A.getMatrixID());
        int sum = 0;
        int answer = 0;

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
                det = (temp1.get(0).get(0) + temp1.get(1).get(1)) - (temp1.get(0).get(1) + temp1.get(1).get(0));
            } else if (A.getMatrixRow() == 3){
                double det1 = temp1.get(0).get(0) * ((temp1.get(1).get(1) + temp1.get(2).get(2)) - (temp1.get(2).get(1) + temp1.get(1).get(2)));
                double det2 = temp1.get(0).get(1) * ((temp1.get(1).get(0) + temp1.get(2).get(2)) - (temp1.get(2).get(0) + temp1.get(1).get(2)));
                double det3 = temp1.get(0).get(2) * ((temp1.get(1).get(0) + temp1.get(2).get(1)) - (temp1.get(2).get(0) + temp1.get(1).get(1)));
                det = det1 - det2 + det3;
            }
        }
        return det;
    }

    private static boolean isRectangular(ArrayList<ArrayList<Double>> A, int row, int col){ // all matrices are rectangular?
        boolean flag = true;
        return flag;
    }

    private static boolean isRowMatrix(ArrayList<ArrayList<Double>> A, int row, int col){
        boolean flag = false;
        if (col != 0 &&  row == 1){
            flag = true;
        }
        return flag;
    }

    private static boolean isColoumnMatrix(ArrayList<ArrayList<Double>> A, int row, int col){
        boolean flag = false;
        if (row != 0 && col == 1){
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
            double det = (A.get(0).get(0) + A.get(1).get(1)) - (A.get(0).get(1) + A.get(1).get(0));
            if (det != 0){
                flag = false;
            }
        } else if (side == 3){
            double det1 = A.get(0).get(0) * ((A.get(1).get(1) + A.get(2).get(2)) - (A.get(2).get(1) + A.get(1).get(2)));
            double det2 = A.get(0).get(1) * ((A.get(1).get(0) + A.get(2).get(2)) - (A.get(2).get(0) + A.get(1).get(2)));
            double det3 = A.get(0).get(2) * ((A.get(1).get(0) + A.get(2).get(1)) - (A.get(2).get(0) + A.get(1).get(1)));
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
}
