public class ToolStore extends NormalLoc {

    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("--- Mağazaya Hoşgeldiniz!! ---");
        System.out.println("1- Silahlar");
        System.out.println("2- Zırhlar");
        System.out.println("3- Çıkış Yap!!");
        System.out.println("Seçiminiz: ");
        int selectCase = Location.input.nextInt();

        while(selectCase < 1 || selectCase > 3){
            System.out.print("Geçersiz değer!! Lütfen tekrar Seçiminizi Yapınız: ");
            selectCase = Location.input.nextInt();
        }

        switch (selectCase){
            case 1:
                printWeapon();
                break;
            case 2:
                printArmor();
                break;
            case 3:
                System.out.println("Yine Bekleriz :) ");
                return true;
        }

        return true;
    }

    public void printWeapon(){
        System.out.println("----- Silahlar -----");
        for(Weapon w : Weapon.weapons()){
            System.out.println(w.getId() + ") " +
                    w.getName() + " <Fiyat: " + w.getPrice() +
                    ", Hasar: " + w.getDamage() + ">");
        }

        System.out.println("Bir Silah Seçiniz: ");

        int selectWeapon = input.nextInt();

        while(selectWeapon < 1 || selectWeapon > Weapon.weapons().length){
            System.out.print("Geçersiz değer!! Lütfen tekrar Seçiminizi Yapınız: ");
            selectWeapon = Location.input.nextInt();
        }



    }

    public void printArmor(){
        System.out.println("Zırhlar");
    }
}





















