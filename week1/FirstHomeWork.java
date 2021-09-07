package PROG.OOP.week1;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.FileWriter;
import java.io.IOException;

public class FirstHomeWork {
    
    static String int_to_time(int tot_time) {
        int hours = tot_time / 3600;
        tot_time %= 3600;
        int minutes = tot_time / 60;
        tot_time %= 60;
        int seconds = tot_time;
        String date = "";
        if(hours < 10) {
            date += "0" + hours + ":";
        } else date += hours + ":";
        if(minutes < 10) {
            date += "0" + minutes + ":";
        } else date += minutes + ":";
        if(seconds < 10) {
            date += "0" + seconds;
        } else date += seconds;
        return date; 
    }

    static int string_to_int(String[] time) {
        return Integer.parseInt(time[0].trim()) * 3600 + Integer.parseInt(time[1].trim()) * 60 + Integer.parseInt(time[2].trim());
    }
    public static void main(String[] args) {
        String path = "meetingAttendanceList.csv";
        String row = "";
        HashMap <String, Integer> total_time = new HashMap<String, Integer>();
        try{
            BufferedReader csvReader = new BufferedReader(new FileReader(path));
            int j = 0, join_time = 0;
            while((row = csvReader.readLine()) != null) {
                String[] data = row.split(";");
                if(j != 0) {
                    String time = data[2].substring(data[2].indexOf(":") - 2, data[2].lastIndexOf(":") + 3);
                    String[] time_detailed = time.split(":");
                    int current_time = 0;
                    if(j % 2 == 0) {
                        current_time = string_to_int(time_detailed);
                        int tot_time = current_time - join_time;
                        total_time.put(data[0], total_time.containsKey(data[0]) ? total_time.get(data[0]) + tot_time : tot_time);
                    } else {
                        join_time = string_to_int(time_detailed);
                    }
                }
                j++;
            } 
            List <String> names = new ArrayList<>(total_time.keySet());
            Collections.sort(names);
            FileWriter csvWriter = new FileWriter("totaltime.csv");
            csvWriter.append("Name, Time");
            csvWriter.append("\n");
            for(String i : names) {
                csvWriter.append(i);
                csvWriter.append(',');
                csvWriter.append(" " + int_to_time(total_time.get(i)));
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();
            csvReader.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}