FROM ubuntu
MAINTAINER TaniaAzarova
RUN apt-get update \
&& apt-get install -y git openjdk-8-jdk\
&& cd /root \
&& git clone https://github.com/TaniaAzar/trainingclient \
&& cd /root/trainingclient/src \
&& javac by/training/client/Client.java \
&& java by/training/client/Client