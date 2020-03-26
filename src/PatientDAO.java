import java.util.List;

public interface PatientDAO {
    //CRUD Operation
    public List<Patient> getAllPatient();
    public void addPatient(Patient newpat);
    public void updatePatient(Patient pat);
    public void deletePatient(int id);
    public  Patient findPatient (int id);

}//
