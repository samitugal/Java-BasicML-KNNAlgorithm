import java.util.Scanner;

public class UserMoney extends Money{

    private double varyans;
    private double carpiklik;
    private double basiklik;
    private double entropi;
    private int tur;


    public UserMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Paranızın Varyans Değeri ?");
        String tempVaryans = scanner.next();
        this.varyans = Double.parseDouble(tempVaryans);
        System.out.print("Paranızın Carpıklık Değeri ?");
        String tempCarpiklik = scanner.next();
        this.carpiklik = Double.parseDouble(tempCarpiklik);
        System.out.print("Paranızın Basıkık Değeri ?");
        String tempBasiklik = scanner.next();
        this.basiklik = Double.parseDouble(tempBasiklik) ;
        System.out.print("Paranızın Entropi Değeri ?");
        String tempEntropi = scanner.next();
        this.entropi = Double.parseDouble(tempEntropi);

    }

    public double getVaryans() {
        return varyans;
    }

    public void setVaryans(double varyans) {
        this.varyans = varyans;
    }

    public double getCarpiklik(){
            return carpiklik;
    }

    public void setCarpiklik(double carpiklik) {
        this.carpiklik = carpiklik;
    }

    public double getBasiklik() {
        return basiklik;
    }

    public void setBasiklik(double basiklik) {
        this.basiklik = basiklik;
    }

    public double getEntropi() {
        return entropi;
    }

    public void setEntropi(double entropi) {
        this.entropi = entropi;
    }

    public int getTur() {
        return tur;
    }

    public void setTur(int tur) {
        this.tur = tur;
    }






}
