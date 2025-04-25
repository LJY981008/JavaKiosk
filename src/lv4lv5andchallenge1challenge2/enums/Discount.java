package lv4lv5andchallenge1challenge2.enums;

/**
 * 할인율 관리자
 */
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
    // 각각 할인율의 연산 메서드
    public abstract double getDiscount(double totalPayment);
}
