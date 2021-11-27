import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Book{
    Title title;
    ISBN isbn;
    Barcode barcode;

    public Book(Title title, ISBN isbn, Barcode barcode){
        this.title = title;
        this.isbn = isbn;
        this.barcode = barcode;
    }

    public String toString(){
        return "Title: " + title.getTitle() + " ISBN: " + isbn.getISBN() + " Barcode: " + barcode.getBarcode();
    }

    public String getTitle(){return title.getTitle();}
    public int getISBN(){return isbn.getISBN();}
    public int getBarcode(){return barcode.getBarcode();}

    public static Comparator<Book> comptitle = new Comparator<Book>(){ // comaparator for copareTo() function with priority to title > ISBN > Barcode
        public int compare(Book A, Book B){
            String title1 = A.getTitle();
            String title2 = B.getTitle();
            if (title1.equals(title2)){
                int isbn1 = A.getISBN();    
                int isbn2 = B.getISBN();
                if (isbn1 == isbn2){
                    int barcode1 = A.getBarcode();  
                    int barcode2 = B.getBarcode();
                    return barcode1 - barcode2;
                }
                return isbn1 - isbn2;
            } 
            return title1.compareTo(title2);
        }
    };
}

class Title{
    private String title;

    public Title(String title){
        this.title = title;
    }

    public String toString(){
        return "Title: " + title; 
    }

    public String getTitle(){return title;}
}

class ISBN{
    private int isbn;

    public ISBN(){
        this.isbn = (int)((1 + Math.random())*100); // 3 digit ISBN
    }

    public String toString(){
        return "ISBN: " + isbn; 
    }

    public int getISBN(){return isbn;}
}

class Barcode{
    private int barcode;

    public Barcode(){
        this.barcode = (int)((1 + Math.random())*10000); // 5 digit barcode
    }

    public String toString(){
        return "Barcode: " + barcode; 
    }

    public int getBarcode(){return barcode;}
}

class BooksMain{
    public static ArrayList<Book> books = new ArrayList<>();
    private static ArrayList<Title> titles = new ArrayList<>();
    private static ArrayList<ISBN> isbns = new ArrayList<>();
    private static ArrayList<Barcode> barcodes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of Books: "); int numbooks = sc.nextInt();
        System.out.print("Enter number of Racks: "); int numracks = sc.nextInt(); sc.nextLine();

        if (numbooks%numracks == 0){
            System.out.println("Hence number of Slots on each Rack: " + (int)numbooks/numracks);
        } else{
            while (numbooks%numracks != 0){
                System.out.println("Enter number of Racks as a multiple of number of Books");
                System.out.print("Enter number of Racks: "); numracks = sc.nextInt(); sc.nextLine();
                if (numbooks%numracks == 0){
                    System.out.println("Hence number of Slots on each Rack: " + (int)numbooks/numracks);
                }
            }
        }

        ArrayList<ArrayList<Object>> Library = new ArrayList<>(); // 2D arralylist containing Generic arraylist of Object 

        for (int i=0; i<numbooks; i++){
            System.out.print("Enter Title of Book " + (i+1) + ": "); String title = sc.nextLine();

            Title temptitle = new Title(title); titles.add(temptitle);
            ISBN tempisbn = new ISBN(); isbns.add(tempisbn);
            Barcode tempbarcode = new Barcode(); barcodes.add(tempbarcode);
            Book tempbook = new Book(temptitle, tempisbn, tempbarcode); books.add(tempbook);

            ArrayList<Object> temparr = new ArrayList<>(); // Generic arraylist of Objects
            temparr.add(titles.get(titles.size()-1).getTitle()); 
            temparr.add(isbns.get(isbns.size()-1).getISBN()); 
            temparr.add(barcodes.get(barcodes.size()-1).getBarcode()); 

            Library.add(temparr);
        }

        Collections.sort(books, Book.comptitle); // sorting according to Title > ISBN > Barcode

        for (Book i : books) {
            System.out.println(i);
        }

        ArrayList<ArrayList<String>> Rack = new ArrayList<>();
        for (int i=0; i<numracks; i++){
            Rack.add(new ArrayList<>());
        }

        int counter = 0;
        for (int i=0; i<Rack.size(); i++){
            for (int j=0; j<(int)numbooks/numracks; j++){
                Rack.get(i).add(books.get(counter++).getTitle());
            }
        }

        for (ArrayList<String> i : Rack){
            System.out.println(i);
        }

        sc.close();
    }
}
