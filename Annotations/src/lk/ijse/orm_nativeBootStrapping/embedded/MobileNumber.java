package lk.ijse.orm_nativeBootStrapping.embedded;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MobileNumber {
    @Column(name = "mobile_no_type")
    private String type;
    @Column(name = "mobile_no")
    private String mobileNo;

    public MobileNumber() {}

    public MobileNumber(String type, String mobileNo) {
        this.type = type;
        this.mobileNo = mobileNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    @Override
    public String toString() {
        return "MobileNumber{" +
                "type='" + type + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                '}';
    }
}
