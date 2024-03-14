package fast.comm.models;

public enum Currency {
    USD("USD")
    ,RUB("RUB")
    ,CNY("CNY")
    ;
    private final String value;

    public String getValue() {
        return value;
    }

    Currency(String value) {
        this.value = value;
    }
}
