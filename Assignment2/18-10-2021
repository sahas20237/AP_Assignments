import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TimeZone;

class Instructor{
    int insID;
    String name;

    public Instructor(int insID, String name){
        this.insID = insID;
        this.name = name;
    }

    public String toString(){
        return "ID: " + insID + " Name: " + name;
    }
}

class Student{
    int stuID;
    String name;

    public Student(int stuID, String name){
        this.stuID = stuID;
        this.name = name;
    }

    public String toString(){
        return "ID: " + stuID + " Name: " + name;
    }
}

class LecMaterial{
    public String uploadedbyname;
    public String topic;
    public int numberofslides;
    public static ArrayList<ArrayList<String>> arrayofcontent = new ArrayList<>();
    public String filename;
    public String datetime;
    public int type;

    public LecMaterial(String uploadedbyname, String topic, int numberofslides, ArrayList<String> arrayofcontent, String datetime){
        this.uploadedbyname = uploadedbyname;
        this.topic = topic;
        this.numberofslides = numberofslides;
        LecMaterial.arrayofcontent.add(arrayofcontent);
        this.datetime = datetime;
        this.type = 1;
    }

    public LecMaterial(String uploadedbyname, String topic, String filename, String datetime){
        this.uploadedbyname = uploadedbyname;
        this.topic = topic;
        this.filename = filename;
        this.datetime = datetime;
        this.type = 2;
    }

    public String display1(){
        return "Uploaded By: " + uploadedbyname + "\n" + datetime +  "\n" + "Number of Slides: " + numberofslides + "\n" + "Title of Slides: " + topic;
    }

    public String display2(){
        return "Uploaded By: " + uploadedbyname + "\n" + datetime +  "\n" + "Title of Video: " + topic +  "\n" + "Filename: " + filename + "\n";
    }

    public static ArrayList<ArrayList<String>> getSlideContents(){
        return arrayofcontent;
    }
}

// class Stest{
//     public static void main(String[] args) {
//         ArrayList<String> content = new ArrayList<>();
//         String topic = "HelloWorld";
//         int number = 2;
//         for (int i=0; i<number; i++){
//             content.add("a" + i);
//         }
//         LecSlides lec[] = new LecSlides[1];
//         lec[0] = new LecSlides(topic, number, content);
//         for (LecSlides i : lec) {
//             System.out.println(i);
//         }
//     }
// }

class Assessments{
    public String IDofassessment;
    public String assignment;
    public int maxmarks;
    public String quizquestion;
    public int type;
    public int asID;
    public boolean open;

    public Assessments(int asID, String assignment, int maxmarks){
        this.assignment = assignment;
        this.maxmarks = maxmarks;
        this.type = 1;
        this.asID = asID;
        this.open = true;
    }

    public Assessments(int asID, String quizquestion){
        this.quizquestion = quizquestion;
        this.maxmarks = 1;
        this.type = 2;
        this.asID = asID;
        this.open = true;
    }

    public String display1(){
        return "ID: " + asID + " Assignment: " + assignment + " Maxmarks: " + maxmarks + "\n";
    }

    public String display2(){
        return "ID: " + asID + " Quiz question: " + quizquestion + "\n";
    }

}

class discussionForum{
    public String IDname;
    public String comment;
    public String datetime;

    public discussionForum(String IDname, String comment, String datetime){
        this.IDname = IDname;
        this.comment = comment;
        this.datetime = datetime;
    }

    public String toString(){
        return comment + " - " + IDname + "\n" + datetime + "\n";
    }
}

class thisMain{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println(
            "Welcome to Backpack" + "\n" +
            "1. Enter as instructor" + "\n" +
            "2. Enter as student"  + "\n" +
            "3. Exit");
    
            // ArrayList<Instructor> ins = new ArrayList<Instructor>();
            // Instructor i0 = new Instructor(0, "i0");
            // Instructor i1 = new Instructor(1, "i1");
            // Instructor i2 = new Instructor(2, "i2");
            // ins.add(i0); ins.add(i1); ins.add(i2);
    
            int numofins = 0;
            Instructor ins[] = new Instructor[3];
            ins[numofins++] = new Instructor(0, "i0");
            ins[numofins++] = new Instructor(1, "i1");
            ins[numofins++] = new Instructor(2, "i2");
    
            int numofstu = 0;
            Student stu[] = new Student[3];
            stu[numofstu++] = new Student(0, "s0");
            stu[numofstu++] = new Student(1, "s1");
            stu[numofstu++] = new Student(2, "s2");
    
            int numoflecmat = 0;
            LecMaterial lecmat[] = new LecMaterial[10];
    
            int numofas = 0;
            Assessments as[] = new Assessments[10];
    
            int numofcomm = 0;
            discussionForum forum[] = new discussionForum[10];
    
    
            int stakeholder = sc.nextInt();
            if (stakeholder == 1){
                System.out.println("Insructors: ");
                for (int i=0; i<numofins; i++){
                    System.out.println(ins[i]);
                }
                System.out.print("Choose ID: "); int insID = sc.nextInt();
                String thatname = "";
                for (int i=0; i<numofins; i++){
                    if (ins[i].insID == insID){
                        thatname = ins[i].name;
                    }
                }

                while (true){
                    System.out.println("Welcome " + thatname);
                    System.out.println("-----------------------");
                    System.out.println(
                    "1. Add class material" + "\n" + 
                    "2. Add assessments" + "\n" + 
                    "3. View lecture materials" + "\n" + 
                    "4. View assessments" + "\n" + 
                    "5. Grade assessments" + "\n" + 
                    "6. Close assessment" + "\n" + 
                    "7. View comments" + "\n" + 
                    "8. Add comments" + "\n" + 
                    "9. Logout");
                    System.out.println("-----------------------");
    
                    System.out.print("Enter query number: "); int query = sc.nextInt();
    
                    if (query == 1){
                        System.out.println("1. Add Lecture Slide" + "\n" + "2. Add Lecture Video");
                        int subquery = sc.nextInt();
                        if (subquery == 1){
                            System.out.print("Enter Topic of Slides: "); String topic = sc.next();
                            System.out.print("Enter Number of Slides: "); int number = sc.nextInt();
                            System.out.println("Enter Content of Slides");
                            ArrayList<String> contentlist = new ArrayList<>();
                            String datetime = datetimegiver();
                            for (int i=0; i<number; i++){
                                System.out.print("Content of Slide " + (i+1) + ": "); String content = sc.next();
                                contentlist.add(content);
                            }
                            lecmat[numoflecmat++] = new LecMaterial(thatname, topic, number, contentlist, datetime);
                        }
    
                        if (subquery == 2){
                            System.out.print("Enter Topic of Video: "); String topic = sc.next();
                            System.out.print("Enter Filename of Video: "); String filename = sc.next();
                            String datetime = datetimegiver();
                            String check = filename.substring(filename.length()-4, filename.length());
                            if (check.equals(".mp4")){
                                lecmat[numoflecmat++] = new LecMaterial(thatname, topic, filename, datetime);
                            } else{
                                System.out.println("Wrong filename");
                            }
                        }
                    }
    
                    if (query == 2){
                        System.out.println("1. Add Assignment" + "\n" + "2. Add Quiz");
                        int subquery = sc.nextInt();
                        if (subquery == 1){
                            System.out.print("Enter Problem Statement: "); String ps = sc.next();
                            System.out.print("Enter Maxmarks: "); int maxmarks = sc.nextInt();
                            as[numofas++] = new Assessments(numofas-1, ps, maxmarks);
                        }
    
                        if (subquery == 2){
                            System.out.print("Enter Quiz Question: "); String qq = sc.next();
                            as[numofas++] = new Assessments(numofas-1, qq);
                        }
                    }
    
                    if (query == 3){
                        int counter = 0;
                        ArrayList<ArrayList<String>> thatlist;
                        thatlist = LecMaterial.getSlideContents();
                        for (int i=0; i<numoflecmat; i++){
                            if (lecmat[i].type == 1){
                                System.out.println(lecmat[i].display1());
                                for (int j=0; j<thatlist.get(counter).size(); j++){
                                    System.out.println("Slide " + (j+1) + ": " + thatlist.get(counter).get(j));
                                }
                                counter++;
                                System.out.println();
                            } else if (lecmat[i].type == 2){
                                System.out.println(lecmat[i].display2());
                            }
                        }
                    }
    
                    if (query == 4){
                        for (int i=0; i<numofas; i++){
                            if (as[i].type == 1 && as[i].open == true){
                                System.out.println(as[i].display1());
                            } else if (as[i].type == 2 && as[i].open == true){
                                System.out.println(as[i].display2());
                            }
                        }
                    }
    
                    if (query == 6){
                        for (int i=0; i<numofas; i++){
                            if (as[i].type == 1){
                                System.out.println(as[i].display1());
                            } else if (as[i].type == 2) {
                                System.out.println(as[i].display2());
                            }
                        }
                        System.out.print("Enter id of assignment to close: "); int thatID = sc.nextInt();
                        for (int i=0; i<numofas; i++){
                            if (as[i].asID == thatID){
                                as[i].open = false;
                            }
                        }
                    }
    
                    if (query == 7){
                        for (int i=0; i<numofcomm; i++){
                            System.out.println(forum[i]);
                        }
                    }
    
                    if (query == 8){
                        System.out.print("Enter Comment: "); String comment = sc.next();
                        forum[numofcomm++] = new discussionForum(thatname, comment, datetimegiver());
                    }
    
                    if (query == 9){
                        break;
                    }
                }
            }

            else if (stakeholder == 2){
                System.out.println("Students: ");
                for (int i=0; i<numofstu; i++){
                    System.out.println(stu[i]);
                }
                System.out.print("Choose ID: "); int stuID = sc.nextInt();
                String thatname = "";
                for (int i=0; i<numofstu; i++){
                    if (stu[i].stuID == stuID){
                        thatname = stu[i].name;
                    }
                }

                while(true){
                    System.out.println("Welcome " + thatname);
                    System.out.println("-----------------------");
                    System.out.println(
                    "1. View lecture materials" + "\n" + 
                    "2. View assessments" + "\n" + 
                    "3. Submit assessment" + "\n" + 
                    "4. View grades" + "\n" + 
                    "5. View comments" + "\n" + 
                    "6. Add comments" + "\n" + 
                    "7. Logout");
                    System.out.println("-----------------------");
    
                    System.out.print("Enter query number: "); int query = sc.nextInt();

                    if (query == 1){
                        for (int i=0; i<numoflecmat; i++){
                            if (lecmat[i].type == 1){
                                System.out.println(lecmat[i].display1());
                            } else if (lecmat[i].type == 2) {
                                System.out.println(lecmat[i].display2());
                            }
                        }
                    }

                    if (query == 2){
                        for (int i=0; i<numofas; i++){
                            if (as[i].type == 1 && as[i].open == true){
                                System.out.println(as[i].display1());
                            } else if (as[i].type == 2 && as[i].open == true) {
                                System.out.println(as[i].display2());
                            }
                        }
                    }

                    // if (query == 3){
                    //     System.out.println("Pending Assessments: ");
                    //     for (int i=0; i<numofas; i++){
                    //         if (as[i].type == 1 && as[i].open == true){
                    //             System.out.println(as[i].display1());
                    //         } else if (as[i].type == 2 && as[i].open == true) {
                    //             System.out.println(as[i].display2());
                    //         }
                    //     }
                    //     System.out.println("Enter ID of Assessment: "); int thatID = sc.nextInt();
                    // }

                    if (query == 4){

                    }

                    if (query == 5){
                        for (int i=0; i<numofcomm; i++){
                            System.out.println(forum[i]);
                        }
                    }

                    if (query == 6){
                        System.out.println("Enter Comment: "); String comment = sc.next();
                        forum[numofcomm++] = new discussionForum(thatname, comment, datetimegiver());
                    }

                    if (query == 7){
                        break;
                    }
                }
            }

            else if (stakeholder == 3){
                break;
            }
        }
        sc.close();
    }

    private static String datetimegiver(){
        LocalDateTime datetime = LocalDateTime.now();
        DateTimeFormatter dttmformat = DateTimeFormatter.ofPattern("EEE dd-MM-yyyy HH:mm:ss ");

        TimeZone thatzone = TimeZone.getDefault();  
        String zone = thatzone.getDisplayName(false, 0);

        String fd = datetime.format(dttmformat) + zone;
        return fd;
    }
}
