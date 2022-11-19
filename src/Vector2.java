public class Vector2 {

        //      ATTRIBUTES

        public int x;
        public int y;

        //      CONSTRUCTOR

        public
        Vector2(int x, int y) {
                this.x = x;
                this.y = y;
        }

        //      X Y
        
        public void
        setValues(int x, int y) {
                this.x = x;
                this.y = y;
        }

        //      ADDITION and SUBTRACTION
        
        public void
        add(Vector2 v2) {
                this.x += v2.x;
                this.y += v2.y;
        }
        
        public void
        sub(Vector2 v2) {
                this.x -= v2.x;
                this.y -= v2.y;
        }

        //      DISTANCE
        
        public static double
        getDistance(Vector2 v1, Vector2 v2) {
                return Math.sqrt(Math.pow(Math.abs(v1.x - v2.x), 2) +
                                 Math.pow(Math.abs(v1.y - v2.y), 2));
        }
}
