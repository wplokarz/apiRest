import io.restassured.response.ExtractableResponse;
import org.testng.annotations.Test;
import org.testng.Assert;
import rest.board.RestBoardClient;

import static org.assertj.core.api.Assertions.assertThat;


public class GetBoardTest extends RestBoardClient {

    @Test
    public void getSpecificBoardTest() {
        String boardID = "658174cce75b456da0c7feaf";
        ExtractableResponse response = getBoard(boardID);

        // TestNG
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("id"), boardID);
        Assert.assertNotNull(response.jsonPath().getString("name"));

        // AssertJ
        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.jsonPath().getString("id")).isEqualTo(boardID);
        assertThat(response.jsonPath().getString("name")).isNotBlank();
    }
}
