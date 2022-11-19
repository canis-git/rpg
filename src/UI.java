public class UI {

        //       ATTRIBUTES

        private int height;
        private int width;

        private Screen  screen;

        private boolean drawNumLines;

        private int listWidth;
        private int mapHeight;
        private int mapWidth;
        
        //      CONSTRUCTOR

        public
        UI(int height, int width) {
                this.height = height;
                this.width = width;

                screen = new Screen(height, width);
                
                //      CONFIG
                drawNumLines = false;
                listWidth = 30;
                //      CONFIG

                mapHeight = height - 5;
                mapWidth = width - listWidth - 4;
        }
                
        //      PRINT ENTITYS

        public void
        print(List<Entity> ems, List<Entity> els) {
                screen.clear();

                screen.setAttribute(9, 9, false, false, false);
                screen.addBox(0, 0, height, width);
                screen.addHLine(2, 1, width - 2, '\0');
                screen.addVLine(3, width - listWidth - 2, height - 4, '\0');
                screen.addStr(height - 1, 2, "RPG");

                screen.setAttribute(2, 9, false, false, false);
                for (int y = 1; y < mapHeight + 1; y++) {
                        for (int x = 1; x < mapWidth + 1; x++) {
                                screen.addChr(3 + y, 1 + x, ' ');
                                if (drawNumLines && (y % 10 == 0 || x % 10 == 0)) {
                                        screen.addChr(3 + y, 1 + x, '\0');
                                }
                        }
                }

                screen.setAttribute(9, 9, false, false, false);
                screen.addChr(3, 1, '0');
                screen.setAttribute(9, 2, false, false, false);
                for (int y = 1; y < mapHeight + 1; y++) {
                        if (y % 10 == 0) {
                                screen.setAttribute(9, 9, false, false, false);
                                screen.addChr(3 + y, 1, Integer.toString((y / 10) % 10).charAt(0));
                                screen.setAttribute(9, 2, false, false, false);
                        } else {
                                screen.addChr(3 + y, 1, Integer.toString(y % 10).charAt(0));
                        }
                }
                for (int x = 1; x < mapWidth + 1; x++) {
                        if (x % 10 == 0) {
                                screen.setAttribute(9, 9, false, false, false);
                                screen.addChr(3, 1 + x, Integer.toString((x / 10) % 10).charAt(0));
                                screen.setAttribute(9, 2, false, false, false);
                        } else {
                                screen.addChr(3, 1 + x, Integer.toString(x % 10).charAt(0));
                        }
                }

                ems.toRoot();
                while (ems.get() != null) {
                        if (ems.get().getHealth() == 0) {
                                continue;
                        }
                        switch (ems.get().getClass().getName()) {
                        case "Hero":
                                screen.setAttribute(4, 9, false, false, false);
                                break;
                        case "Monster":
                                screen.setAttribute(1, 9, false, false, false);
                                break;
                        default:
                                screen.setAttribute(5, 5, false, false, false);
                                break;
                        }
                        screen.addChr(3 + ems.get().getPosition().y, 1 + ems.get().getPosition().x, ems.get().getName().charAt(0));
                        ems.incIndex();
                }

                screen.setAttribute((byte)9, (byte)9, false, false, false);
                String listName = "ENTITYS";
                screen.addStr(height - 2, width - listWidth - 1 + (listWidth - listName.length()) / 2, listName);
               
                int y = 4;
                ems.toRoot();
                while (ems.get() != null) {
                        y += printEntity(screen, height - y, els.get()) + 1;
                        ems.incIndex();
                }
                
                screen.fillBoarders();
                screen.update();
        }





        public int
        printEntity(Screen s, int y, Entity e) {
                String tmp;

                int i = 0;

                tmp = e.getName();
                s.addChr(y - i, width - listWidth - 1, '\0');
                s.addStr(y - i, width - listWidth, tmp);
                for (int x = e.getName().length() + 1; x < listWidth; x++) {
                        s.addChr(y - i, width - listWidth - 1 + x, '\0');
                }
                i++;

                s.addChr(y - i, width - listWidth - 1, 'H');
                tmp = Integer.toString(e.getHealth());
                s.addStr(y - i++, width - tmp.length() - 1, tmp);

                switch (e.getClass().getName()) {
                case "Hero":
                        Hero h = (Hero)e;
                s.addChr(y - i, width - listWidth - 1, 'S');
                        tmp = Integer.toString(h.getStrength());
                        s.addStr(y - i++, width - tmp.length() - 1, tmp);
                s.addChr(y - i, width - listWidth - 1, 'W');
                        tmp = h.getWeapon().getName();
                        s.addStr(y - i++, width - tmp.length() - 1, tmp);
                s.addChr(y - i, width - listWidth - 1, 'M');
                        tmp = h.getWeapon().getMaterial().getName();
                        s.addStr(y - i++, width - tmp.length() - 1, tmp);
                s.addChr(y - i, width - listWidth - 1, 'C');
                        tmp = h.getWeapon().getCharm().getName();
                        s.addStr(y - i++, width - tmp.length() - 1, tmp);
                s.addChr(y - i, width - listWidth - 1, 'M');
                        tmp = Integer.toString((int)(h.getWeapon().getMultiplier() * 100)) + '%';
                        s.addStr(y - i++, width - tmp.length() - 1, tmp);
                        break;
                default:
                        break;
                }
                
                s.addChr(y - i, width - listWidth - 1, 'D');
                tmp = Integer.toString(e.getDamage());
                s.addStr(y - i++, width - tmp.length() - 1, tmp);

                return i;
        }
}
