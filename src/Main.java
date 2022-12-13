public class Main {

        static final int height = 50;
        static final int width = 150;

        public static void
        main(String args[]) {

                /*Game game = new Game(height, width);
                game.loop();*/
                                
                List<String> list1 = new List<String>();
                List<String> list2 = new List<String>();

                list1.append("H");
                list1.append("ABA");
                list1.append("R");
                list1.append("B");
                list1.append("W");
                list1.append("L");
                list1.append("M");
                list1.append("AAB");
                list1.append("D");
                list1.append("P");

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

                /*list.toRoot();
                while(list.get() != null) {
                        System.out.println(list.get());
                        list.incIndex();
                }
                System.out.println();*/

                long start, end;

                start = System.nanoTime();
                list1.sortBubble();
                end = System.nanoTime();
                System.out.println("Bubblesort took\t" + Long.toString(end - start) + "ns");
                
                start = System.nanoTime();
                list2.sortQuick();
                end = System.nanoTime();
                System.out.println("Quicksort took\t" + Long.toString(end - start) + "ns");

                /*list.toRoot();
                while(list.get() != null) {
                        System.out.println(list.get());
                        list.incIndex();
                }*/
        }
}
