import java.util.stream.Stream;

/**
 * Created by Ronney
 */

public class IPL {
    String id;
    String seasons;
    String city;
    String team1;
    String team2;
    String toss_winner;
    String toss_decision;
    String venue;
    String umpire1;
    String umpire2;
    String umpire3;
    String winner;
    String dl_applied;
    int win_by_run;
    int win_by_wickets;
    String player_of_match;

    public IPL(String id, String seasons, String city, String team1, String team2, String toss_winner,
			String toss_decision, String result, String dl_applied, String winner, int win_by_run,
			int win_by_wickets, String player_of_match, String venue, String umpire1, String umpire2
			) {
		// TODO Auto-generated constructor stub
    	
   	 this.id = id;
     this.seasons = seasons;
     this.city = city;
     this.team1 = team1;
     this.team2 = team2;
     this.toss_winner = toss_winner;
     this.toss_decision = toss_decision;
     this.venue = venue;
     this.umpire1 = umpire1;
     this.umpire2 = umpire2;
     this.winner = winner;
     this.dl_applied = dl_applied;
     this.win_by_run = win_by_run;
     this.win_by_wickets = win_by_wickets;
     this.player_of_match = player_of_match;
     this.result = result;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeasons() {
        return seasons;
    }

    public void setSeasons(String seasons) {
        this.seasons = seasons;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getToss_winner() {
        return toss_winner;
    }

    public void setToss_winner(String toss_winner) {
        this.toss_winner = toss_winner;
    }

    public String getToss_decision() {
        return toss_decision;
    }

    public void setToss_decision(String toss_decision) {
        this.toss_decision = toss_decision;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDl_applied() {
        return dl_applied;
    }

    public void setDl_applied(String dl_applied) {
        this.dl_applied = dl_applied;
    }

    public int getWin_by_run() {
        return win_by_run;
    }

    public void setWin_by_run(int win_by_run) {
        this.win_by_run = win_by_run;
    }

    public int getWin_by_wickets() {
        return win_by_wickets;
    }

    public void setWin_by_wickets(int win_by_wickets) {
        this.win_by_wickets = win_by_wickets;
    }

    public String getPlayer_of_match() {
        return player_of_match;
    }

    public void setPlayer_of_match(String player_of_match) {
        this.player_of_match = player_of_match;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getUmpire1() {
        return umpire1;
    }

    public void setUmpire1(String umpire1) {
        this.umpire1 = umpire1;
    }

    public String getUmpire2() {
        return umpire2;
    }

    public void setUmpire2(String umpire2) {
        this.umpire2 = umpire2;
    }

    public String getUmpire3() {
        return umpire3;
    }

    public void setUmpire3(String umpire3) {
        this.umpire3 = umpire3;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    String result;



 



	@Override
    public String toString() {
        return "IPL{" +
                "id='" + id + '\'' +
                ", seasons='" + seasons + '\'' +
                ", city='" + city + '\'' +
                ", team1='" + team1 + '\'' +
                ", team2='" + team2 + '\'' +
                ", toss_winner='" + toss_winner + '\'' +
                ", toss_decision='" + toss_decision + '\'' +
                ", venue='" + venue + '\'' +
                ", umpire1='" + umpire1 + '\'' +
                ", umpire2='" + umpire2 + '\'' +
                ", umpire3='" + umpire3 + '\'' +
                ", winner='" + winner + '\'' +
                ", dl_applied='" + dl_applied + '\'' +
                ", win_by_run='" + win_by_run + '\'' +
                ", win_by_wickets='" + win_by_wickets + '\'' +
                ", player_of_match='" + player_of_match + '\'' +
                ", result='" + result + '\'' +
                '}';
    }

    public static IPL parseIPL(String str){
    	
		  String[] s = str.split(",",-1);
		  if ( s.length != 17) {
			  System.out.println("The elements are ::"); 
			    Stream.of( s ).forEach(System. out ::println);
			    throw new IllegalArgumentException("Each line must contain 10 fields while the current line has ::" + s.length );
		  }
            String id = s[0];
            String seasons = s[1];
            String city = s[2];
            String team1 = s[3];
            String team2 = s[4];
            String toss_winner = s[5];
            String toss_decision = s[6];
            String result = s[7];
            String dl_applied = s[8];
            String winner = s[9];
            int win_by_run = Integer.parseInt(s[10]);
            int win_by_wickets = Integer.parseInt(s[11]);
            String player_of_match = s[12];
            String venue = s[13];
            String umpire1 = s[14];
            String umpire2 = s[15];
          //  String umpire3 = s[16];

    
    
  		  return new IPL(id, seasons, city,team1,team2,toss_winner,
				  toss_decision,result,dl_applied,winner,win_by_run,
				  win_by_wickets,player_of_match,venue,
				  umpire1,umpire2
				  );

		  
		

		}


}
