import java.text.DecimalFormat;

public class JacobiAndSeidel {
    int MAX = 1000;//最大迭代次数
    double e = Math.pow(10, -6);//绝对误差限
    int n = 4;//矩阵行数
    double[] x = {0, 0, 0, 0};//初值
    double[] y = {0, 0, 0, 0};//迭代值
    double[] d = {0, 0, 0, 0};//x^(k+1) - x^(k)
    double[][] A = {
            {8.3, 2.1, -1.2, 0.5},
            {0.8, 10.2, 3.5, -1.8},
            {1.2, 0.2, -4, -0.5},
            {-0.2, 0.3, 0.4, -2}
    };//系数矩阵
    double B[] = {-3.02, 4.79, -6.72, 8.89};//b
    DecimalFormat format = new DecimalFormat("0.0000000");//保留小数点后7位

    public void jacobi() {
        System.out.println("Jacobi迭代：");
        int k = 0;
        do {
            for (int i = 0; i < n; i++) {
                x[i] = y[i];
            }
            for (int i = 0; i < n; i++) {
                double tem = 0;
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        tem += A[i][j] * x[j];
                    }
                }

                y[i] = (B[i] - tem) / A[i][i];
            }
            k++;
            for (int a = 0; a < n; a++) {
                d[a] = x[a] - y[a];
            }
        } while (k < MAX && Math.abs(maxOfArray(d)) > e);

        System.out.println("迭代次数为：" + k);
        System.out.println("最终的值为：");
        for (int i = 0; i < n; i++) {
            System.out.println("x" + (i + 1) + ":" + format.format(y[i]));
        }
    }

    public void seidel() {
        System.out.println("Gauss-Seidel迭代：");
        int k = 0;
        do {
            for (int i = 0; i < n; i++) {
                x[i] = y[i];
            }
            for (int i = 0; i < n; i++) {
                double tem = 0;
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        tem += A[i][j] * y[j];
                    }
                }

                y[i] = (B[i] - tem) / A[i][i];
            }
            k++;
            for (int a = 0; a < n; a++) {
                d[a] = x[a] - y[a];
            }
        } while (k < MAX && Math.abs(maxOfArray(d)) > e);

        System.out.println("迭代次数为：" + k);
        System.out.println("最终的值为：");
        for (int i = 0; i < n; i++) {
            System.out.println("x" + (i + 1) + ":" + format.format(y[i]));
        }
    }

    double maxOfArray(double[] x) {
        double max = x[0];
        for (int i = 0; i < n; i++)
            if (x[i] > max) max = x[i];
        return max;
    }

    public static void main(String[] args) {
        new JacobiAndSeidel().jacobi();
        new JacobiAndSeidel().seidel();
    }
}
