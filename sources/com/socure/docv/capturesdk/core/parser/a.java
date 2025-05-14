package com.socure.docv.capturesdk.core.parser;

/* loaded from: classes5.dex */
public enum a {
    FIRST_NAME("DAC"),
    LAST_NAME("DCS"),
    BIRTH_DATE("DBB"),
    DRIVER_LICENSE_NUMBER("DAQ"),
    DRIVER_LICENSE_NAME("DAA"),
    EXPIRATION_DATE("DBA"),
    SUFFIX("DBS"),
    GIVEN_NAME("DCT"),
    MIDDLE_NAME("DAD"),
    FIRST_NAME_TRUNCATION("DDF"),
    MIDDLE_NAME_TRUNCATION("DDG"),
    LAST_NAME_TRUNCATION("DDE"),
    LAST_NAME_ALIAS("DBN"),
    GIVEN_NAME_ALIAS("DBG"),
    STREET_ADDRESS("DAG"),
    STREET_ADDRESS_TWO("DAH"),
    CITY("DAI"),
    STATE("DAJ"),
    COUNTRY("DCG"),
    POSTAL_CODE("DAK"),
    UNIQUE_DOCUMENT_ID("DCF"),
    ISSUE_DATE("DBD"),
    EYE_COLOR("DAY"),
    SEX("DBC"),
    HEIGHT_IN("DAU"),
    HEIGHT_CM("DAV"),
    COMPLIANCE_INDICATOR("@"),
    DATA_SEPARATOR("\n"),
    FORMAT("ANSI ");

    private final String mvaKey;

    a(String str) {
        this.mvaKey = str;
    }

    public final String a() {
        return this.mvaKey;
    }
}
