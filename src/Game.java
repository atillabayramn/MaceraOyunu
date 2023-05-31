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
            System.out.println();
            System.out.println("#####-BÖLGELER-#####");
            System.out.println("1- Güvenli Ev --> Burası sizin için güvenli bir alan, düşman yoktur!");
            System.out.println("2- Mağaza --> Silah ve Zırh satın alabilirsiniz!");
            System.out.println("Lütfen gitmek istediğiniz bölgeyi seçiniz: ");
            int selectLoc = input.nextInt();
            switch (selectLoc) {

                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }
            if (!location.onLocation()) {
                System.out.println("GMAE OVER !!!");
                break;
            }
        }
    }
}
