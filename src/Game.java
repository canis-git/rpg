public class Game {

        private int height;
        private int width;

        private UI      ui;
        private Rules   rules;

        public
        Game(int height, int width) {
                this.height = height;
                this.width = width;

                ui = new UI(height, width);
                rules = new Rules(5);
        }
        
        public void
        loop() {
                Loot    l = new Loot();

                Group gh = new Group();
                gh.addMember(l.genHero(0.5f));
                gh.addMember(l.genHero(0.7f));
                gh.addMember(l.genHero(1.0f));
                gh.addMember(l.genHero(0.8f));
                gh.move(16, 34, 3.0f);
                
                Group gm = new Group();
                for (int i = 0; i < 10; i++) {
                        gm.addMember(new Monster("Zombie", 1, 3));
                }
                gm.move(19, 12, 1.7f);


                ui.print(Group.concat(gh, gm), gh.getMembers());

                System.out.print("\u001b[" + Integer.toString(height - 1) + ";2f");
                try {System.in.read();} catch (Exception e) {}

                rules.fightGroup(gh, gm);
                ui.print(Group.concat(gh, gm), gh.getMembers());
        }
}
