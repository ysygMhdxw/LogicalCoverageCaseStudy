package edu.sei.st.logicalcoverage;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepayConditionCoverageTest {
//        条件	                                                                路径
//        isCardValid	isNameValid	balance>0	isTotal	isPart	payment>=10.0
//        真	        真	        真	        真	    -	    真	            ACEG
//        假	        -	        -	        -	    -	    -	            AB
//        真	        假	        -	        -	    -	    -	            AB
//        真	        真	        假	        -	    -	    -	            AB
//        真	        真	        真	        假	    真	    假	            ACEF
//        真	        真	        真	        假	    假	    -	            ACD
//以满足判定——每一个branch的真假都已经执行了一次
    @Test
    public void doRepay1() {
        Repay repay = new Repay(true, true, new BigDecimal(10.0), true, false, new BigDecimal(10.0));
        assertEquals("success", repay.doRepay());
    }

    @Test
    public void doRepay2() {
        Repay repay = new Repay(false,true,new BigDecimal(20),false,false,new BigDecimal(0));
        assertEquals("card invalid or name invalid or balance <=0 ",repay.doRepay());
    }

    @Test
    public void doRepay3() {
        Repay repay = new Repay(true,false,new BigDecimal(20),false,false,new BigDecimal(10));
        assertEquals("card invalid or name invalid or balance <=0 ",repay.doRepay());

    }

    @Test
    public void doRepay4() {
        Repay repay = new Repay(true,true,new BigDecimal(0),false,false,new BigDecimal(10));
        assertEquals("card invalid or name invalid or balance <=0 ",repay.doRepay());
    }

    @Test
    public void doRepay5() {
        Repay repay = new Repay(true, true, new BigDecimal(10.0), false, true, new BigDecimal(0.0));
        assertEquals("not enough balance ", repay.doRepay());
    }

    @Test
    public void doRepay6() {
        Repay repay = new Repay(true, true, new BigDecimal(10.0), false, false, new BigDecimal(10.0));
        assertEquals("return", repay.doRepay());
    }

}
