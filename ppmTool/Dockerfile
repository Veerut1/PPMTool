FROM java:8
EXPOSE 9999
ADD /target/ppmtool.jar ppmtool.jar
ENTRYPOINT ["java","-Duser.timezone=PST","-jar","ppmtool.jar"]