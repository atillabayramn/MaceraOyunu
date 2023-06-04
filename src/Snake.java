import java.util.Random;

public class Snake extends Obstacle {
    public Snake() {
        super(4, "Yılan", snakeDamage(), 12, randomAward());
    }

    public static int snakeDamage(){
        int snakeDam;
        Random random = new Random();
        snakeDam = random.nextInt(4) + 3;
        return snakeDam;
    }

    public static int randomAward() {
        int awardID;
        int probable;
        Random random = new Random();
        probable = random.nextInt(100) + 1;
        if(0 < probable && probable <= 15){
            int weaponProbable = random.nextInt(100) + 1;
            if(0 < weaponProbable && weaponProbable <= 20){
                //System.out.println("Tüfek Kazandınız !");
                return awardID = 21;
            } else if(20 < weaponProbable && weaponProbable <= 50){
                //System.out.println("Kılıç Kazandınız !");
                return awardID = 22;
            } else {
                //System.out.println("Tabanca Kazandınız !");
                return awardID = 23;
            }
        } else if(15 < probable && probable <= 30){
            int armorProbable = random.nextInt(100) + 1;
            if(0 < armorProbable && armorProbable <= 20){
                //System.out.println("Ağır Zırh Kazandınız !");
                return awardID = 24;
            } else if(20 < armorProbable && armorProbable <= 50){
                //System.out.println("Orta Zırh Kazandınız !");
                return awardID = 25;
            } else {
                //System.out.println("Hafif Zırh Kazandınız !");
                return awardID = 26;
            }
        } else if(30 < probable && probable <=55) {
            int moneyProbable = random.nextInt(100) + 1;
            if(0 < moneyProbable && moneyProbable <= 20){
                //System.out.println("10 para Kazandınız !");
                return awardID = 27;
            } else if(20 < moneyProbable && moneyProbable <= 50){
                //System.out.println("5 para Kazandınız !");
                return awardID = 28;
            } else {
                //System.out.println("1 para Kazandınız !");
                return awardID = 29;
            }
        } else {
            //System.out.println("Hiçbir Şey Kazanamadınız :( ");
            return 30;
        }
    }
}
