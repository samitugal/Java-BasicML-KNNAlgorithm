import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class main {  public static void main(String[] args) throws InterruptedException {
    Asama1 asama1_1 = new Asama1(100,100,10);
    Asama1 asama1_2 = new Asama1(100,100,100);
    ArrayList list1_1 = asama1_1.createRandomArrayList(asama1_1.getN());
    ArrayList list1_2 = asama1_2.createRandomArrayList(asama1_2.getN());
    System.out.println("--------------------------------------------");
    for (int i = 0 ; i<list1_1.size();i++){
        System.out.println(list1_1.get(i));                         /* 10 Verili Random*/
    }

    System.out.println("--------------------------------------------");
    Thread.sleep(3000);
    for (int i = 0 ; i<list1_2.size();i++){
        System.out.println(list1_2.get(i));                          /* 100 Verili Random*/
    }
    System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");

    Thread.sleep(3000);

    ArrayList calculatedArraylist = asama1_1.calculateArrayList(list1_1);

    Object[] liste = new ArrayList[calculatedArraylist.size()];
    for(int i = 0 ; i<calculatedArraylist.size();i++){
        liste[i]=calculatedArraylist.get(i);
    }
    ArrayList<Double> alisteD = asama1_1.distanceResults(list1_1); /* TABLO YAZDIRMA*/

    for(int m = 0 ; m< asama1_1.getN();m++){
        System.out.format("%15d",m);
    }
    System.out.println();
    for(int n = 0 ; n< asama1_1.getN();n++){
        System.out.format("%15s","  ------");
    }
    System.out.println();

    int m =0;
    int n= 1 ;
    System.out.print("0");
    for(int i = 0;i<calculatedArraylist.size();i++){
        if(m==asama1_1.getN()){
            System.out.println();
            System.out.print(n);
            System.out.format("%15s",alisteD.get(i));
            m=0;
            n++;
        }
        else {
            System.out.format("%15s",alisteD.get(i));
        }
        m++;
    }
    System.out.println("");
    System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");

    ArrayList<Money> moneyList = new ArrayList<Money>();
    Money money = new Money();


    try {
        File fileIn = new File("C:\\Users\\samit\\IdeaProjects\\Top Secret Project\\Proje 1.2\\src\\data_banknote_authentication.txt");
        Scanner scan = new Scanner(fileIn);


        try {
            while (scan.hasNext()) {
                String[] liste1;
                String satir = scan.next();
                liste1 = satir.split(",");
                double varyans = Double.parseDouble(liste1[0]);
                double carpiklik = Double.parseDouble(liste1[1]);
                double basiklik = Double.parseDouble(liste1[2]);
                double entropi = Double.parseDouble(liste1[3]);
                int tur = Integer.parseInt(liste1[4]);
                Money money_read1 = new Money(varyans,carpiklik,basiklik,entropi,tur);

                moneyList.add(money_read1);

            }



        } catch (NoSuchElementException e) {
            System.out.println("Dosyada başka eleman kalmadı!");

        }

    } catch (FileNotFoundException e) {
        System.out.println("Dosya konumu bulunamadı! ");
        System.exit(0);
    }
    /* --------------------------------------------------------------  */

    UserMoney userMoney = new UserMoney();       /* Kullanıcı Veri Girişi*/
    System.out.print("En Yakın Kaç Değeri İstersiniz ?");
    Scanner scanner = new Scanner(System.in);
    int k = scanner.nextInt();

    ArrayList<Double> distanceList = new ArrayList<Double>();

    for(int i = 0; i<moneyList.size();i++){
        double result = money.distanceCalculator(moneyList,userMoney,i);
        distanceList.add(result);
    }

    for(int y = 0 ; y<distanceList.size();y++){
        moneyList.get(y).setDistance(distanceList.get(y));
    }


    System.out.println("---------------------------------------------------------------------");
    Collections.sort(distanceList);
    ArrayList<Double> kNNList = new ArrayList<Double>(money.kNN(distanceList,k));

    ArrayList<Money> moneyFinalList= new ArrayList<Money>(money.distanceToObject(moneyList,kNNList));

    System.out.println("Belirttiğiniz Paraya En Yakın Özellikli Paralar Şunlardır : ");
    for(int i = 0 ; i<moneyFinalList.size();i++){
        System.out.println(moneyFinalList.get(i));
    }
    int turCinsi=money.turHesapla(moneyFinalList);
    System.out.println("---------------------------------------------------------------------");
    System.out.println(money.turSoyle(turCinsi));
    System.out.println("---------------------------------------------------------------------");

    ArrayList<Money> denekList = new ArrayList<Money>();


    try {
        File fileIn = new File("C:\\Users\\samit\\IdeaProjects\\Top Secret Project\\Proje 1.2\\src\\basarı_olcumu_list1.txt");
        Scanner scan = new Scanner(fileIn);

        try {
            while (scan.hasNext()) {
                String[] liste1;
                String satir = scan.next();
                liste1 = satir.split(",");
                double varyans = Double.parseDouble(liste1[0]);
                double carpiklik = Double.parseDouble(liste1[1]);
                double basiklik = Double.parseDouble(liste1[2]);
                double entropi = Double.parseDouble(liste1[3]);
                int tur = Integer.parseInt(liste1[4]);
                Money money_read2 = new Money(varyans,carpiklik,basiklik,entropi,tur);
                denekList.add(money_read2);


            }



        } catch (NoSuchElementException e) {
            System.out.println("Dosyada başka eleman kalmadı!");

        }

    } catch (FileNotFoundException e) {
        System.out.println("Dosya konumu bulunamadı! ");
        System.exit(0);
    }

    /*--------------------------------------------------------------------------------------*/

    System.out.println("Kaç Değerle Karşılaştırma İstersiniz ?");
    int veri = scanner.nextInt();

    double Basari_Orani = money.compareResults(denekList,moneyList,veri);

    System.out.println("%"+Basari_Orani);

    System.out.println("-----------------------------------------------------------------------");
    Thread.sleep(3000);

    for(int i = 0 ; i<moneyList.size() ; i++){
        System.out.println(moneyList.get(i));

    }

}

}









