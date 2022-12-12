public class Main {

        static final int height = 50;
        static final int width = 150;

        public static void
        main(String args[]) {

                /*Game game = new Game(height, width);
                game.loop();*/
                                
                List<String> list = new List<String>();

                list.append("H");
                list.append("ABA");
                list.append("R");
                list.append("B");
                list.append("W");
                list.append("L");
                list.append("M");
                list.append("AAB");
                list.append("D");
                list.append("P");
                
                list.toRoot();
                while(list.get() != null) {
                        System.out.println(list.get());
                        list.incIndex();
                }
                System.out.println();
                
                list.sortQuick();

                list.toRoot();
                while(list.get() != null) {
                        System.out.println(list.get());
                        list.incIndex();
                }
        }
}
