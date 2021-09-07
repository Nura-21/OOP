import csv
import re
import datetime
d = {}
with open('meetingAttendanceList.csv', newline='') as file:
    total = 0
    file = file.readlines()
    
    for i in range(int(len(file))):
        #print(file[i],end=" ")
        row = file[i].split(';')
        next_row = file[i].split(";")

        name = row[0]
        status = row[1]
        next_name = next_row[0]
        next_status = next_row[2]

        time = row[2]
        time = time.replace('9/1/2021, ','')
        time = time.replace(' AM','')
        
        next_time = next_row[2]
        next_time = next_time.replace('9/1/2021, ','')
        next_time = next_time.replace(' AM','')

        time1 = datetime.datetime.strptime(time,"%H:%M:%S")
        time2 = datetime.datetime.strptime(next_time, "%H:%M:%S")
        
        dif = (time2 - time1)
        print(dif)


        
        
            
        