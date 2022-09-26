package programmers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class parkingFee {
    public static void main(String[] args) throws IOException, ParseException {

        // 기본 시간, 기본 요금, 단위 시간, 단위 요금
        int[] fees = {180, 5000, 10, 600};
        // 시간 차량번호 내역
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        int[] result = solution(fees,records);

        for (int r : result) {
            System.out.println(r);
        }
    }

    public static int[] solution(int[] fees, String[] records) throws ParseException {
        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        Map<String,String> inCars = new HashMap<>();
        Map<String,Double> totalParkingTime  = new HashMap<>();

        for (String record : records) {
            String carNumber = record.split(" ")[1];
            String parkingTime = record.split(" ")[0];
            if (record.split(" ")[2].equals("IN")) {
                inCars.put(carNumber,parkingTime);
            } else {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                Date startParking = simpleDateFormat.parse(inCars.get(carNumber));
                Date endParking = simpleDateFormat.parse(parkingTime);
                double useParkingMin = (endParking.getTime() - startParking.getTime()) / 60000;
                inCars.remove(carNumber);

                if (totalParkingTime.containsKey(carNumber)) {
                    totalParkingTime.put(carNumber,totalParkingTime.get(carNumber) + useParkingMin);
                } else {
                    totalParkingTime.put(carNumber,useParkingMin);
                }
            }
        }

        if (!inCars.isEmpty()) {
            for( Map.Entry<String, String> entry  : inCars.entrySet()) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                Date startParking = simpleDateFormat.parse(entry.getValue());
                Date endParking = simpleDateFormat.parse("23:59");
                double useParkingMin = (endParking.getTime() - startParking.getTime()) / 60000;

                if (totalParkingTime.containsKey(entry.getKey())) {
                    totalParkingTime.put(entry.getKey(),totalParkingTime.get(entry.getKey()) + useParkingMin);
                } else {
                    totalParkingTime.put(entry.getKey(),useParkingMin);
                }
            }
            inCars.clear();
        }

        Object[] sortTotalParkingTime = totalParkingTime.keySet().toArray();
        Arrays.sort(sortTotalParkingTime);

        int[] answer = new int[sortTotalParkingTime.length];
        int i = 0;
        for (Object s : sortTotalParkingTime) {
            double useParkingMin = totalParkingTime.get(s);
            if (useParkingMin <= defaultTime ) {
                answer[i] = defaultFee;
            } else {
                answer[i] = (int) (defaultFee + (Math.ceil((useParkingMin - defaultTime) / unitTime) * unitFee));
            }
            i++;
        }

        return answer;
    }
}
