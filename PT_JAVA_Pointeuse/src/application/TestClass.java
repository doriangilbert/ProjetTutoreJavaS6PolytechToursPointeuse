package application;

import java.io.*;
import java.util.Date;
import java.util.List;

public class TestClass {
    public static void main(String[] args) {
            Check Check1=new Check(true,false,new Date(),14,15);
            Employee Employee1=new Employee("475","Mathéo","Dhondt");
            Employee1.addCheck(Check1);
            Department Department1=new Department("Informatique");
            Department1.addEmployee(Employee1);
            Entreprise Entreprise1= new Entreprise("PolyEntreprise");
            Entreprise1.addDepartement(Department1);
            System.out.println(Entreprise1.getName());

            try{
                System.out.println(Entreprise1.getDepartmentByName("Informatique").getName());
                System.out.println(Entreprise1.getDepartmentByName("Informatique").getEmployeeById("475").getFirstName());
                Serialization(Entreprise1,"Entreprise1.dat");
                Entreprise Entreprise2=Deserialization("Entreprise1.dat");
                System.out.println(Entreprise2.getDepartmentByName("Informatique").getName());
                System.out.println(Entreprise2.getDepartmentByName("Informatique").getEmployeeById("475").getFirstName());
                Entreprise1.DeleteDepartment(Department1);
                List<Department> ListDepartment=Entreprise1.getListDepartment();
                System.out.println(ListDepartment.size());
                Department DepartmentDel=Entreprise2.getDepartmentByName("Informatique");
                Entreprise2.DeleteDepartment(DepartmentDel);
                System.out.println(Entreprise2.getListDepartment().size());
                Entreprise2.addDepartement(Department1);
                Check Check2=new Check(true,false,new Date(),15,06);
                Entreprise2.getDepartmentByName("Informatique").getEmployeeById("475").addCheck(Check2);
                System.out.println(Entreprise2.getDepartmentByName("Informatique").getEmployeeById("475").getListCheck().size());

            }
            catch(IOException e){

            }


    }

    public static void Serialization(Entreprise EntrepriseParam, String NomFichier) throws IOException {
        FileOutputStream fos = new FileOutputStream(NomFichier);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(EntrepriseParam);
        oos.close();
    }
    public static Entreprise Deserialization(String NomFichier) throws IOException {
        FileInputStream fis = new FileInputStream(NomFichier);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Entreprise EntrepriseParam = new Entreprise();
        try{
            EntrepriseParam=(Entreprise) ois.readObject();
        }
        catch (ClassNotFoundException e){

        }
        ois.close();
        return EntrepriseParam;
    }
}