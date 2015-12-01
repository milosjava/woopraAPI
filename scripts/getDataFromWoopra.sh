

#create sequence from 2014-06-16 to 2015-11-18

#seq 1 520 | xargs -I {} date -d "2014-06-16 {} days" +%Y-%m-%d



for date in `seq 1 520 | xargs -I {} date -d "2014-06-16 {} days" +%Y-%m-%d`
do
temp="https://www.woopra.com/rest/2.4/logs/export?website=harris.partners&file=$date&pos=0"
echo $temp
curl --user Q7X22PW22BU38XG4TQVG25MM954F5S4J:r8Q12fDirRBI0BoEBXdiHOHpbCNcPHngv8TJdlhvVHdQLfkfqDHcTjtZyhkmetbL $temp > ../historicData/harrisPartners_$date.log
done




