package USER.CUSTOMER;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Random;

public class Bill {
    private String UniqueNo;
    private String BillId;
    private Double Amount;
    private LocalDate datetime;
    private String Billpaystatus;

    public Bill() {

    }

    public Bill(String uniqueNo, String billId, Double amount, LocalDate datetime, String billpaystatus) {
        UniqueNo = uniqueNo;
        BillId = billId;
        Amount = amount;
        this.datetime = datetime;
        Billpaystatus = billpaystatus;
    }

    public String getBillId() {
        return BillId;
    }

    public void setBillId(String billId) {
        BillId = billId;
    }

    public Double getAmount() {
        return Amount;
    }

    public void setAmount(Double amount) {
        Amount = amount;
    }

    public LocalDate getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDate localDate) {
        this.datetime = localDate;
    }

    public void GenerateBillID(String UniqueNo, LocalDate datetime) {
        String bId = UniqueNo + "" + datetime;
        setBillId(bId);
        setDatetime(LocalDate.now());
    }

    // public String[] getBillsArr() {
    // return billsArr;
    // }

    // public void setBillsArr(String[] billsArr) {
    // this.billsArr = billsArr;
    // }

    // String[] billsArr = new String[100];

    public double calculateBill(Customer c) {
        if (c.getTypeOfConnection().equalsIgnoreCase("normal")) {
            float units = new Random().nextInt(1000);
            double billpay = 0;
            if (units < 100) {
                billpay = units * 1.20;
                if (billpay < 80) {
                    billpay = 80;
                }
            } else if (units < 300) {
                billpay = 100 * 1.20 + (units - 100) * 2;
            }

            else if (units > 300) {
                billpay = 100 * 1.20 + 200 * 2 + (units - 300) * 3;
            }
            setAmount(billpay);
            setDatetime(LocalDate.now());
            // System.out.prStringln("Bill to pay : " + billpay);
            return billpay;
        }

        else if (c.getTypeOfConnection().equalsIgnoreCase("solar")) {
            double billpay = 0;
            float unitsCons = new Random().nextInt(1000);
            float unitsProd = new Random().nextInt(1000);

            if (unitsCons > unitsProd) {
                float netUnits;
                netUnits = unitsCons - unitsProd;
                if (netUnits < 100) {
                    billpay = netUnits * 1.20;
                } else if (netUnits < 300) {
                    billpay = 100 * 1.2 + (netUnits - 100) * 2;
                } else if (netUnits > 300) {
                    billpay = 100 * 1.2 + 200 * 2 + (netUnits - 300) * 3;
                }
            } else {
                float netUnits;
                netUnits = unitsProd - unitsCons;
                if (netUnits < 100) {
                    billpay = -(netUnits * 1.20);
                } else if (netUnits < 300) {
                    billpay = -(100 * 1.2 + (netUnits - 100) * 2);
                } else if (netUnits > 300) {
                    billpay = -(100 * 1.2 + 200 * 2 + (netUnits - 300) * 3);
                }
            }
            setAmount(billpay);
            setDatetime(LocalDate.now());
            return billpay;
        }
        return 0;
    }

    public String getUniqueNo() {
        return UniqueNo;
    }

    public void setUniqueNo(String uniqueNo) {
        UniqueNo = uniqueNo;
    }

    public String getBillpaystatus() {
        return Billpaystatus;
    }

    public void setBillpaystatus(String billpaystatus) {
        Billpaystatus = billpaystatus;
    }

    public boolean isBillPayed() {
        if (getBillpaystatus().equalsIgnoreCase("true")) {
            return true;
        } else {
            return false;
        }
    }

    public void prStringbilldetails() throws SQLException{
  

    }
}
