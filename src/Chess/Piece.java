package Chess;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {
	protected Player owner; //No longer racist
	protected Square currentSquare;
	protected char representation;
	protected Dir[] moveDirs;
		
	public Piece(Player owner, Square currentSquare) {
		this.owner = owner;
		this.setCurrentSquare(currentSquare);
	}
	
	//need different logic for all pieces
	public ArrayList<Square> getLegalMoves(){
		ArrayList<Square> legalSquares = new ArrayList<Square>();
		//for all opponent pieces
		//if can take king
		//illegal move
		return legalSquares;
	}
	
	public List<Square> getPossibleMoves(){
		List<Square> possibleFields = new ArrayList<Square>();
		List<Square> path = new ArrayList<Square>();
		//if pawn: Do special
		for (Dir d: getDirs()){
			int moveLength = getMoveLength(d);
			path = getCurrentSquare().getPath(d, moveLength);
			path.remove(0); //removes current square from path
			Piece foundPiece = path.get(path.size() - 1).getPiece();
			if (foundPiece != null && shareOwner(foundPiece)) path.remove(path.size() - 1); 
			possibleFields.addAll(path);
			path.clear();
		}
		return possibleFields;
	}
	
	
	
	public Dir[] getDirs(){
		return moveDirs;
	}
	
	public char getRepresentation() {
		return owner.isWhite() ? representation:Character.toUpperCase(representation);
	}
	
	public void setRepresentation(char representation) {
		this.representation = representation;
	}
	
	public Square getCurrentSquare() {
		return currentSquare;
	}
	
	public void setCurrentSquare(Square currentSquare) {
		this.currentSquare = currentSquare;
	}
	
	public Player getOwner() {
		return owner;
	}
	
	public boolean shareOwner(Piece piece){
		return (piece.getOwner() == getOwner());
	}

	public int getMoveLength(Dir d) {
		return 8;
	}
}
