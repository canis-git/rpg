public class Stack {

        //      ATTRIBUTES

        private Node pointer;

        //      CONSTRUCTOR
        
        public Stack() {
                this.pointer = null;
        }
                
        //      NODE ACCESS

        public void
        push(Node node) {
                node.setPrevious(pointer);
                this.pointer = node;
        }

        public Node
        pop() {
                Node node = pointer;
                if (node != null) {
                        this.pointer = node.getPrevious();
                }
                return node;
        }

        public boolean
        isEmpty() {
                return (this.pointer == null);
        }
}
