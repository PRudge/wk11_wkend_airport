public enum Code {
    PEK("Peking" ,2),
    DXB("Dubia" ,70),
    LAX("Los Angeles", 400),
    HND("Tokyo", 120),
    ATL("Atlanta" , 200),
    GLA("Glasgow", 0),
    INV("Inverness", 20),
    DBL("Dublin", 200),
    AGP("Malaga", 293),
    LHR("London Heathrow", 400);

    private final int value;
    private final String destination;

    Code(String destination, int value){
        this.destination = destination;
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
    public String getDestination(){return this.destination;}
}
