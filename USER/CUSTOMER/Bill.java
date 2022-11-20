package USER.CUSTOMER;

import java.time.LocalDate;
import java.util.Random;

public class Bill {
    private int UniqueNo;
    private String BillId;
    private Double Amount;
    private LocalDate datetime;
    private String Billpaystatus;

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

    public void GenerateBillID(int UniqueNo, LocalDate datetime) {
        String bId = UniqueNo + "" + datetime;
        setBillId(bId);
    }

    // public int[] getBillsArr() {
    // return billsArr;
    // }

    // public void setBillsArr(int[] billsArr) {
    // this.billsArr = billsArr;
    // }

    // int[] billsArr = new int[100];

    public double calculateBill(Customer c) {
        if (c.getTypeOfConnection() == 0) {
            float units = new Random().nextInt(2000);
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
            // System.out.println("Bill to pay : " + billpay);
            return billpay;
        }

        else {
            double billpay = 0;
            float unitsCons = new Random().nextInt(2000);
            float unitsProd = new Random().nextInt(2000);

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
    }

    public int getUniqueNo() {
        return UniqueNo;
    }

    public void setUniqueNo(int uniqueNo) {
        UniqueNo = uniqueNo;
    }

    public String getBillpaystatus() {
        return Billpaystatus;
    }

    public void setBillpaystatus(String billpaystatus) {
        Billpaystatus = billpaystatus;
    }
}
