package data;

import org.example.pojoClasses.Board;

public class BoardDataProvider {
    public Board getBoardData(String boardID, String name) {
        return new Board(boardID, name);
    }
}
