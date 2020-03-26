import java.util.List;
import java.util.Scanner;

public class PatientManagement {
    public static void main(String[] args) {
        //create interface constant
        PatientDAO dao = PatientDAOImp.getInstance();

        //Get all P
        displayAllPatient(dao);
        //add new Patient
        //addNewPatient(dao);
        //find Patient by ID
        //findPatientByID(dao);
        //update Patient by ID
        //updatePatientByID(dao);
        //deletePatient By ID
        deletePatientByID(dao);


    }//main

    private static void deletePatientByID(PatientDAO dao) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Delete Patient with ID: ");
        int id = Integer.parseInt(sc.nextLine().trim());
        dao.deletePatient(id);

    }


    private static void updatePatientByID(PatientDAO dao) {
        Patient pat = findPatientByID2(dao);
        Scanner sc = new Scanner(System.in);
        System.out.print("Update new p_blood_result for Patient ID" + pat.getP_id()+":");
        String ns = (sc.nextLine().trim());
        //update p_blood_result
        pat.setP_blood_result(ns);
        dao.updatePatient(pat);
        System.out.println("Updated employee with ID: "+pat.getP_id());


    }

    private static Patient findPatientByID2(PatientDAO dao) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an Patient ID: ");
        int id = Integer.parseInt(sc.nextLine().trim());
        Patient pat = dao.findPatient(id);
        System.out.println(pat.toString());

        return pat;
    }


    private static void findPatientByID(PatientDAO dao) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an Patient ID: ");
        int id = Integer.parseInt(sc.nextLine().trim());
        Patient pat = dao.findPatient(id);
        System.out.println(pat.toString());

    }

    private static void addNewPatient(PatientDAO dao) {
        Scanner sc = new Scanner(System.in);
        //input data
        System.out.print("Enter Patient p_id :");
        int id = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Enter Patient p_name:");
        String name = sc.nextLine().trim();
        System.out.print("Enter Patient p_gender");
        String gender = sc.nextLine().trim();
        System.out.print("Enter Patient p_age");
        int age = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Enter Patient p_address :");
        String address = sc.nextLine().trim();
        System.out.print("Enter Patient p_blood_result :");
        String blood_result = sc.nextLine().trim();





        //insert data to darabase
        Patient newpat = new Patient(id ,name ,gender ,age ,blood_result ,address);
        dao.addPatient(newpat);
    }

    private static void displayAllPatient(PatientDAO dao) {
        List<Patient> mypat = dao.getAllPatient();
        for (Patient pat:mypat){
            System.out.println(pat.toString());
        }
    }

}//
