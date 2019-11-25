# spark
sudo yum install git -y && git clone
sudo yum update -y
sudo yum install maven docker -y
cd spark/
sudo mvn package
docker build . -t test:v1
sudo sh -c "echo 0> /proc/sys/net/ipv4/ip_unpriviledged_port_start"
docker run -p 80:9091 -d test:v1
