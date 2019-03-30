public enum Code {
    PEK(700),
    DXB(500),
    LAX(700),
    HND(600),
    ATL(600),
    GLA(0),
    LHR(400);

    private final int value;

    Code(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
