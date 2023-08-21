import java.util.*;

public class ReportResult {

    public static void main(String[] args) {

        // 회원리스트
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};

        // 신고 리스트
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi","muzi frodo"};

        // 신고 기준
        int k = 2;

        // 회원을 여러번 신고할 수 있으나 신고는 1회로 카운트 됨
        // -> 중복을 제거
        Set<String> unique_report_set = new HashSet<String>(Arrays.asList(report));
        String[] unique_report = unique_report_set.toArray(new String[0]);

        // 유저별 신고한 유저
        Map<String,List<String>> countReport = new HashMap<>();
        for(String user : id_list){
            countReport.put(user, new ArrayList<>());
        }

        for(String singleReport : unique_report){
//            String reported = singleReport.substring(singleReport.indexOf(" ")+1,singleReport.length());
            String[] report_unit = singleReport.split(" ");
            String reporter = report_unit[0];
            String reported = report_unit[1];
            if(countReport.containsKey(reported)){
                List<String> reporterList = countReport.get(reported);
                reporterList.add(reporter);
            }
        }

        // 신고 기준 이상의 신고는 신고한 유저에게 메일을 발송
        int[] result = new int[id_list.length];

        Iterator<String> reported_iterator = countReport.keySet().iterator();
        while(reported_iterator.hasNext()){
            String reported = reported_iterator.next();
            List<String> reporter_list = countReport.get(reported);
            if(reporter_list.size()>=k){
                for(String singleReporter : reporter_list){
                    for(int i=0;i<id_list.length;i++){
                        if(id_list[i].equals(singleReporter)){
                            result[i]++;
                        }
                    }
                }
            }
        }
    }

}
