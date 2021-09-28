package edu.sei.st.logicalcoverage;

import java.math.BigDecimal;

public class Repay {

    private boolean isCardValid;
    private boolean isNameValid;
    private BigDecimal balance;

    private boolean  isTotal;
    private boolean  isPart;

    private BigDecimal payment;

    public Repay(boolean isCardValid, boolean isNameValid, BigDecimal balance, boolean isTotal, boolean isPart, BigDecimal payment) {
        this.isCardValid = isCardValid;
        this.isNameValid = isNameValid;
        this.balance = balance;
        this.isTotal = isTotal;
        this.isPart = isPart;
        this.payment = payment;
    }

    public String doRepay(){

        if (isCardValid && isNameValid && balance.compareTo(BigDecimal.ZERO)>0) {
            if(isTotal || isPart){
                if(payment.compareTo(new BigDecimal(10.00))>=0)
                    return "success";
                else
                    return "not enough balance ";
                }
            else
                return "return";
        }
        else
            return "card invalid or name invalid or balance <=0 ";
    }
}
