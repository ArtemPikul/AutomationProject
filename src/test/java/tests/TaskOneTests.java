package tests;

import logiclayer.LogicLayer;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class TaskOneTests extends BaseTest {

    private static final String EXPECTED_ARTICLE_HEADLINE = "Fire destroys Greece's largest migrant camp";
    private static final String[] EXPECTED_SECONDARY_ARTICLES_TITLES = new String[]{
            "US to withdraw 2,200 troops from Iraq within weeks",
            "Oxford vaccine trial paused as participant falls ill",
            "Police shoot autistic boy after mum calls for help",
            "Kardashians announce end of hit reality show"
    };


    @Test
    public void checkThatExpectedArticleHeadlineIsMatch() {

        LogicLayer logicLayer = new LogicLayer();
        logicLayer.navigateToNewsPage();

        Assert.assertEquals(logicLayer.getExpectedArticleHeadlineText(), EXPECTED_ARTICLE_HEADLINE);
    }

    @Test
    public void checkThatSecondaryArticleHeadlinesIsMatch() {

        LogicLayer logicLayer = new LogicLayer();
        logicLayer.navigateToNewsPage();

        boolean result = true;
        for (int i = 0; i < 4; i++) {
            String actualTitle = logicLayer.getSecondaryArticleHeadlinesList().get(i).getText();
            if (EXPECTED_SECONDARY_ARTICLES_TITLES[i].equals(actualTitle)) {
                result = false;
                break;
            }
        }

        Assert.assertTrue(result);
    }

    @Test
    public void checkThatArticleCategoryIsMatch() {
        LogicLayer logicLayer = new LogicLayer();
        logicLayer.navigateToNewsPage();

        String searchQuery = logicLayer.getHeadlineArticleCategoryText();
        logicLayer.searchByKeyword(searchQuery);
        String firstFoundArticleName = logicLayer.getFirstSearchResult();

        boolean found = Arrays.asList(firstFoundArticleName.split(" ")).contains(searchQuery);

        Assert.assertTrue(found);
    }
}
