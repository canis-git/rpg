package Rpg;

public class Hero extends Entity {

        //      ATTRIBUTES

        private Weapon  weapon;

        //      CONSTRUCTOR

        public
        Hero(String name, int health, int strength, Weapon weapon) {
                super(name, health, strength);
                this.weapon = weapon;
        }

        //      WEAPON
        
        public void
        setWeapon(Weapon weapon) {
                this.weapon = weapon;
        }
        public Weapon
        getWeapon() {
                return this.weapon;
        }

        //      DAMAGE

        public int
        getDamage() {
                return (int)((float)this.strength * this.weapon.getMultiplier());
        }
}
