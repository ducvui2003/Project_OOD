package model;

public class PercentDiscountCalculator implements DiscountCalculator {
	private double percentDiscount;

	public PercentDiscountCalculator(double percentDiscount) {
		super();
		this.percentDiscount = percentDiscount;
	}

	@Override
	public double calculateDiscount(double price) {
		return price * (1 - percentDiscount / 100);
	}

	@Override
	public String getDiscountValue() {
		return this.percentDiscount + "%";
	}
}
