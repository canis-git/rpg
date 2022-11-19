public abstract class Entity {

        //      ATTRIBUTES

        protected String  name;
        protected int     health;
        protected int     healthMax;
        protected int     strength;
        protected Vector2 position;

        //      CONSTRUCTOR

        public
        Entity(String name, int health, int strength) {
                this.name = name;
                this.health = health;
                this.healthMax = health;
                this.strength = strength;
                this.position = new Vector2(1, 1);
        }

        //      NAME

        public void 
        setName(String name) {
                this.name = name;
        }
        public String
        getName() {
                return this.name;
        }
        
        //      HEALTH

        public void
        setHealth(int health) {
                this.health = health;
        }
        public void
        incHealth(int amount) {
                this.health += amount;
        }
        public int
        getHealth() {
                return this.health;
        }
        public void
        setHealthMax(int healthMax) {
                this.healthMax = healthMax;
        }
        public int
        getHealthMax() {
                return this.healthMax;
        }

        //      STRENGTH

        public void
        setStrength(int strength) {
                this.strength = strength;
        }
        public int
        getStrength() {
                return this.strength;
        }

        //      POSITION

        public void
        setPosition(int y, int x) {
                this.position.setValues(x, y);
        }
        public Vector2
        getPosition() {
                return this.position;
        }

        //      DAMAGE

        public int
        getDamage() {
                return strength;
        }
}
