import data.BoardDataProvider;
import io.restassured.response.ExtractableResponse;
import org.example.pojoClasses.Board;
import org.testng.Assert;
import org.testng.annotations.Test;
import rest.board.RestBoardClient;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateBoardTest extends RestBoardClient {

    BoardDataProvider board = new BoardDataProvider();

    @Test
    public void createNewBoardTest() {
        String boardName = "newBoard1046";
        Board body = board.getBoardData("", boardName);
        ExtractableResponse response = createBoard(body);

        // TestNG
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("name"), boardName);

        // AssertJ
        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.jsonPath().getString("name")).isEqualTo(boardName);
    }
}
