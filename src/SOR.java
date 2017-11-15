import java.text.DecimalFormat;

public class SOR {
    int MAX = 1000;//最大迭代次数
    double e = Math.pow(10, -6);//绝对误差限
    int n = 3;//矩阵行数
    double[] x = {0, 0, 0};//初值
    double[] y = {0, 0, 0};//迭代值
    double[] d = {0, 0, 0};//x^(k+1) - x^(k)
    double[][] A = {
            {5, 2, 1},
            {-1, 4, 1},
            {2, -3, -4}
    };//系数矩阵
    double B[] = {5.2, -6.2, -4.9};//b
    double w = 1.25;
    DecimalFormat format = new DecimalFormat("0.0000000");//保留小数点后7位

    public void sor() {
        System.out.println("SOR迭代：");
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

                y[i] = (1 - w) * x[i] + w * (B[i] - tem) / A[i][i];
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
        new SOR().sor();
    }
}
