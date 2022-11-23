package Rpg;
import java.util.Random;

public class Loot {

        //      HEROS
        
        public Hero
        genHero() {
                String name;
                int health;
                int strength;

                float tier = genTier();

                name = heroNames[(int)(genFloat(tier) * (heroNames.length - 1))];
                health = genInt(tier, 9) + 1;
                strength = genInt(tier, 3) + 1;

                return new Hero(name, health, strength, genWeapon(tier));
        }

        public Hero
        genHero(float tier) {
                String name;
                int health;
                int strength;

                name = heroNames[(int)(genFloat(tier) * (heroNames.length - 1))];
                health = genInt(tier, 9) + 1;
                strength = genInt(tier, 4) + 1;

                return new Hero(name, health, strength, genWeapon(tier));
        }

        //      NAMES

        private static final String[] heroNames = {
                "Aldwyn",
                "Daario",
                "Falkor",
                "Duncan",
                "Gregor",
                "Eowyn",
                "Aravis",
                "Catelyn",
                "Ripley",
                "Sybil",
                "Bellatrix",
                "Durwell",
                "Haleth",
                "Gurney",
                "Keyvyre",
        };

        //      WEAPONS

        public Weapon
        genWeapon() {
                String name;
                Weapon.Bonus material;
                Weapon.Bonus charm;
                float multiplier;
                
                Random random = new Random();
                float tier = genTier();

                material = weaponMaterials[(int)(genFloat(tier) * (weaponMaterials.length - 1))];
                if (random.nextInt(6) == 0) {
                        name = weaponNames[(int)(genFloat(tier) * (weaponNames.length - 1))];
                } else {
                        name = material.getName() + " " + weaponKinds[(int)(genFloat(tier) * (weaponKinds.length - 1))];
                }
                charm = weaponCharms[(int)(genFloat(tier) * (weaponCharms.length - 1))];
                multiplier = genWeaponMultiplier(tier);

                return new Weapon(name, multiplier, material, charm);
        }
        public Weapon
        genWeapon(float tier) {
                String name;
                Weapon.Bonus material;
                Weapon.Bonus charm;
                float multiplier;
                
                Random random = new Random();

                material = weaponMaterials[(int)(genFloat(tier) * (weaponMaterials.length - 1))];
                if (random.nextInt(6) == 0) {
                        name = weaponNames[(int)(genFloat(tier) * (weaponNames.length - 1))];
                } else {
                        name = material.getName() + " " + weaponKinds[(int)(genFloat(tier) * (weaponKinds.length - 1))];
                }
                charm = weaponCharms[(int)(genFloat(tier) * (weaponCharms.length - 1))];
                multiplier = genWeaponMultiplier(tier);

                return new Weapon(name, multiplier, material, charm);
        }
        
        private float
        genTier() {
                Random random = new Random();
                float func = random.nextFloat();
                return Math.max(0.0f, Math.min(1.0f, func));
        }
        private int
        genInt(float tier, int lim) {
                Random random = new Random();
                float seed = random.nextFloat() - 0.5f;
                float func = tier + 6.0f * (float)Math.pow(seed, 5) + 0.05f * Math.signum(seed);
                return Math.round(lim * Math.max(0.0f, Math.min(1.0f, func)));
        }
        private float
        genFloat(float tier) {
                Random random = new Random();
                float seed = random.nextFloat() - 0.5f;
                float func = tier + 6.0f * (float)Math.pow(seed, 5) + 0.05f * Math.signum(seed);
                return Math.max(0.0f, Math.min(1.0f, func));
        }
        private float
        genWeaponMultiplier(float tier) {
                Random random = new Random();
                //float seed = random.nextFloat() - 0.5f;
                //float func = (float)Math.round((0.8f + tier + seed * 0.25f) * 100.0f) / 100.0f;
                float seed = genFloat(tier);
                float func = (float)Math.round((0.4f * seed + 0.8f) * 100.0f) / 100.0f;
                return (float)Math.max(0.0f, func);
        }
        
        //      KINDS

        private static final String[] weaponKinds = {
                "(Sharpened)",
                "Blade",
                "Bayonet",
                "Dagger",
                "Sword",
                "Axe",
                "Scythe",
        };
        
        //      NAMES

        private static final String[] weaponNames = {
                "Ominous Blade",
                "Soul Knife",
                "Axe of Doom",
                "Bloody Death",
                "Death Bringer",
                "Forsaken Broadaxe",
                "Despair",
                "Tortured Whishes",
        };

        //      MATERIALS

        private static final Weapon.Bonus[] weaponMaterials = {
                new Weapon.Bonus("Bone", 0.0f),
                new Weapon.Bonus("Wood", 0.1f),
                new Weapon.Bonus("Bronze", 0.1f),
                new Weapon.Bonus("Carit", 0.2f),
                new Weapon.Bonus("Kordit", 0.3f),
                new Weapon.Bonus("Iron", 0.4f),
                new Weapon.Bonus("Steel", 0.4f),
                new Weapon.Bonus("Endurium", 0.5f),
                new Weapon.Bonus("Elerium 115", 0.6f),
                new Weapon.Bonus("Elex", 0.6f),
                new Weapon.Bonus("Digedanium", 0.7f),
                new Weapon.Bonus("Scrith", 0.8f),
                new Weapon.Bonus("Unitall", 0.9f),
                new Weapon.Bonus("Laas", 1.0f),
                new Weapon.Bonus("Adamantium", 1.0f),
        };

        //      CHARMS

        private static final Weapon.Bonus[] weaponCharms = {
                new Weapon.Bonus("None", 0.0f),
                new Weapon.Bonus("Air", 0.1f),
                new Weapon.Bonus("Earth", 0.2f),
                new Weapon.Bonus("Dark", 0.3f),
                new Weapon.Bonus("Water", 0.4f),
                new Weapon.Bonus("Fire", 0.5f),
                new Weapon.Bonus("Living", 0.6f),
                new Weapon.Bonus("Mosaic", 0.7f),
                new Weapon.Bonus("Light", 0.8f),
                new Weapon.Bonus("Electricity", 1.0f),
                new Weapon.Bonus("Magnetism", 1.0f),
        };
}
