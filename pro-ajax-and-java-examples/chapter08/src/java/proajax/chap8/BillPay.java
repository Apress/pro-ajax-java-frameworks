package proajax.chap8;

import java.util.Date;

public class BillPay {
    
    private String payTo = "";
    private double amount;
    private Date payDate = new Date();
    
    /** Creates a new instance of BillPay */
    public BillPay() {
    }

    public String getPayTo() {
        return payTo;
    }

    public double getAmount() {
        return amount;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayTo(String payTo) {
        this.payTo = payTo;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }    
}
