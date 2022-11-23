public class Queue<T> {

        //        ATTRIBUTES

        private Node<T> head;
        private Node<T> tail;
        private int size;

        //        CONSTRUCTOR

        public Queue() {
                this.head = null;
                this.tail = null;
                this.size = 0;
        }
                
        //        NODE ACCESS
        
        public void
        addTail(T content) {
                Node<T> node = new Node<T>(content);
                node.setPrevious(null);
                node.setNext(null);
                if (this.size++ == 0) {
                        this.head = node;
                }
                else {
                        this.tail.setNext(node);
                }
                this.tail = node;
        }
        public T
        removeHead() {
                Node<T> node = this.head;
                if (node == null) {
                        return null;
                }
                this.head = this.head.getNext();
                if (--this.size == 0) {
                        this.tail = null;
                }
                return node.getContent();
        }
        
        public Node<T>
        getHead() {
                return this.head;
        }
        public Node<T>
        getTail() {
                return this.tail;
        }
                
        //        SIZE

        public int
        getSize() {
                return this.size;
        }
}
