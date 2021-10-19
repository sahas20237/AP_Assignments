import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TimeZone;

class Instructor{
    private int insID;
    private String insname;

    public Instructor(int insID, String insname){
        this.insID = insID;
        this.insname = insname;
    }

    public String toString(){
        return "ID: " + insID + " Name: " + insname;
    }

    public int getInsID() {return insID;}
    public String getInsName() {return insname;}
}

class Student{
    private int stuID;
    private String stuname;
    int subcounter = 0;
    int[] submittedAssignID = new int[10];
    private int gradedcounter = 0;
    int[] gradedAssignID = new int[10];

    public Student(int stuID, String stuname){
        this.stuID = stuID;
        this.stuname = stuname;
        // this.submittedAssignID = new int[10];
        // this.subcounter = 0;
        // this.gradedAssignID = new int[10];
        // this.gradedcounter = 0;
    }

    public String toString(){
        return "ID: " + stuID + " Name: " + stuname;
    }

    public int getStuID() {return stuID;}
    public String getStuName() {return stuname;}
    public int[] getSubmittedAssign() {return submittedAssignID;}
    public int getGradedCounter() {return gradedcounter;}
    public int[] getGradedAssign() {return gradedAssignID;}
    public void addSubmittedAssign(int assignID) {this.submittedAssignID[this.subcounter++] = assignID;}
    public void addGradedAssign(int assignID) {this.gradedAssignID[this.gradedcounter++] = assignID;}
}

class LecMaterial{
    private String uploadedbyname;
    private String topic;
    private int numberofslides;
    private static ArrayList<ArrayList<String>> arrayofcontent = new ArrayList<>();
    private String filename;
    private String datetime;
    private int type;

    public LecMaterial(String uploadedbyname, String topic, int numberofslides, ArrayList<String> arrayofcontent, String datetime){
        this.uploadedbyname = uploadedbyname;
        this.topic = topic;
        this.numberofslides = numberofslides;
        this.datetime = datetime;
        this.type = 1;
        LecMaterial.arrayofcontent.add(arrayofcontent);
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

    public int getType() {return type;}
}

class Assessments{
    private String assignment;
    private int maxmarks;
    private String quizquestion;
    private int type;
    private int assignID;
    private boolean open;

    public Assessments(int assignID, String assignment, int maxmarks){
        this.assignment = assignment;
        this.maxmarks = maxmarks;
        this.type = 1;
        this.assignID = assignID;
        this.open = true;
    }

    public Assessments(int asID, String quizquestion){
        this.quizquestion = quizquestion;
        this.maxmarks = 1;
        this.type = 2;
        this.assignID = asID;
        this.open = true;
    }

    public String display1(){
        return "ID: " + assignID + " Assignment: " + assignment + " Maxmarks: " + maxmarks;
    }

    public String display2(){
        return "ID: " + assignID + " Quiz question: " + quizquestion;
    }

    public int getType() {return type;}
    public int getassignID() {return assignID;}
    public String getQuizQuestion() {return quizquestion;}
    public int getMaxmarks() {return maxmarks;}
    public boolean getStatus() {return open;}
    public void setStatus(boolean status) {this.open = status;}
}

class addSubmission{
    private int stuID;
    private int assignID;
    private String nameofsub;
    private int type;
    private boolean submitted;

    public addSubmission(int stuID, int assignID, String nameofsub, int type){
        this.stuID = stuID;
        this.assignID = assignID;
        this.nameofsub = nameofsub;
        this.type = type;
        this.submitted = false;
    }
    
    public int getStuID() {return stuID;}
    public int getAssignID() {return assignID;}
    public String getNameofSub() {return nameofsub;}
    public int getType() {return type;}
    public boolean getStatus() {return submitted;}
    public void setSubmitted(boolean submitted) {this.submitted = true;}
}

class gradedSubs{
    private String checkedby;
    private int marksgot;
    private String subname;
    private int thatstuID;
    private int assignID;
    private boolean hasgraded;

    public gradedSubs(String checkedby, int marksgot, String subname, int thatstuID, int assignID){
        this.checkedby = checkedby;
        this.marksgot = marksgot;
        this.subname = subname;
        this.thatstuID = thatstuID;
        this.assignID = assignID;
        this.hasgraded = false;
    } 

    public String getChecker() {return checkedby;}
    public int getMarksgot() {return marksgot;}
    public String getSubname() {return subname;}
    public int getthatstuID() {return thatstuID;}
    public int getassignID() {return assignID;}
    public boolean gethasGraded() {return hasgraded;}
    public void sethasGraded(boolean status) {this.hasgraded = status;}
}

class discussionForum{
    private String IDname;
    public String comment;
    private String datetime;

    public discussionForum(String IDname, String comment, String datetime){
        this.IDname = IDname;
        this.comment = comment;
        this.datetime = datetime;
    }

    public String toString(){
        return comment + " - " + IDname + "\n" + datetime + "\n";
    }

    public String getCommenter() {return IDname;}
}

class thisMain{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Number of Instructors: "); int numofins = sc.nextInt();
        Instructor ins[] = new Instructor[numofins];
        for (int i=0; i<numofins; i++){
            ins[i] = new Instructor(i, "I"+i);
        }
        
        // ins[numofins++] = new Instructor(0, "i0");
        // ins[numofins++] = new Instructor(1, "i1");
        // ins[numofins++] = new Instructor(2, "i2");

        // ArrayList<Instructor> ins = new ArrayList<Instructor>();
        // Instructor i0 = new Instructor(0, "i0");
        // Instructor i1 = new Instructor(1, "i1");
        // Instructor i2 = new Instructor(2, "i2");
        // ins.add(i0); ins.add(i1); ins.add(i2);

        System.out.print("Number of Students: "); int numofstu = sc.nextInt();
        Student stu[] = new Student[numofstu];
        for (int i=0; i<numofstu; i++){
            stu[i] = new Student(i, "S"+i);
        }

        // stu[numofstu++] = new Student(0, "s0");
        // stu[numofstu++] = new Student(1, "s1");
        // stu[numofstu++] = new Student(2, "s2");

        int numoflecmat = 0;
        LecMaterial lecmat[] = new LecMaterial[10];

        int numofas = 0;
        Assessments as[] = new Assessments[10];

        int numofcomm = 0;
        discussionForum forum[] = new discussionForum[10];

        int numofsub = 0;
        addSubmission sub[] = new addSubmission[10];

        int numofgrad = 0;
        gradedSubs grad[] = new gradedSubs[10];

        while(true){
            System.out.println(
            "Welcome to Backpack" + "\n" +
            "1. Enter as instructor" + "\n" +
            "2. Enter as student"  + "\n" +
            "3. Exit");
                
            int stakeholder = sc.nextInt();
            if (stakeholder == 1){
                System.out.println("Insructors: ");
                for (int i=0; i<numofins; i++){
                    System.out.println(ins[i]);
                }

                System.out.print("Choose ID: "); int insID = sc.nextInt();

                String thatname = "";
                for (int i=0; i<numofins; i++){
                    if (ins[i].getInsID() == insID){
                        thatname = ins[i].getInsName();
                    }
                }

                while (true){
                    System.out.println("\n" + "Welcome " + thatname);
                    System.out.println("--------------------------");
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
                    System.out.println("--------------------------");
    
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
                            if (filename.length() >= 4){
                                String check = filename.substring(filename.length()-4, filename.length());
                                if (check.equals(".mp4")){
                                    lecmat[numoflecmat++] = new LecMaterial(thatname, topic, filename, datetimegiver());
                                } else{
                                    System.out.println("Wrong filename, only .mp4 allowed");
                                }
                            } else{
                                System.out.println("No name provided");
                            }
                        }
                    }
    
                    if (query == 2){
                        System.out.println("1. Add Assignment" + "\n" + "2. Add Quiz");
                        int subquery = sc.nextInt();
                        if (subquery == 1){
                            System.out.print("Enter Problem Statement: "); String ps = sc.next();
                            System.out.print("Enter Maxmarks: "); int maxmarks = sc.nextInt();
                            as[numofas++] = new Assessments(numofas, ps, maxmarks);
                        }
    
                        if (subquery == 2){
                            System.out.print("Enter Quiz Question: "); String qq = sc.next();
                            as[numofas++] = new Assessments(numofas, qq);
                        }
                    }
    
                    if (query == 3){
                        int counter = 0;
                        ArrayList<ArrayList<String>> thatlist;
                        thatlist = LecMaterial.getSlideContents();
                        for (int i=0; i<numoflecmat; i++){
                            if (lecmat[i].getType() == 1){
                                System.out.println(lecmat[i].display1());
                                for (int j=0; j<thatlist.get(counter).size(); j++){
                                    System.out.println("Slide " + (j+1) + ": " + thatlist.get(counter).get(j));
                                }
                                counter++;
                                System.out.println();
                            } else if (lecmat[i].getType() == 2){
                                System.out.println(lecmat[i].display2());
                            }
                        }
                    }
    
                    if (query == 4){
                        for (int i=0; i<numofas; i++){
                            if (as[i].getType() == 1 && as[i].getStatus() == true){
                                System.out.println(as[i].display1());
                            } else if (as[i].getType() == 2 && as[i].getStatus() == true){
                                System.out.println(as[i].display2());
                            }
                        }
                    }

                    if (query == 5){
                        System.out.println("List of Assessments: ");
                        for (int i=0; i<numofas; i++){
                            if (as[i].getType() == 1 && as[i].getStatus() == true){
                                System.out.println(as[i].display1());
                            } else if (as[i].getType() == 2 && as[i].getStatus() == true){
                                System.out.println(as[i].display2());
                            }
                        }
                        System.out.print("Enter ID of assessment to view submissions: "); int assignID = sc.nextInt();

                        int[] temp = new int[10];
                        int[] temp2 = new int[10];
                        boolean flag = true;
                        for (int i=0; i<numofstu; i++){
                            temp = stu[i].getSubmittedAssign();
                            temp2 = stu[i].getGradedAssign();
                            for (int j=0; j<temp.length; j++){
                                if (temp[j] == assignID){
                                    for (int k=0; k<temp2.length; k++){
                                        if (temp2[k] == assignID){
                                            flag = false;
                                        }
                                        if (k == temp2.length-1 && flag == true){
                                            System.out.println(stu[i].getStuID() + ". " + stu[i].getStuName());
                                        }
                                    }
                                }
                            }
                        }

                        System.out.print("Choose student ID to grade: "); int thatstuID = sc.nextInt();
                        String nameofassign = "";
                        for (int i=0; i<numofstu; i++){
                            if (stu[i].getStuID() == thatstuID){
                                stu[i].addGradedAssign(assignID);
                                for (int j=0; j<numofsub; j++){
                                    if (sub[j].getStuID() == thatstuID && sub[j].getAssignID() == assignID){
                                        for (int k=0; k<numofgrad; k++){
                                            if (grad[k].gethasGraded() == false){
                                                System.out.print("Submission: ");
                                                nameofassign = sub[j].getNameofSub();
                                                System.out.println(nameofassign);
                                                grad[k].sethasGraded(true);
                                                stu[i].addGradedAssign(assignID);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        int thatmax = 0;
                        for (int i=0; i<numofas; i++){
                            if (as[i].getassignID() == assignID){
                                thatmax = as[i].getMaxmarks();
                            }
                        }
                        System.out.println("Maxmarks: " + thatmax);
                        System.out.print("Marks scored: "); int gotmarks = sc.nextInt();
                        grad[numofgrad++] = new gradedSubs(thatname, gotmarks, nameofassign, thatstuID, assignID);
                    }
    
                    if (query == 6){
                        for (int i=0; i<numofas; i++){
                            if (as[i].getType() == 1){
                                System.out.println(as[i].display1());
                            } else if (as[i].getType() == 2) {
                                System.out.println(as[i].display2());
                            }
                        }
                        System.out.print("Enter id of assignment to close: "); int thatID = sc.nextInt();
                        for (int i=0; i<numofas; i++){
                            if (as[i].getassignID() == thatID){
                                as[i].setStatus(false);
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
                    if (stu[i].getStuID() == stuID){
                        thatname = stu[i].getStuName();
                    }
                }

                while(true){
                    System.out.println("\n" + "Welcome " + thatname);
                    System.out.println("--------------------------");
                    System.out.println(
                    "1. View lecture materials" + "\n" + 
                    "2. View assessments" + "\n" + 
                    "3. Submit assessment" + "\n" + 
                    "4. View grades" + "\n" + 
                    "5. View comments" + "\n" + 
                    "6. Add comments" + "\n" + 
                    "7. Logout");
                    System.out.println("--------------------------");
    
                    System.out.print("Enter query number: "); int query = sc.nextInt();

                    if (query == 1){
                        int counter = 0;
                        ArrayList<ArrayList<String>> thatlist;
                        thatlist = LecMaterial.getSlideContents();
                        for (int i=0; i<numoflecmat; i++){
                            if (lecmat[i].getType() == 1){
                                System.out.println(lecmat[i].display1());
                                for (int j=0; j<thatlist.get(counter).size(); j++){
                                    System.out.println("Slide " + (j+1) + ": " + thatlist.get(counter).get(j));
                                }
                                counter++;
                                System.out.println();
                            } else if (lecmat[i].getType() == 2){
                                System.out.println(lecmat[i].display2());
                            }
                        }
                    }

                    if (query == 2){
                        for (int i=0; i<numofas; i++){
                            if (as[i].getType() == 1 && as[i].getStatus() == true){
                                System.out.println(as[i].display1());
                            } else if (as[i].getType() == 2 && as[i].getStatus() == true) {
                                System.out.println(as[i].display2());
                            }
                        }
                    }

                    if (query == 3){
                        int[] submit = new int[10];
                        for (int i=0; i<numofstu; i++){
                            if (stu[i].getStuID() == stuID){
                                submit = stu[i].getSubmittedAssign();
                            }
                        }

                        System.out.println("Pending Assessments: ");
                        boolean bigflag = true;
                        for (int i=0; i<numofas; i++){
                            boolean flag = true;
                            int thistype = as[i].getType();
                            for (int j=0; j<numofas; j++){
                                if (as[i].getassignID() == submit[j]){
                                    flag = false;
                                }
                                if (as[i].getStatus() == false){
                                    bigflag = false;
                                }
                                if (j == numofas-1 && flag == true && as[i].getStatus() == true){
                                    if (thistype == 1){
                                        System.out.print(as[i].display1() + "\n");
                                    } else if (thistype == 2){
                                        System.out.print(as[i].display2() + "\n");
                                    }
                                }
                            }
                        }

                        if (bigflag == true){
                            System.out.print("Enter ID of Assessment: "); int assignID = sc.nextInt();
                            int thattype = 0;
                            String thatq = "";
                            for (int i=0; i<numofas; i++){
                                if (as[i].getassignID() == assignID){
                                    thattype = as[i].getType();
                                    if (thattype == 2){
                                        thatq = as[i].getQuizQuestion();
                                    }
                                }
                            }

                            if (thattype == 1){
                                System.out.print("Enter filename of Assignment: "); String filename = sc.next();
                                if (filename.length() >= 4){
                                    String check = filename.substring(filename.length()-4, filename.length());
                                    if (check.equals(".zip")){
                                        sub[numofsub++] = new addSubmission(stuID, assignID, filename, thattype);
                                        for (int i=0; i<numofstu; i++){
                                            if (stu[i].getStuID() == stuID){
                                                stu[i].addSubmittedAssign(assignID);
                                            }
                                        }
                                    } else{
                                        System.out.println("Wrong filename, only .zip allowed");
                                    }
                                } else{
                                    System.out.println("No name provided");
                                }
                            } else if (thattype == 2){
                                System.out.print(thatq + ": "); String answer = sc.next();
                                sub[numofsub++] = new addSubmission(stuID, assignID, answer, thattype);
                                for (int i=0; i<numofstu; i++){
                                    if (stu[i].getStuID() == stuID){
                                        stu[i].addSubmittedAssign(assignID);
                                    }
                                }
                            }
                        } else{
                            System.out.println("No Pending Assessments");
                        }
                    }

                    if (query == 4){
                        System.out.println("Graded Submissions: ");
                        if (numofgrad == 0){
                            System.out.println("No graded submissions yet");
                        } else{
                            for (int j=0; j<numofgrad; j++){
                                if (grad[j].getthatstuID() == stuID){
                                    System.out.println("Assessment Name: " + grad[j].getSubname());
                                    System.out.println("Marks Obtained: " + grad[j].getMarksgot());
                                    System.out.println("Checked By: " + grad[j].getChecker());
                                }
                            }
                        }
                    }

                    if (query == 5){
                        for (int i=0; i<numofcomm; i++){
                            System.out.println(forum[i]);
                        }
                    }

                    if (query == 6){
                        System.out.print("Enter Comment: "); String comment = sc.next();
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
