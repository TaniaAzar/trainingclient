FROM ubuntu:18.04
MAINTAINER TaniaAzarova
RUN apt-get update \
&& apt-get install -y git \
&& cd /root \
&& git clone https://github.com/TaniaAzar/trainingclient \
&& cd trainingclient/ \
&& echo "oracle-java10-installer shared/accepted-oracle-license-v1-1 boolean true" | debconf-set-selections \
&& apt-get update \
&& apt-get install -y oracle-java10-installer \
&& javac Client.java
ENTRYPOINT ["java", "-jar", "Client", "/trainingclient/target/Client-1.0.jar"]