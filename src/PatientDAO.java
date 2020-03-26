import java.util.List;

public interface PatientDAO {
    //CRUD Operation
    public List<Patient> getAllPatient();
    public void addPatient(Patient newPat);
    public void updatePatient(Patient Pat);
    public void deletePatient(int id);
    public  Patient findPatient (int id);

}//
