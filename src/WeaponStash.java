package Rpg;

public class WeaponStash {

        //      ATTRIBUTES

        private Stack<Weapon> stack;
        private int size;

        //      CONSTRUCTOR

        public
        WeaponStash() {
                this.stack = new Stack<Weapon>();
                this.size = 0;
        }
                
        //      ACCESS WEAPONS

        public void
        addWeapon(Weapon weapon) {
                this.stack.push(weapon);
                this.size++;
        }
        public Weapon
        getWeapon() {
                if (this.size == 0) {
                        return null;
                }
                this.size--;
                return this.stack.pop();
        }

        public int
        getSize() {
                return this.size;
        }
}
