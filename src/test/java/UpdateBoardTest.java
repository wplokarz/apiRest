import data.BoardDataProvider;
import io.restassured.response.ExtractableResponse;
import org.example.pojoClasses.Board;
import org.testng.Assert;
import org.testng.annotations.Test;
import rest.board.RestBoardClient;

import static org.assertj.core.api.Assertions.assertThat;

public class UpdateBoardTest extends RestBoardClient {

    BoardDataProvider board = new BoardDataProvider();

    @Test
    public void updateBoard() {
        String boardID = "658d62b869d61a009d1e3ef6";
        String boardName = "newName1217";
        Board body = board.getBoardData(boardID, boardName);
        ExtractableResponse response = updateBoard(boardID, body);

        // TestNG
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("name"), boardName);

        // AssertJ
        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.jsonPath().getString("name")).isEqualTo(boardName);
    }
}
