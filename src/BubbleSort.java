public class BubbleSort {

    public static <T extends Comparable<T>> void
    sort(List<T> list) {
        boolean keep_sorting = true;
        while(keep_sorting) {
            keep_sorting = false;
            
            for (int i = 0; i < list.getSize() - 1; i++) {
                T current = list.getAt(i);
                T next = list.getAt(i + 1);
                
                if (current.compareTo(next) > 0) {
                    list.setAt(i, next);
                    list.setAt(i + 1, current);
                    keep_sorting = true;
                }
            }
        }
    }
}
