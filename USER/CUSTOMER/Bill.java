package USER.CUSTOMER;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Random;

public class Bill {
    private String UniqueNo;
    private String BillId;
    private int Amount;
    private LocalDate billdate;
    private LocalDate billduedate;
    private String Billpaystatus;

    public Bill() {

    }

    public Bill(String uniqueNo, String billId, int amount, LocalDate billdate, LocalDate billduedate,
            String billpaystatus) {
        UniqueNo = uniqueNo;
        BillId = billId;
        Amount = amount;
        this.billdate = billdate;
        this.billduedate = billduedate;
        Billpaystatus = billpaystatus;
    }

    public LocalDate getBilldate() {
        return billdate;
    }

    public void setBilldate(LocalDate billdate) {
        this.billdate = billdate;
    }

    public LocalDate getBillduedate() {
        return billduedate;
    }

    public void setBillduedate(LocalDate billdate) {
        this.billduedate = billdate.plusDays(15);
    }

    public String getBillId() {
        return BillId;
    }

    public void setBillId(String billId) {
        BillId = billId;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public void GenerateBillID(String UniqueNo, LocalDate billdate) {
        String bId = UniqueNo + "" + billdate;
        setBillId(bId);
        setBilldate(LocalDate.now());
    }

    public int calculateBill(Customer c) {
        if (c.getTypeOfConnection().equalsIgnoreCase("normal")) {
            int units = new Random().nextInt(1000);
            int billpay = 0;
            if (units < 100) {
                billpay = (int) (units * 1.20);
                if (billpay < 80) {
                    billpay = 80;
                }
            } else if (units < 300) {
                billpay = (int) (100 * 1.20 + (units - 100) * 2);
            }

            else if (units > 300) {
                billpay = (int) (100 * 1.20 + 200 * 2 + (units - 300) * 3);
            }
            setAmount(billpay);
            setBilldate(LocalDate.now());
            // System.out.prStringln("Bill to pay : " + billpay);
            return billpay;
        }

        else if (c.getTypeOfConnection().equalsIgnoreCase("solar")) {
            int billpay = 0;
            int unitsCons = new Random().nextInt(1000);
            int unitsProd = new Random().nextInt(1000);

            if (unitsCons > unitsProd) {
                int netUnits;
                netUnits = unitsCons - unitsProd;
                if (netUnits < 100) {
                    billpay = (int) (netUnits * 1.20);
                } else if (netUnits < 300) {
                    billpay = (int) (100 * 1.2 + (netUnits - 100) * 2);
                } else if (netUnits > 300) {
                    billpay = (int) (100 * 1.2 + 200 * 2 + (netUnits - 300) * 3);
                }
            } else {
                int netUnits;
                netUnits = unitsProd - unitsCons;
                if (netUnits < 100) {
                    billpay = (int) -(netUnits * 1.20);
                } else if (netUnits < 300) {
                    billpay = (int) -(100 * 1.2 + (netUnits - 100) * 2);
                } else if (netUnits > 300) {
                    billpay = (int) -(100 * 1.2 + 200 * 2 + (netUnits - 300) * 3);
                }
            }
            setAmount(billpay);
            setBilldate(LocalDate.now());
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

    public void printbilldetails() throws SQLException {
        System.out.println("UniqueNo: " + getUniqueNo());
        System.out.println("BillId: " + getBillId());
        System.out.println("Bill Date: " + getBilldate());
        System.out.println("Bill Amount: " + getAmount());
        System.out.println("Bill due date: " + getBillduedate());
        System.out.println("Bill pay Status: " + getBillpaystatus());
    }
}
