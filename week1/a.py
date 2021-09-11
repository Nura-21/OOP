import csv
import datetime as dt
# ready template for difference of time
def diff(start, end):
    start_dt = dt.datetime.strptime(start, '%H:%M:%S')
    end_dt = dt.datetime.strptime(end, '%H:%M:%S')
    diff = (end_dt - start_dt) 
    return diff.seconds

d = {}
k = {}
with open('meetingAttendanceList.csv') as csv_file:
    csv_reader = csv.reader(csv_file, delimiter=';')
    line_count = 0
    for row in csv_reader:
        if(row[1] == "Joined"):
            # print('hi')
            if row[0] not in k:
                k[row[0]] = 0
            d[row[0]] = row[2]

        else:
            try:
                t1 = d[row[0]][10:18].strip()
                t2 = row[2][10:18].strip()
                t3 = diff(t1, t2)
                k[row[0]] += t3
            except:
                pass
        line_count += 1

cnt = 1


with open('meet_result.csv', mode='w', newline='') as csv_file:
    fieldnames = ['Number', 'Name', 'Time']
    writer = csv.DictWriter(csv_file, fieldnames=fieldnames)

    writer.writeheader()
    for i in sorted(k):
        print(cnt, i, str(dt.timedelta(seconds=k[i])))
        time = str(dt.timedelta(seconds=k[i]))
        writer.writerow({'Number': f'{cnt}', 'Name': f'{i}', 'Time': f'{time}'})
        cnt += 1
    