public class Screen {

        //      CELL

        private class Cell {

                public char ch;
                public Attribute at;

                public
                Cell() {
                        ch = ' ';
                        at = new Attribute();
                }
        };


        //      ATTRIBUTE

        private class Attribute {

                byte bg;
                byte fg;
                boolean bl;
                boolean it;
                boolean un;

                public
                Attribute() {
                        bg = 9;
                        fg = 9;

                        bl = false;
                        it = false;
                        un = false;
                }

                public void
                get(Attribute at) {
                        bg = at.bg;
                        fg = at.fg;
                        bl = at.bl;
                        it = at.it;
                        un = at.un;
                }

                public boolean
                nequal(Attribute at) {
                        return (this.bg != at.bg ||
                                this.fg != at.fg ||
                                this.bl != at.bl ||
                                this.it != at.it ||
                                this.un != at.un);
                }

                public String
                getEscape() {
                        String esc = "\u001b[0";

                        esc += ";4" + Byte.toString(this.bg);
                        esc += ";3" + Byte.toString(this.fg);

                        if (this.bl) {
                                esc += ";1";
                        }
                        if (this.it) {
                                esc += ";3";
                        }
                        if (this.un) {
                                esc += ";4";
                        }
                        
                        return esc + 'm';
                }
        };

        private int             height;
        private int             width;
        private Cell[][]        screen;
        private Attribute       attr;


        //      CONSTRUCTOR

        public
        Screen(int height, int width) {
                this.height = height;
                this.width = width;

                this.screen = new Cell[height][width];

                for (int y = 0; y < this.height; y++) {
                        for (int x = 0; x < this.width; x++) {
                                this.screen[y][x] = new Cell();
                        }
                }

                this.attr = new Attribute();
        }


        //      CLEAR

        public void
        clear() {
                for (int y = 0; y < this.height; y++) {
                        for (int x = 0; x < this.width; x++) {
                                this.screen[y][x] = new Cell();
                        }
                }
        }

        //      UPDATE
        
        public void
        update() {
                Attribute at = new Attribute();

                String data = "\033[H\033[2J" + at.getEscape();

                for (int y = this.height-1; y >= 0; y--) {
                        for (int x = 0; x < this.width; x++) {
                                if (at.nequal(this.screen[y][x].at)) {
                                        at.get(this.screen[y][x].at);
                                        data += at.getEscape();
                                }
                                data += this.screen[y][x].ch;
                        }
                        data += '\n';
                }

                System.out.print(data);
                System.out.flush();
        }


        //      ATTRIBUTE

        public void
        setAttribute(int bg, int fg, boolean bl, boolean it, boolean un) {
                this.attr.bg = (byte)bg;
                this.attr.fg = (byte)fg;
                this.attr.bl = bl;
                this.attr.it = it;
                this.attr.un = un;
        }


        //      ADD TO SCREEN

        public void
        addStr(int y, int x, String str) {
                if (x < 0 || y < 0 || y >= height) {
                        return;
                }
                for (int i = 0; i < str.length(); i++) {
                        if (x+i >= this.width) {
                                x = 0-i;
                                y--;
                        }
                        if (y < 0) {
                                return;
                        }
                        this.screen[y][x + i].ch = str.charAt(i);
                        this.screen[y][x + i].at.get(attr);
                }
        }

        public void
        addChr(int y, int x, char ch) {
                if (y < 0 || y >= height || x < 0 || x >= width) {
                        return;
                }
                if (ch == '\0') {
                        ch = (char)9470;
                }

                this.screen[y][x].ch = ch;
                this.screen[y][x].at.get(attr);
        }
                        
        public void
        addVLine(int y, int x, int len, char ch) {
                if (ch == '\0') {
                        ch = (char)9470;
                }
                for (int i = 0; i < len; i++) {
                        addChr(y + i, x, ch);
                }
        }

        public void
        addHLine(int y, int x, int len, char ch) {
                if (ch == '\0') {
                        ch = (char)9470;
                }
                for (int i = 0; i < len; i++) {
                        addChr(y, x + i, ch);
                }
        }

        public void
        addBox(int y, int x, int height, int width) {
                addHLine(y, x, width,'\0');
                addHLine(y + height - 1, x, width, '\0');
                
                addVLine(y, x, height, '\0');
                addVLine(y, x + width - 1, height, '\0');

                //fillBoarders();
        }



        public boolean
        isBoarder(char ch) {
                if ((int)ch >= 9470 && (int)ch <= 9600) {
                        return true;
                }
                return false;
        }

        public void
        fillBoarders() {
                for (int y = 0; y < this.height; y++) {
                        for (int x = 0; x < this.width; x++) {
                                if (isBoarder(this.screen[y][x].ch)) {
                                        byte n = 0;
                                        char ch;

                                        if (y > 0 && isBoarder(this.screen[y - 1][x].ch)) {
                                                n |= 1 << 3;
                                        }
                                        if (y < height - 1 && isBoarder(this.screen[y + 1][x].ch)) {
                                                n |= 1 << 2;
                                        }
                                        if (x > 0 && isBoarder(this.screen[y][x - 1].ch)) {
                                                n |= 1 << 1;
                                        }
                                        if (x < width - 1 && isBoarder(this.screen[y][x + 1].ch)) {
                                                n |= 1;
                                        }

                                        switch (n) {
                                        case 0:
                                                ch = '╳';
                                                break;
                                        case 1:
                                                ch = '╶';
                                                break;
                                        case 2:
                                                ch = '╴';
                                                break;
                                        case 3:
                                                ch = '─';
                                                break;
                                        case 4:
                                                ch = '╵';
                                                break;
                                        case 5:
                                                ch = '└';
                                                break;
                                        case 6:
                                                ch = '┘';
                                                break;
                                        case 7:
                                                ch = '┴';
                                                break;
                                        case 8:
                                                ch = '╷';
                                                break;
                                        case 9:
                                                ch = '┌';
                                                break;
                                        case 10:
                                                ch = '┐';
                                                break;
                                        case 11:
                                                ch = '┬';
                                                break;
                                        case 12:
                                                ch = '│';
                                                break;
                                        case 13:
                                                ch = '├';
                                                break;
                                        case 14:
                                                ch = '┤';
                                                break;
                                        case 15:
                                                ch = '┼';
                                                break;
                                        default:
                                                ch = ' ';
                                                break;
                                        };

                                        this.screen[y][x].ch = ch;
                                }
                        }
                }
        }
}
