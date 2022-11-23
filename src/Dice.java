import java.util.Random;

public class Dice {

        //      ATTRIBUTES

        private int     faces;
        private Random  random;

        //      CONSTRUCTOR

        public
        Dice(int faces) {
                this.faces = faces;
                this.random = new Random();
        }

        //      ROLL

        public int
        roll() {
                return this.random.nextInt(this.faces);
        }

}
