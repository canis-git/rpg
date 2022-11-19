import java.util.Random;

public class Rules {

        //      ATTRIBUTES

        private int randomness;

        //      CONSTRUCTOR

        public
        Rules(int randomness) {
                this.randomness = randomness;
        }

        //      FIGHTING

        public boolean
        canFight(Entity e1, Entity e2) {
                if (e1 == e2) {
                        return false;
                }

                if (e1.getHealth() == 0) {
                        return false;
                }
                
                if (e2.getHealth() == 0) {
                        return false;
                }

                return true;
        }

        public void
        hit(Entity e1, Entity e2) {
                if (!canFight(e1, e2)) {
                        return;
                }

                Random r = new Random();

                int d1 = e1.getDamage() + r.nextInt(this.randomness);
                int d2 = e2.getDamage() + r.nextInt(this.randomness);

                if (d1 > d2) {
                        e2.incHealth(-1);
                        return;
                }
                if (d2 > d1) {
                        e1.incHealth(-1);
                        return;
                }
                if (d1 == d2) {
                        e1.incHealth(-1);
                        e2.incHealth(-1);
                }
        }

        public void
        fight(Entity e1, Entity e2) {
                hit(e1, e2);
                while (e1.getHealth() > 0 && e2.getHealth() > 0) {
                        hit(e1, e2);
                }
        }

        public void
        fightGroup(Group g1, Group g2) {
                Random random = new Random();

                while (g1.getSize() > 0 && g2.getSize() > 0) {
                        Entity e1 = g1.getMember(random.nextInt(g1.getSize()));
                        Entity e2 = g2.getMember(random.nextInt(g2.getSize()));

                        fight(e1, e2);

                        if (e1.getHealth() == 0) {
                                g1.removeMember(e1);
                        }
                        if (e2.getHealth() == 0) {
                                g2.removeMember(e2);
                        }

                }

                g1.nurse(0);
                g2.nurse(0);
        }
}
