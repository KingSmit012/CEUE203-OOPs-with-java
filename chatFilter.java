public class chatFilter {
    public static String FilterLogs(String []logs , String Keyword){
        StringBuilder report = new StringBuilder();
        int MatchCount = 0;


        String lowerKW = Keyword.toLowerCase();

        for(String line : logs){
            String parts[] = line.split(" ",3);

            if(parts.length < 3){
                continue;
            }

            String time = parts[0];
            String user = parts[1];
            String msg = parts[2];

            if(msg.toLowerCase().contains(lowerKW)){
                MatchCount ++;
                report.append(time)
                .append(" ")
                .append(user)
                .append(" : ")
                .append(msg)
                .append("\n");
            }

        }

        return "Matches: " + MatchCount + "\n" + report.toString();
    }
}
