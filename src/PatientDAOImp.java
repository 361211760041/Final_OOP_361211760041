import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAOImp implements PatientDAO {
    //connect database
    public static String driverName = "org.sqlite.JDBC";
    public static String url = "jdbc:sqlite:c:/Final_OOP_361211760041/Hospitall.sqlite";
    public static Connection conn = null;

    //constant operators

    //CRUD
    public static final String GET_All_Pat = "select * from Patient";
    public static final String ADD_Pat = "insert into Patient" +
            "(p_id,p_name,p_gender,p_age,p_address,p_blood_result) values (?,?,?,?)";
    public static final String UPDATE_Pat = "update Patient set" +
            " p_name = ?,p_gender = ?,p_age =?,p_address=?,p_blood_result =? where p_id = ?";
    public static final String DEDETE_Pat = "delete from Patient"+
            " where ep_id =?";
    public static final String FIND_Pat_BY_ID = "select * from Patient"+
            " where p_id = ?";
    //create class instant
    private static PatientDAOImp instant = new PatientDAOImp();
    private Object Pat;


    public static PatientDAOImp getInstance() {
        return instant;
    }
    //constructor

    public PatientDAOImp() {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Driver load successfully.");


    }

    @Override
    public List<Patient> getAllPatient() {
        List<Patient> pat = new ArrayList<Patient>();
        try {
            conn = DriverManager.getConnection((url));
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(GET_All_Pat);
            while (rs.next()){
                int p_id = rs.getInt(1);
                String p_name =  rs.getString(2);
                String p_gender = rs.getString(3);
                int p_age = rs.getInt(4);
                String p_address = rs.getNString(5);
                String p_blood_result=rs.getNString(6);

                //add data to abject
                pat.add(new Patient(p_id, p_name, p_gender, p_age,p_address,p_blood_result));
            }
            //close connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return pat;
    }

    @Override
    public void addPatient(Patient newPat) {
        try {
            conn = DriverManager.getConnection(url);
            PreparedStatement ps = conn.prepareStatement(ADD_Pat);
            //set parameter
            ps.setInt(1,newPat.getP_id());
            ps.setString(2,newPat.getP_name());
            ps.setString(3,newPat.getP_gender());
            ps.setInt(4,newPat.getP_age());
            ps.setString(5,newPat.getP_address());
            ps.setString(6,newPat.getP_blood_result());

            boolean rs = ps.execute();
            if (rs == true){
                System.out.println("Could not add data tob database");
                //close connection
                ps.close();
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updatePatient(Patient pat) {
        try {
            conn = DriverManager.getConnection(url);
            PreparedStatement ps = conn.prepareStatement(UPDATE_Pat);
            //set parameter
            ps.setInt(1,pat.getP_id());
            ps.setString(2,pat.getP_name());
            ps.setString(3,pat.getP_gender());
            ps.setInt(4,pat.getP_age());
            ps.setString(5,pat.getP_address());
            ps.setString(6,pat.getP_blood_result());



            int rs = ps.executeUpdate();
            if (rs != 0){
                System.out.printf("Data with patID%d%n", pat.getP_id() + "was update.") ;
            }  else{
                System.out.println("Cloud not update data with patID"
                        + pat.getP_id());
            }
            ps.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void deletePatient(int id) {
        try {
            conn = DriverManager.getConnection(url);
            PreparedStatement ps = conn.prepareStatement(DEDETE_Pat);
            //set parameter
            ps.setInt(1,id);
            int rs = ps.executeUpdate();
            if (rs != 0){
                System.out.println("Patient with patID"
                        + id + "as deleted.");
            } else{
                System.out.println("Could not delete Patient"
                        +"waite patID" + id);
            }
            ps.close();
            conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    @Override
    public Patient findPatient(int id) {
        Patient pat = null;
        try {
            conn = DriverManager.getConnection(url);
            PreparedStatement ps = conn.prepareStatement(FIND_Pat_BY_ID);
            //set parameter
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                int p_id = rs.getInt(1);
                String p_name = rs.getString(2);
                String p_gender = rs.getString(3);
                int p_age = rs.getInt(4);
                String p_address =rs.getNString(5);
                String p_blood_result  = rs.getNString(6);

                pat = new Patient(p_id,p_name,p_gender,p_age,p_address,p_blood_result);

            } else {
                System.out.println("Cloud not found Patient" +
                        "with patID" +id);
            }
            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pat;
    }
}//
