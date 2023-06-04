import java.util.Random;

public abstract class BattleLoc extends Location {

    private Obstacle obstacle;
    private String award;
    private int maxObstacle;


    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }


    @Override
    public boolean onLocation() {
        if (this.getPlayer().getAwards().containAward(this.award)) {
            System.out.println("Buradaki görevi tamamladınız! Başka bir bölgeyi seçiniz!!");
            System.out.println();
            return true;
        }

        int obsNumber = this.randomObstacleNumber();
        System.out.println("Şu an Buradasınız: " + this.getName());
        System.out.println("Dikkatli Ol!! Burada " + obsNumber + " tane " + this.getObstacle().getName() + " Yaşıyor!! -->");
        System.out.print(" <S>avaş veya <K>aç");
        String selectCase = input.nextLine().toUpperCase();

        if (selectCase.equals("S") && combat(obsNumber)) {
            System.out.println(this.getName() + " tüm düşmanları yendiniz ");
            this.getPlayer().getAwards().addAward(this.getAward());
            this.getPlayer().getAwards().printAward();
            return true;
        }

        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("Öldünüz :( ");
            return false;
        }
        return true;
    }

    public boolean combat(int obsNumber) {

        for (int i = 1; i <= obsNumber; i++) {

            int luckyBall;
            Random random = new Random();
            luckyBall = random.nextInt(2) + 1;

            this.getObstacle().setHealth(this.getObstacle().getOrjinalHealth());
            playerStats();
            obstacleStats(i);

            switch (luckyBall) {
                case 1:
                    while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                        System.out.println("<V>ur veya <K>aç: ");
                        String selectCombat = input.nextLine().toUpperCase();

                        if (selectCombat.equals("V")) {
                            System.out.println("Siz Vurdunuz!");
                            this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());

                            afterHit();

                            if (this.getObstacle().getHealth() > 0) {
                                System.out.println("Canavar size vurdu!!");
                                int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();

                                if (obstacleDamage < 0) {
                                    obstacleDamage = 0;
                                }
                                this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);

                                afterHit();
                            }
                        } else {
                            return false;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Canavar size saldıracak!!! <D>ur veya <K>aç");
                    String select = input.nextLine().toUpperCase();

                    if (select.equals("D")) {
                        while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                            System.out.println("Canavar size vurdu!!");
                            int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                            if (obstacleDamage < 0) {
                                obstacleDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);

                            afterHit();
                            if (this.getPlayer().getHealth() > 0) {
                                System.out.println("<V>ur veya <K>aç: ");
                                String selectCombat = input.nextLine().toUpperCase();
                                if (selectCombat.equals("V")) {
                                    System.out.println("Siz Vurdunuz!");
                                    this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());

                                    afterHit();
                                } else {
                                    return false;
                                }
                            }
                        }
                    } else {
                        return false;
                    }
                    break;
            }


            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
                System.out.println("Düşmanı Yendiniz !!");
                if (20 < this.getObstacle().getAward() && this.getObstacle().getAward() <= 23){



                } else if (23 < this.getObstacle().getAward() && this.getObstacle().getAward() <=26){



                } else if (26 < this.getObstacle().getAward() && this.getObstacle().getAward() <=29) {



                } else if (this.getObstacle().getAward() == 30) {


                } else {
                    System.out.println(this.getObstacle().getAward() + " para kazandınız :) ");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                    System.out.println("Güncel Paranız: " + this.getPlayer().getMoney());
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public void afterHit() {
        System.out.println("Canınız: " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " Canı: " + this.getObstacle().getHealth());
        System.out.println();
    }

    public void playerStats() {
        System.out.println("Oyuncu Değerleri");
        System.out.println("-----------------------------");
        System.out.println("Sağlık: " + this.getPlayer().getHealth());
        System.out.println("Silah: " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Hasar: " + this.getPlayer().getTotalDamage());
        System.out.println("Zırh: " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama: " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Para: " + this.getPlayer().getMoney());

    }

    public void obstacleStats(int i) {
        System.out.println();
        System.out.println(i + ". " + this.getObstacle().getName() + " Değerleri");
        System.out.println("------------------------------");
        System.out.println("Sağlık: " + this.getObstacle().getHealth());
        System.out.println("Hasar: " + this.getObstacle().getDamage());
        System.out.println("Ödül: " + this.getObstacle().getAward());
    }

    public int randomObstacleNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }


}
