import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;


public class MoviesSparkProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Logger.getLogger("org.apache").setLevel(Level.WARN);
		

		
		SparkSession spark = SparkSession.builder().appName("testingsql").master("local[*]")
				.config("spark.sql.warehouse.dir","file///c:/tmp/").getOrCreate();
		
		//Dataset<Row> dataset = spark.read().option("header", true).csv("src/main/resources/USA_cars_datasets.csv");
		Movies movie = new Movies();
		Dataset<Row> csv_read = spark.read().format("com.databricks.spark.csv")
				.option("header", "true")
				.option("inferSchema", "true")
				.option("delimiter",",")
				.load("src/main/resources/MoviesOnStreamingPlatforms_updated 2.csv");
		csv_read.printSchema();

		csv_read.show();

		
//		JavaRDD<Movies> movieRDD = spark.read().option("delimeter",",").textFile("src/main/resources/MoviesOnStreamingPlatforms_updated 2.csv")
//
//                .javaRDD().filter(str -> !(null == str))
//                .filter(str -> !(str.length()==0))
//                .filter(str -> !str.contains("slno"))
//                .map(str -> movie.parseRating(str));
//
//System.out.println(movieRDD.count());
		
		
		spark.close();

	}

}
