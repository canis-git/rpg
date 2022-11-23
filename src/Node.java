public class Node<T> {
        
        //      ATTRIBUTES
        
        private Node<T> previous;
        private Node<T> next;
        private T content;

        //      CONSTRUCTOR

        public Node(T content) {
                this.previous = null;
                this.next = null;
                this.content = content;
        }
        
        //      PREVIOUS

        public void
        setPrevious(Node<T> previous) {
                this.previous = previous;
        }
        public Node<T>
        getPrevious() {
                return this.previous;
        }

        //      NEXT

        public void
        setNext(Node<T> next) {
                this.next = next;
        }
        public Node<T>
        getNext() {
                return this.next;
        }

        //      CONTENT
        
        public void
        setContent(T content) {
                this.content = content;
        }
        public T
        getContent() {
                return this.content;
        }
}
