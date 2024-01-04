import data.BoardDataProvider;
import io.restassured.response.ExtractableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import rest.board.RestBoardClient;
import org.example.pojoClasses.Board;
import static org.assertj.core.api.Assertions.assertThat;

public class DeleteBoardTest extends RestBoardClient {
    BoardDataProvider board = new BoardDataProvider();

    @Test
    public void deleteSpecificBoardTest() {
        String boardName = "boardForTesting";
        Board body = board.getBoardData("", boardName);

        // Create sample board to get board ID to remove in next steps
        ExtractableResponse response = createBoard(body);

        // TestNG
        Assert.assertEquals(response.statusCode(), 200);

        // AssertJ
        assertThat(response.statusCode()).isEqualTo(200);

        String boardID = response.jsonPath().getString("id");
        response = deleteBoard(boardID);

        // TestNG
        Assert.assertEquals(response.statusCode(), 200);

        // AssertJ
        assertThat(response.statusCode()).isEqualTo(200);

        // try to delete the same board again, should return 404 as this board doesn't exist anymore
        response = deleteBoard(boardID);

        // TestNG
        Assert.assertEquals(response.statusCode(), 404);
        Assert.assertEquals(response.asString(), "The requested resource was not found.");

        // AssertJ
        assertThat(response.statusCode()).isEqualTo(404);
        assertThat(response.asString()).isEqualTo("The requested resource was not found.");
    }
}
