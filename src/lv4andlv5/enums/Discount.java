package lv4andlv5.enums;

public enum Discount {
    NATIONAL {
        @Override
        public double getDiscount(double totalPayment) {
            return totalPayment * 0.9;
        }
    },SOLDIER {
        @Override
        public double getDiscount(double totalPayment) {
            return totalPayment * 0.95;
        }
    }, STUDENT {
        @Override
        public double getDiscount(double totalPayment) {
            return totalPayment * 0.97;
        }
    }, NORMAL {
        @Override
        public double getDiscount(double totalPayment) {
            return totalPayment;
        }
    };
    public abstract double getDiscount(double totalPayment);
}
