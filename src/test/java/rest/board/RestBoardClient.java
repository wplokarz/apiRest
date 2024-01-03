package rest.board;


import io.restassured.response.ExtractableResponse;
import org.example.pojoClasses.Board;
import rest.RestClientBase;

public class RestBoardClient extends RestClientBase {

    public ExtractableResponse createBoard (Board board) {
        return postRequest(board);
    }

    public ExtractableResponse getBoard (String boardID) {
        String path = boardID;
        return getRequest(path);
    }

    public ExtractableResponse updateBoard (String path, Board board) {
        return putRequest(path, board);
    }

    public ExtractableResponse deleteBoard (String boardID) {
        String path = boardID;
        return deleteRequest(path);
    }

}
