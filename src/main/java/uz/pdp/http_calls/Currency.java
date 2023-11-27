package uz.pdp.http_calls;

import com.google.gson.annotations.SerializedName;

public class Currency {
    private int id;

    @SerializedName("CcyNm_EN")
    private String ccyNmEN;

    @SerializedName("CcyNm_UZC")
    private String ccyNmUZC;

    @SerializedName("Diff")
    private String diff;

    @SerializedName("Rate")
    private String rate;

    @SerializedName("Ccy")
    private String ccy;

    @SerializedName("CcyNm_RU")
    private String ccyNmRU;

    @SerializedName("CcyNm_UZ")
    private String ccyNmUZ;

    @SerializedName("Code")
    private String code;

    @SerializedName("Nominal")
    private String nominal;

    @SerializedName("Date")
    private String date;

    @Override
    public String toString() {
        return "[" +
                "id=" + id +
                ", ccyNmEN='" + ccyNmEN + '\'' +
                ", ccyNmUZC='" + ccyNmUZC + '\'' +
                ", diff=" + diff +
                ", rate=" + rate +
                ", ccy='" + ccy + '\'' +
                ", ccyNmRU='" + ccyNmRU + '\'' +
                ", ccyNmUZ='" + ccyNmUZ + '\'' +
                ", code='" + code + '\'' +
                ", nominal=" + nominal +
                ", date=" + date +
                ']';
    }
}