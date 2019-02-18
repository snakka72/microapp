package com.spark;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.StructType;
import org.apache.spark.api.java.JavaRDD;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.spark.SparkConf;
import scala.Tuple2;

import java.io.IOException;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class App {

	static String filePath;
	static String directoryPath;
	static String guideOutputPath;
	static String guideFilePath;
	static String inputFilePath;
	
    public static void main(String[] args){
    	
    	//environment variables
		directoryPath = System.getenv("DIRECTORYPATH");
		guideOutputPath = System.getenv("DIRECTORYPATH2");
		filePath = System.getenv("FILEPATH"); 
		guideFilePath = System.getenv("GUIDEFILEPATH");
		inputFilePath = System.getenv("INPUTFILEPATH");
		
        System.out.println("DIRECTORYPATH(getenv): " + System.getenv("DIRECTORYPATH"));
		System.out.println("FILEPATH(getenv): " + System.getenv("FILEPATH"));

        System.out.println("DIRECTORYPATH(getProperty): " + System.getProperty("DIRECTORYPATH"));
		System.out.println("FILEPATH(getProperty): " + System.getProperty("FILEPATH"));
		
		System.out.println("SPARK_MAJOR_VERSION(getenv): " + System.getenv("SPARK_MAJOR_VERSION"));
		System.out.println("SPARK_MAJOR_VERSION(getProperty): " + System.getProperty("SPARK_MAJOR_VERSION"));

        System.out.println("GUIDEFILEPATH(getProperty): " + System.getenv("GUIDEFILEPATH"));
		System.out.println("INPUTFILEPATH(getProperty): " + System.getenv("INPUTFILEPATH"));
		
        System.out.println("GUIDEFILEPATH(getProperty): " + System.getProperty("GUIDEFILEPATH"));
		System.out.println("INPUTFILEPATH(getProperty): " + System.getProperty("INPUTFILEPATH"));
		
		//set winutils path for run spark locally
    	//System.setProperty("hadoop.home.dir", "D:\\New Programs\\Winutils\\winutils");
    	
        //Create a SparkContext to initialize
        SparkConf conf = new SparkConf().setMaster("local").setAppName("Word Count");

        // Create a Java version of the Spark Context
        JavaSparkContext sc = new JavaSparkContext(conf);

        //RDD
        SparkRDD(sc);
        
        //Dataset
	    SparkDataset(sc);

    }
    
    public static void SparkRDD(JavaSparkContext context)  {
    	
        // Load the text into a Spark RDD, which is a distributed representation of each line of text
        JavaRDD<String> textFile = context.textFile(filePath);
        
        JavaPairRDD<String, Integer> counts = textFile
                .flatMap(s -> Arrays.asList(s.split("[ ,]")).iterator())
                .mapToPair(word -> new Tuple2<>(word, 1))
                .reduceByKey((a, b) -> a + b);
        
        //counts.foreach(p -> System.out.println(p));
        System.out.println("Total words: " + counts.count());
        
		CheckDirectory(context, directoryPath);
	    counts.saveAsTextFile(directoryPath);    	
    }
    
    public static void SparkDataset(JavaSparkContext context)  {
    	
	    SparkSession spark = SparkSession
	    	    .builder()
	    	    .appName("Java Spark SQL Example")
	    	    .getOrCreate();	    

	    StructType schema = new StructType()
	    	    .add("lastname", "string")
	    	    .add("firstname", "string")
	    	    .add("city", "string")
	    	    .add("state", "string")	    
	    	    .add("zip", "string")
	    	    .add("zip4", "string");
	    
	    Dataset<Row> df = spark.read()
	    	    .option("mode", "DROPMALFORMED")
	    	    .schema(schema)
	    	    .csv(guideFilePath);
	    
	    Dataset<Row> input = spark.read()
	    	    .option("mode", "DROPMALFORMED")
	    	    .schema(schema)
	    	    .csv(inputFilePath);
	    
	    //System.out.println("Spark function");
	    //df.foreach((ForeachFunction<Row>) row -> System.out.println(row));
	    //System.out.println("Spark dataset");
	    //df.foreach(p -> System.out.println(p));
	    //df.foreach(p -> System.out.println(p.get(0)));
	    
	    Dataset<Row> filteredData = df
                .join(input, df.col("firstname")
                .equalTo(input.col("firstname")));
                //.drop("lastname", "firstname", "city", "state", "zip", "zip4");	
	    
	    System.out.println("firstname\tlastname\tzip");
	    filteredData.foreach(p -> System.out.println(p.get(0) + "\t" + p.get(1) + "\t" + p.get(4)));   
	    
	    CheckDirectory(context, guideOutputPath);
	    
	    filteredData.javaRDD().map(x -> x.toString()).saveAsTextFile(guideOutputPath);
    }

    public static void CheckDirectory(JavaSparkContext context, String pathInfo)  {
    	
		FileSystem hdfs;
		
		try{
			hdfs = FileSystem.get(context.hadoopConfiguration());
			
			if(hdfs.exists(new Path(pathInfo))) {
				System.out.println("Directory or file exists");
				hdfs.delete(new Path(pathInfo),true);
			} 
						
		}catch (NoSuchElementException | IOException e) {
			e.printStackTrace();
			System.out.println("Directory or file not exists");
		}
    }    
}