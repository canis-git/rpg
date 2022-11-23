import java.util.Random;

public class Group {

        //      ATTRIBUTES

        private List<Entity> members;
        private Healer       healer;

        //      CONSTRUCTOR
        
        public
        Group() {
                this.members = new List<Entity>();
                this.healer = new Healer();
        }

        //      SIZE

        public int
        getSize() {
                return this.members.getSize();
        }

        //      MEMBERS

        public void
        addMember(Entity entity) {
                this.members.append(entity);
        }
        public void
        removeMember(Entity entity) {
                this.members.toRoot();
                while (this.members.get() != null) {
                        if (this.members.get() == entity) {
                                this.members.remove();
                                return;
                        }
                        this.members.incIndex();
                }
        }
        public Entity
        getMember(int index) {
                return this.members.getAt(index);
        }
        public List<Entity>
        getMembers() {
                return this.members;
        }

        //      HEALER
 
        public void
        nurse(int threshold) {
                this.members.toRoot();

                Entity healthiest = (Entity)this.members.get();
                this.members.incIndex();

                while (this.members.get() != null) {
                        Entity member = (Entity)this.members.get();

                        if (member.getHealth() > healthiest.getHealth()) {
                                this.removeMember(healthiest);
                                this.healer.addWaiting(healthiest);
                                healthiest = member;
                        }
                        else if (member.getHealth() + threshold < member.getHealthMax()){
                                this.removeMember(member);
                                this.healer.addWaiting(member);
                        }
                        else {
                                this.members.incIndex();
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

                Random random = new Random();
                int required = (int)(this.members.getSize() * Math.max(1.0f, density) + 1);
                int width = (int)(Math.sqrt(2 * required) + 1);
                int height = width / 2;
                int[] taken = new int[this.members.getSize()];

                for (int i = 0; i < this.members.getSize(); i++) {
                        boolean fine = false;
                        int tmp = 0;

                        while (!fine) {
                                tmp = random.nextInt(height * width);
                                fine = true;
                                for (int h = 0; h < i && fine; h++) {
                                        fine = taken[h] != tmp;
                                }
                        }

                        this.members.getAt(i).setPosition((int)(tmp / width) - (int)(height / 2) + y, tmp % width - (int)(width / 2) + x);
                        taken[i] = tmp;
                }
        }

        //      CONCATENATION

        public static List<Entity>
        concat(Group ... groups) {
                List<Entity> list = new List<Entity>();
                for (int g = 0; g < groups.length; g++) {
                        for (int m = 0; m < groups[g].getSize(); m++) {
                                list.append(groups[g].getMember(m));
                        }
                }
                return list;
        }
}
