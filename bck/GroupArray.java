import java.util.Random;

public class Group {

        //      ATTRIBUTES

        private int      capacity;
        private Entity[] members;
        private int      size;
        private Healer   healer;
        private Vector2  position;

        //      CONSTRUCTOR
        
        public
        Group(int y, int x, int capacity) {
                this.capacity = capacity;
                this.members = new Entity[capacity];
                this.size = 0;
                this.healer = new Healer();
                this.position = new Vector2(x, y);
        }

        public
        Group(int y, int x, int capacity, Entity[] members) {
                this.capacity = Math.max(capacity, members.length);
                this.members = new Entity[capacity];
                this.size = members.length;
                this.healer = new Healer();
                this.position = new Vector2(x, y);

                for (int  i = 0; i < Math.min(members.length, capacity); i++) {
                        this.members[i] = members[i];
                }
        }

        //      SIZE

        public int
        getSize() {
                return this.size;
        }

        //      MEMBERS

        public void
        addMember(Entity entity) {
                if (this.size < this.capacity) {
                        this.members[this.size++] = entity;
                }
        }
        public void
        removeMember(Entity entity) {
                boolean found = false;

                for (int i = 0; i < this.size; i++) {
                        if (this.members[i] == entity) {
                                found = true;
                                this.size--;
                        }

                        if (found) {
                                if (i + 1 < this.capacity) {
                                        this.members[i] = this.members[i + 1];
                                } else {
                                        this.members[i] = null;
                                }
                        }
                }
        }
        public Entity
        getMember(int i) {
                return this.members[i];
        }

        //      HEALER

        public void
        nurse(int threshold) {
                Entity healthiest = this.members[0];

                for (int i = 1; i < this.size; i++) {

                        Entity member = this.members[i];

                        if (member.getHealth() > healthiest.getHealth()) {
                                this.removeMember(healthiest);
                                this.healer.addWaiting(healthiest);
                                healthiest = member;
                                i--;
                        }
                        else if (member.getHealth() + threshold < member.getHealthMax()){
                                this.removeMember(member);
                                this.healer.addWaiting(member);
                                i--;
                        }
                }
        }

        public void
        heal() {
                Entity e = this.healer.heal();
                if (e != null) {
                        this.addMember(e);
                }
        }

        //      MOVEMENT

        public void
        move(int y, int x, float density) {

                this.position.setValues(x, y);

                int required = (int)(this.size * Math.max(1.0f, density) + 1);
                int width = (int)(Math.sqrt(2 * required) + 1);
                int height = width / 2;

                Random random = new Random();
                int[] taken = new int[this.size];

                for (int i = 0; i < this.size; i++) {
                        boolean fine = false;
                        int tmp = 0;

                        while (!fine) {
                                tmp = random.nextInt(height * width);
                                fine = true;
                                for (int h = 0; h < i && fine; h++) {
                                        fine = taken[h] != tmp;
                                }
                        }

                        this.members[i].setPosition((int)(tmp / width) - (int)(height / 2) + y, tmp % width - (int)(width / 2) + x);
                        taken[i] = tmp;
                }
        }

        //      CONCATENATION

        public static Group
        concat(Group ... gs) {
                int size = 0;
                for (int i = 0; i < gs.length; i++) {
                        size += gs[i].getSize();
                }

                Group g = new Group(size);
                for (int i = 0; i < gs.length; i++) {
                        for (int x = 0; x < gs[i].getSize(); x++) {
                                g.addMember(gs[i].getMember(x));
                        }
                }

                return g;
        }
}
