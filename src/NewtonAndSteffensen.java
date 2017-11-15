import java.text.DecimalFormat;

public class NewtonAndSteffensen {
    private double y = 0.0;
    private double x = 0.0;
    private int MAX = 1000;
    private double e = Math.pow(10, -6);//绝对误差限
    DecimalFormat format = new DecimalFormat("0.0000000");//保留小数点后7位

    public void Newton() {
        System.out.println("Newton 迭代法");
        int k = 0;
        x = 0;
        y = 0;
        do {
            x = y;
            y = f1(x);
            k++;
        } while (k < MAX && Math.abs(x - y) > e);

        printResult(k, y);

        k = 0;
        y = 0.25;
        do {
            x = y;
            y = f2(x);
            k++;
        } while (k < MAX && Math.abs(y * y + 10 * Math.cos(y)) > e);

        printResult(k, y);
    }

    public void Steffensen() {
        System.out.println("Steffensen 迭代法");
        int k = 0;
        y = 0;
        do {
            x = y;
            double x1 = f1(x);
            double x2 = f1(x1);
            y = x2 - Math.pow(x2 - x1, 2) / (x2 - 2 * x1 + x);
            k++;
        } while (k < MAX && Math.abs(x - y) > e);

        printResult(k, y);

        k = 0;
        y = 0.25;
        do {
            x = y;
            double x1 = f2(x);
            double x2 = f2(x1);
            y = x2 - Math.pow(x2 - x1, 2) / (x2 - 2 * x1 + x);
            k++;
        } while (k < MAX && Math.abs(x - y) > e);

        printResult(k, y);
    }

    private double f1(double x) {
        return x - (Math.exp(x) - x * x + 3 * x - 2) / (Math.exp(x) - 2 * x + 3);
    }

    private double f2(double x) {
        return x - (x * x + 10 * Math.cos(x)) / (2 * x - 10 * Math.sin(x));
    }

    private void printResult(int k, double y) {
        System.out.println("迭代次数为：" + k);
        System.out.println("最终的值为：" + format.format(y));
    }

    public static void main(String[] args) {
        new NewtonAndSteffensen().Newton();
        new NewtonAndSteffensen().Steffensen();
    }
}
