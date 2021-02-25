import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.SparkSession;

public class IPLMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		Logger.getLogger("org.apache").setLevel(Level.WARN);
		
		SparkSession spark = SparkSession.builder().appName("testingsql").master("local[*]")
				.config("spark.sql.warehouse.dir","file///c:/tmp/").getOrCreate();
		
		
		
/*		long iplRDD1 = spark.read().textFile("src/main/resources/IPL dataset1.csv")
                .javaRDD().filter(str -> !(null == str))
                .filter(str -> !(str.length()==0))
                .filter(str -> !str.contains("id"))
                .map(str -> IPL.parseIPL(str))
                .filter(ipl->ipl.getTeam1().equals("Mumbai Indians")
                		|| ipl.getTeam2().equals("Mumbai Indians")
                		&& ipl.getVenue().equals("Wankhede Stadium")).count();
		System.out.println("Query 1: Query to find how many times Mumbai Indians team won the match played in Mumbai");
		System.out.println("----------------------------------------------------------------");
		System.out.println("Count : "+ iplRDD1);*/

		
		
		
		
/*		JavaRDD<Object> iplRDD2 = spark.read().textFile("src/main/resources/IPL dataset1.csv")
      .javaRDD().filter(str -> !(null == str))
      .filter(str -> !(str.length()==0))
      .filter(str -> !str.contains("id"))
      .map(str -> IPL.parseIPL(str))
      .filter(ipl-> ipl.getPlayer_of_match().endsWith("Singh"))
      .map(s-> "Man of the Match   : "+ s.getPlayer_of_match());
System.out.println("Query 2: Query to find the player of the match whose name end with Singh");
System.out.println("----------------------------------------------------------------");
iplRDD2.foreach(m -> System.out.println(m));*/




/*		System.out.println("Query 3:Write a  Query to find the city and winning team whose tossed the coin and decided to do batting first");
		System.out.println("----------------------------------------------------------------");
		spark.read().textFile("src/main/resources/IPL dataset1.csv")
					.javaRDD().filter(str -> !(null == str))
					.filter(str -> !(str.length()==0))
					.filter(str -> !str.contains("id"))
					.map(str -> IPL.parseIPL(str))
					.filter(ipl-> ipl.getToss_decision().equals("bat"))
					.map(s->"City :"+ s.getCity() +" ,Winning Team :"+ s.getWinner())
		 			.collect().forEach(m->System.out.println(m));*/



 
 
/*String iplRDD4 = spark.read().textFile("src/main/resources/IPL dataset1.csv")
.javaRDD().filter(str -> !(null == str))
.filter(str -> !(str.length()==0))
.filter(str -> !str.contains("id"))
.map(str -> IPL.parseIPL(str))
.filter(ipl-> ipl.getResult().equals("tie"))
.map(s->" City :"+ s.getCity()
+ "\n" +" Winning Team :"+ s.getWinner() +
"\n" + " Result :"+ s.getResult() +
"\n"+ " IPL season :"+ s.getSeasons() +
"\n" + " Venue :"+ s.getVenue()).first();
System.out.println("Query 4: Write a Query to find the city,winning team,result,ipl seasons and venue whose first result of the match  was a TIE ");
System.out.println("----------------------------------------------------------------");
System.out.print(iplRDD4);*/

		



JavaRDD<IPL> iplRDD5 = (JavaRDD<IPL>) spark.read().textFile("src/main/resources/IPL dataset1.csv")
.javaRDD().filter(str -> !(null == str))
.filter(str -> !(str.length()==0))
.filter(str -> !str.contains("id"))
.map(str -> IPL.parseIPL(str))
.filter(ipl->ipl.getWin_by_wickets()==0 && ipl.getWinner().equals("Mumbai Indians"));

 System.out.println("Query 5: Write a Query in which the team won by 0 wickets and the team is Mumbai Indians.");
 System.out.println("----------------------------------------------------------------");

 iplRDD5.foreach(m -> System.out.println( " Team 1 : "+ m.getTeam1() +  " Team 2 : " + m.getTeam2() + " || \uD83C\uDFC6  Winning team: "+ m.getWinner() +"\uD83C\uDFC6 ||"));


		
		
		spark.close();
		

	}

}
