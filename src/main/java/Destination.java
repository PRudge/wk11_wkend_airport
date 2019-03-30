public enum Destination {
    INVERNESS(40),
    ABERDEEN(120),
    MALAGA(293),
    LONDON(200),
    NEWYORK(480),
    BARCELONA(150);

    private final int value;

    Destination (int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

}
