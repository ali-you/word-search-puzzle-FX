package P1;

/*you are not bound to use enumeration for levels of the game.
this is here just to inform you of the levels of the game
you can use it or leave it*/

public enum Level {
	EASY(10),
	AVERAGE(20),
	DIFFICULT(30);
	
	private final int num;
	Level(int num){
		this.num = num;
	}
	
	public int getNumVal() {
        return num;
	}
}
