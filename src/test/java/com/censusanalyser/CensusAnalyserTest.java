package com.censusanalyser;





import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTest {
    private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
    private static final String INDIA_CENSUS_CSV_INCORRECT_TYPE = "./src/test/resources/IndiaStateCensusData.txt";
    private static final String INDIA_CENSUS_CSV_INCORRECT_DELIMITER = "./src/test/resources/IndiaStateCensusData,csv";
    private static final String WRONG_HEADER_CSV_FILE_PATH = "./src/test/resources/WrongHeaderIndiaStateCensusData.csv";
    /**
     * this testcase will check the number of entries.
     */
    @Test
    public void givenIndianCensusCSVFileReturnsCorrectRecords() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            Assertions.assertEquals(29,numOfRecords);
        } catch (CensusAnalyserException e) { }
    }

    /**
     * this test case will check the exception with the wrong path.
     */
    @Test
    public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }

    /**
     * this test case will check the exception according to wrong file type.
     */
    @Test
    public void givenIndiaCensusData_WithIncorrectFileType_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_INCORRECT_TYPE);
        } catch (CensusAnalyserException e) {
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type, "Incorrect File Type");
        }
    }

    /**
     * This will check the given csv file with delimiter and return the exception.
     */
    @Test
    public void givenIndiaCensusData_WithIncorrectDelimiter_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_INCORRECT_DELIMITER);
        } catch (CensusAnalyserException e) {
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type, "Incorrect Delimiter");
        }
    }

    /**
     * This will check the given csv file with wrong header and return the exception.
     */
    @Test
    public void givenIndianCensusData_WithWrongHeader_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WRONG_HEADER_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }
}
