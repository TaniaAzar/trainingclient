FROM ubuntu
MAINTAINER TaniaAzarova
RUN mkdir /home/training_client
WORKDIR /home/training_client
RUN apt-get update \
&& apt-get install -y git \
&& cd /root \
&& git clone https://github.com/TaniaAzar/trainingclient \
&& cd /home/training_client/ \
&& javac Client.java
ENTRYPOINT ["java", "-jar", "Client"]