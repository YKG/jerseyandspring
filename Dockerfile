From ubuntu:trusty

RUN apt-get update

#Getting dependencies
RUN apt-get install -y openjdk-7-jre-headless tar

#Preparing jetty
RUN adduser --system jetty
RUN mkdir /opt/jetty

ADD http://repo1.maven.org/maven2/org/eclipse/jetty/jetty-distribution/9.1.2.v20140210/jetty-distribution-9.1.2.v20140210.tar.gz /opt/jetty.tar.gz

#RUN cat /opt/jetty.tar.gz | tar -C /opt/jetty --strip-components=1 -xz
RUN tar -zxf /opt/jetty.tar.gz --strip-components=1 -C /opt/jetty
RUN chown -R jetty /opt/jetty
USER jetty
EXPOSE 8080

#Adding .war 
ADD target/root.war /opt/jetty/webapps/root.war

#CMD ["/opt/jetty/bin/jetty.sh", "-d", "run"]
# Set defaults for docker run
WORKDIR /opt/jetty
CMD ["java", "-jar", "start.jar", "jetty.home=/opt/jetty"]
