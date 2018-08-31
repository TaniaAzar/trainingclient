FROM ubuntu
MAINTAINER TaniaAzarova
RUN mkdir /root/trainingclient
WORKDIR /root/trainingclient/src
RUN apt-get update \
&& apt-get install -y git openjdk-8-jdk\
&& cd /root \
&& git clone https://github.com/TaniaAzar/trainingclient \
&& cd /root/trainingclient/src \
&& javac by/training/client/Client.java
ENTRYPOINT ["java", "by/training/client/Client"]