import java.util.ArrayList;
import java.util.Scanner;

class Matrix{
    private ArrayList<ArrayList<Integer>> matrix;
    private int matrixID;
    private ArrayList<String> type;

    public Matrix(ArrayList<ArrayList<Integer>> matrix, ArrayList<String> type, int matrixID){
        this.matrix = matrix;
        this.type = type;
        this.matrixID = matrixID;
    }

    public String toString(){
        return "MatrixID: " + matrixID + " Matrix: " + matrix + " Type: " + type;
    }

    public ArrayList<ArrayList<Integer>> getMatrix(int matrixID) {return matrix;}
    public ArrayList<String> getMatrixType(int matrixID) {return type;}
}

class matrixMain{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> input = new ArrayList<>();
        int row = sc.nextInt();
        int col = sc.nextInt();
        for (int i=0; i<row*col; i++){
            input.add(sc.nextInt());
        }

        ArrayList<ArrayList<Integer>> output;
        output = generateMatrix(input, row, col);
        ArrayList<String> type;
        type = typeGiver(output, row, col);
       
        ArrayList<Matrix> mat = new ArrayList<>();
        Matrix m0 = new Matrix(output, type, mat.size());
        mat.add(m0);
        Matrix m1 = new Matrix(output, type, mat.size());
        mat.add(m1);
        for (Matrix i : mat) {
            System.out.println(i);
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

    
    private static boolean isRectangular(ArrayList<ArrayList<Integer>> A, int row, int col){ // all matrices are rectangular?
        boolean flag = true;
        return flag;
    }

    private static boolean isRowMatrix(ArrayList<ArrayList<Integer>> A, int row, int col){
        boolean flag = false;
        if (col == 0 &&  row == 1){
            flag = true;
        }
        return flag;
    }

    private static boolean isColoumnMatrix(ArrayList<ArrayList<Integer>> A, int row, int col){
        boolean flag = false;
        if (row == 0 && col == 1){
            flag = true;
        }
        return flag;
    }

    private static boolean isSquare(ArrayList<ArrayList<Integer>> A, int row, int col){
        boolean flag = true;
        if (row != col){
            flag = false;
        }
        return flag;
    }

    private static boolean isSymmetric(ArrayList<ArrayList<Integer>> A, int side){
        ArrayList<Integer> X = new ArrayList<>();
        ArrayList<Integer> Y = new ArrayList<>();
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

    private static boolean isSkewSymmetric(ArrayList<ArrayList<Integer>> A, int side){
        ArrayList<Integer> X = new ArrayList<>();
        ArrayList<Integer> Y = new ArrayList<>();
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
            if (side == 2 && i == 3){
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

    private static boolean isUpperTriangular(ArrayList<ArrayList<Integer>> A, int side){
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

    private static boolean isLowerTriangular(ArrayList<ArrayList<Integer>> A, int side){
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

    private static boolean isSingular(ArrayList<ArrayList<Integer>> A, int side){
        boolean flag = true;
        if (side == 1){
            if (A.get(0).get(0) != 0){
                flag = false;
            }
        } else if (side == 2){
            int det = (A.get(0).get(0) + A.get(1).get(1)) - (A.get(0).get(1) + A.get(1).get(0));
            if (det != 0){
                flag = false;
            }
        } else if (side == 3){
            int det1 = A.get(0).get(0) * ((A.get(1).get(1) + A.get(2).get(2)) - (A.get(2).get(1) + A.get(1).get(2)));
            int det2 = A.get(0).get(1) * ((A.get(1).get(0) + A.get(2).get(2)) - (A.get(2).get(0) + A.get(1).get(2)));
            int det3 = A.get(0).get(2) * ((A.get(1).get(0) + A.get(2).get(1)) - (A.get(2).get(0) + A.get(1).get(1)));
            int det = det1 - det2 + det3;
            if (det != 0){
                flag = false;
            }
        }
        return flag;
    }

    private static boolean isDiagonal(ArrayList<ArrayList<Integer>> A, int side){
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

    private static boolean isScalar(ArrayList<ArrayList<Integer>> A, int side){
        boolean flag = true;
        int init = A.get(0).get(0);
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

    private static boolean isIdentity(ArrayList<ArrayList<Integer>> A, int side){
        boolean flag = true;
        int init = A.get(0).get(0);
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

    private static boolean isSingleton(ArrayList<ArrayList<Integer>> A, int row, int col){
        boolean flag = true;
        if (row != 1 && col != 1){
            flag = false;
        }
        return flag;
    }

    private static boolean isOnes(ArrayList<ArrayList<Integer>> A, int row, int col){
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

    private static boolean isNull(ArrayList<ArrayList<Integer>> A, int row, int col){
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

    private static ArrayList<String> typeGiver(ArrayList<ArrayList<Integer>> A, int row, int col){
        ArrayList<String> type = new ArrayList<>();
        int side = 0;
        if (row == col){
            side = row;
        }
        if (isSingular(A, side) == true){
            type.add("Singular");
        }
        if (isRectangular(A, row, col) == true){
            type.add("Rectangular");
            if (isColoumnMatrix(A, row, col) == true){
                type.add(("Coloumn"));
            } else if (isRowMatrix(A, row, col) == true){
                type.add(("Row"));
            } else if (isSquare(A, row, col) == true){
                type.add("Square");
                if (isSymmetric(A, side) == true){
                    type.add("Symmetric");
                } else if (isSkewSymmetric(A, side) == true){
                    type.add("Skew Symmetric");
                }
                if (isUpperTriangular(A, side) == true){
                    type.add("Upper Triangular");
                } else if (isLowerTriangular(A, side) == true){
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
}
