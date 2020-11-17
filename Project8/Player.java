/**
 * Class Player defines data and method members for Player class objects
 * which represent soccer players on a team
 */
public class Player {
   private int jerseyNum;
   private int rating;

	/**
	 * default constructor
	 */
   public Player() {
      jerseyNum = 0;
      rating = 0;
   }

	/**
	 * constructor with parameters
	 * 
	 * @param jerseyNum
	 * @param rating 
	 */
   public Player(int jerseyNum, int rating) {
      this.jerseyNum = jerseyNum;
      this.rating = rating;
   }

	/**
	 * getter
	 * 
	 * @return rating
	 */
   public int getRating() {
      return rating;
   }

	/**
	 * setter
	 * 
	 * @param rating 
	 */
   public void setRating(int rating) {
      this.rating = rating;
   }

	/**
	 * getter
	 * 
	 * @return jerseyNum 
	 */
   public int getJerseyNum() {
      return jerseyNum;
   }

	/**
	 * setter
	 * 
	 * @param jerseyNum 
	 */
   public void setJerseyNum(int jerseyNum) {
      this.jerseyNum = jerseyNum;
   }
   
}
