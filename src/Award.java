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

    public void printAward() {
        System.out.println("----------------------");
        System.out.println("Sahip Olunan Ödüller");
        System.out.println("----------------------");

        for (Object a : awardList) {
            System.out.println(a);
        }
        System.out.println("----------------------");
    }

    public boolean containAward(String str) {
        if(str.equals("Ganimet")){
            return false;
        } else {
            return awardList.contains(str);
        }
    }

    public boolean isFinishGame() {
        if (awardList.contains("Food") && awardList.contains("Firewood") && awardList.contains("Water")) {
            return true;
        }
        return false;
    }
}
