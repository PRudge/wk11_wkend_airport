public enum AirlineName {
    AMERICANAIRLINES("AA"),
    AIRCANADA("AC"),
    ALASKAAIRLINES("AS"),
    JETBLUEAIRWAYS("B6"),
    BRITISHAIRWAYS("BA"),
    DELTAAIRLINES("DL"),
    FRONTIERAIRLINES("F9"),
    LUFTHANSA("LH"),
    FLYBE("FB"),
    KLM("KL"),
    AIRFRANCE("AF");

    private final String value;

    AirlineName(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }


}
