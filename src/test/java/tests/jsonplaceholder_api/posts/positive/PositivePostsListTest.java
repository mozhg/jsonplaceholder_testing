package tests.jsonplaceholder_api.posts.positive;

import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import models.PostModel;
import org.junit.jupiter.api.*;
import tests.jsonplaceholder_api.posts.AbstractPostsTest;

@Epic("Тестирование постов JSON Placeholder")
@Story("Получение списка постов")
@Severity(value = SeverityLevel.BLOCKER)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PositivePostsListTest extends AbstractPostsTest {
    private static TestData testData;


    @BeforeAll
    public static void setup() {
        testData = new TestData();
    }


    @DisplayName("Проверка возврата статуса 200 при получении первого поста")
    @Order(1)
    @Test()
    public void positivePostsListTestStep1() {
        Response response = getPost(1);
        checkStatusCode(response, 200);
    }

    @DisplayName("Проверка возврата статуса 200 при получении списка постов")
    @Order(2)
    @Test()
    public void positivePostsListTestStep2() {
        Response response = getPosts();
        checkStatusCode(response, 200);
    }

    @DisplayName("Проверка количества постов")
    @Order(3)
    @Test()
    public void positivePostsListTestStep3() {
        PostModel[] postList = getPostsList();
        Integer expectedPostsQuantity = 100;
        Integer actualPostsQuantity = postList.length;
        assertEquals(expectedPostsQuantity, actualPostsQuantity,
                "Ожидаемое количество постов = " + expectedPostsQuantity + " , но было получено " + actualPostsQuantity);
    }

    @DisplayName("Проверка содержимого первого поста")
    @Order(4)
    @Test()
    public void positivePostsListTestStep4() {
        PostModel post = getPostModel(1);
        compareTwoModels(testData.firstPost, post);
    }

    @DisplayName("Проверка содержимого последнего поста")
    @Order(5)
    @Test()
    public void positivePostsListTestStep5() {
        PostModel post = getPostModel(100);
        compareTwoModels(testData.lastPost, post);
    }


    private static class TestData {
        PostModel firstPost = new PostModel();

        {
            firstPost.id = 1;
            firstPost.userId = 1;
            firstPost.title = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit";
            firstPost.body = "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum" +
                    "\nreprehenderit molestiae ut ut quas totam" +
                    "\nnostrum rerum est autem sunt rem eveniet architecto";
        }

        PostModel lastPost = new PostModel();

        {
            lastPost.id = 100;
            lastPost.userId = 10;
            lastPost.title = "at nam consequatur ea labore ea harum";
            lastPost.body = "cupiditate quo est a modi nesciunt soluta\nipsa voluptas error itaque dicta in" +
                    "\nautem qui minus magnam et distinctio eum\naccusamus ratione error aut";
        }

    }
}
