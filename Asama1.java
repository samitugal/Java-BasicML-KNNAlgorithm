import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class Asama1 {

    private int width;
    private int height;
    private int n;


    public Asama1(int width, int height, int n) {
        this.width = width;
        this.height = height;
        this.n = n;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }



    public ArrayList createRandomArrayList(int m){
        ArrayList<ArrayList> arrayList = new ArrayList<ArrayList>();

        for (int k=0 ; k<m ; k++ ){
            ArrayList list = new ArrayList() ;
            Random random = new Random();
            double d1 = Math.random();
            double d2 = Math.random();
            double randomDouble_width = (double)(d1*width);
            double randomDouble_height= (double)(d2*height);

            list.add(randomDouble_width);
            list.add(randomDouble_height);

            arrayList.add(list);

        }

        return arrayList;

    }

    public double calculateDistance(ArrayList<ArrayList> list1 , ArrayList<ArrayList> list2 , int i ,int j){



        double distanceDifX =(double)(list1.get(i).get(0))-(double)(list2.get(j).get(0));
        double distanceDifY =(double)(list1.get(i).get(1))-(double)(list2.get(j).get(1));
        double distanceX = Math.pow(distanceDifX,2);
        double distanceY = Math.pow(distanceDifY,2);

        double distance=Math.sqrt(distanceX+distanceY);

        return distance;

    }

    public ArrayList<ArrayList> calculateArrayList(ArrayList<ArrayList> alist ){

        ArrayList<ArrayList> copyList = new ArrayList<ArrayList>(alist);
        ArrayList<ArrayList> results = new ArrayList<ArrayList>();

        for(int i = 0 ; i < alist.size() ; i++){

            for (int j = 0 ; j<alist.size();j++){
                ArrayList<ArrayList> temp = new ArrayList();
                ArrayList<Double> tempDistance=new ArrayList();
                double distance= calculateDistance(alist,copyList,i,j);
                temp.add(alist.get(i));
                temp.add(copyList.get(j));
                tempDistance.add(distance);
                temp.add(tempDistance);
                results.add(temp);


            }

        }
        return results;

    }

    public ArrayList<String> distanceResults(ArrayList<ArrayList> alist){

        ArrayList<ArrayList> copyList = new ArrayList<ArrayList>(alist);
        ArrayList<String> results = new ArrayList<String>();

        for(int i = 0 ; i < alist.size() ; i++){
            for (int j = 0 ; j<alist.size();j++){
                double distance= calculateDistance(alist,copyList,i,j);
                results.add(df.format(distance));

            }

        }
        return results;


    }

    DecimalFormat df = new DecimalFormat("####0.000");


    }



