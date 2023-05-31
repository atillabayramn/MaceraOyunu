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
        player.selectLoc();
    }
}
