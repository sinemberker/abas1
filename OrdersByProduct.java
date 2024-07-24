import java.util.*;

public class OrdersByProduct {
    public static void main(String[] args) {
        double[][] data = {
            {1000, 2000, 12, 100.51},
            {1000, 2001, 31, 200},
            {1000, 2002, 22, 150.86},
            {1000, 2003, 41, 250},
            {1000, 2004, 55, 244},
            {1001, 2001, 88, 44.531},
            {1001, 2002, 121, 88.11},
            {1001, 2004, 74, 211},
            {1001, 2002, 14, 88.11},
            {1002, 2003, 2, 12.1},
            {1002, 2004, 3, 22.3},
            {1002, 2003, 8, 12.1},
            {1002, 2002, 16, 94},
            {1002, 2005, 9, 44.1},
            {1002, 2006, 19, 90}
        };

        Map<Double, Map<Double, Integer>> malSiparis = new HashMap<>();
        for (double[] row : data) {
            double siparisNo = row[0];
            double malNo = row[1];
            int miktar = (int) row[2];
            malSiparis.putIfAbsent(malNo, new HashMap<>());
            Map<Double, Integer> siparisMiktar = malSiparis.get(malNo);
            siparisMiktar.put(siparisNo, siparisMiktar.getOrDefault(siparisNo, 0) + miktar);
        }

        for (Map.Entry<Double, Map<Double, Integer>> entry : malSiparis.entrySet()) {
            double malNo = entry.getKey();
            Map<Double, Integer> siparisMiktar = entry.getValue();
            System.out.println("Mal No: " + malNo);
            for (Map.Entry<Double, Integer> siparisEntry : siparisMiktar.entrySet()) {
                double siparisNo = siparisEntry.getKey();
                int miktar = siparisEntry.getValue();
                System.out.println("\tSiparis No: " + siparisNo + ", Miktar: " + miktar);
            }
        }
    }
}
