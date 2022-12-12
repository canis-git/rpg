public class Main {

        static final int height = 50;
        static final int width = 150;

        public static void
        main(String args[]) {

                /*Game game = new Game(height, width);
                game.loop();*/
                                
                List<String> list;
                List<String> list1 = new List<String>();
                List<String> list2 = new List<String>();

                list2.append("H");
                list2.append("ABA");
                list2.append("R");
                list2.append("B");
                list2.append("W");
                list2.append("L");
                list2.append("M");
                list2.append("AAB");
                list2.append("D");
                list2.append("P");
                
                list2.append("H");
                list2.append("ABA");
                list2.append("R");
                list2.append("B");
                list2.append("W");
                list2.append("L");
                list2.append("M");
                list2.append("AAB");
                list2.append("D");
                list2.append("P");
                                
                list = List.concat(list1, list2);
                list.toRoot();
                while(list.get() != null) {
                        System.out.println(list.get());
                        list.incIndex();
                }
                System.out.println();
                
                BubbleSort.sort(list);

                list.toRoot();
                while(list.get() != null) {
                        System.out.println(list.get());
                        list.incIndex();
                }
        }
}
