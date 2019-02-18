[resources]
spark documentation: https://spark.apache.org/docs/latest/
Java devenv set up: https://hortonworks.com/tutorial/setting-up-a-spark-development-environment-with-java/
https://stackoverflow.com/questions/39518792/how-to-compare-two-files-using-spark
https://community.hortonworks.com/articles/82346/spark-pyspark-for-etl-to-join-text-files-with-data.html
https://raw.githubusercontent.com/hortonworks/data-tutorials/master/tutorials/hdp/setting-up-a-spark-development-environment-with-java/assets/shakespeare.txt
https://www.programcreek.com/java-api-examples/?class=org.apache.spark.api.java.JavaRDD&method=mapToPair

[local mode]
scp -P 2222 ./target/spark-0.0.1-SNAPSHOT.jar root@127.0.0.1:/root
ssh -p 2222 root@127.0.0.1
export SPARK_MAJOR_VERSION=2
spark-submit --class "com.spark.App" --master local ./spark-0.0.1-SNAPSHOT.jar

[master-cluster mode]
scp -P 2222 -i "key.pem" ./target/spark-0.0.1-SNAPSHOT.jar root@127.0.0.1:/root
ssh -p 2222 -i "key.pem" root@127.0.0.1
export SPARK_MAJOR_VERSION=2
spark-submit --class "com.spark.App" --master yarn --deploy-mode client ./spark-0.0.1-SNAPSHOT.jar

[local paths]
FILEPATH = src/main/resources/shakespeare.txt
DIRECTORYPATH = /tmp/shakespeareWordCount
DIRECTORYPATH2 = /tmp/guideoutput
GUIDEFILEPATH = src/main/resources/guide.csv
INPUTFILEPATH = src/main/resources/input.csv

[hdfs paths]
export FILEPATH=hdfs://tmp/shakespeare.txt
export DIRECTORYPATH=hdfs:///tmp/shakespeareWordCount
export DIRECTORYPATH2=hdfs:///tmp/guideoutput
export GUIDEFILEPATH=hdfs:///tmp/guide.csv
export INPUTFILEPATH=hdfs:///tmp/input.csv


[environment]
eclipse
spark(hadoop)

[HADOOP_HOME - env]
download winutils.exe from hortonworks.com website
HADOOP_HOME - D:\New Programs\Winutils\winutils