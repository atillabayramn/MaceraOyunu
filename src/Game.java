import java.sql.SQLOutput;
import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);
    public void start(){
        System.out.println("Macera oyununa Hoşgeldiniz! ");
        System.out.println("Lütfen bir isim giriniz: ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.print("Sayın '" + player.getName() + "' bu karanlık ve sisli adaya Hoşgeldiniz!! ");
        System.out.println("Burada yaşananların hepsi GERÇEKTİR!!!");
        System.out.println("Oyunu başlamak için önce bir karakter seçiniz: ");
        player.selectChar();

        Location location = null;
        while(true) {
            player.printInfo();
            System.out.println();
            System.out.println("#####-BÖLGELER-#####");
            System.out.println("1- Güvenli Ev --> Burası sizin için güvenli bir alan, düşman yoktur!");
            System.out.println("2- Eşya Dükkanı --> Silah ve Zırh satın alabilirsiniz!");
            System.out.println("3- Mağara --> Ödül <Yemek>, Dikkatli ol karşına Zombi çıkabilir!!");
            System.out.println("4- Orman --> Ödül <Odun>, Dikkatli ol karşına Vampir çıkabilir!!");
            System.out.println("5- Nehir --> Ödül <Su>, Dikkatli ol karşına Ayı çıkabilir!!");
            System.out.println("6- Maden --> Ödül <Sürpriz>, Dikkatli ol karşına Yılan çıkabilir!!");
            System.out.println("0- Çıkış Yap --> Oyunu Sonlandır!");
            System.out.println("Lütfen gitmek istediğiniz bölgeyi seçiniz: ");
            int selectLoc = input.nextInt();
            switch (selectLoc) {

                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                case 6:
                    location = new Mine(player);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir seçim yapınız! ");
            }
            if(location == null){
                System.out.println("Bu karanlık ve sisli adadan çabuk vazgeçtin!!");
                break;
            }
            if (!location.onLocation()) {
                if(player.getAwards().isFinishGame()){
                    break;
                } else {
                    System.out.println("GAME OVER !!!");
                    break;
                }
            }
        }
    }
}
