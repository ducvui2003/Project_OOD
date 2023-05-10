package model;

public class ValueDiscountCalculator implements DiscountCalculator {
	private double valueDiscount;

	public ValueDiscountCalculator(double valueDiscount) {
		super();
		this.valueDiscount = valueDiscount;
	}

	@Override
	public double calculateDiscount(double price) {
		return Math.max(price - valueDiscount, 0);
	}

	@Override
	public String getDiscountValue() {
		return this.valueDiscount + "VND";
	}
}
