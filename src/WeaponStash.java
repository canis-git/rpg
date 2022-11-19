public class WeaponStash {

        //      ATTRIBUTES

        private Stack stack;
        private int size;

        //      CONSTRUCTOR

        public
        WeaponStash() {
                this.stack = new Stack();
                this.size = 0;
        }
                
        //      ACCESS WEAPONS

        public void
        addWeapon(Weapon weapon) {
                Node stored = new Node(weapon);
                this.stack.push(stored);
                this.size++;
        }
        public Weapon
        getWeapon() {
                if (this.size == 0) {
                        return null;
                }
                Node stored = this.stack.pop();
                Weapon weapon = (Weapon)stored.getContent();
                this.size--;
                return weapon;
        }

        public int
        getSize() {
                return this.size;
        }
}
