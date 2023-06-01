import java.util.ArrayList;

public class Award {

    private ArrayList<String> awardList;

    public Award() {
        awardList = new ArrayList<>(3);
    }

    public void addAward(String str) {
        awardList.add(str);
        System.out.println(str + " ödülü eklendi !");
    }

    public void printAward(){
        System.out.println("----------------------");
        System.out.println("Sahip Olunan Ödüller");
        System.out.println("----------------------");

        for(Object a : awardList){
            System.out.println(a);
        }
        System.out.println("----------------------");
    }

    public int sizeAward(){
        return  awardList.size();
    }

    public boolean containAward(String str){
        return awardList.contains(str);
    }

    public boolean containAward(String str1, String str2, String str3) {
        if(awardList.contains(str1) || awardList.contains(str2) || awardList.contains(str3)){
            return true;
        } else {
            return false;
        }
    }



}
