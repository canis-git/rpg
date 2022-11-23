package Rpg;

public class Stack<T> {

        //      ATTRIBUTES

        private Node<T> pointer;

        //      CONSTRUCTOR
        
        public Stack() {
                this.pointer = null;
        }
                
        //      NODE ACCESS

        public void
        push(T content) {
                Node<T> node = new Node<T>(content);
                node.setPrevious(pointer);
                this.pointer = node;
        }

        public T
        pop() {
                Node<T> node = pointer;
                if (node == null) {
                        return null;
                }
                this.pointer = node.getPrevious();
                return node.getContent();
        }

        public boolean
        isEmpty() {
                return (this.pointer == null);
        }
}
