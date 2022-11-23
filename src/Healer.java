public class Healer {

        //        ATTRIBUTES
        
        private Queue<Entity> queue;

        //        CONSTRUCTOR
        
        public
        Healer() {
                queue = new Queue<Entity>();
        }
                
        //        HEALING

        public void
        addWaiting(Entity entity) {
                this.queue.addTail(entity);
        }
        public Entity
        heal() {
                Entity entity = this.queue.removeHead();
                if (entity != null) {
                        entity.setHealth(entity.getHealthMax());
                }
                return entity;
        }

        //      SIZE

        public int
        getWaiting() {
                return this.queue.getSize();
        }
}
