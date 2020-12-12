import java.util.ArrayList;
import java.util.Collections;

public class Money {

    private double varyans;
    private double carpiklik;
    private double basiklik;
    private double entropi;
    private double distance;
    private int tur;

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Money(double varyans, double carpiklik, double basiklik, double entropi, int tur) {
        this.varyans = varyans;
        this.carpiklik = carpiklik;
        this.basiklik = basiklik;
        this.entropi = entropi;
        this.tur = tur;

    }

    public Money() {
    }

    public double getVaryans() {
        return varyans;
    }

    public void setVaryans(double varyans) {
        this.varyans = varyans;
    }

    public double getCarpiklik() {
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

    @Override
    public String toString() {
        return  "varyans=" + varyans + ", carpiklik=" + carpiklik + ", basiklik=" + basiklik + ", entropi=" + entropi + ", distance=" + distance + ", tur=" + tur;
    }

    public double distanceCalculator(ArrayList<Money> moneyList, Money money, int i ){

        double distanceDifVaryans =(money.getVaryans()-moneyList.get(i).getVaryans());
        double distanceDifCarpiklik=(money.getCarpiklik()-moneyList.get(i).getCarpiklik());
        double distanceDifBasiklik=(money.getBasiklik()-moneyList.get(i).getBasiklik());
        double distanceDifEntropi=(money.getEntropi()-moneyList.get(i).getEntropi());
        double distanceX = Math.pow(distanceDifVaryans,2);
        double distanceY = Math.pow(distanceDifCarpiklik,2);
        double distance3D = Math.pow(distanceDifBasiklik,2);
        double distance4D = Math.pow(distanceDifEntropi,2);

        double distance=Math.sqrt(distanceX+distanceY+distance3D+distance4D);

        return distance;

    }


    public ArrayList<Double> kNN(ArrayList<Double> list,int i){
        ArrayList<Double> finalList = new ArrayList<Double>();
        for(int y = 0 ; y<i ; y++){
            finalList.add(list.get(y));
        }
        return finalList;
    }

    public ArrayList<Money> distanceToObject(ArrayList<Money> moneylist , ArrayList<Double> distanceList){
        ArrayList<Money> list = new ArrayList<Money>();
        for (int i = 0 ; i<distanceList.size();i++){
            for (int k = 0 ; k<moneylist.size();k++){
                if (distanceList.get(i) == moneylist.get(k).getDistance()) {
                    list.add(moneylist.get(k));
                }
                else {
                    continue;
                }
            }

        }
        return list;
    }

    public int turHesapla(ArrayList<Money> liste){
        int fake = 0 ;
        int real = 0;

        for(int i = 0 ; i <liste.size();i++){
            if (liste.get(i).getTur()==1){
                real++;
            }
            else {
                fake++;
            }
        }
        if(fake>real){
            return 0;
        }
        else if (real >fake){
            return 1;
        }
        else{
            return liste.get(0).getTur();
        }
    }

    public String turSoyle(int tur){
        if(tur==1){
            return "PARANIZ GERÇEKTİR";
        }
        else{
            return "PARANIZ SAHTEDİR";
        }
    }



    public double compareResults(ArrayList<Money> denek , ArrayList<Money> ortam , int k ){
        double True = 0 ;
        double False = 0 ;

        for(int i = 0 ; i<denek.size();i++){
            Money money = new Money(denek.get(i).getVaryans(),denek.get(i).getCarpiklik(),denek.get(i).getBasiklik(),denek.get(i).getEntropi(),denek.get(i).getTur());
            ArrayList<Double> distanceList = new ArrayList<Double>();
            for(int z = 0 ; z<ortam.size();z++){
                double result = money.distanceCalculator(ortam,money,z);
                distanceList.add(result);

            }
            for(int y = 0 ; y<distanceList.size();y++){
                ortam.get(y).setDistance(distanceList.get(y));
            }
            Collections.sort(distanceList);
            ArrayList<Double> kNNList = new ArrayList<Double>(kNN(distanceList,k));
            ArrayList<Money> moneyFinalList= new ArrayList<Money>(distanceToObject(ortam,kNNList));
            int deger = turHesapla(moneyFinalList);

            if (deger==1 && denek.get(i).getTur()==1){
                True++;
            }
            else if (deger==0 && denek.get(i).getTur()==1){
                False++;
            }
            else if (deger==1 && denek.get(i).getTur()==0) {
                False++;
            }
            else {
                True++;
            }
        }
        double basarı_orani = (True/(True+False)*100);
        return basarı_orani;
    }


}


