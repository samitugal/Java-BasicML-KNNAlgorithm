import java.util.ArrayList;
import java.util.Scanner;

public class UserMoney {

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

    public UserMoney(double varyans, double carpiklik, double basiklik, double entropi,int tur) {
        this.varyans = varyans;
        this.carpiklik = carpiklik;
        this.basiklik = basiklik;
        this.entropi = entropi;
        this.tur=tur;
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

    public double distanceCalculator(ArrayList<Money> moneyList, UserMoney moneyUser, int i ){

        double distanceDifVaryans =(moneyUser.getVaryans()-moneyList.get(i).getVaryans());
        double distanceDifCarpiklik=(moneyUser.getCarpiklik()-moneyList.get(i).getCarpiklik());
        double distanceDifBasiklik=(moneyUser.getBasiklik()-moneyList.get(i).getBasiklik());
        double distanceDifEntropi=(moneyUser.getEntropi()-moneyList.get(i).getEntropi());
        double distanceX = Math.pow(distanceDifVaryans,2);
        double distanceY = Math.pow(distanceDifCarpiklik,2);
        double distance3D = Math.pow(distanceDifBasiklik,2);
        double distance4D = Math.pow(distanceDifEntropi,2);

        double distance=Math.sqrt(distanceX+distanceY+distance3D+distance4D);

        return distance;

    }




}
