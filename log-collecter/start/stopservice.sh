apppid=com.sense.cloud.logCollecter.server.App
ps -ef|grep $apppid|grep -v grep|awk '{print $2}'|while read pid
do
    echo "kill -9 $pid"
    kill -9 $pid
done
echo "$apppid is stop"
