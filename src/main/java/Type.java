public enum Type {
    A330(293),
    BOEING747(420),
    A340(295),
    BOEING757(186),
    BOEING777(440),
    A380(2);

    private final int value;

    Type (int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
