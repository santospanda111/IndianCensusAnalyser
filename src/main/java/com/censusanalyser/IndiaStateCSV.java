package com.censusanalyser;

import com.opencsv.bean.CsvBindByName;
/**
 * here in this class @CsvBindByName is an annotation which will take column value and boolean value as a parameter.
 */
public class IndiaStateCSV {
    @CsvBindByName(column = "SrNo", required = true)
    public int SrNo;
    @CsvBindByName(column = "State Name", required = true)
    public String state;
    @CsvBindByName(column = "TIN", required = true)
    public int TIN;
    @CsvBindByName(column = "StateCode", required = true)
    public String stateCode;

    /**
     * @return all values by printing all.
     */
    @Override
    public String toString() {
        return "IndiaStateCSV{" +
                "SrNo=" + SrNo +
                ", state='" + state + '\'' +
                ", TIN=" + TIN +
                ", stateCode='" + stateCode + '\'' +
                '}';
    }
}
