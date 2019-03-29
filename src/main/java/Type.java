public enum Type {
    BOEING747(420),
    BOEING757(186),
    BOEING777(440),
    A330(293),
    A340(295),
    A380(2);

    private final int value;

    Type (int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
