package enum_training.enumExample2;

public enum Transportation {
    BUS(100){
        public int getTotalFare(int distance) {
            return basicFare * distance;
        }
    },
    TRAIN(100){
        public int getTotalFare(int distance) {
            return basicFare * distance;
        }
    },
    TAXI(500){
        public int getTotalFare(int distance) {
            return basicFare * distance;
        }
    },
    SHIP(600){
        public int getTotalFare(int distance) {
            return basicFare * distance;
        }
    },
    AIRPLANE(1000){
        public int getTotalFare(int distance) {
            return basicFare * distance;
        }
    };

    protected final int basicFare;

    Transportation(int basicFare) {
        this.basicFare = basicFare;
    }

    abstract int getTotalFare(int distance);
}
