package model.enumration;

public enum PaymentType {
    PERCENTAGE,FIX_SUM;
    public static PaymentType getPayment(int val) {
    	if(val==0) return PERCENTAGE;
    	if(val==1) return FIX_SUM;
		return null;
    }
}
