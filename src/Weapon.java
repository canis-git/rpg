public class Weapon {

        //      ATTRIBUTES

        private String  name;
        private float   multiplier;
        private Bonus   material;
        private Bonus   charm;

        //      CONSTRUCTOR

        public
        Weapon(String name, float multiplier, Bonus material, Bonus charm) {
                this.name = name;
                this.multiplier = multiplier;
                this.material = material;
                this.charm = charm;
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

        //      MULTIPLIER

        public void
        setMultiplier(float multiplier) {
                this.multiplier = multiplier;
        }
        public float
        getMultiplier() {
                return this.multiplier + this.material.bonus + this.charm.bonus;
        }

        //      MATERIAL
        
        public Bonus
        getMaterial() {
                return this.material;
        }
        
        //      CHARM
        
        public Bonus
        getCharm() {
                return this.charm;
        }

        //      BONUS
        
        public static class Bonus {

                //      ATTRIBUTES

                private String  name;
                private float   bonus;

                //      CONSTRUCTOR

                public
                Bonus(String name, float bonus) {
                        this.name = name;
                        this.bonus = bonus;
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
                
                //      BONUS
                
                public void
                setBonus(float bonus) {
                        this.bonus = bonus;
                }
                public float
                getBonus() {
                        return this.bonus;
                }
        }
}
