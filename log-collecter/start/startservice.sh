source /etc/profile
DIR="/home/cloud/log-collecter"
echo "==========正在启动服务========="
nohup $DIR/bin/start >/dev/null 2>&1 &
echo "service is starting"
echo "==========正在启动服务========="
