import java.sql.Connection;
import java.util.List;

public class PatientDAOImp implements PatientDAO {
    //connect database
    public static String driverName = "org.sqlite.JDBC";
    public static String url = "jdbc:sqlite:c:/Final_OOP_361211760041/Hospitall.sqlite";
    public static Connection conn = null;

    //constant operators

    //CRUD




    @Override
    public List<Patient> getAllPatient() {
        return null;
    }

    @Override
    public void addPatient(Patient newPat) {

    }

    @Override
    public void updatePatient(Patient Pat) {

    }

    @Override
    public void deletePatient(int id) {

    }

    @Override
    public Patient findPatient(int id) {
        return null;
    }
}//
