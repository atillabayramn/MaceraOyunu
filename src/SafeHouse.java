public class SafeHouse extends NormalLoc {

    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Güvenli Evdesiniz!");
        System.out.println("Sağlığınız yenilendi!");
        this.getPlayer().setHealth(this.getPlayer().getOrjinalHealth());

        if(this.getPlayer().getAwards().sizeAward() == 3){
            System.out.println("TEBRİKLER!! OYUNU KAZANDINIZ :)");
            return false;
        }
        return true;
    }
}
