public class List<T> {

        //      ATTRIBUTES

        private Node<T> root;
        private Node<T> pointer;
        private Node<T> dummy;
        private int     size;
        private int     index;

        //      CONSTRUCTOR

        public List() {
                this.dummy = new Node<T>(null);
                this.root = this.dummy;
                this.pointer = this.dummy;
                this.size = 0;
                this.index = 0;
        }

        //      SIZE

        public int
        getSize() {
                return this.size;
        }

        //      INDEX

        public int
        setIndex(int index) {
                if (index > this.size || index < 0) {
                        //this.toDummy();
                        System.out.println("ERROR: tried to access an invalid index: " + Integer.toString(index));
                        System.exit(-1);
                }
                else {
                        this.toRoot();
                        while (this.index != index) {
                                this.incIndex();
                        }
                }
                return this.index;
        }
        public int
        incIndex() {
                if (this.pointer != this.dummy) {
                        this.pointer = this.pointer.getNext();
                        this.index++;
                }
                return this.index;
        }
        public int
        decIndex() {
                if (this.pointer != this.root) {
                        this.pointer = this.pointer.getPrevious();
                        this.index--;
                }
                return this.index;
        }
        public int
        getIndex() {
                return this.index;
        }

        //      ROOT / DUMMY

        public void
        toRoot() {
                this.pointer = this.root;
                this.index = 0;
        }
        public void
        toDummy() {
                this.pointer = this.dummy;
                this.index = this.size;
        }
        
        //      SET / GET

        public void
        set(T object) {
                this.pointer.setContent(object);
        }
        public void
        setAt(int index, T object) {
                this.setIndex(index);
                this.pointer.setContent(object);
        }

        public T
        get(){
                return this.pointer.getContent();
        }
        public T
        getAt(int index){
                this.setIndex(index);
                return this.pointer.getContent();
        }

        //      MODIFY

        public void
        append(T object) {
                this.toDummy();
                this.insert(object);
        }

        public void
        insert(T object) {
                Node<T> node = new Node<T>(object);
                Node<T> next = this.pointer;
                Node<T> previous = this.pointer.getPrevious();

                node.setNext(next);
                node.setPrevious(previous);
                next.setPrevious(node);
                if (previous != null) {
                        previous.setNext(node);
                }
                else {
                        this.root = node;
                }
                this.pointer = node;
                this.size++;
        }
        public void
        insertAt(int index, T object) {
                this.setIndex(index);
                this.insert(object);
        }

        public void
        remove() {
                Node<T> node = this.pointer;
                Node<T> next = node.getNext();
                Node<T> previous = node.getPrevious();

                next.setPrevious(previous);
                if (previous != null) {
                        previous.setNext(next);
                }
                else {
                        this.root = next;
                }
                this.pointer = next;
                this.size--;
        }
        public void
        removeAt(int index) {
                this.setIndex(index);
                this.remove();
        }

        //      CONCATENATION

        /*public static List
        concat(List ... lists) {
                List list = new List();
                for (int i = 0; i < lists.length; i++) {
                        if (lists[i].getSize() == 0) {
                                continue;
                        }
                        lists[i].toRoot();
                        do {
                                list.append(lists[i].get());
                        } while (lists[i].incIndex() != lists[i].getSize());
                }
                return list;
        }*/
}

