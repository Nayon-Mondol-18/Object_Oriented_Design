//****************************************************************
// Title : A java programme to demonstrate Open Close Principle.
// Author : Nayon Mondol, Undergrduate student, Khulna University.
//****************************************************************

import java.util.ArrayList;
import java.util.List;

/**
 * Interface representing a discount strategy.
 */
abstract class DiscountStrategy {
    /**
     * Apply discount to the total price.
     *
     * @param totalPrice The total price of the order.
     * @return The discounted total price.
     */
    abstract double applyDiscount(double totalPrice);
}

/**
 * Concrete discount strategy for percentage discount.
 */
class PercentageDiscount extends DiscountStrategy {
    private double percentage;

    /**
     * Constructs a PercentageDiscount object with the given percentage.
     *
     * @param percentage The percentage discount to apply.
     */
    public PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }

    /**
     * Apply percentage discount to the total price.
     *
     * @param totalPrice The total price of the order.
     * @return The discounted total price.
     */
    @Override
    public double applyDiscount(double totalPrice) {
        return totalPrice * (1 - percentage / 100);
    }
}

/**
 * Concrete discount strategy for fixed amount discount.
 */
class FixedAmountDiscount extends DiscountStrategy {
    private double amount;

    /**
     * Constructs a FixedAmountDiscount object with the given amount.
     *
     * @param amount The fixed amount discount to apply.
     */
    public FixedAmountDiscount(double amount) {
        this.amount = amount;
    }

    /**
     * Apply fixed amount discount to the total price.
     *
     * @param totalPrice The total price of the order.
     * @return The discounted total price.
     */
    @Override
    public double applyDiscount(double totalPrice) {
        return totalPrice - amount;
    }
}

/**
 * Context class that applies discount based on the provided strategy.
 */
class DiscountApplier {
    private DiscountStrategy discountStrategy;

    /**
     * Constructs a DiscountApplier object with the given discount strategy.
     *
     * @param discountStrategy The discount strategy to apply.
     */
    public DiscountApplier(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    /**
     * Apply discount to the total price using the provided discount strategy.
     *
     * @param totalPrice The total price of the order.
     * @return The discounted total price.
     */
    public double applyDiscount(double totalPrice) {
        return discountStrategy.applyDiscount(totalPrice);
    }
}

/**
 * Demo class demonstrating the usage of different discount strategies.
 */
public class Open_Close_Principle {
    public static void main(String[] args) {
        List<DiscountApplier> discountAppliers = new ArrayList<>();
        discountAppliers.add(new DiscountApplier(new PercentageDiscount(10))); // 10% discount
        discountAppliers.add(new DiscountApplier(new FixedAmountDiscount(5))); // $5 fixed discount

        double totalPrice = 100; // Total price of the order

        for (DiscountApplier discountApplier : discountAppliers) {
            totalPrice = discountApplier.applyDiscount(totalPrice);
        }

        System.out.println("Final price after discounts: $" + totalPrice);
    }
}

/**
 * In the above programme the applyDiscount method is different for
 * percentageDiscount and fixedAmountDiscount classes but whenever we
 * need to apply any type of discount we don't need to change anything
 * in the discountStrategy class.
 */