package edu.sei.st.logicalcoverage;

import org.junit.jupiter.api.Test;

import javax.xml.ws.RequestWrapper;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepayDecisionCoverageTest {
    @Test
    public void doRepay1() {

//        语句	isValid	    isNameValid	    balance	isTotal	    isPart	payment	    return
//         AB	T	        T               0    N/A	        N/A	    N/A	        card invalid…
//        ACD	T	        T	            10.0	F	        F	    N/A	        return
//        ACEF	T	        T	            10.0	T	        N/A	    1	        not enough…
//        ACEG	T	        T	            10.0	T	        N/A	    10.0	    success

        Repay repay = new Repay(true, true, new BigDecimal(0.00), false, true, new BigDecimal(10.00));
        assertEquals("card invalid or name invalid or balance <=0 ", repay.doRepay());

    }
    @Test
    public void doRepay2(){
        Repay repay = new Repay(true, true, new BigDecimal(10.00), false, false, new BigDecimal(10.00));
        assertEquals("return", repay.doRepay());
    }

    @Test
    public void doRepay3(){
        Repay repay = new Repay(true, true, new BigDecimal(10.00), true, false, new BigDecimal(1.00));
        assertEquals("not enough balance ", repay.doRepay());

    }

    @Test
    public void doRepay4(){
        Repay repay = new Repay(true, true, new BigDecimal(10.00), true, true, new BigDecimal(10.00));
        assertEquals("success", repay.doRepay());

    }

}
