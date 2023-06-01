import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int orjinalHealth;
    private int money;
    private String charName;
    private String name;

    private Inventory inventory;
    private Award awards;

    private Scanner input = new Scanner(System.in);

    public Player(String name){
        this.name = name;
        this.inventory = new Inventory();
        this.awards = new Award();
    }

    public void selectChar(){

        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};

        System.out.println("------------------------------------------------------------------");
        System.out.println("KARAKTERLER");
        System.out.println("------------------------------------------------------------------");
        for(GameChar gameChar : charList){
            System.out.println("ID: " + gameChar.getId() +
                    "\t Karakter: " + gameChar.getName() +
                    "\t Hasar: " + gameChar.getDamge() +
                    "\t Sağlık: " + gameChar.getHealth() +
                    "\t Para: " + gameChar.getMoney());
        }
        System.out.println("------------------------------------------------------------------");
        System.out.println("Lütfen Bir Karakter Giriniz: ");

        int selectChar = input.nextInt();

        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }

    }

    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamge());
        this.setHealth(gameChar.getHealth());
        this.setOrjinalHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

    public void printInfo(){
        System.out.println("Silahnız: " + this.getInventory().getWeapon().getName() +
                ", Zırhınız: " + this.getInventory().getArmor().getName() +
                ", Bloklama: " + this.getInventory().getArmor().getBlock() +
                ", Hasarınız: " + this.getTotalDamage() +
                ", Sağlığınız: " + this.getHealth() +
                ", Paranız: " + this.getMoney());
    }

    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }


    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if(health < 0){
            health = 0;
        }
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }


    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }

    public Award getAwards() {
        return awards;
    }

    public void setAwards(Award awards) {
        this.awards = awards;
    }
}
