package entities;

/**
 *
 * @author quent
 */
public class DepartementTest {

    public static void main(String[] args) {

        Departement d75 = new Departement(1, "75", "Scène");
        System.out.println(d75);

        System.out.println(d75.getIdDepartement());
        System.out.println(d75.getCodeDepartement());
        System.out.println(d75.getNomDepartement());

        d75.setNomDepartement("Seine");
        System.out.println(d75);
    }
}
